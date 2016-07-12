package com.restaurant.servicios;

import com.restaurant.modelo.Persona;
import com.restaurant.modelo.Usuario;
//interfaz manejadora de la clase persona
public interface PersonaService {
	
	public Persona getPersonaByIdentificacion(String identificacion);
	public Persona getPersonaById(long id);
	public Persona createPersona(String nombre1,String nombre2,String identicacion);
	public boolean setUsuario(Persona persona,Usuario usuario);
	public Persona removeUsuario(Persona persona);
	public boolean savePersona(Persona persona);
	
	public Usuario createUsuario(String username,String password);
	public boolean validaUsuario(String username,String password);
	public Usuario getUsuarioByUserName(String username);
	public boolean saveUsuario(Usuario user);
	
	//public Usuario resetUsuario(Usuario usuario);
	
	
	
	
	

}
