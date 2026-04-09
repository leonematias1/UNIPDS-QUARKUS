package com.quarkus.project.unipds;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://swapi.info/api/")
public interface StarWarsService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/films")
	public String getFilms();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/people")
	public String getPeople();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/vehicles")
	public String getVehicles();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/starships")
	public String getStarships();
	
}
