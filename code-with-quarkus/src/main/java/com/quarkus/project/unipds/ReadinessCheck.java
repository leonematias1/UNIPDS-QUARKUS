package com.quarkus.project.unipds;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck{

	@RestClient
	StarWarsService starWarsService;
	
	@Override
	public HealthCheckResponse call() {
		// esse tipo de validação serve apenas para um endpoint ou seja caso sejam multiplos não funciona
		if(starWarsService.getFilms().contains(StarWarsService.MSG_ERROR)) {
			return HealthCheckResponse.down("ERROR");
		}else {
			return HealthCheckResponse.up("OK");
		}
	}

}
