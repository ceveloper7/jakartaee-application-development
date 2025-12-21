package com.jad.ch03.restful.queryparams.client;

import com.jad.ch03.restful.javajson.entity.Customer;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class App {
	
	public void getCustomer() {
		Client client = ClientBuilder.newClient();
		Customer customer = client.target("http://localhost:8080/jakartaee/resources/cliente")
				.queryParam("id", 1L)
				.request()
				.get(Customer.class);
		
		System.out.println(String.format("REceive the following customer information \n%s", customer));
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.getCustomer();
	}
}
