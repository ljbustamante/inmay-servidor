package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Pedido;

public interface PedidoDAO {
	public int guardarPedido(Pedido bean);
	public Pedido buscarPedido(int id);
	public List<Pedido> listarPedidos();
	public int eliminarPedido(Pedido bean);
}

