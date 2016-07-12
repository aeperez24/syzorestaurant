package com.restaurant.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	public static final String categorias[]={null,"Entrada","Plato Principal","Bebida"};
	public static final int ENTRADA=1;
	public static final int PLATOPRINCIPAL=2;
	public static final int BEBIDA=3;
	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private String codigo;
	private String descripcion;
	private String categoria;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Presentacion> presentaciones=new ArrayList<Presentacion>();
	public List<Presentacion> getPresentaciones() {
		return presentaciones;
	}
	public void setPresentaciones(List<Presentacion> presentaciones) {
		this.presentaciones = presentaciones;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	

}
