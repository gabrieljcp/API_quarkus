package br.com.gabriel.DTO;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.gabriel.Model.Professor;

public class DisciplinaDTO {
    
    public String nome;
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
