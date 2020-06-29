package com.cibertec.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cibertec.dao.ProvinciaDAOImpl;

@Path("/provincia")
public class ProvinciaRest {
	private ProvinciaDAOImpl dao;
	
	public  ProvinciaRest() {
		dao = new ProvinciaDAOImpl();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarProvincies(){
		return  Response.ok(dao.listarProvincias()).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarProvincia(@PathParam("codigo") int cod){
		return  Response.ok(dao.buscarProvincia(cod)).build();
	}
}



