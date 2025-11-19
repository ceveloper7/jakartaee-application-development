package com.jad.ch03.restful.basic.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;

public class CustomerRESTfulTest {
	
	public void insertCustomer() {
		// 1. creamos la instancia del client
		Client client = ClientBuilder.newClient();
		String customerJson = """
                {
                "customer": {
                  "id": 234,
                  "firstName": "Tamara",
                  "middleName": "Adeline",
                  "lastName": "Graystone"
                }
              }
              """;
		
		// 2. passamos la url
		client.target("http://localhost:8080/jakartaee/resources/customer")
			// invocamos request del WebTarget object
			.request()
			// hacemos un PUT Request. creamos al vuelo una clase Entity
			// customerJson -> datos que deseamos pasar alRESTful web service
			// MediaType.APPLICATION_JSON -> MIME Type del dato que se enviara al web service
			// String.class -> tipo de respuesta que dara el web service
			.put(Entity.entity(customerJson, MediaType.APPLICATION_JSON), String.class);
	}
	
	public static void main(String[] args) {
		CustomerRESTfulTest restful = new CustomerRESTfulTest();
		restful.insertCustomer();
	}
}
