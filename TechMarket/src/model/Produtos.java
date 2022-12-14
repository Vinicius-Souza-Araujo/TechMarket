package model;

public class Produtos {
	private int idProduto;
	private String nome;
	private String categoria;
	private double preco;
	private int estoque;
	
	public Produtos() {}
	
	public Produtos(String nome, String categoria, double preco, int estoque ) {
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.estoque = estoque;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	
	
}
