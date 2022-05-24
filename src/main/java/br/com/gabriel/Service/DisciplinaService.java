package br.com.gabriel.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;

import br.com.gabriel.DTO.DisciplinaDTO;
import br.com.gabriel.DTO.ProfessorDTO;
import br.com.gabriel.Model.Disciplina;
import br.com.gabriel.Model.Professor;

@ApplicationScoped
public class DisciplinaService {

    public void adicionarDisciplina(DisciplinaDTO disciplinaDto){

        Disciplina disciplina = new Disciplina();
        disciplina.setNome(disciplinaDto.getNome());
        disciplina.persist(); 
    }

    // public void adicionarProfessor(ProfessorDTO professorDto){
        
    //     Professor professor = new Professor();
    //     professor.setNome(professorDto.getNome());
    //     professor.setIdade(professorDto.getIdade());
    //     professor.persist();
        
    // }
    
    public Disciplina updateDisciplina(Long id, DisciplinaDTO dto) {

        Disciplina entity = Disciplina.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.nome = dto.nome; 
        
        return entity;
    }

    public String deleteDisciplina(Long id) {

       Disciplina entity = Disciplina.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
        return "EXCLUIDO COM SUCESSO";
    }

    
}
