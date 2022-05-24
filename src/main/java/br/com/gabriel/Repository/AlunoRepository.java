package br.com.gabriel.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gabriel.Model.Aluno;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno> {

    @Inject
    EntityManager em;

    public List<?> findProfessores(Long id) {

        // Query queryy = em.createQuery("SELECT a.nome from Aluno a WHERE "+id+"=
        // a.id");

        // Query query = em.createQuery("SELECT p.nome from MatriculaProfessor mp join
        // Professor p ON(mp.professor.id = p.id)");
        Query query = em.createQuery("SELECT p.nome from Professor p, Matricula m, MatriculaProfessor mp WHERE " + id
                + "= m.aluno.id AND m.disciplina.id = mp.disciplina.id AND mp.professor.id = p.id");

        return query.getResultList();

    }

}
