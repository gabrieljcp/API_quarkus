package br.com.gabriel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Aluno extends PanacheEntity{

    public String nome;

    public Integer idade;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Disciplinas> disciplinas;

}
