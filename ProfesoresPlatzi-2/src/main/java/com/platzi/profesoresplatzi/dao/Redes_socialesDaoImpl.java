package com.platzi.profesoresplatzi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import  java.util.ArrayList ;

import com.platzi.profesoresplatzi.model.Redes_sociales;
import com.platzi.profesoresplatzi.model.Usuario;


@Repository
@Transactional
public class Redes_socialesDaoImpl extends AbstractSession implements Redes_socialesDAO {

	@Override
	public void saveRedes_sociales(Redes_sociales r) {
		// TODO Auto-generated method stub
		getSession().persist(r);
	}

	@Override
	public List<Redes_sociales> imprimirListaRedes_socialeses() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Redes_sociales").list();
	}

	@Override
	public void eliminarRedes_sociales(int idRedes_sociales) {
		// TODO Auto-generated method stub
		Redes_sociales redes_sociales = buscarRedes_socialesPorId(idRedes_sociales);
		if (redes_sociales != null) {
			getSession().delete(redes_sociales);
		}
	}

	@Override
	public void actuaizarRedes_sociales(Redes_sociales r) {
		// TODO Auto-generated method stub
		getSession().update(r);
	}

	@Override
	public Redes_sociales buscarRedes_socialesPorId(int idRedes_sociales) {
		// TODO Auto-generated method stub
		return (Redes_sociales)getSession().get(Redes_sociales.class, idRedes_sociales);
	}

	@Override
	public Redes_sociales buscarRedes_socialesPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return (Redes_sociales) getSession().createQuery(" from Redes_sociales where nombre= :nombre").setParameter("nombre", nombre).uniqueResult();
	}

	@Override
	public List<Redes_sociales> imprimirListaPorIdProfesor(String nickname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarUsuarioPorIdAndNombre(int idRedes_sociales, String nickname) {
		// TODO Auto-generated method stub
		List<Object[]> objeto=  getSession().createQuery("from Usuario u join u.id_redes_sociales ur "
				+ "where ur.id = :idRedesSociales and u.nickname= :nickname")
				.setParameter("idRedesSociales", idRedes_sociales)
				.setParameter("nickname", nickname).list();
		if (objeto.size() > 0) {
			for (Object[] objects : objeto) {
				for (Object object : objects) {
					if (object instanceof Usuario ) {
						return (Usuario) object;
					}
				}
			}
		}
		return null;
	}

}
