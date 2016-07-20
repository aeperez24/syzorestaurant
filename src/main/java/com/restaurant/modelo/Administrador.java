package com.restaurant.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Administrador")
public class Administrador {
	@Id
	@GeneratedValue
	private long id;
	@OneToOne
	private Persona persona;
	@OneToOne
	private Usuario usuario;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
