package br.com.gabriel.Repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.gabriel.Model.Professor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepository<Professor>{
    
}
