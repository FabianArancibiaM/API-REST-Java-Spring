package com.platzi.profesoresplatzi.controler;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.platzi.profesoresplatzi.model.Redes_sociales;
import com.platzi.profesoresplatzi.services.Redes_socialesServices;
import com.platzi.profesoresplatzi.util.customError;

import retrofit2.http.PATCH;
import retrofit2.http.Path;

@Controller
@RequestMapping("/v1")
public class Redes_socialesControler {
	
	@Autowired
	Redes_socialesServices _redes_socialesServices;
	
	//GET
	@RequestMapping(value="/redes_sociales", method = RequestMethod.GET , headers="Accept=application/json")	
	public ResponseEntity<List<Redes_sociales>> getRedes_sociales(@RequestParam(value="nombre",required = false) String nombre){
		List<Redes_sociales> redesSociales = new ArrayList<>();
		
		if(nombre==null) {
			redesSociales = _redes_socialesServices.imprimirListaRedes_socialeses();
			if (redesSociales.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Redes_sociales>>(redesSociales,HttpStatus.OK);
		}else {
			Redes_sociales redeSociales = _redes_socialesServices.buscarRedes_socialesPorNombre(nombre);
			if(redeSociales==null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			redesSociales.add(redeSociales);		
			
			return new ResponseEntity<List<Redes_sociales>>(redesSociales,HttpStatus.OK);
		}		
	}
	//GET
	@RequestMapping(value="/redes_sociales/{id}", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<Redes_sociales> getRedes_socialesporId(@PathVariable("id") int idRedes_sociales){
		if (idRedes_sociales<= 0) {
			return new ResponseEntity(new customError("id requerido"),HttpStatus.CONFLICT);
		}
		Redes_sociales redes_sociales = _redes_socialesServices.buscarRedes_socialesPorId(idRedes_sociales);
		if (redes_sociales==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Redes_sociales>(redes_sociales,HttpStatus.OK);
	}
	
	
	//Post
	@RequestMapping(value="/redes_sociales", method = RequestMethod.POST , headers="Accept=application/json")
	public ResponseEntity<?> crearRedSocial(@RequestBody Redes_sociales redesSociales, UriComponentsBuilder uriComponentsBuilder){
		if (redesSociales.getNombre().equals(null) || redesSociales.getNombre().isEmpty() ) {
			return new ResponseEntity(new customError("nombre requerido"),HttpStatus.CONFLICT);
		}
		if (_redes_socialesServices.buscarRedes_socialesPorNombre(redesSociales.getNombre())!= null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_redes_socialesServices.saveRedes_sociales(redesSociales);
		Redes_sociales redesSociales2 =_redes_socialesServices.buscarRedes_socialesPorNombre(redesSociales.getNombre());
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uriComponentsBuilder.path("v1/redes_sociales/{id}").buildAndExpand(redesSociales2.getId()).toUri());
		return new ResponseEntity<String>(header, HttpStatus.CREATED);
	}
	//Update
	@RequestMapping(value="/redes_sociales/{id}", method = RequestMethod.PATCH , headers="Accept=application/json")
	public ResponseEntity<Redes_sociales> updateRedes_sociales(@PathVariable("id") int idRedes_sociales, @RequestBody Redes_sociales redesSociales){
		if (idRedes_sociales<= 0 ) {
			return new ResponseEntity(new customError("id requerido"),HttpStatus.CONFLICT);
		}
		Redes_sociales currentRedes_sociales = _redes_socialesServices.buscarRedes_socialesPorId(idRedes_sociales);
		if (currentRedes_sociales==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		currentRedes_sociales.setNombre(redesSociales.getNombre());
		currentRedes_sociales.seticono(redesSociales.geticono());
		_redes_socialesServices.actuaizarRedes_sociales(currentRedes_sociales);
		return new ResponseEntity<Redes_sociales>(currentRedes_sociales, HttpStatus.CREATED);
	}
	//Delete
	@RequestMapping(value="/redes_sociales/{id}", method = RequestMethod.DELETE , headers="Accept=application/json")
	public ResponseEntity<?> deleteRedes_sociales(@PathVariable("id") int idRedes_sociales){
		if (idRedes_sociales<= 0 ) {
			return new ResponseEntity(new customError("id requerido"),HttpStatus.CONFLICT);
		}
		Redes_sociales currentRedes_sociales = _redes_socialesServices.buscarRedes_socialesPorId(idRedes_sociales);
		if (currentRedes_sociales == null ) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_redes_socialesServices.eliminarRedes_sociales(idRedes_sociales);
		return new ResponseEntity<Redes_sociales>(HttpStatus.CREATED);
	}
}
