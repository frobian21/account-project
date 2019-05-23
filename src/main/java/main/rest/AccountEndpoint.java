package main.rest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import main.service.Service;

@Path("/account")
public class AccountEndpoint {
	@Inject
	private Service service;

	public void setService(Service service) {
		this.service = service;
	}

	@Path("/addAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.addAccount(account);
	}

	@Path("/getAccount/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAccount(@PathParam("id") Integer id) {
		return service.retrieveAccount(id);
	}
	
	@Path("/getAccount/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAccounts() {
		return service.retrieveAllAccounts();
	}
	
	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAccount(@PathParam("id") Integer id) {
		return service.deleteAccount(id);
	}
	
}
