package com.restaurant.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="factura")
public class Factura {
	@Id
	@GeneratedValue
	private long id;
	private String fecha;
	@OneToOne
	private Orden orden;
	@ManyToOne
	private Cliente cliente;
	private float consumo;
	private float impuestos;
	private float propinaMinima;
	private float propinaPagada;
	@ManyToOne
	private Mesonero mesoneroAsignado;
	private String sugerencia;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Orden getOrden() {
		return orden;
	}
	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public float getConsumo() {
		return consumo;
	}
	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}
	public float getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(float impuestos) {
		this.impuestos = impuestos;
	}
	public float getPropinaMinima() {
		return propinaMinima;
	}
	public void setPropinaMinima(float propinaMinima) {
		this.propinaMinima = propinaMinima;
	}
	public float getPropinaPagada() {
		return propinaPagada;
	}
	public void setPropinaPagada(float propinaPagada) {
		this.propinaPagada = propinaPagada;
	}
	public Mesonero getMesoneroAsignado() {
		return mesoneroAsignado;
	}
	public void setMesoneroAsignado(Mesonero mesoneroAsignado) {
		this.mesoneroAsignado = mesoneroAsignado;
	}
	public String getSugerencia() {
		return sugerencia;
	}
	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}
	

}
