package com.restaurant.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dao.ItemDao;
import com.restaurant.dao.PresentacionDao;
import com.restaurant.modelo.Item;
import com.restaurant.modelo.Presentacion;
@Service
public class ProductosServiceImpl implements ProductosService{
	@Autowired
	ItemDao itemDao;
	@Autowired
	PresentacionDao presendao;
	@Override
	public Item createItem(String codigo, String nombre, String descripcion,int categoria) {
		// TODO Auto-generated method stub
		if(findItemByCodigo(codigo)==null&&findItemByNombre(nombre)==null)
		{
			Item item=new Item();
			item.setNombre(nombre);
			item.setCodigo(codigo);
			item.setDescripcion(descripcion);
			item.setCategoria(Item.categorias[categoria]);
			itemDao.save(item);
			return item;
		}
	
		return null;
	}

	@Override
	public Item modificarDescripcion(String codigo, String descripcion) {
		// TODO Auto-generated method stub
			Item item=findItemByCodigo(codigo);
			if(item!=null)
			{
				item.setDescripcion(descripcion);
				return item;
			}
		return null;
	}

	@Override
	public Item modificarNombre(String codigo, String nombre) {
		// TODO Auto-generated method stub
		Item item=findItemByCodigo(codigo);
		if(item!=null)
		{
			item.setNombre(nombre);
			return item;
		}
		return null;
	}

	@Override
	public Item agregarPresentacion(Item item, String nombre, float precio) {
		// TODO Auto-generated method stub
		Presentacion presentacion=new Presentacion();
		presentacion.setNombre(nombre);
		presentacion.setPrecio(precio);
		item.getPresentaciones().add(presentacion);
		
		itemDao.save(item);
		return item;
	}

	@Override
	public Item agregarPresentacion(String codigo, String nombre, float precio) {
		// TODO Auto-generated method stub
		Item item=findItemByCodigo(codigo);
		if(item!=null)
			return agregarPresentacion(item, nombre, precio);
		return null;
	}

	

	@Override
	public Item findItemByCodigo(String codigo) {
		// TODO Auto-generated method stub
		List<Item> lista=(List<Item>) itemDao.findAll();
		for(Item item:lista)
			if(item.getCodigo().equals(codigo))
				return item;
		return null;
	}

	@Override
	public Item findItemByNombre(String nombre) {
		// TODO Auto-generated method stub
		List<Item> lista=(List<Item>) itemDao.findAll();
		for(Item item:lista)
			if(item.getNombre().equals(nombre))
				return item;
		return null;
	}
	
	
	
	@Override
	public boolean removerPresentacion(Item item, String nombre) {
		// TODO Auto-generated method stub
		
		for(Presentacion presentacion:item.getPresentaciones())
			if(presentacion.getNombre().equals(nombre))
			{
				item.getPresentaciones().remove(presentacion);
				presendao.delete(presentacion);
				itemDao.save(item);
				return true;
			}
		return false;
	}
	
	
	@Override
	public boolean modificarPresentacion(Item item, String nombre,float precio) {
		// TODO Auto-generated method stub
		
		for(Presentacion presentacion:item.getPresentaciones())
			if(presentacion.getNombre().equals(nombre))
			{
				presentacion.setPrecio(precio);
				presendao.save(presentacion);
				return true;
			}
		return false;
	}
	
	@Override
	public boolean eliminarItem(Item item)
	{
		
		itemDao.delete(item);
		return true;
	}
	
	@Override
	public int getNumeroCategoria(String categoria)
	{	
		for(int i=0;i<Item.categorias.length;i++)
		{
			
			if(categoria.equals(Item.categorias[i]))
				return i;
		}
		return 0;
	}
	@Override
	public List<Item> obtenerItems()
	{
		return (List<Item>) itemDao.findAll();
	}

}
