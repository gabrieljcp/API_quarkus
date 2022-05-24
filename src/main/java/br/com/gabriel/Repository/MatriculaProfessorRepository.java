package br.com.gabriel.Repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.gabriel.Model.MatriculaProfessor;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class MatriculaProfessorRepository implements PanacheRepository<MatriculaProfessor> {

}
