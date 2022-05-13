package br.com.gabriel.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.resteasy.annotations.Query;

import br.com.gabriel.Model.Aluno;
import br.com.gabriel.Model.Professor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno> {

    // @Query("select nome from Professor")
    // public List<Professor> nome(String nome);

  
    
}
