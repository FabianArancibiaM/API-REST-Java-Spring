package com.platzi.profesoresplatzi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.platzi.profesoresplatzi.model.Curso;
import com.platzi.profesoresplatzi.model.Redes_sociales;


@Repository
@Transactional
public class CursoDaoImpl extends AbstractSession implements CursoDAO {

	@Override
	public void saveCurso(Curso c) {
		// TODO Auto-generated method stub
		getSession().persist(c);
	}

	@Override
	public List<Curso> imprimirListaCurso() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Curso").list();
	}

	@Override
	public void eliminarCurso(int idCurso) {
		// TODO Auto-generated method stub
		Curso curso = buscarCursoPorId(idCurso);
		if (curso != null) {
			getSession().delete(curso);
		}
	}

	@Override
	public void actuaizarCurso(Curso c) {
		// TODO Auto-generated method stub
		getSession().update(c);
	}

	@Override
	public Curso buscarCursoPorId(int idCurso) {
		// TODO Auto-generated method stub
		return (Curso)getSession().get(Curso.class, idCurso);
	}

	@Override
	public Curso buscarCursoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return (Curso) getSession().createQuery(" from Curso where nombre= :nombre").setParameter("nombre", nombre).uniqueResult();
	}

	@Override
	public List<Curso> imprimirListaPorIdProfesor(int idProfesor) {
		// TODO Auto-generated method stub
		return (List<Curso>)getSession().createQuery("from Curso c join c.id_profesor p where p.id= :id").setParameter("id", idProfesor).list();
	}

}
