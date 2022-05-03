package br.com.gabriel;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Aluno extends PanacheEntity{

    private String nome;

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

    public LocalDateTime getDataAtualizaçãoDados() {
        return dataAtualizaçãoDados;
    }

    public void setDataAtualizaçãoDados(LocalDateTime dataAtualizaçãoDados) {
        this.dataAtualizaçãoDados = dataAtualizaçãoDados;
    }

    public List<Disciplinas> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplinas> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Professor> getProfessor() {
        return professor;
    }

    public void setProfessor(List<Professor> professor) {
        this.professor = professor;
    }

    private Integer idade;

    private LocalDateTime dataAtualizaçãoDados;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Disciplinas> disciplinas;

    @OneToMany
    private List<Professor> professor;

}
