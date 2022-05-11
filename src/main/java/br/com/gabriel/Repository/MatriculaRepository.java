package br.com.gabriel.Repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.gabriel.Model.Matricula;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class MatriculaRepository implements PanacheRepository<Matricula>{
    
}
