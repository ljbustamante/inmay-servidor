package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Provincia;

public interface ProvinciaDAO {
	public Provincia buscarProvincia(int id);
	public List<Provincia> listarProvincias();
}

