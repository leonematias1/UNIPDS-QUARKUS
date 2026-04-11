package com.quarkus.project.unipds;

import java.time.temporal.ChronoUnit;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://swapi.info/api/")
public interface StarWarsService {

	public static final String MSG_ERROR = "Fallback";
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/films")
	@Timeout(
		value = 3L,
		unit = ChronoUnit.SECONDS
	)
	@Fallback(
		fallbackMethod = "integrationFallBack"
	)
	@CircuitBreaker(
		//Define quantas requisições são precisas para informar um problema
		requestVolumeThreshold = 2,
		// % de falhas que fazem o trigger de dar um break
		failureRatio = .5,
		//qtd de tempo de Pausa para a proxima tentativa
		delay = 3000L,
		// Quantos retornos com sucesso são necessarios para informar que está tudo certo
		successThreshold = 2
	)
	public String getFilms();
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/people")
//	@Timeout(
//		value = 3L,
//		unit = ChronoUnit.SECONDS
//	)
//	@Fallback(
//		fallbackMethod = "integrationFallBack"
//	)
//	@CircuitBreaker(
//		requestVolumeThreshold = 2,
//		failureRatio = .5,
//		delay = 3000L,
//		successThreshold = 2
//	)
//	public String getPeople();
//	
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/vehicles")
//	@Timeout(
//		value = 3L,
//		unit = ChronoUnit.SECONDS
//	)
//	@Fallback(
//		fallbackMethod = "integrationFallBack"
//	)
//	@CircuitBreaker(
//		requestVolumeThreshold = 2,
//		failureRatio = .5,
//		delay = 3000L,
//		successThreshold = 2
//	)
//	public String getVehicles();
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/starships")
//	@Timeout(
//		value = 3L,
//		unit = ChronoUnit.SECONDS
//	)
//	@Fallback(
//		fallbackMethod = "integrationFallBack"
//	)
//	@CircuitBreaker(
//		requestVolumeThreshold = 2,
//		failureRatio = .5,
//		delay = 3000L,
//		successThreshold = 2
//	)
//	public String getStarships();
	
	default String integrationFallBack() {
		return MSG_ERROR;
	}
	
}
