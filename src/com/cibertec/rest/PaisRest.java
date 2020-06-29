package com.cibertec.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cibertec.dao.PaisDAOImpl;
import com.cibertec.entidad.Usuario;

@Path("/cliente")
public class PaisRest {
	private PaisDAOImpl dao;
	
	public  PaisRest() {
		dao = new PaisDAOImpl();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarPaises(){
		return  Response.ok(dao.listarPaises()).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPAis(@PathParam("codigo") int cod){
		return  Response.ok(dao.buscarPais(cod)).build();
	}
}



