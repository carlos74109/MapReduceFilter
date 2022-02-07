package Produtos;

public class Produtos {
	
	private String nome;
	private Double preco;
	
	
	public Produtos() {
		super();
	}


	public Produtos(String nome, Double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	@Override
	public String toString() {
		
		return "Nome: " + nome + ", Preco: " + preco;
	}
}
