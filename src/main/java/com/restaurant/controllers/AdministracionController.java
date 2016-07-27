package com.restaurant.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restaurant.beans.UsuarioBean;
import com.restaurant.modelo.Persona;
import com.restaurant.modelo.Usuario;
import com.restaurant.servicios.AdministradorService;
import com.restaurant.servicios.MesonerosService;
import com.restaurant.servicios.PersonaService;

@Controller
public class AdministracionController {

	@Autowired
	PersonaService personServ;

	@Autowired
	AdministradorService adminServ;
	
	@Autowired
	MesonerosService mesoserv;
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
	
	
}
