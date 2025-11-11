package com.jad.ch03.restful.basic.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * @Path -> puede ser usado a nivel class y a nivel metodo. Usar @Path a nivel de metodo permite escribir varios metodos que gestionan
 *          el mismo tipo de solicitud HTTP
 */
@Path("customer")
public class CustomerResource {
	private static final Logger LOG = Logger.getLogger(CustomerResource.class.getName());

	/**
	 * 
	 * @Produces -> Cuando el metodo retorna datos al cliente usamos @Produces
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomer() {
		
		LOG.log(Level.INFO, "{0}.getCustomer() invoked", this.getClass().getCanonicalName());
		
		return """
				{
				 	"customer": 
				 		{
				           "id": 123,
				           "firstName": "Joseph",
				           "middleName": "William",
				           "lastName": "Graystone"
				         }
				 }
				""";
	}
	
	/**
	 * 
	 * @Consumes -> cuando el servicio necesita consumir datos del client, usamos @Consume
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCustomer(String customerJson) {
		LOG.log(Level.INFO, "{0}.createCustomer() invoked", this.getClass().getCanonicalName());
		LOG.log(Level.INFO, "customerJson = {0}", customerJson);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCustomer(String customerJson) {
		LOG.log(Level.INFO, "{0}.updateCustomer() invoked", this.getClass().getCanonicalName());
	    LOG.log(Level.INFO, "customerJson = {0}", customerJson);
	}
	
	
	
}
