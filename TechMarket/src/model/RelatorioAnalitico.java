package model;

public class RelatorioAnalitico {
 private int idCarrinho;
 private int idProduto;
 private int quantidade;
 private double subtotal;
 
 public RelatorioAnalitico() {}
 
public int getIdCarrinho() {
	return idCarrinho;
}
public void setIdCarrinho(int idCarrinho) {
	this.idCarrinho = idCarrinho;
}
public int getIdProduto() {
	return idProduto;
}
public void setIdProduto(int idProduto) {
	this.idProduto = idProduto;
}
public int getQuantidade() {
	return quantidade;
}
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}
public double getSubtotal() {
	return subtotal;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
}
