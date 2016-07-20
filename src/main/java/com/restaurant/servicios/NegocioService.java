package com.restaurant.servicios;

import com.restaurant.beans.ItemBean;
import com.restaurant.beans.MesaBean;
import com.restaurant.beans.OrdenBean;
import com.restaurant.beans.UsuarioBean;

public interface NegocioService {

	public boolean ocuparMesa(MesaBean mesa,UsuarioBean usuario,UsuarioBean mesonero);
	public boolean iniciarNuevaOrden(MesaBean mesa);
	public boolean agregarPeticionAOrden(MesaBean mesa,ItemBean item);
	public boolean cancelarOrden(MesaBean mesa,OrdenBean orden);
	public boolean finalizarOrden(MesaBean mesa,OrdenBean orden);

	public boolean servir(MesaBean mesa,OrdenBean orden,ItemBean item);
	public boolean generarFactura(MesaBean mesa);
	public boolean finalizarFactura(MesaBean mesa);
	public boolean desocuparMesa(MesaBean mesa);
	public boolean creacionCliente();
	
	
}
