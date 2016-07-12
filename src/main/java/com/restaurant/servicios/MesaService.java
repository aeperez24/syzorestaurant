package com.restaurant.servicios;

import com.restaurant.modelo.Mesa;
import com.restaurant.modelo.Posicion;

public interface MesaService {
	
	public Posicion createPosicion(int columna,int fila);
	public Posicion getPosicion(int columna,int fila);
	public Mesa createMesa(Posicion posicion);
	public boolean saveMesa(Mesa mesa);
	public boolean savePosicion(Posicion posicion);
	public Mesa getMesaInPosicion(int columna,int fila);
	
	
}
