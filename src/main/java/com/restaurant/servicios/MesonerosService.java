package com.restaurant.servicios;

import java.util.List;

import com.restaurant.modelo.Mesa;
import com.restaurant.modelo.Mesonero;
import com.restaurant.modelo.Persona;
import com.restaurant.modelo.Usuario;
//clase encargada de manejar mesoneros
public interface MesonerosService {
	public Mesonero CreateMesonero(Persona persona);
	public boolean saveMesonero(Mesonero mesonero);
	public Mesonero getMesoneroById(long id);
	public Mesonero getMesoneroByIdentificacion(String identificacion);
	public Mesonero getMesoneroByUsuario(Usuario usuario);
	public boolean asignarMesa(Mesonero mesonero,Mesa mesa);
	public boolean desasignarMesa(Mesonero mesonero,Mesa mesa);
	public boolean activarMesonero(Mesonero mesonero);
	public boolean desactivarMesonero(Mesonero mesonero);
	public List<Mesonero> getMesonerosActivos();

}
