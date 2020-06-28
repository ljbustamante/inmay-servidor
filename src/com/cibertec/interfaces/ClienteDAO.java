package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Cliente;

public interface ClienteDAO {
	public int guardarCliente(Cliente bean);
	public List<Cliente> listarClientesPorEdad(int minimo,int maximo);
}

