package com.platzi.profesoresplatzi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="curso")
public class Curso implements Serializable{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="TEMA")
	private String tema;
	
	@Column(name="PROYECTO")
	private String proyecto;
	
	@ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name="ID_PROFESOR")
	private Profesor id_profesor;
	
	
	public Curso() {
		super();
	}
	public Curso(String nombre, String tema, String proyecto) {
		super();
		this.nombre = nombre;
		this.tema = tema;
		this.proyecto = proyecto;
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
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public Profesor getId_profesor() {
		return id_profesor;
	}
	public void setId_profesor(Profesor id_profesor) {
		this.id_profesor = id_profesor;
	}
	
	
	
	
}
