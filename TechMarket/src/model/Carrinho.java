package model;

import java.util.ArrayList;

public class Carrinho {
	private int id;
	private int idCliente;
	private String dataEhora;
	private double total;
	
	private ArrayList<ItemCarrinho> listaItens = null;
	
	public Carrinho() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	

	public String getDataEhora() {
		return dataEhora;
	}

	public void setDataEhora(String dataEhora) {
		this.dataEhora = dataEhora;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ArrayList<ItemCarrinho> getListaItens() {
		return listaItens;
	}

	public void setListaItens(ArrayList<ItemCarrinho> listaItens) {
		this.listaItens = listaItens;
	}
	
	
}
