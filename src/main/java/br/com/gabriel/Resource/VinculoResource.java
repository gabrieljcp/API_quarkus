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

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.gabriel.Model.Vinculo;
import br.com.gabriel.Repository.VinculoRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

@Path("/vinculo")
@Tag(name="Vinculos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class VinculoResource {

    @Inject
    private VinculoRepository vinculoRepository;

    @GET    
    public List<Vinculo> buscarVinculos(){
        return vinculoRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Vinculo get(@PathParam("id")Long id) {
        return Vinculo.findById(id);
    }

    @POST
    @Transactional    
    public Vinculo adicionarVinculo(Vinculo Vinculo) {
        Vinculo.persist();
        return Vinculo ;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Vinculo update(@PathParam("id")Long id, Vinculo Vinculo) {
        Vinculo entity = Vinculo.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }

        // map all fields from the Vinculo parameter to the existing entity
        entity.nome = Vinculo.nome;
        

        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String delete(@PathParam("id")Long id) {
        Vinculo entity = Vinculo.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
        return "EXCLUIDO COM SUCESSO";
    }

}