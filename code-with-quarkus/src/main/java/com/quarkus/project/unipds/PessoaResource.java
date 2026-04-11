package com.quarkus.project.unipds;

import java.util.List;

import io.micrometer.core.annotation.Counted;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

	@GET
	@Path("/getPessoa")
	@Counted(value = "counted.getPessoa")
	public List<Pessoa> getPessoa() {
		return Pessoa.listAll();
	}
	
	@GET
	@Path("/findByAnoNascimento")
	public List<Pessoa> findByAnoNascimento(@QueryParam("anoNascimento") int anoNascimento) {
		return Pessoa.findByAnoNascimento(anoNascimento);
	}
	
	@POST
	@Transactional
	@Path("/createPessoa")
	public Pessoa createPessoa(Pessoa pessoa) {
		pessoa.id = null;
		pessoa.persist();
		return pessoa;
	}
	
	@PUT
	@Transactional
	@Path("/updatePessoa")
	public Pessoa updatePessoa(Pessoa pessoa) {
		Pessoa pessoaUpdate = Pessoa.findById(pessoa.id);
		pessoaUpdate.nome = pessoa.nome;
		pessoaUpdate.anoNascimento = pessoa.anoNascimento;
		pessoaUpdate.persist();
		return pessoaUpdate;
	}
	
	@DELETE
	@Transactional
	@Path("/deletePessoa")
	public String deletePessoa(int id) {
		Pessoa.deleteById(id);
		return "Pessoa de id: "+id+" Foi Deletada";
	}

	
	
	
	
	
}
