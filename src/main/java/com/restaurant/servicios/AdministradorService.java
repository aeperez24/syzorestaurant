package com.restaurant.servicios;

import com.restaurant.modelo.Administrador;
import com.restaurant.modelo.Persona;

public interface AdministradorService {

	public Administrador createAdministrador(Persona persona);
	public Administrador getAdministradorById(long id);
	public Administrador getAdministradorByIdentificacion(String identificacion);
	public boolean saveAdministrador(Administrador administrador);
}
