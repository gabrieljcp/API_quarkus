package br.com.gabriel.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

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
    
    public Aluno updateAluno(Long id, AlunoDTO dto) {

        Aluno entity = Aluno.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.nome = dto.nome; 
        entity.idade = dto.idade;        

        return entity;
    }

    public String deleteAluno(Long id) {

       Aluno entity = Aluno.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
        return "EXCLUIDO COM SUCESSO";
    }

}
