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

import com.platzi.profesoresplatzi.model.Curso;
import com.platzi.profesoresplatzi.services.CursosServices;
import com.platzi.profesoresplatzi.util.customError;

@Controller
@RequestMapping("/v1")
public class CursosControler {
	@Autowired
	CursosServices _cursoServicios;
	
	//GET // Ej: http://localhost:8085/v1/redes_sociales?nombre=Instagram
	@RequestMapping(value="/curso", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<List<Curso>> getCursos(@RequestParam(value="nombre",required = false) String nombre){
		List<Curso> cursosLista = new ArrayList<>();
		if(nombre==null) {
			cursosLista = _cursoServicios.imprimirListaCurso();
			if(cursosLista.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Curso>>(cursosLista,HttpStatus.OK);
		}else {
			Curso curso = _cursoServicios.buscarCursoPorNombre(nombre);
			if (curso==null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			cursosLista.add(curso);
			return new ResponseEntity<List<Curso>>(cursosLista,HttpStatus.OK);
		}
	}
	
	//GET
	@RequestMapping(value="/curso/{id}", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<Curso> getCursoPorId(@PathVariable("id") int idCurso){
		if(idCurso<=0 ) {
			return new ResponseEntity(new customError("id requerido"),HttpStatus.CONFLICT);
		}
		Curso curso = _cursoServicios.buscarCursoPorId(idCurso);
		if (curso==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Curso>(curso,HttpStatus.OK);
	}
	//Post
	@RequestMapping(value="/curso", method = RequestMethod.POST , headers="Accept=application/json")
	public ResponseEntity<?> crearCurso(@RequestBody Curso curso, UriComponentsBuilder uriComponentsBuilder){
		if(curso.getNombre().equals(null) || curso.getNombre().isEmpty()) {
			return new ResponseEntity(new customError("nombre requerido"),HttpStatus.CONFLICT);
		}
		if(_cursoServicios.buscarCursoPorNombre(curso.getNombre())!=null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_cursoServicios.saveCurso(curso);
		Curso cursos = _cursoServicios.buscarCursoPorNombre(curso.getNombre());
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uriComponentsBuilder.path("v1/curso/{id}").buildAndExpand(cursos.getId()).toUri());
		return new ResponseEntity<String>(header, HttpStatus.CREATED);
	}
	//Update
	@RequestMapping(value="/curso/{id}", method = RequestMethod.PATCH , headers="Accept=application/json")
	public ResponseEntity<Curso> updateCurso(@PathVariable("id") int idCurso, @RequestBody Curso curso){
		if (idCurso<= 0 ) {
			return new ResponseEntity(new customError("id requerido"),HttpStatus.CONFLICT);
		}
		Curso currentCurso = _cursoServicios.buscarCursoPorId(idCurso);
		if (currentCurso==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		currentCurso.setNombre(curso.getNombre());
		currentCurso.setProyecto(curso.getProyecto());
		currentCurso.setTema(curso.getTema());
		currentCurso.setId_profesor(curso.getId_profesor());
		_cursoServicios.actuaizarCurso(currentCurso);
		return new ResponseEntity<Curso>(currentCurso,HttpStatus.CREATED);
	}
	//Delete
	@RequestMapping(value="/curso/{id}", method = RequestMethod.DELETE , headers="Accept=application/json")
	public ResponseEntity<?> deleteRedes_sociales(@PathVariable("id") int idCurso){
		if (idCurso<= 0 ) {
			return new ResponseEntity(new customError("id requerido"),HttpStatus.CONFLICT);
		}
		Curso currentCurso = _cursoServicios.buscarCursoPorId(idCurso);
		if(currentCurso == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_cursoServicios.eliminarCurso(idCurso);
		return new ResponseEntity<Curso>(HttpStatus.CREATED);
	}

	
}
