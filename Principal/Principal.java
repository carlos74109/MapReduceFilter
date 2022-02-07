package Principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Produtos.Produtos;

public class Principal {

	public static void main(String[] args) {
		
		String path = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Produtos> lista = new ArrayList<>();
			String linha = br.readLine();
			
			while(linha != null){
				String[] vetor = linha.split(",");
				lista.add(new Produtos(vetor[0], Double.parseDouble(vetor[1])));
				linha = br.readLine();
			
			}
			
			Comparator<String> comp = (n1, n2) -> n1.toUpperCase().compareTo(n2.toUpperCase());
			
			Double precoMedia = lista.stream().map(p -> p.getPreco()).reduce(0.0, (x, y) -> x +y) / lista.size();
			//List<Produtos> medio = lista.stream().filter(x -> x.getPreco() <= precoMedia).collect(Collectors.toList());
			List<Produtos> media = lista.stream().filter(p -> p.getPreco() < precoMedia).collect(Collectors.toList());
			
			List<String> nomes = lista.stream()
					.filter(x -> x.getPreco() < precoMedia)
					.map(x -> x.getNome())
					.sorted(comp.reversed())
					.collect(Collectors.toList());
			
			
			nomes.forEach(System.out:: println);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
