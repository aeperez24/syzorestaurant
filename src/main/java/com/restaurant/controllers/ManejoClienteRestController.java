package com.restaurant.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.beans.ItemBean;
import com.restaurant.beans.PresentacionBean;
import com.restaurant.modelo.Item;
import com.restaurant.modelo.Presentacion;
import com.restaurant.servicios.ProductosService;

@RestController
public class ManejoClienteRestController {
	@Autowired
	ProductosService prodserv;
//servicios web para el cliente
	
	@RequestMapping("getPresentacionesByNombreItem")
	public String presentacionesByNombreItem(String nombreItem) throws JsonProcessingException
	{
		List<PresentacionBean> presentacionBeans=new ArrayList<PresentacionBean>();
		Item item=prodserv.findItemByNombre(nombreItem);
		if(item!=null)
		{
			for(Presentacion presentacion:item.getPresentaciones())
			{
				presentacionBeans.add(generaPresentacionBean(presentacion,item));
			}
		}
		return new ObjectMapper().writeValueAsString(presentacionBeans);
		
		
	}
	
	@RequestMapping("getPresentacionesByCodigoItem")
	public String presentacionesByCodigoItem(String codigoItem) throws JsonProcessingException
	{
		List<PresentacionBean> presentacionBeans=new ArrayList<PresentacionBean>();
		Item item=prodserv.findItemByCodigo(codigoItem);
		if(item!=null)
		{
			for(Presentacion presentacion:item.getPresentaciones())
			{	
				presentacionBeans.add(generaPresentacionBean(presentacion,item));
			}
		}
		return new ObjectMapper().writeValueAsString(presentacionBeans);
		
		
	}
	
	
	
	
	
	@RequestMapping("getItems")
	public String items() throws JsonProcessingException
	{
		List<ItemBean> itemBeans=new ArrayList<>();
		for(Item item:prodserv.obtenerItems())
		{
			ItemBean itemBean=new ItemBean();
			itemBean.setId(item.getId());
			itemBean.setNombre(item.getNombre());
			itemBean.setDescripcion(item.getDescripcion());
			itemBean.setCodigo(item.getCodigo());
			itemBean.setCategoria(item.getCategoria());
			itemBeans.add(itemBean);
		}
		return new ObjectMapper().writeValueAsString(itemBeans);
		
		
		
	}
	
	
	
	
	private PresentacionBean generaPresentacionBean(Presentacion presentacion,Item item)
	{
		PresentacionBean presentacionBean=new PresentacionBean();
		presentacionBean.setNombre(item.getNombre());
		presentacionBean.setPresentacion(presentacion.getNombre());
		presentacionBean.setCodigoItem(item.getCodigo());
		presentacionBean.setPrecio(presentacion.getPrecio());
		presentacionBean.setId(presentacion.getId());
		return presentacionBean;
	}
	
}
