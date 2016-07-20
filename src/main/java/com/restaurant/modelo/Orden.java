package com.restaurant.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="orden")
public class Orden {
	@Id
	@GeneratedValue
	private long id;
	@OneToMany
	
	private List<Peticion> pedido;
	@OneToOne
	private Mesa mesa;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Peticion> getPedido() {
		return pedido;
	}
	public void setPedido(List<Peticion> pedido) {
		this.pedido = pedido;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	

}
