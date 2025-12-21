package com.jad.ch03.restful.pathparams.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.jad.ch03.restful.javajson.entity.Customer;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * @PathParam -> permite pasar un parametro al RESTful web service
 */
@Path("/tenant/")
public class CustomerResource {
	private static final Logger LOG = Logger.getLogger(CustomerResource.class.getName());
	
	private Customer customer;
	
	public CustomerResource() {
		customer = new Customer(1L, "William", "Daniel", "Graystone");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Customer getCustomer(@PathParam("id") Long id) {
		return customer;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCustomer(Customer customer) {
		LOG.log(Level.INFO, "Customer = {0}", customer);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCustomer(Customer customer) {
		LOG.log(Level.INFO, "customer = {0}", customer);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public void deleteCustomer(@PathParam("id") Long id) {
		LOG.log(Level.INFO, "Customer = {0}", customer);
	}
	
	
}
