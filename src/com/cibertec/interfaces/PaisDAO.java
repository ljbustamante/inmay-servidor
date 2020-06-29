package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Pais;

public interface PaisDAO {
	public Pais buscarPais(int id);
	public List<Pais> listarPaises();
}

