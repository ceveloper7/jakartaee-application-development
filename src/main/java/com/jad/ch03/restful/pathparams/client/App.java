package com.jad.ch03.restful.pathparams.client;

import com.jad.ch03.restful.javajson.entity.Customer;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class App {
	
	public void getCustomer() {
		Client client = ClientBuilder.newClient();
		Customer customer = client.target("http://localhost:8080/jakartaee/resources/tenant")
				.path("{id}")
				.resolveTemplate("id", 1L)
				.request().get(Customer.class);
		
		System.out.println("Received the following " + "customer information:");
		System.out.println("Id: " + customer.getId());
		System.out.println("First Name: " + customer.getFirstName());
		System.out.println("Middle Name: " + customer.getMiddleName());
		System.out.println("Last Name: " + customer.getLastName());
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.getCustomer();
	}
}
