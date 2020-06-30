package com.cibertec.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cibertec.dao.CategoriaDAOImpl;

@Path("/categoria")
public class CategoriaRest {
	private CategoriaDAOImpl dao;
	
	public  CategoriaRest() {
		dao = new CategoriaDAOImpl();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarCategorias(){
		return  Response.ok(dao.listarCategoria()).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarCategorias(@PathParam("codigo") int cod){
		return  Response.ok(dao.buscarCategoria(cod)).build();
	}
}
