package com.platzi.profesoresplatzi.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.platzi.profesoresplatzi.model.Profesor;
import com.platzi.profesoresplatzi.services.ProfesorServices;
import com.platzi.profesoresplatzi.util.customError;

@Controller
@RequestMapping("/v1")
public class ProfesorControler {
	@Autowired
	ProfesorServices _profesorServicios;
	
	//GET
	@RequestMapping(value="/profesor", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<List<Profesor>> getProfesores(@RequestParam(value="nombre",required = false) String nombre){
		List<Profesor> profesorLista = new ArrayList<>();
		if(nombre==null) {
			profesorLista = _profesorServicios.imprimirListaProfesores();
			if(profesorLista.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Profesor>>(profesorLista,HttpStatus.OK);
		}else {
			Profesor profe = _profesorServicios.buscarProfesorPorNombre(nombre);
			if(profe==null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			profesorLista.add(profe);
			return new ResponseEntity<List<Profesor>>(profesorLista,HttpStatus.OK);
		}		
	}
	//GET
	@RequestMapping(value="/profesor/{id}", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<Profesor> getProfesorPorId(@PathVariable("id") int idProfesor){
		if(idProfesor<=0) {
			return new ResponseEntity(new customError("id requerido"),HttpStatus.CONFLICT);
		}
		Profesor profe = _profesorServicios.buscarProfesorPorId(idProfesor);
		if(profe==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Profesor>(profe,HttpStatus.OK);
	}
	//Post
	@RequestMapping(value="/profesor", method = RequestMethod.POST , headers="Accept=application/json")
	public ResponseEntity<?> crearProfesor(@RequestBody Profesor profe,UriComponentsBuilder uriComponentsBuilder){
		if (profe.getNombre().equals(null) || profe.getNombre().isEmpty() ) {
			return new ResponseEntity(new customError("nombre requerido"),HttpStatus.CONFLICT);
		}
		if (_profesorServicios.buscarProfesorPorNombre(profe.getNombre())!= null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_profesorServicios.saveProfesor(profe);
		Profesor profesor = _profesorServicios.buscarProfesorPorNombre(profe.getNombre());
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uriComponentsBuilder.path("v1/profesor/{id}").buildAndExpand(profesor.getId()).toUri());
		return new ResponseEntity<String>(header, HttpStatus.CREATED);
	}
	//Update
	@RequestMapping(value="/profesor/{id}", method = RequestMethod.PATCH , headers="Accept=application/json")
	public ResponseEntity<Profesor> updateProfesor(@PathVariable("id") int idProfesor, @RequestBody Profesor profe){
		if (idProfesor<= 0 ) {
			return new ResponseEntity(new customError("id requerido"),HttpStatus.CONFLICT);
		}
		Profesor currentProfesor = _profesorServicios.buscarProfesorPorId(idProfesor);
		if (currentProfesor==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		currentProfesor.setAvatar(profe.getAvatar());
		currentProfesor.setCursos(profe.getCursos());
		currentProfesor.setNombre(profe.getNombre());
		currentProfesor.setUsuario(profe.getUsuario());
		_profesorServicios.actuaizarProfesor(currentProfesor);
		return new ResponseEntity<Profesor>(currentProfesor, HttpStatus.CREATED);
	}
	//Delete
	@RequestMapping(value="/profesor/{id}", method = RequestMethod.DELETE , headers="Accept=application/json")
	public ResponseEntity<?> deleteProfesor(@PathVariable("id") int idProfesor){
		if (idProfesor<= 0 ) {
			return new ResponseEntity(new customError("id requerido"),HttpStatus.CONFLICT);
		}
		Profesor currentProfesor = _profesorServicios.buscarProfesorPorId(idProfesor);
		if (currentProfesor==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_profesorServicios.eliminarProfesor(idProfesor);
		return new ResponseEntity<Profesor>(HttpStatus.CREATED);
	}

}
