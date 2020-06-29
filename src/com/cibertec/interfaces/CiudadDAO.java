package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Ciudad;

public interface CiudadDAO {
	public Ciudad buscarCiudad(int id);
	public List<Ciudad> listarCiudades();
}

