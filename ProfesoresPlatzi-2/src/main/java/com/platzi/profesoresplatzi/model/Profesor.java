package com.platzi.profesoresplatzi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="profesor")
public class Profesor implements Serializable{
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="AVATAR")
	private String avatar;
	
	@OneToMany(mappedBy="id_profesor")
	private Set<Curso> cursos;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_PROFESOR")
	private Set<Usuario> usuario;
	
	public Profesor(String nombre, String avatar) {
		super();
		this.nombre = nombre;
		this.avatar = avatar;
	}
	public Profesor() {
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
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Set<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
	public Set<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	
	
}
