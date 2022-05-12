package br.com.gabriel.Model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

import br.com.gabriel.DTO.DisciplinaDTO;

import javax.persistence.JoinColumn;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

@Entity
@Transactional

public class Aluno extends PanacheEntityBase{

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id;


    public String nome;

    public Integer idade;

    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculas; 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

   

  

   
    







}
