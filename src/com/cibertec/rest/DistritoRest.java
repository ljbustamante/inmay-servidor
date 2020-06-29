package com.cibertec.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cibertec.dao.DistritoDAOImpl;

@Path("/distrito")
public class DistritoRest {
	private DistritoDAOImpl dao;
	
	public  DistritoRest() {
		dao = new DistritoDAOImpl();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarProvincies(){
		return  Response.ok(dao.listarDistritos()).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarDistrito(@PathParam("codigo") int cod){
		return  Response.ok(dao.buscarDistrito(cod)).build();
	}
}



