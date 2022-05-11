package br.com.gabriel.Service;

import javax.enterprise.context.ApplicationScoped;

import br.com.gabriel.DTO.AlunoDTO;
import br.com.gabriel.Model.Aluno;

@ApplicationScoped
public class AlunoService {

    public void adicionarAluno(AlunoDTO dto){

        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setIdade(dto.getIdade());
        aluno.persist();    
        
    }
    
}
