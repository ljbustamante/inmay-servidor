package com.cibertec.entidad;

import java.io.Serializable;

public class Ciudad implements Serializable {
	private int idCiudad;
	private String descCiudad;
	private Pais pais;
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getDescCiudad() {
		return descCiudad;
	}
	public void setDescCiudad(String descCiudad) {
		this.descCiudad = descCiudad;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}
