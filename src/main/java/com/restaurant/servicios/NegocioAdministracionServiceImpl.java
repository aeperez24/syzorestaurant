package com.restaurant.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.beans.ItemBean;
import com.restaurant.beans.MesaBean;
import com.restaurant.beans.PresentacionBean;
import com.restaurant.modelo.Item;
import com.restaurant.modelo.Presentacion;

@Service
public class NegocioAdministracionServiceImpl  implements NegocioServiceAdministracion{
	@Autowired
	ProductosService productoService;
	MesaService mesaService;
	
	@Override
	public boolean crearNuevaEntradaMenu(ItemBean item) {
		// TODO Auto-generated method stub
		if((productoService.findItemByCodigo(item.getCodigo())   ==null)&&(productoService.findItemByNombre(item.getNombre())==null))
		{
			productoService.createItem(item.getCodigo(), item.getNombre(), item.getDescripcion(),productoService.getNumeroCategoria(item.getCategoria()));
			return true;
			
		}
		return false;
		
	}

	@Override
	public boolean agregarPresentacion(PresentacionBean presentacion) {
		// TODO Auto-generated method stub
		
		Item entrada=productoService.findItemByCodigo(presentacion.getCodigoItem());
		if(entrada!=null)
		{
			for(Presentacion presentacionx:entrada.getPresentaciones())
			{
				if(presentacionx.getNombre().equals(presentacion))
					return false;
				
			}
			productoService.agregarPresentacion(presentacion.getCodigoItem(), presentacion.getNombre(), presentacion.getPrecio());
			return true;
		}
		return false;
			
	}

	@Override
	public boolean eliminarPresentacion(PresentacionBean presentacion) {
		// TODO Auto-generated method stub
		Item entrada=productoService.findItemByCodigo(presentacion.getCodigoItem());
		if(entrada!=null)
		{
			for(Presentacion presentacionAux:entrada.getPresentaciones())
			{
				if(presentacionAux.getNombre().equals(presentacion.getNombre()))
				{
					productoService.removerPresentacion(entrada, presentacion.getNombre());
					return true;
				}
			}
			
		}
		return false;
	}

	@Override
	public boolean modificarPresentacion(PresentacionBean presentacion) {
		// TODO Auto-generated method stub
		
		
		Item entrada=productoService.findItemByCodigo(presentacion.getCodigoItem());
		if(entrada!=null)
		{
			for(Presentacion presentacionAux:entrada.getPresentaciones())
			{
				if(presentacionAux.getNombre().equals(presentacion.getNombre()))
				{
					productoService.modificarPresentacion(entrada, presentacion.getNombre(),presentacion.getPrecio());
					return true;
				}
			}
			
		}
		return false;
	}

	@Override
	public boolean eliminarEntrada(ItemBean item) {
		// TODO Auto-generated method stub
		Item entrada=productoService.findItemByCodigo(item.getCodigo());
		if(entrada!=null)
			{productoService.eliminarItem(entrada);
			return true;
			}
		return false;
	}

	@Override
	public void crearNuevaMesa(MesaBean mesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarMesa(MesaBean mesa) {
		// TODO Auto-generated method stub
		
	}

}
