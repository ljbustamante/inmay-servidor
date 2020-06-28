package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Usuario;

public interface ClienteDAO {
	public int guardarCliente(Usuario bean);
	public List<Usuario> listarClientesPorEdad(int minimo,int maximo);
}

