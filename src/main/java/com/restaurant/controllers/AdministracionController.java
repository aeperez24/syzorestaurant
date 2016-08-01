package com.restaurant.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restaurant.beans.ItemBean;
import com.restaurant.beans.PersonaBean;
import com.restaurant.beans.UsuarioBean;
import com.restaurant.modelo.Item;
import com.restaurant.modelo.Mesonero;
import com.restaurant.modelo.Persona;
import com.restaurant.modelo.Presentacion;
import com.restaurant.modelo.Usuario;
import com.restaurant.servicios.AdministradorService;
import com.restaurant.servicios.MesonerosService;
import com.restaurant.servicios.PersonaService;
import com.restaurant.servicios.ProductosService;

@Controller
public class AdministracionController {

	@Autowired
	PersonaService personServ;

	@Autowired
	AdministradorService adminServ;
	
	@Autowired
	MesonerosService mesoserv;
	
	@Autowired
	ProductosService prodserv;
	@RequestMapping(value = "/creaMesoneroExe", method = RequestMethod.GET)
	public String creaMesoneroExe(HttpServletRequest request,Model model)
	{
		UsuarioBean userbean=(UsuarioBean) request.getSession().getAttribute("Usuario");
		List<String> errores=new ArrayList<String>();
		if(userbean!=null)
			{if(personServ.validaTipoUsuario(userbean.getUsername(), Usuario.tiposUsuarios[Usuario.USUARIOADMINISTRADOR]))
				{
				
				String nombre=request.getParameter("nombre");
				
				String apellido=request.getParameter("apellido");
				
				String identificacion=request.getParameter("identificacion");
				
				String userName=request.getParameter("usuario");
				
				if(nombre.equals("")||apellido.equals("")||identificacion.equals("")||userName.equals(""))
				{
					errores.add(" algun campo necesario fue dejado  en blanco");
					model.addAttribute("errores",errores);
					return "creacionMesoneroForm";
				}
				
				//validar la identificacion de la persona
				
				if(personServ.getPersonaByIdentificacion(identificacion)!=null)
				{
					
					errores.add("identificacion ya utilizada");
					model.addAttribute("errores",errores);
					return "creacionMesoneroForm";
				}
				
				//valida que no exista el usuario
				
				if(personServ.getUsuarioByUserName(userName)!=null)
				{
					
					errores.add("nombre de usuario ya utilizado");
					model.addAttribute("errores",errores);
					return "creacionMesoneroForm";
				}
				
				//crea la persona
				Persona persona=personServ.createPersona(nombre, apellido, identificacion);
				
				//crea el usuario
				Usuario usuario=personServ.createUsuario(userName,"***");
				
				personServ.setUsuario(persona, usuario);
				mesoserv.CreateMesonero(persona);
				
				return "redirect:/panel";
				
				
				
				
				
				}
			}
		return "redirect:/panel";
	}
	
	
	
	@RequestMapping(value = "/modificaPersonaExe", method = RequestMethod.GET)
	public String modificaEmpleadoExe(HttpServletRequest request,Model model)
	{
		UsuarioBean userbean=(UsuarioBean) request.getSession().getAttribute("Usuario");
		List<String> errores=new ArrayList<String>();
		if(userbean!=null)
			{if(personServ.validaTipoUsuario(userbean.getUsername(), Usuario.tiposUsuarios[Usuario.USUARIOADMINISTRADOR]))
				{
				
				String nombre=request.getParameter("nombre");
				
				String apellido=request.getParameter("apellido");
				
				String identificacion=request.getParameter("identificacion");
				
				
				if(nombre.equals("")||apellido.equals("")||identificacion.equals(""))
				{
					errores.add(" algun campo necesario fue dejado  en blanco");
					model.addAttribute("errores",errores);
					return "creacionMesoneroForm";
				}
				
				//validar la identificacion de la persona
				
				if(personServ.getPersonaByIdentificacion(identificacion)!=null)
				{
					
					errores.add("identificacion ya utilizada");
					model.addAttribute("errores",errores);
					return "creacionMesoneroForm";
				}
				
				//crea la persona
				Persona persona=personServ.getPersonaByIdentificacion(identificacion);
				persona.setNombre1(nombre);
				persona.setNombre2(apellido);
				personServ.savePersona(persona);
				
				return "redirect:/panel";
				
				
				
				
				
				}
			}
		return "redirect:/panel";
	}
	

	
	

	@RequestMapping(value = "/resetPersonaPassword", method = RequestMethod.GET)
	public String resetPersonaPasword(HttpServletRequest request,Model model)
	{		//validacion
		
		
			return "resetPersonaPasswordForm";
		
	}	
	
	@RequestMapping(value = "/resetPersonaPasswordExe", method = RequestMethod.GET)
	public String resetPersonaPaswordExe(HttpServletRequest request,Model model)
	{
		String identificacion=request.getParameter("identificacion");
		if(identificacion=="")
			return "resetPersonaPasswordForm";
		
		Persona persona=personServ.getPersonaByIdentificacion(identificacion);
		
		Usuario usuario=persona.getUsuario();
		
		usuario.setPassword("***");
		personServ.saveUsuario(usuario);
		
		return "redirect:/";
	}	
	
	
	
