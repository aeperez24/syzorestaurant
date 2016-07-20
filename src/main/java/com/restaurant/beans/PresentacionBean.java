package com.restaurant.beans;

public class PresentacionBean {
	private long id;
	private String nombre;
	private String codigoItem;
	private String presentacion;
	private float precio;
	
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(String codigo) {
		this.codigoItem = codigo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	

}
