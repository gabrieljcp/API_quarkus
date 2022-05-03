package br.com.gabriel;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;


// public interface AlunoResource extends PanacheEntityResource<Aluno, Long> {

    
// }

@Path("/alunos")
@Tag(name="Alunos")
public class AlunoResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aluno> buscarAluno(){
        return Aluno.listAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String adicionarUsuario(@RequestBody Aluno aluno) {
        return "hello" ;
    }

    @GET
    @Path("{idAluno}/professores")
    @Produces(MediaType.APPLICATION_JSON)
    @Tag(name="Professores_aluno")
    @APIResponse(responseCode = "200",description = "OK")
    @APIResponse(responseCode = "404",description = "Caso o aluno não exista")
    public List<Aluno> buscarAluno(@QueryParam("idAluno") Integer idAluno){
        return Aluno.listAll();
    }
}