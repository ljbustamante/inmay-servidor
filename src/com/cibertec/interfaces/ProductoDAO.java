package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Producto;
import com.cibertec.entidad.Usuario;

public interface ProductoDAO {
	public int guardarProducto(Producto bean);
	public int actualizarProducto(Producto bean);
	public Producto buscarProducto(int codigo);
	public List<Producto> listarProductos();
	public int eliminarProducto(int codigo);
}

