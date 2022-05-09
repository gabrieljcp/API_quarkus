package br.com.gabriel.DTO;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.gabriel.Model.Professor;

public class DisciplinaDTO {
    
    public String nome;

    @ManyToOne
	@JoinColumn(name = "professor_id")
	public ProfessorDTO professor;

    public ProfessorDTO getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDTO professor) {
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
