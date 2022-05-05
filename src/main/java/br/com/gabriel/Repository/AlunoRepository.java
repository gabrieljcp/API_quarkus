package br.com.gabriel.Repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.gabriel.Model.Aluno;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno>{

  
    
}
