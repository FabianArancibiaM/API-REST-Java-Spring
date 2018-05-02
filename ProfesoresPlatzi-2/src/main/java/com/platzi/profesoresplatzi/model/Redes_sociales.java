package com.platzi.profesoresplatzi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="redes_sociales")
public class Redes_sociales implements Serializable{
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="ICONO")
	private String icono;
	
	@OneToMany
	@JoinColumn(name="ID_REDES_SOCIALES")
	@JsonIgnore
	private Set<Usuario> usuarios;
	
	public Redes_sociales(String nombre, String icono) {
		super();
		this.nombre = nombre;
		this.icono = icono;
	}
	
	public Redes_sociales() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String geticono() {
		return icono;
	}
	public void seticono(String icono) {
		this.icono = icono;
	}
	
	
}
