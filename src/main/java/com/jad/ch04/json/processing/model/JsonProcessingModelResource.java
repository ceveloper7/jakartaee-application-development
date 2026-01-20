package com.jad.ch04.json.processing.model;


import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonWriter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("jsonpmodel")
public class JsonProcessingModelResource {
	private static final Logger LOG = Logger.getLogger(JsonProcessingModelResource.class.getName());
	
	/**
	 * Generating JSON data with the Model API
	 * http://localhost:8080/jakartaee/resources/jsonpmodel/build
	 */
	@Path("build")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String jsonProcessingModelBuildJson() {
		// Creamos una instancia de JsonObject
		JsonObject jsonObject = Json.createObjectBuilder()
				.add("firstName", "Scott")
				.add("lastName", "Gosling")
				.add("email", "sgosling@example.com")
				.build();
		
		// Creamos una representacion a String de un objeto Json		
		StringWriter stringWriter = new StringWriter();
		try (JsonWriter jsonWriter = Json.createWriter(stringWriter)){
			jsonWriter.writeObject(jsonObject);
		}
		return stringWriter.toString();
	}
	
	/**
	 * Reading and Parsing existing JSON Data
	 */
	@Path("parse")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String jsonProcessingModelParseJson(String jsonStr) {
		LOG.log(Level.INFO, String.format("received the  following JSON string: %s", jsonStr));
		Customer customer = new Customer();
		JsonObject jsonObject;
		
		try(JsonReader jsonReader = Json.createReader(new StringReader(jsonStr))){
			jsonObject = jsonReader.readObject();
		}
		
		customer.setFirstName(jsonObject.getString("firstName"));
		customer.setLastName(jsonObject.getString("lastName"));
		customer.setEmail(jsonObject.getString("email"));
		
		return customer.toString();
	}
}
