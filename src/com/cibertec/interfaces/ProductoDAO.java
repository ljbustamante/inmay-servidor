package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Producto;

public interface ProductoDAO {
	public int guardarProducto(Producto bean);
	public Producto buscarProducto(int id);
	public List<Producto> listarProductos();
	public int eliminarProducto(Producto bean);
}

