package com.platzi.profesoresplatzi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.profesoresplatzi.dao.Redes_socialesDAO;
import com.platzi.profesoresplatzi.model.Redes_sociales;
import com.platzi.profesoresplatzi.model.Usuario;

@Service("redes_socialesServices")
@Transactional
public class Redes_socialesServicesImp implements Redes_socialesServices{

	@Autowired
	private Redes_socialesDAO _redes_socialesDAO;
	
	@Override
	public void saveRedes_sociales(Redes_sociales r) {
		// TODO Auto-generated method stub
		_redes_socialesDAO.saveRedes_sociales(r);
	}

	@Override
	public List<Redes_sociales> imprimirListaRedes_socialeses() {
		// TODO Auto-generated method stub
		return _redes_socialesDAO.imprimirListaRedes_socialeses();
	}

	@Override
	public void eliminarRedes_sociales(int idRedes_sociales) {
		// TODO Auto-generated method stub
		_redes_socialesDAO.eliminarRedes_sociales(idRedes_sociales);
	}

	@Override
	public void actuaizarRedes_sociales(Redes_sociales r) {
		// TODO Auto-generated method stub
		_redes_socialesDAO.actuaizarRedes_sociales(r);
	}

	@Override
	public Redes_sociales buscarRedes_socialesPorId(int idRedes_sociales) {
		// TODO Auto-generated method stub
		return _redes_socialesDAO.buscarRedes_socialesPorId(idRedes_sociales);
	}

	@Override
	public Redes_sociales buscarRedes_socialesPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return _redes_socialesDAO.buscarRedes_socialesPorNombre(nombre);
	}

	@Override
	public List<Redes_sociales> imprimirListaPorIdProfesor(String nickname) {
		// TODO Auto-generated method stub
		return _redes_socialesDAO.imprimirListaPorIdProfesor(nickname);
	}

	@Override
	public Usuario buscarUsuarioPorIdAndNombre(int idRedes_sociales, String nickname) {
		// TODO Auto-generated method stub
		return _redes_socialesDAO.buscarUsuarioPorIdAndNombre(idRedes_sociales, nickname);
	}

}
