package br.com.gabriel.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.com.gabriel.DTO.AlunoDTO;
import br.com.gabriel.Model.Aluno;
import br.com.gabriel.Repository.AlunoRepository;

@ApplicationScoped
public class AlunoService {

    @Inject
    AlunoRepository alunoRepository;

    public Aluno builder(AlunoDTO dto) {

        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setIdade(dto.getIdade());

        return aluno;

    } 

    public void adicionarAluno(AlunoDTO dto){

        Aluno aluno = builder(dto);
        alunoRepository.persist(aluno);    
        
    }
    
    public Aluno updateAluno(Long id, AlunoDTO dto) {

        Aluno entity = alunoRepository.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.nome = dto.nome; 
        entity.idade = dto.idade; 
        alunoRepository.persist(entity);;   

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
