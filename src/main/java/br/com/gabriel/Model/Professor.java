package br.com.gabriel.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Transactional
@Getter
@Setter
public class Professor extends PanacheEntity{

    public String nome;

    public Integer idade;

    @OneToMany
    private List<Disciplina> disciplinas;

}
