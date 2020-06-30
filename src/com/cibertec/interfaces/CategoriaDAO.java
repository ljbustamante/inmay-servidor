package com.cibertec.interfaces;

import java.util.List;

import com.cibertec.entidad.Categoria;
import com.cibertec.entidad.Distrito;

public interface CategoriaDAO {
	public Categoria buscarCategoria(int id);
	public List<Categoria> listarCategoria();
}
