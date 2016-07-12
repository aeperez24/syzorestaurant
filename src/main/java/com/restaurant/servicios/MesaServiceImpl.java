package com.restaurant.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dao.MesaDao;
import com.restaurant.dao.PosicionDao;
import com.restaurant.modelo.Mesa;
import com.restaurant.modelo.Posicion;

@Service
public class MesaServiceImpl implements MesaService {
	@Autowired
	private PosicionDao posicionDao;
	@Autowired
	private MesaDao mesaDao;
	@Override
	public Posicion createPosicion(int columna, int fila) {
		// TODO Auto-generated method stub
		Posicion posicion=new Posicion();
		posicion.setColumna(columna);
		posicion.setFila(fila);
		List<Posicion> posiciones=(List<Posicion>) posicionDao.findAll();
		for(Posicion posAux:posiciones)
		{
			if(posAux.getColumna()==columna&&posAux.getFila()==fila)
				return null;
		}
		savePosicion(posicion);
		return posicion;
	}

	@Override
	public Posicion getPosicion(int columna, int fila) {
		// TODO Auto-generated method stub
		List<Posicion> posiciones=(List<Posicion>) posicionDao.findAll();
		for(Posicion posAux:posiciones)
		{
			if(posAux.getColumna()==columna&&posAux.getFila()==fila)
				return posAux;
		}
		return null;
	}

	@Override
	public Mesa createMesa(Posicion posicion) {
		// TODO Auto-generated method stub
		Mesa mesa=new Mesa();
		mesa.setPosicion(posicion);
		posicion.setMesa(mesa);
		saveMesa(mesa);
		savePosicion(posicion);
		
		return mesa;
	}

	
	@Override
	public boolean saveMesa(Mesa mesa)
	{
		// TODO Auto-generated method stub
		mesaDao.save(mesa);
		return true;
	}

	
	@Override
	public boolean savePosicion(Posicion posicion)
	{
		// TODO Auto-generated method stub
		posicionDao.save(posicion);
		return true;
	}

	
	@Override
	public Mesa getMesaInPosicion(int columna, int fila) 
	{
		// TODO Auto-generated method stub
		List<Mesa> mesas=(List<Mesa>) mesaDao.findAll();
		for(Mesa mesa:mesas)
		{
			if(mesa.getPosicion().getColumna()==columna&&mesa.getPosicion().getFila()==fila)
				return mesa;
		}
		return null;
	}

}
