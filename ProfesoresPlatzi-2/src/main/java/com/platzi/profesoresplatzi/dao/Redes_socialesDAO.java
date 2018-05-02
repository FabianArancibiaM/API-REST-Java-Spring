package com.platzi.profesoresplatzi.dao;

import java.util.List;

import com.platzi.profesoresplatzi.model.Redes_sociales;
import com.platzi.profesoresplatzi.model.Usuario;

public interface Redes_socialesDAO {
	void saveRedes_sociales(Redes_sociales r);
	
	List<Redes_sociales> imprimirListaRedes_socialeses();
	
	void eliminarRedes_sociales(int idRedes_sociales);
	
	void actuaizarRedes_sociales(Redes_sociales r);
	
	Redes_sociales buscarRedes_socialesPorId(int idRedes_sociales);
	
	Redes_sociales buscarRedes_socialesPorNombre(String nombre);
	
	List<Redes_sociales> imprimirListaPorIdProfesor(String nickname);
	
	Usuario buscarUsuarioPorIdAndNombre(int idRedes_sociales,String nickname);
}
