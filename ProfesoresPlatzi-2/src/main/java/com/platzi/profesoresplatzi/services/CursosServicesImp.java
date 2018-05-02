package com.platzi.profesoresplatzi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.profesoresplatzi.dao.CursoDAO;
import com.platzi.profesoresplatzi.model.Curso;

@Service("cursosServices")
@Transactional
public class CursosServicesImp implements CursosServices{
	
	@Autowired
	private CursoDAO _cursosDAO;
	
	@Override
	public void saveCurso(Curso c) {
		// TODO Auto-generated method stub
		_cursosDAO.saveCurso(c);
	}

	@Override
	public List<Curso> imprimirListaCurso() {
		// TODO Auto-generated method stub
		return _cursosDAO.imprimirListaCurso();
	}

	@Override
	public void eliminarCurso(int idCurso) {
		// TODO Auto-generated method stub
		_cursosDAO.eliminarCurso(idCurso);
	}

	@Override
	public void actuaizarCurso(Curso c) {
		// TODO Auto-generated method stub
		_cursosDAO.actuaizarCurso(c);
	}

	@Override
	public Curso buscarCursoPorId(int idCurso) {
		// TODO Auto-generated method stub
		return _cursosDAO.buscarCursoPorId(idCurso);
	}

	@Override
	public Curso buscarCursoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return _cursosDAO.buscarCursoPorNombre(nombre);
	}

	@Override
	public List<Curso> imprimirListaPorIdProfesor(int idProfesor) {
		// TODO Auto-generated method stub
		return _cursosDAO.imprimirListaPorIdProfesor(idProfesor);
	}

}
