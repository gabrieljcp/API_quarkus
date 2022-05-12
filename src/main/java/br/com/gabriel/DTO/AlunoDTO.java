package br.com.gabriel.DTO;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

public class AlunoDTO extends PanacheEntityBase{
    
    public String nome;
    public Integer idade;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }


  
}