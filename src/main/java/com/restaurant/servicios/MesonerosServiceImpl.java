package com.restaurant.servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dao.MesoneroDao;
import com.restaurant.modelo.Mesa;
import com.restaurant.modelo.Mesonero;
import com.restaurant.modelo.Persona;
import com.restaurant.modelo.Usuario;
@Service
public class MesonerosServiceImpl implements MesonerosService{
	@Autowired
	private MesoneroDao mesoneroDao;
	@Autowired
	private PersonaServiceImpl personaService;
	@Autowired
	private MesaServiceImpl mesaserv;
	
	@Override
	public Mesonero CreateMesonero(Persona persona) {
		// TODO Auto-generated method stub
		Mesonero mesonero=new Mesonero();
		mesonero.setPersona(persona);
		Usuario usuario=persona.getUsuario();
		usuario.setTipoUsuario(Usuario.tiposUsuarios[Usuario.USUARIOMESONERO]);
		personaService.savePersona(persona);
		personaService.saveUsuario(usuario);
		saveMesonero(mesonero);
		return mesonero;
	}

	@Override
	public boolean saveMesonero(Mesonero mesonero) {
		// TODO Auto-generated method stub
		mesoneroDao.save(mesonero);
		return false;
	}

	@Override
	public Mesonero getMesoneroById(long id) {
		// TODO Auto-generated method stub
		return mesoneroDao.findOne(id);
	}

	@Override
	public Mesonero getMesoneroByIdentificacion(String identificacion) {
		// TODO Auto-generated method stub
		List<Mesonero> mesoneros=(List<Mesonero>) mesoneroDao.findAll();
		for(Mesonero mesonero:mesoneros)
			if(mesonero.getPersona().getIdentificacion().equals(identificacion))
				{
				return mesonero;
				}
		return null;
	}

	@Override
	public Mesonero getMesoneroByUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		List<Mesonero> mesoneros=(List<Mesonero>) mesoneroDao.findAll();
		for(Mesonero mesonero:mesoneros)
		{
			if(mesonero.getPersona().getUsuario().getId()==usuario.getId())
				return mesonero;
		}
		return null;
	}

	@Override
	public boolean asignarMesa(Mesonero mesonero, Mesa mesa) {
		// TODO Auto-generated method stub
		if(!mesa.isAsignada()&&mesonero.isActivo())
		{	
			mesa.setAsignada(true);
			mesaserv.saveMesa(mesa);
			mesonero.getMesasAsignadas().add(mesa);
			saveMesonero(mesonero);
			
			mesonero=null;
			
			
			return true;
		}
		return false;
	}

	@Override
	public boolean desasignarMesa(Mesonero mesonero, Mesa mesa) {
		// TODO Auto-generated method stub
		for(Mesa mesaAsignada:mesonero.getMesasAsignadas())
			if(mesaAsignada.getId()==mesa.getId())
			{
				mesonero.getMesasAsignadas().remove(mesaAsignada);
				mesaAsignada.setAsignada(false);
				saveMesonero(mesonero);
				mesaserv.saveMesa(mesaAsignada);
				return true;
			}
		return false;
	}
	
	@Override
	public boolean activarMesonero(Mesonero mesonero)
	{
		if(mesonero.isActivo())
			return false;
		else
		{
			mesonero.setActivo(true);
			saveMesonero(mesonero);
			return true;
		}
	}
	
	@Override
	public boolean desactivarMesonero(Mesonero mesonero)
	{
		
		if(!mesonero.isActivo())
			return false;
		else
		{
			mesonero.setActivo(false);
			saveMesonero(mesonero);
			return true;
		}
	}
	
	@Override
	public List<Mesonero> getMesonerosActivos()
	{
		List<Mesonero> mesoneros=(List<Mesonero>) mesoneroDao.findAll();
		List<Mesonero> resultado=new ArrayList<>();
		for(Mesonero mesonero:mesoneros)
		{
			if(mesonero.isActivo())
				resultado.add(mesonero);
			
		}
		return resultado;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	//en construccion
	
	
	
	public Mesonero inicializacion(Mesonero mesonero)
	{
		Hibernate.initialize(mesonero.getMesasAsignadas());
		return mesonero;
	}
	
	
	
	public List<Mesonero> sortByMesasAsignadas(List<Mesonero> mesoneros)
	{	
	
		Mesonero auxMesonero;
		List<Mesonero> resultado=new ArrayList<Mesonero>();
		Mesonero minMesonero=null;
		while(!mesoneros.isEmpty())
		{minMesonero=null;
			for(Mesonero mesonero:mesoneros)
			{
				if(minMesonero==null)
					minMesonero=mesonero;
				else
				{
					if(minMesonero.getMesasAsignadas().size()>mesonero.getMesasAsignadas().size())
						minMesonero=mesonero;
					
					
				}
				
			}
			if(minMesonero!=null)
			{
				resultado.add(minMesonero);
				mesoneros.remove(minMesonero);
			}
		}
		
		return resultado;
		
	}
	

}
