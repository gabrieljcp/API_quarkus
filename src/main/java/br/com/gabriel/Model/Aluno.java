package br.com.gabriel.Model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

@Entity
@Transactional
@Getter
@Setter
public class Aluno extends PanacheEntityBase{

    @Id
    @GeneratedValue
    public Long id;

    public String nome;

    public Integer idade;

    // public void persistOrUpdate() {
    // } 
     
    // @OneToMany(cascade = CascadeType.ALL)
    // private List<Disciplina> disciplinas;

   

    
    // public List<Disciplina> getDisciplinas() {
    //     return disciplinas;
    // }

    // public void setDisciplinas(List<Disciplina> disciplinas) {
    //     this.disciplinas = disciplinas;
    // }





}
