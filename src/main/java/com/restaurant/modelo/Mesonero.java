package com.restaurant.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.criteria.Fetch;

import org.hibernate.engine.internal.Cascade;
@Entity
@Table(name="mesonero")
public class Mesonero {
	@Id
	@GeneratedValue
	private long id;
	@OneToOne
	private Persona persona;
	
	private boolean activo;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Mesa> mesasAsignadas;
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
	public List<Mesa> getMesasAsignadas() {
		return mesasAsignadas;
	}
	public void setMesasAsignadas(List<Mesa> mesasAsignadas) {
		this.mesasAsignadas = mesasAsignadas;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

}
