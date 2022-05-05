package br.com.gabriel.Repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.gabriel.Model.Disciplina;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class DisciplinaRepository implements PanacheRepository<Disciplina>{
    
}
