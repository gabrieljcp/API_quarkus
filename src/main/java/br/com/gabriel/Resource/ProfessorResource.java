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

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.gabriel.DTO.ProfessorDTO;
import br.com.gabriel.Model.Professor;
import br.com.gabriel.Repository.ProfessorRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;


@Path("/professor")
@Tag(name="Professor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProfessorResource {

    @Inject
    private ProfessorRepository professorRepository;

    @GET    
    public List<Professor> buscarProfessor(){
        return professorRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Professor get(@PathParam("id")Long id) {
        return Professor.findById(id);
    }

    // @POST
    // @Transactional    
    // public Professor adicionarProfessor(Professor Professor) {
    //     Professor.persist();
    //     return Professor ;
    // }
    @POST
    @Transactional    
    public void adicionarProfessor(@RequestBody ProfessorDTO dto) {
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setIdade(dto.getIdade());
        professor.persist();    
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Professor update(@PathParam("id")Long id, Professor Professor) {
        Professor entity = Professor.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }

        // map all fields from the Professor parameter to the existing entity
        entity.nome = Professor.nome; 
        entity.idade = Professor.idade;
        

        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String delete(@PathParam("id")Long id) {
        Professor entity = Professor.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
        return "EXCLUIDO COM SUCESSO";
    }

}