package com.jad.ch03.restful.javajson.client;

import com.jad.ch03.restful.javajson.entity.Customer;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class App {

	public void insertCustomer() {
		Customer customer = new Customer(456L, "Daniel", "Robert", "Hanson");
		Client client = ClientBuilder.newClient();

		Response response = client.target("http://localhost:8080/jakartaee/resources/customer").request()
				.put(Entity.entity(customer, MediaType.APPLICATION_JSON));

		// verificacion.
		System.out.println("HTTP Status = " + response.getStatus());
		System.out.println("Respuesta Body = " + response.readEntity(String.class));

		response.close();
		client.close();
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.insertCustomer();
	}
}
