package com.platzi.profesoresplatzi.services;

import java.util.List;

import com.platzi.profesoresplatzi.model.Profesor;

public interface ProfesorServices {
	void saveProfesor(Profesor p);
	
	List<Profesor> imprimirListaProfesores();
	
	void eliminarProfesor(int idProfe);
	
	void actuaizarProfesor(Profesor p);
	
	Profesor buscarProfesorPorId(int idProfesor);
	
	Profesor buscarProfesorPorNombre(String nombre);
}
