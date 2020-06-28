package com.cibertec.entidad;
import java.io.Serializable;
import java.sql.Date;

public class Usuario implements Serializable{
	private int idUsuario;
	private String nombreU;
	private String apellidoU;
	private String emailU;
	private String claveU;
	private Date fRegistroU;
	private String direccionU;
	private Pais pais;
	private Ciudad ciudad;
	private Provincia provincia;
	private Distrito distrito;
	private String telefonoU;
	private EstadoUsuario estadoU;
	private boolean isStaff;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreU() {
		return nombreU;
	}
	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}
	public String getApellidoU() {
		return apellidoU;
	}
	public void setApellidoU(String apellidoU) {
		this.apellidoU = apellidoU;
	}
	public String getEmailU() {
		return emailU;
	}
	public void setEmailU(String emailU) {
		this.emailU = emailU;
	}
	public String getClaveU() {
		return claveU;
	}
	public void setClaveU(String claveU) {
		this.claveU = claveU;
	}
	public Date getfRegistroU() {
		return fRegistroU;
	}
	public void setfRegistroU(Date fRegistroU) {
		this.fRegistroU = fRegistroU;
	}
	public String getDireccionU() {
		return direccionU;
	}
	public void setDireccionU(String direccionU) {
		this.direccionU = direccionU;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public Distrito getDistrito() {
		return distrito;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	public String getTelefonoU() {
		return telefonoU;
	}
	public void setTelefonoU(String telefonoU) {
		this.telefonoU = telefonoU;
	}
	public EstadoUsuario getEstadoU() {
		return estadoU;
	}
	public void setEstadoU(EstadoUsuario estadoU) {
		this.estadoU = estadoU;
	}
	public boolean isStaff() {
		return isStaff;
	}
	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}
	
	
	
}

