package com.restaurant.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.beans.UsuarioBean;
import com.restaurant.dao.PersonaDao;
import com.restaurant.dao.UsuarioDao;
import com.restaurant.modelo.Persona;
import com.restaurant.modelo.Usuario;
@Service
public class PersonaServiceImpl implements PersonaService{
	@Autowired
	
	PersonaDao personaDao;
	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	public Persona getPersonaByIdentificacion(String identificacion) {
		// TODO Auto-generated method stub
		List<Persona> listaPersonas=(List<Persona>) personaDao.findAll();
		for(Persona persona:listaPersonas)
			if(persona.getIdentificacion().equals(identificacion))
				return persona;
		return null;
	}

	@Override
	public Persona getPersonaById(long id) {
		// TODO Auto-generated method stub
		personaDao.findOne(id);
		return null;
	}

	@Override
	public Persona createPersona(String nombre1, String nombre2,String identicacion) {
		// TODO Auto-generated method stub
		
		Persona persona =new  Persona();
		persona.setNombre1(nombre1);
		persona.setNombre2(nombre2);
		persona.setIdentificacion(identicacion);
		List<Persona> personas=(List<Persona>) personaDao.findAll();
		for(Persona personaAux:personas)
		{
			if(personaAux.getIdentificacion().equals(persona.getIdentificacion()))
				return null;
		}
		personaDao.save(persona);
		return persona;
	}

	@Override
	public boolean setUsuario(Persona persona, Usuario usuario) {
		// TODO Auto-generated method stub
		if(persona.getUsuario()==null)
			{
			persona.setUsuario(usuario);
			
			savePersona(persona);
			System.out.println("guardado");
			return true;
			}
		return false;
	}

	@Override
	public Persona removeUsuario(Persona persona) {
		// TODO Auto-generated method stub
		Usuario usuario=persona.getUsuario();
		if(usuario!=null)
		{	persona.setUsuario(null);
			usuarioDao.delete(usuario);}
		return persona;
	}

	@Override
	public boolean savePersona(Persona persona) {
		// TODO Auto-generated method stub
		personaDao.save(persona);
		return false;
	}

	@Override
	public Usuario createUsuario(String username, String password) {
		// TODO Auto-generated method stub
		Usuario user=new Usuario();
		user.setUsername(username);
		user.setPassword(password);
		List<Usuario> usuarios=(List<Usuario>) usuarioDao.findAll();
		for(Usuario usuarioAux:usuarios)
			if(usuarioAux.getUsername().equals(user.getUsername()))
				return null;
		usuarioDao.save(user);
		return user;
	}

	@Override
	public boolean validaUsuario(String username, String password)
	{
		// TODO Auto-generated method stub
		List<Usuario> listaUsuarios=(List<Usuario>) usuarioDao.findAll();
		for(Usuario usuario:listaUsuarios)
		{
			if(usuario.getUsername().equals(username)&&usuario.getPassword().equals(password))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean validaUsuario(UsuarioBean usuario)
	{
		if(validaUsuario(usuario.getUsername(), usuario.getPassword()))
		{
			Usuario user=getUsuarioByUserName(usuario.getUsername());
			usuario.setId(user.getId());
			return true;
		}
		return false;
	}
	@Override
	
	public Usuario getUsuarioByUserName(String username)
	{
		List<Usuario> listaUsuarios=(List<Usuario>) usuarioDao.findAll();
		for(Usuario usuario:listaUsuarios)
		{
			if(usuario.getUsername().equals(username))
				return usuario;
		}
		return null;
	}
	
	@Override
	public boolean saveUsuario(Usuario user)
	{	
		usuarioDao.save(user);
		return true;
	}
	@Override
	public boolean validaTipoUsuario(String usuario,String tipo)
	{
		Usuario userAux=getUsuarioByUserName(usuario);
		if(userAux!=null)
		{
			return userAux.getTipoUsuario().equals(tipo);
		}
		
		return false;
		
	}

}
