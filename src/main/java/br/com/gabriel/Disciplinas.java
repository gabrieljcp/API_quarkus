package br.com.gabriel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Disciplinas extends PanacheEntity{

    public String nome;

    @OneToMany(cascade = CascadeType.ALL)    
    private List<Aluno> aluno;

    @OneToOne(cascade = CascadeType.ALL)  
    @JoinColumn(name = "professor_id")  
    private Professor professor;


}
