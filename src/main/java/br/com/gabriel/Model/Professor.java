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

    @OneToMany(mappedBy = "professor")
    private List<Disciplina> disciplina; 

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
