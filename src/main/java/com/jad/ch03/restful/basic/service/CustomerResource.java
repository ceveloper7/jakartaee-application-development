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
 * @Path -> puede ser usado a nivel class y a nivel metodo. Usar @Path a nivel
 *       de metodo permite escribir varios metodos que gestionan el mismo tipo
 *       de solicitud HTTP
 */
@Path("customer")
public class CustomerResource {
	private static final Logger LOG = Logger.getLogger(CustomerResource.class.getName());

	/**
	 * curl -XGET http://localhost:8080/jakartaee/resources/customer
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
				           "firstName": "Joseph Antone",
				           "middleName": "William",
				           "lastName": "Graystone"
				         }
				 }
				""";
	}

	/**
	 * curl -XGET http://localhost:8080/jakartaee/resources/customer/customername
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("customername")
	public String getCustomerName() {
		return "Joseph Graystone";
	}

	/**
	 * curl -XPUT -HContent-type:application/json --data "{n/json --data "
	 * {
	 *   "customer": {
	 *      "id": 321,
	 *      "firstName": "Amanda",
	 *      "middleName": "Zoe",
	 *      "lastName": "Adams"   
	 *  	} 
	 * }" http://localhost:8080/jakartaee/resources/customer
	 * 
	 * @Consumes -> cuando el servicio necesita consumir datos del client,
	 *           usamos @Consume
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCustomer(String customerJson) {
		LOG.log(Level.INFO, "{0}.createCustomer() invoked", this.getClass().getCanonicalName());
		LOG.log(Level.INFO, "customerJson = {0}", customerJson);
	}

	/**
	 * curl -XPOST -HContent-type:application/json --data "
	 * {
		  "customer": {
    		"id": 321,
    		"firstName": "Amanda",
    		"middleName": "Tamara",
    		"lastName": "Adams"
  			}
		}" http://localhost:8080/jakartaee/resources/customer
	 * 
	 * Web browser only support GET and POST request To test a POST we would have to
	 * write a web app with an html form.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCustomer(String customerJson) {
		LOG.log(Level.INFO, "{0}.updateCustomer() invoked", this.getClass().getCanonicalName());
		LOG.log(Level.INFO, "customerJson = {0}", customerJson);
	}

}
