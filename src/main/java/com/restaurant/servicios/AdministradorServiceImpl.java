package com.restaurant.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dao.AdministradorDao;
import com.restaurant.dao.UsuarioDao;
import com.restaurant.modelo.Administrador;
import com.restaurant.modelo.Persona;
import com.restaurant.modelo.Usuario;

@Service
public class AdministradorServiceImpl implements AdministradorService {
	
	@Autowired
	AdministradorDao admindao;
	@Autowired
	UsuarioDao usuariodao;
	@Override
	public Administrador createAdministrador(Persona persona) {
		// TODO Auto-generated method stub
		Administrador administrador =new Administrador();
		administrador.setPersona(persona);
		Usuario usuario=persona.getUsuario();
		
		usuario.setTipoUsuario(Usuario.tiposUsuarios[Usuario.USUARIOADMINISTRADOR]);
		
		admindao.save(administrador);
		usuariodao.save(usuario);
		return administrador;
	}

	@Override
	public Administrador getAdministradorById(long id) {
		// TODO Auto-generated method stub
		return admindao.findOne(id);
		
	}

	@Override
	public Administrador getAdministradorByIdentificacion(String identificacion) {
		// TODO Auto-generated method stub
		List<Administrador> administradores=(List<Administrador>) admindao.findAll();
		for(Administrador administrador:administradores)
		{
			if(administrador.getPersona().getIdentificacion().equals(identificacion))
				return administrador;
		}
		return null;
	}

	@Override
	public boolean saveAdministrador(Administrador administrador) {
		// TODO Auto-generated method stub
		admindao.save(administrador);
		return true;
	}

}
