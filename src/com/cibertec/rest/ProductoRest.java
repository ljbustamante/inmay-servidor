package com.cibertec.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cibertec.dao.ProductoDAOImpl;
import com.cibertec.entidad.Producto;

@Path("/producto")
public class ProductoRest {
	private ProductoDAOImpl dao;
	
	public  ProductoRest() {
		dao = new ProductoDAOImpl();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarProductos(){
		return  Response.ok(dao.listarProductos()).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarProducto(@PathParam("codigo") int cod){
		return  Response.ok(dao.buscarProducto(cod)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int guardarProducto(Producto bean) {
		return dao.guardarProducto(bean);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int actualizarProducto(Producto bean) {
		return dao.actualizarProducto(bean);
	}	
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public int eliminarProducto(@PathParam("codigo") int cod) {
		return dao.eliminarProducto(cod);
	}	
}



