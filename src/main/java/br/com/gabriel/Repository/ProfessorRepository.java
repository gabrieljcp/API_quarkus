package br.com.gabriel.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.PathParam;

import br.com.gabriel.Model.Professor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepository<Professor>{

    @Inject
    EntityManager em;
    
    public List<?> findDisciplinas(@PathParam("id")Long id){
        
        Query query = em.createQuery("SELECT d.nome from Disciplina d, Professor p, MatriculaProfessor mp WHERE "+id+"= mp.professor.id AND d.id = mp.disciplina.id AND mp.professor.id = p.id");

        return query.getResultList();   
         
    } 

}
