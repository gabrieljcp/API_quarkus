package br.com.gabriel.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Id;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.gabriel.Model.Aluno;
import br.com.gabriel.Model.Disciplina;
import br.com.gabriel.Repository.AlunoRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;


@Path("/alunos")
@Tag(name="Alunos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AlunoResource {

    @Inject
    private AlunoRepository alunoRepository;

    @GET    
    public List<Aluno> buscarAlunos(){
        return alunoRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Aluno get(@PathParam("id")Long id) {
        return Aluno.findById(id);
    }

    @POST
    @Transactional    
    public Aluno adicionarAluno(Aluno aluno) {
        aluno.persist();
        return aluno;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Aluno update(@PathParam("id")Long id, Aluno aluno) {
        Aluno entity = Aluno.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }

        // map all fields from the aluno parameter to the existing entity
        entity.nome = aluno.nome; 
        entity.idade = aluno.idade;
        

        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String delete(@PathParam("id")Long id) {
        Aluno entity = Aluno.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
        return "EXCLUIDO COM SUCESSO";
    }

}