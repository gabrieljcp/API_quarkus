package br.com.gabriel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;


public interface ProfessorResource extends PanacheEntityResource<Professor, Long> {

    
}