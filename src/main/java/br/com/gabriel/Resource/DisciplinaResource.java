package br.com.gabriel.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.gabriel.Model.Disciplina;
import br.com.gabriel.Repository.DisciplinaRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.MethodProperties;
import io.quarkus.rest.data.panache.ResourceProperties;

@Path("/disciplinas")
@Tag(name="Disciplinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class DisciplinaResource {

    @Inject
    private DisciplinaRepository disciplinaRepository;

    @GET    
    public List<Disciplina> buscarDisciplinas(){
        return disciplinaRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Disciplina get(@PathParam("id")Long id) {
        return Disciplina.findById(id);
    }

    @POST
    @Transactional    
    public Disciplina adicionarDisciplina(Disciplina Disciplina) {
        Disciplina.persist();
        return Disciplina ;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Disciplina update(@PathParam("id")Long id, Disciplina Disciplina) {
        Disciplina entity = Disciplina.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }

        // map all fields from the Disciplina parameter to the existing entity
        entity.nome = Disciplina.nome; 
        

        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String delete(@PathParam("id")Long id) {
        Disciplina entity = Disciplina.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
        return "EXCLUIDO COM SUCESSO";
    }

    
}