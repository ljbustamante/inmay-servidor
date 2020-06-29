package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Distrito;

public interface DistritoDAO {
	public Distrito buscarDistrito(int id);
	public List<Distrito> listarDistritos();
}

