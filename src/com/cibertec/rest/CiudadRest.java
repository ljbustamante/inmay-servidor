package com.cibertec.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cibertec.dao.CiudadDAOImpl;

@Path("/ciudad")
public class CiudadRest {
	private CiudadDAOImpl dao;
	
	public  CiudadRest() {
		dao = new CiudadDAOImpl();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarCiudades(){
		return  Response.ok(dao.listarCiudades()).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarCiudad(@PathParam("codigo") int cod){
		return  Response.ok(dao.buscarCiudad(cod)).build();
	}
}



