package br.com.gabriel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

@Tag(name="Disciplinas")
public interface DisciplinasResource extends PanacheEntityResource<Disciplinas, Long> {

    
}