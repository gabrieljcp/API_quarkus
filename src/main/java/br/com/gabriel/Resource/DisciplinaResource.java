package br.com.gabriel.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.gabriel.Model.Disciplina;
import br.com.gabriel.Repository.DisciplinaRepository;
import br.com.gabriel.Service.DisciplinaService;
import br.com.gabriel.Service.ProfessorService;
import br.com.gabriel.DTO.DisciplinaDTO;

@Path("/disciplinas")
@Tag(name="Disciplinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class DisciplinaResource {

    @Inject
    private DisciplinaRepository disciplinaRepository;

    @Inject
    private DisciplinaService disciplinaService;

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
    public void adicionarDisciplina(@RequestBody DisciplinaDTO disciplinaDto) {
        //professorService.adicionarProfessor(dto);   
        disciplinaService.adicionarDisciplina(disciplinaDto);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public DisciplinaDTO updateDisciplina(@PathParam("id")Long id, DisciplinaDTO dto) {
        disciplinaService.updateDisciplina(id, dto);
        return dto;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String delete(@PathParam("id")Long id) {
        disciplinaService.deleteDisciplina(id);
        return "EXCLUIDO COM SUCESSO";
    }

    
}