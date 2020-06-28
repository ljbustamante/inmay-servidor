package com.cibertec.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cibertec.dao.ClienteDAOImpl;
import com.cibertec.entidad.Cliente;

@Path("/cliente")
public class ClienteRest {
	private ClienteDAOImpl dao;
	
	public  ClienteRest() {
		dao = new ClienteDAOImpl();
	}
	
	@GET
	@Path("/listarPorEdad/{minimo}/{maximo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaCliente(@PathParam("minimo") int minimo, @PathParam("maximo") int maximo){
		return  Response.ok(dao.listarClientesPorEdad(minimo, maximo)).build();
	}
	
	@POST
	@Path("/guardar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int registrarCliente(Cliente bean) {
		return dao.guardarCliente(bean);
	}
}



