package br.com.gabriel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/aluno/professores")
public class ProfessoresAlunoResouce {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String methodname() {
        return "Heineken";
    }
}
