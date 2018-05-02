package com.platzi.profesoresplatzi.dao;

import java.util.List;

import com.platzi.profesoresplatzi.model.Curso;


public interface CursoDAO {
	void saveCurso(Curso c);
	
	List<Curso> imprimirListaCurso();
	
	void eliminarCurso(int idCurso);
	
	void actuaizarCurso(Curso c);
	
	Curso buscarCursoPorId(int idCurso);
	
	Curso buscarCursoPorNombre(String nombre);
	
	List<Curso> imprimirListaPorIdProfesor(int idProfesor);
}
