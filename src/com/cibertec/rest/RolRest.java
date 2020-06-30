package com.cibertec.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cibertec.dao.RolDAOImpl;

@Path("/rol")
public class RolRest {
	private RolDAOImpl dao;
	
	public  RolRest() {
		dao = new RolDAOImpl();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarRoles(){
		return  Response.ok(dao.listarRoles()).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarRol(@PathParam("codigo") int cod){
		return  Response.ok(dao.buscarRol(cod)).build();
	}
}