	@RequestMapping(value = "/getMesonerosActivos", method = RequestMethod.GET)	
	@ResponseBody
	public List<PersonaBean> obtenerMesonerosActivos()
	{
		List<Mesonero> mesoneros=mesoserv.getMesonerosActivos();
		List<PersonaBean> personasBean=new ArrayList<PersonaBean>();
		PersonaBean personaAux;
		for(Mesonero mesonero:mesoneros)
		{personaAux=new PersonaBean();
		personaAux.setNombre1(mesonero.getPersona().getNombre1());
		personaAux.setNombre2(mesonero.getPersona().getNombre2());
		personaAux.setId(mesonero.getPersona().getId());
		personasBean.add(personaAux);
			
		}
		return personasBean;
	} 
	
	
	@RequestMapping("creaEntrada")
	public String crearEntrada()
	{
		
		return "creacionEntradaForm";
		
	}
	
	@RequestMapping("creaEntradaExe")
	public String crearEntradaExe(HttpServletRequest request,Model model)
	{

		//validar que es un administrador
		
		
		String categoria=request.getParameter("categoria");
		String nombre=request.getParameter("nombre");
		String codigo=request.getParameter("codigo");
		String descripcion=request.getParameter("descripcion");
		List<String> errores=new ArrayList<String>();
		model.addAttribute("errores",errores);
		if(categoria.equals("")||nombre.equals("")||codigo.equals(""))
			{
			errores.add("Rellene los campos necesarios");
			
			return "creacionEntradaForm";
			}
		if(prodserv.getNumeroCategoria(categoria)!=0&&prodserv.findItemByNombre(nombre)==null&&prodserv.findItemByCodigo(codigo)==null)
		{
			prodserv.createItem(codigo, nombre, descripcion,prodserv.getNumeroCategoria(categoria));

			return "redirect:/";
		}
		else
		{
			
			//manejo de errores
			if(prodserv.getNumeroCategoria(categoria)==0)
				errores.add("Categoria no invalida");
			if(prodserv.findItemByNombre(nombre)!=null)
				errores.add("ya existe el nombre en el menu");
			if(prodserv.findItemByCodigo(codigo)!=null)
				errores.add("ya existe el codigo en el menu");
			
			return "creacionEntradaForm";
		}
		
		
	}

	@RequestMapping("agregaPresentacionExe")
	
	public String agregarPresentacion(HttpServletRequest request,Model model)
	{

		//validar que es un administrador
		String nombreEntrada=request.getParameter("nombreI");;
		String nombrePresentacion=request.getParameter("nombreP");;
		//String descripcion=request.getParameter("descripcion");;
		//valida precio
		float precio= Float.parseFloat(request.getParameter("precio")); 
		
		Item item=prodserv.findItemByNombre(nombreEntrada);
		//validar nombre
		if(item==null)
			return "redirect:/";
		
		//validar presentacion
		for(Presentacion presentacion:item.getPresentaciones())
		{
			if(presentacion.getNombre().equals(nombrePresentacion))
				return "redirect:/";
		}
		
		//valida precio
		
		
		
		//agregapresentacion
		
		prodserv.agregarPresentacion(item, nombrePresentacion, precio);
		
		
		
		return "redirect:/";
		
	}
	

	
	
	
	@RequestMapping("agregaPresentacionForm")
	public String agregaPresentacionForm(HttpServletRequest request,Model model)
	{
		//validar usuario
		
		List<ItemBean> itemsBean=new ArrayList<ItemBean>();
		List<Item> items=prodserv.obtenerItems();
		for(Item item:items)
		{
			ItemBean itemBean=new ItemBean();
			itemBean.setNombre(item.getNombre());
			itemsBean.add(itemBean);
			itemBean.setDescripcion(item.getDescripcion());
			itemBean.setTipo(item.getCategoria());
			
		}
		model.addAttribute("items",itemsBean);
		return "agregaPresentacionForm";
		
	}
	
	
	

	@RequestMapping("eliminaPresentacionForm")
	public String eliminaPresentacionForm(HttpServletRequest request,Model model)
	{
		//validar usuario

		List<ItemBean> itemsBean=new ArrayList<ItemBean>();
		List<Item> items=prodserv.obtenerItems();
		for(Item item:items)
		{
			ItemBean itemBean=new ItemBean();
			itemBean.setNombre(item.getNombre());
			itemsBean.add(itemBean);
			itemBean.setDescripcion(item.getDescripcion());
			itemBean.setTipo(item.getCategoria());
			
		}
		model.addAttribute("items",itemsBean);
		
		return "eliminaPresentacionForm";
		
	}
	
	
	
	
	
	
	
	
	@RequestMapping("eliminaPresentacionExe")
	public String eliminaPresentacion(HttpServletRequest request,Model model)
	{

		//validar que es un administrador
		
		
		
		
		
		String nombreEntrada=request.getParameter("nombreI");
		String nombrePresentacion=request.getParameter("nombreP");;
		
		Item item= prodserv.findItemByNombre(nombreEntrada);
		if(item!=null)
		{
			for(Presentacion presentacion:item.getPresentaciones())
			{
				if(presentacion.getNombre().equals(nombrePresentacion))
				{
					prodserv.removerPresentacion(item, nombrePresentacion);
				}
			}
		}
		
		return "redirect:/";
		
	}
	
	
	public String modificarPresentacion(HttpServletRequest request,Model model)
	{

		//validar que es un administrador
		String nombreEntrada;
		String nombrePresentacion;
		String descripcion;
		float precio; 
		
		
		return "redirect:/";
		
	}
	
	
	
	
	//public String agregarMesa(){}
	//public String eliminarMesa(){}
	
	
	
	
	
	
//	public String eliminaEmpleado()
//	{
//		return "";
//	}
	
//	public String modificaTipoEmpleado(HttpServletRequest request,Model model)
//	{
//		
//		return "";
//	}
	
	
}
