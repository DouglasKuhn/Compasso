package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {

	private Integer id;
	private Integer cliente;
	private List<Produto> itens;

	public Pedido() {
		this.itens = new ArrayList<Produto>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}

}
