package br.com.gabriel.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
import br.com.gabriel.Service.ProfessorService;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;


@Path("/professor")
@Tag(name="Professor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProfessorResource {

    @Inject
    EntityManager em;

    @Inject
    private ProfessorRepository professorRepository;

    @Inject
    protected ProfessorService professorService;


    @GET    
    public List<Professor> buscarProfessor(){
        return professorRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Professor get(@PathParam("id")Long id) {
        return Professor.findById(id);
    }

    @GET 
    @Path("/{id}/disciplinas")   
    public List<?> findDisciplinas(@PathParam("id")Long id){   
        return professorRepository.findDisciplinas(id);      
    } 

    @POST
    @Transactional    
    public void adicionarProfessor(@RequestBody ProfessorDTO dto) {
        professorService.adicionarProfessor(dto);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public String update(@PathParam("id")Long id, ProfessorDTO dto) {
        professorService.updateProfessor(id, dto);
        return "ATUALIZADO COM SUCESSO";
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String delete(@PathParam("id")Long id) {
        professorService.deleteProfessor(id);
        return "EXCLUIDO COM SUCESSO";
    }

}