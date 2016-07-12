package com.restaurant.servicios;

import com.restaurant.modelo.Cliente;
import com.restaurant.modelo.Mesa;
import com.restaurant.modelo.Persona;
import com.restaurant.modelo.Usuario;
//interfaz manejadora de la clase cliente
public interface ClienteService {
	
	public Cliente getClienteByIdentificacion(String identificacion);
	public Cliente getClienteById(long id);
	public Cliente createCliente(Persona persona);
	public Cliente setUsuario(Cliente cliente,Usuario usuario);
	public boolean asignClienteMesa(Cliente cliente,Mesa mesa);
	public boolean desasignClienteMesa(Cliente cliente,Mesa mesa);
	
	
	
	
	
	

}
