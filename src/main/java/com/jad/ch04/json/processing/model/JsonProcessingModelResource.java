package com.jad.ch04.json.processing.model;


import java.io.StringWriter;
import java.util.logging.Logger;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonWriter;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("jsonpmodel")
public class JsonProcessingModelResource {
	private static final Logger LOG = Logger.getLogger(JsonProcessingModelResource.class.getName());
	
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
}
