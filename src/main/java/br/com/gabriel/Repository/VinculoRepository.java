package br.com.gabriel.Repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.gabriel.Model.Vinculo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class VinculoRepository implements PanacheRepository<Vinculo>{
    
}
