package com.restaurant.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

import com.restaurant.beans.UsuarioBean;
import com.restaurant.modelo.Persona;
import com.restaurant.modelo.Usuario;
import com.restaurant.servicios.PersonaService;
import com.restaurant.servicios.PersonaServiceImpl;

@Controller
@SessionAttributes
public class ManejoSessionController {
	@Autowired
	PersonaService personServ;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home()
	{
		
		return "redirect:/panel";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model)
	{
		
		return "loginform";
	}
	
	
	@RequestMapping(value = "/inicioSession", method = RequestMethod.POST)
	public String inicioSession(HttpServletRequest request, HttpServletResponse response,Model model,UsuarioBean loginBean)
	{	//verificacion de que es un usuario valido
		if(personServ.validaUsuario(loginBean))
		{
			//verificacion del tipo de usuario(administrador)
			if((personServ.getUsuarioByUserName(loginBean.getUsername()).getTipoUsuario().equals(Usuario.tiposUsuarios[Usuario.USUARIOADMINISTRADOR])))
			{
					//redireccionar  a el menu de administrador o agregar funciiones de admnistrador
					System.out.println("exito el usuario es un administrador");
			}
			//verificacion del tipo de usuario(mesonero)
			if((personServ.getUsuarioByUserName(loginBean.getUsername()).getTipoUsuario().equals(Usuario.tiposUsuarios[Usuario.USUARIOMESONERO])))
			{
				System.out.println("exito el usuario es un mesonero");	
				//redireccionar  a el menu de mesonero o agregar funciiones de mesonero
			}
			
			System.out.println(loginBean.getUsername());
			System.out.println(loginBean.getPassword());
			UsuarioBean usuario=new UsuarioBean();
			usuario.setUsername(loginBean.getUsername());
			request.getSession().setAttribute("Usuario",usuario);
			
			return "redirect:/panel";
		}else
		{	System.out.println("tipo de usuario no encontrado");
		
			return "loginform";
			//mensaje de error
		}

		
		
	        
	}
	
	@RequestMapping(value = "/panel", method = RequestMethod.GET)
	public String sendToPanel(HttpServletRequest request, HttpServletResponse response,Model model,UsuarioBean loginBean)
	{	if(request.getSession().getAttribute("Usuario")!=null)
		{UsuarioBean usuario=(UsuarioBean) request.getSession().getAttribute("Usuario");
		model.addAttribute("Usuario",usuario.getUsername());
		return getMenuParaUsuario(usuario);}
		
	return "redirect:/login";
		
	}
	
	
	
	
	
	private String getMenuParaUsuario(UsuarioBean usuarioBean)
	{
		Usuario usuario=personServ.getUsuarioByUserName(usuarioBean.getUsername());
		
		if(usuario.getTipoUsuario().equals(Usuario.tiposUsuarios[Usuario.USUARIOMESONERO]))
		{
			
			return "panel_mesonero";
		}
		else if(usuario.getTipoUsuario().equals(Usuario.tiposUsuarios[Usuario.USUARIOADMINISTRADOR]))
		{
			
			return "panel_administrador";
		}
		
		
		
		return "redirect:/loggin";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
