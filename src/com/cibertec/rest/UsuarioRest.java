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

import com.cibertec.dao.UsuarioDAOImpl;
import com.cibertec.entidad.Usuario;

@Path("/usuario")
public class UsuarioRest {
	private UsuarioDAOImpl dao;
	
	public  UsuarioRest() {
		dao = new UsuarioDAOImpl();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarUsuarios(){
		return  Response.ok(dao.listarUsuarios()).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarUsuario(@PathParam("codigo") int cod){
		return  Response.ok(dao.buscarUsuario(cod)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int guardarUsuario(Usuario bean) {
		return dao.guardarUsuario(bean);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int actualizarUsuario(Usuario bean) {
		return dao.actualizarUsuario(bean);
	}	
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public int eliminarUsuario(@PathParam("codigo") int cod) {
		return dao.eliminarUsuario(cod);
	}	
}



