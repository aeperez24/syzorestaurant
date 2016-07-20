package com.restaurant.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="usuario")
public class Usuario {
	
	public static int USUARIOCLIENTE			=	1;
	public static int USUARIOCOCINERO			=	2;
	public static int USUARIOMESONERO			=	3;
	public static int USUARIOADMINISTRADOR		=	4;
	public static String tiposUsuarios[]	=	{null,"Cliente","Cocinero","Mesonero","Administrador"};
	
	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String password;
	private String tipoUsuario;
	//tipoUsuario={cliente, mesonero, cocinero}
	
	
	
	public long getId() {
		return id;
	}
	public String getUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
