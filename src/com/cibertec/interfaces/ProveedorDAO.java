package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Proveedor;

public interface ProveedorDAO {
	public int guardarProveedor(Proveedor bean);
	public Proveedor buscarProveedor(int id);
	public List<Proveedor> listarProveedores();
	public int eliminarProveedor(Proveedor bean);
}

