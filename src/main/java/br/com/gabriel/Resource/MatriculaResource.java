package br.com.gabriel.Resource;

import java.util.ArrayList;
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

import br.com.gabriel.DTO.MatriculaDTO;
import br.com.gabriel.Model.Aluno;
import br.com.gabriel.Model.Disciplina;
import br.com.gabriel.Model.Matricula;
import br.com.gabriel.Repository.AlunoRepository;
import br.com.gabriel.Repository.DisciplinaRepository;
import br.com.gabriel.Repository.MatriculaRepository;
import br.com.gabriel.Service.MatriculaService;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

@Path("/matricula")
@Tag(name="Matrículas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class MatriculaResource {

    @Inject
    private MatriculaRepository matriculaRepository;

    @Inject
    private AlunoRepository alunoRepository;

    @Inject
    private DisciplinaRepository disciplinaRepository;

    @Inject
    private MatriculaService matriculaService;

    @GET    
    public List<MatriculaDTO> buscarMatriculas(){
        List<MatriculaDTO> matriculasDTO = new ArrayList<>();
        List<Matricula> matriculas = matriculaRepository.listAll();
        for (Matricula matricula : matriculas) {
            MatriculaDTO matriculaDTO = new MatriculaDTO(); 
            matriculaDTO.alunoId = matricula.aluno.id;
            matriculaDTO.disciplinaId = matricula.disciplina.id;
            matriculasDTO.add(matriculaDTO);
            
        }
        return matriculasDTO;
    }

    @GET
    @Path("/{id}")
    public Matricula get(@PathParam("id")Long id) {
        return Matricula.findById(id);
    }

    @POST    
    @Transactional    
    public void matricular(@RequestBody MatriculaDTO dto) {
         matriculaService.matricular(dto);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Matricula update(@PathParam("id")Long id, Matricula Vinculo) {
        Matricula entity = Vinculo.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }

        // map all fields from the Vinculo parameter to the existing entity
        entity.aluno = Vinculo.aluno;
        entity.disciplina = Vinculo.disciplina;
        

        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String delete(@PathParam("id")Long id) {
        Matricula entity = Matricula.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
        return "EXCLUIDO COM SUCESSO";
    }

}