package com.quarkus.project.unipds;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/starwars")
@Produces(MediaType.APPLICATION_JSON)
public class StarWarsResource {

	@RestClient
	StarWarsService starWarsService;
	
	@GET
	@Path("/films")
	public String getFilms() {
		return starWarsService.getFilms();
	}
	
//	@GET
//	@Path("/people")
//	public String getPeople() {
//		return starWarsService.getPeople();
//	}
//	
//	@GET
//	@Path("/vehicles")
//	public String getVehicles() {
//		return starWarsService.getVehicles();
//	}
//	
//	@GET
//	@Path("/starships")
//	public String getStarships() {
//		return starWarsService.getStarships();
//	}
	
}
