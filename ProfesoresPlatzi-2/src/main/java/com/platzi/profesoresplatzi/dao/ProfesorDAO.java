package com.platzi.profesoresplatzi.dao;

import java.util.List;

import com.platzi.profesoresplatzi.model.Profesor;

public interface ProfesorDAO {
	
	void saveProfesor(Profesor p);
	
	List<Profesor> imprimirListaProfesores();
	
	void eliminarProfesor(int idProfe);
	
	void actuaizarProfesor(Profesor p);
	
	Profesor buscarProfesorPorId(int idProfesor);
	
	Profesor buscarProfesorPorNombre(String nombre);
}
