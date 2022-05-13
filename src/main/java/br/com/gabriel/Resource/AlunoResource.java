package br.com.gabriel.Resource;

import java.util.List;

import javax.enterprise.inject.AmbiguousResolutionException;
import javax.inject.Inject;
import javax.persistence.EntityManager;
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
import br.com.gabriel.Service.AlunoService;
import br.com.gabriel.DTO.AlunoDTO;


@Path("/alunos")
@Tag(name="Alunos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AlunoResource {

    @Inject
    private AlunoRepository alunoRepository;

    @Inject
    private AlunoService alunoService;

    @Inject
	EntityManager manager;
    
    @GET    
    public List<Aluno> buscarAlunos(){
        return alunoRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Aluno get(@PathParam("id")Long id) {
        return Aluno.findById(id);
    }

    // @GET
    // @Path("/{id}/professores")
    // public Object professorAluno(@PathParam("id")Long id) {
    //     return manager.createQuery("select id from professor"
    //     ).getSingleResult();
    // }

    @POST
    @Transactional    
    public void adicionarAluno(@RequestBody AlunoDTO dto) {
        alunoService.adicionarAluno(dto);   
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public AlunoDTO updateAluno(@PathParam("id")Long id, AlunoDTO dto) {
        alunoService.updateAluno(id, dto);
         return dto;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String deleteAluno(@PathParam("id")Long id) {
        alunoService.deleteAluno(id);
        return "EXCLUIDO COM SUCESSO";
    }

}