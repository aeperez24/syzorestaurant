package com.restaurant.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dao.ClienteDao;
import com.restaurant.dao.PersonaDao;
import com.restaurant.modelo.Cliente;
import com.restaurant.modelo.Mesa;
import com.restaurant.modelo.Persona;
import com.restaurant.modelo.Usuario;
@Service
public class ClienteServiceImpl implements ClienteService{
	@Autowired
	private ClienteDao clienteDao;
	@Autowired PersonaService personaService;
	@Autowired MesaService mesaservice;
	@Override
	public Cliente getClienteByIdentificacion(String identificacion) {
		// TODO Auto-generated method stub
		List<Cliente> clientes=(List<Cliente>) clienteDao.findAll();
		for(Cliente cliente:clientes)
		{
			if(cliente.getPersona().getIdentificacion().equals(identificacion))
				return cliente;
		}
		return null;
	}

	@Override
	public Cliente getClienteById(long id) {
		// TODO Auto-generated method stub
		clienteDao.findOne(id);
		return null;
	}

	@Override
	public Cliente createCliente(Persona persona) {
		
		// TODO Auto-generated method stub
		Cliente cliente=new Cliente();
		cliente.setPersona(persona);
		Usuario usuario=persona.getUsuario();
		usuario.setTipoUsuario(Usuario.tiposUsuarios[Usuario.USUARIOCLIENTE]);
		personaService.saveUsuario(usuario);
		saveCliente(cliente);
		return cliente;
	}

	@Override
	public Cliente setUsuario(Cliente cliente, Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean asignClienteMesa(Cliente cliente, Mesa mesa) {
		// TODO Auto-generated method stub
		if(!mesa.isOcupada())
		{
			cliente.setMesasOcupada(mesa);
			mesa.setOcupada(true);
			mesaservice.saveMesa(mesa);
			clienteDao.save(cliente);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean desasignClienteMesa(Cliente cliente, Mesa mesa) {
		// TODO Auto-generated method stub
		if(cliente.getMesasOcupada().getId()==mesa.getId())
		{
			cliente.setMesasOcupada(null);
			mesa.setOcupada(false);
			return true;
		}
		
		return false;
	}
	public boolean saveCliente(Cliente cliente)
	{	clienteDao.save(cliente);
		return true;
	}

}
