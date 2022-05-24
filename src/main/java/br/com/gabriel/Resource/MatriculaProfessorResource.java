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

import br.com.gabriel.DTO.MatriculaProfessorDTO;
import br.com.gabriel.Model.MatriculaProfessor;
import br.com.gabriel.Repository.DisciplinaRepository;
import br.com.gabriel.Repository.MatriculaProfessorRepository;
import br.com.gabriel.Repository.ProfessorRepository;
import br.com.gabriel.Service.MatriculaProfessorService;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Path("/matriculas")
@Tag(name="Matrículas dos Professores", description = "dos professores nas disciplinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class MatriculaProfessorResource {

    @Inject
    private MatriculaProfessorRepository matriculaProfessorRepository;

    @Inject
    EntityManager em;

    @Inject
    private MatriculaProfessorService matriculaProfessorService;

    @GET 
    @Path("/professores")   
    public List<?> findProfessores(){
         
        Query query = em.createQuery("SELECT p.nome from MatriculaProfessor mp join Professor p ON(mp.professor.id = p.id)");

        return query.getResultList();   
         //matriculaProfessorRepository.joins();
    } 
    
    @GET
    public List<MatriculaProfessorDTO>buscarMatriculas() {
        
        List<MatriculaProfessorDTO> matriculasProfessorDTO = new ArrayList<>();
        List<MatriculaProfessor> matriculasProfessor = matriculaProfessorRepository.listAll();
        for (MatriculaProfessor matriculaProfessor : matriculasProfessor) {
            MatriculaProfessorDTO matriculaProfessorDTO = new MatriculaProfessorDTO();
            matriculaProfessorDTO.professorId = matriculaProfessor.professor.id;
            matriculaProfessorDTO.disciplinaId = matriculaProfessor.disciplina.id;
            matriculasProfessorDTO.add(matriculaProfessorDTO);

        }
        return matriculasProfessorDTO;
    }

    @GET
    @Path("/{id}")
    public MatriculaProfessor get(@PathParam("id")Long id) {
        return MatriculaProfessor.findById(id);
    }

    @POST    
    @Transactional    
    public void matricular(@RequestBody MatriculaProfessorDTO dto) {
         matriculaProfessorService.matricular(dto);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public MatriculaProfessor update(@PathParam("id")Long id, MatriculaProfessor Vinculo) {
        MatriculaProfessor entity = Vinculo.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.professor = Vinculo.professor;
        entity.disciplina = Vinculo.disciplina;
        

        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String delete(@PathParam("id")Long id) {
        MatriculaProfessor entity = MatriculaProfessor.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
        return "EXCLUIDO COM SUCESSO";
    }

}