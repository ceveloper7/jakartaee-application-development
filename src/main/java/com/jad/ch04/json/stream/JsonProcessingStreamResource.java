package com.jad.ch04.json.stream;

import java.io.StringWriter;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * How to generate JSON Data adn write it to a stream using Streaming API
 */
@Path("jsonstreaming")
public class JsonProcessingStreamResource {
	
	@Path("build")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buildJson() {
		
		StringWriter stringWriter = new StringWriter();
		try (JsonGenerator jsonGenerator = Json.createGenerator(stringWriter)){
			jsonGenerator.writeStartObject()
			// add properties to Json STream
			.write("firstName", "Larry")
			.write("lastName", "Gates")
			.write("email", "lgates@example.com")
			.writeEnd();
		}
		return stringWriter.toString();
	}
}
