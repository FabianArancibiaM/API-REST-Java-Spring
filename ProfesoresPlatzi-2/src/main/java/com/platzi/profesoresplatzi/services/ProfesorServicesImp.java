package com.platzi.profesoresplatzi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.profesoresplatzi.dao.ProfesorDAO;
import com.platzi.profesoresplatzi.model.Profesor;

@Service("profesorServices")
@Transactional
public class ProfesorServicesImp implements ProfesorServices {

	@Autowired
	private ProfesorDAO _profeDAO;
	
	@Override
	public void saveProfesor(Profesor p) {
		// TODO Auto-generated method stub
		_profeDAO.saveProfesor(p);
	}

	@Override
	public List<Profesor> imprimirListaProfesores() {
		// TODO Auto-generated method stub
		return _profeDAO.imprimirListaProfesores();
	}

	@Override
	public void eliminarProfesor(int idProfe) {
		// TODO Auto-generated method stub
		_profeDAO.eliminarProfesor(idProfe);
	}

	@Override
	public void actuaizarProfesor(Profesor p) {
		// TODO Auto-generated method stub
		_profeDAO.actuaizarProfesor(p);
	}

	@Override
	public Profesor buscarProfesorPorId(int idProfesor) {
		// TODO Auto-generated method stub
		return _profeDAO.buscarProfesorPorId(idProfesor);
	}

	@Override
	public Profesor buscarProfesorPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return _profeDAO.buscarProfesorPorNombre(nombre);
	}

}
