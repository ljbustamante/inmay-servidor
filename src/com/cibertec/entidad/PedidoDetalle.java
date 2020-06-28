package com.cibertec.entidad;

import java.io.Serializable;

import org.eclipse.jdt.core.compiler.CategorizedProblem;

public class PedidoDetalle implements Serializable {
	private int idPedidoDetalle;
	private Pedido pedido;
	private Producto producto;
	public int getIdPedidoDetalle() {
		return idPedidoDetalle;
	}
	public void setIdPedidoDetalle(int idPedidoDetalle) {
		this.idPedidoDetalle = idPedidoDetalle;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
		
}
