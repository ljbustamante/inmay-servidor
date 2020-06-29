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

import com.cibertec.dao.ProveedorDAOImpl;
import com.cibertec.entidad.Proveedor;

@Path("/proveedor")
public class ProveedorRest {
	private ProveedorDAOImpl dao;
	
	public  ProveedorRest() {
		dao = new ProveedorDAOImpl();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarProveedors(){
		return  Response.ok(dao.listarProveedores()).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarProveedor(@PathParam("codigo") int cod){
		return  Response.ok(dao.buscarProveedor(cod)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int guardarProveedor(Proveedor bean) {
		return dao.guardarProveedor(bean);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int actualizarProveedor(Proveedor bean) {
		return dao.actualizarProveedor(bean);
	}	
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public int eliminarProveedor(@PathParam("codigo") int cod) {
		return dao.eliminarProveedor(cod);
	}	
}



