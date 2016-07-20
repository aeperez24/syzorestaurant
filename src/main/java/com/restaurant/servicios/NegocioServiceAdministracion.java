package com.restaurant.servicios;

import com.restaurant.beans.ItemBean;
import com.restaurant.beans.MesaBean;
import com.restaurant.beans.PresentacionBean;
public interface NegocioServiceAdministracion {

	public boolean crearNuevaEntradaMenu(ItemBean item);
	public boolean agregarPresentacion(PresentacionBean presentacion);
	public boolean eliminarPresentacion(PresentacionBean presentacion);
	public boolean modificarPresentacion(PresentacionBean presentacion);
	public boolean eliminarEntrada(ItemBean item);
	public void crearNuevaMesa(MesaBean mesa);
	public void eliminarMesa(MesaBean mesa);
	
	
}
