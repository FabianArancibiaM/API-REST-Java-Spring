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
@Table(name="usuario")
public class Usuario implements Serializable{
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NICKNAME")
	private String nickname;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_PROFESOR")
	private Profesor id_profesor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_REDES_SOCIALES")
	private Redes_sociales id_redes_sociales;
	
		
	public Usuario() {
		super();
	}


	public Usuario(Profesor id_profesor, Redes_sociales id_redes_sociales, String nickname) {
		super();
		this.id_profesor = id_profesor;
		this.id_redes_sociales = id_redes_sociales;
		this.nickname = nickname;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Profesor getId_profesor() {
		return id_profesor;
	}


	public void setId_profesor(Profesor id_profesor) {
		this.id_profesor = id_profesor;
	}


	public Redes_sociales getId_redes_sociales() {
		return id_redes_sociales;
	}


	public void setId_redes_sociales(Redes_sociales id_redes_sociales) {
		this.id_redes_sociales = id_redes_sociales;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
	
}
