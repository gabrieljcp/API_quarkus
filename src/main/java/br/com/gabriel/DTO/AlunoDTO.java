package br.com.gabriel.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.gabriel.Model.Disciplina;
import lombok.Getter;
import lombok.Setter;



public class AlunoDTO {
    
    private String nome;
    private Integer idade;

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