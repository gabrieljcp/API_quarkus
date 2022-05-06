package br.com.gabriel.Model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;
import javax.persistence.JoinColumn;

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

    // @ManyToMany 
    // @JoinTable(name = "aluno_disciplina",  
    //         joinColumns = @JoinColumn(name = "aluno_id"),
    //         inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
    // private List<Disciplina> disciplina;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_disciplina")
    private List<Disciplina> disciplina;






}
