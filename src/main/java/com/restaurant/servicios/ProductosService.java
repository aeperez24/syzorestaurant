package com.restaurant.servicios;

import java.util.List;

import com.restaurant.modelo.Item;
import com.restaurant.modelo.Presentacion;

public interface ProductosService {
	public Item createItem(String codigo,String nombre,String descripcion,int categoria);
	public Item modificarDescripcion(String codigo,String descripcion);
	public Item modificarNombre(String codigo,String nombre);
	public Item agregarPresentacion(Item item,String nombre,float precio);
	public Item agregarPresentacion(String codigo,String nombre,float precio);
	public boolean removerPresentacion(Item item,String nombre);
	public Item findItemByCodigo(String codigo);
	public Item findItemByNombre(String nombre);
	public int getNumeroCategoria(String categoria);
	public boolean modificarPresentacion(Item item, String nombre, float precio);
	public boolean eliminarItem(Item item);
	public List<Item> obtenerItems();
	


}
