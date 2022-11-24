package model;

public class RelatorioAnalitico {
 private int idCarrinho;
 private String nomeProduto;
 private int quantidade;
 private double valorUnit;
 
 public RelatorioAnalitico() {}
 
public int getIdCarrinho() {
	return idCarrinho;
}
public void setIdCarrinho(int idCarrinho) {
	this.idCarrinho = idCarrinho;
}

public String getNomeProduto() {
	return nomeProduto;
}

public void setNomeProduto(String nomeProduto) {
	this.nomeProduto = nomeProduto;
}

public int getQuantidade() {
	return quantidade;
}
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}

public double getValorUnit() {
	return valorUnit;
}

public void setValorUnit(double valorUnit) {
	this.valorUnit = valorUnit;
}

}
