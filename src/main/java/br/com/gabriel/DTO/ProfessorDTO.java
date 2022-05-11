package br.com.gabriel.DTO;

import java.util.List;

import javax.persistence.OneToMany;

import br.com.gabriel.Model.Disciplina;

public class ProfessorDTO {

    
    public String nome;
    
    public Integer idade;
     
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getIdade() {
        return idade;
    }
    
}
