package com.platzi.profesoresplatzi.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.platzi.profesoresplatzi.model.Profesor;
import com.platzi.profesoresplatzi.model.Usuario;

@Repository
@Transactional
public class ProfesorDaoImpl extends AbstractSession implements ProfesorDAO{

	
	
	public void saveProfesor(Profesor p) {
		// TODO Auto-generated method stub
		getSession().persist(p);
	}

	public List<Profesor> imprimirListaProfesores() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Profesor").list();
	}

	public void eliminarProfesor(int idProfe) {
		// TODO Auto-generated method stub
		Profesor profe = buscarProfesorPorId(idProfe);
		if (profe != null) {
			Iterator<Usuario> i =  profe.getUsuario().iterator();
			while (i.hasNext()) {
				Usuario type = i.next();
				i.remove();
				getSession().delete(type);
			}
			profe.getUsuario().clear();
			getSession().delete(profe);
		}
	}

	public void actuaizarProfesor(Profesor p) {
		// TODO Auto-generated method stub
		getSession().update(p);
	}

	public Profesor buscarProfesorPorId(int idProfesor) {
		// TODO Auto-generated method stub
		return (Profesor) getSession().get(Profesor.class,idProfesor);
	}

	public Profesor buscarProfesorPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return (Profesor) getSession().createQuery(" from Profesor where nombre= :nombre").setParameter("nombre", nombre).uniqueResult();
		
	}
	
}
