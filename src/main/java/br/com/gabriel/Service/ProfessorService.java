package br.com.gabriel.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PathParam;

import br.com.gabriel.DTO.ProfessorDTO;
import br.com.gabriel.Model.Professor;

@ApplicationScoped
public class ProfessorService {

    public void adicionarProfessor (ProfessorDTO dto) {

        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setIdade(dto.getIdade());
        professor.persist(); 
    }

    public Professor updateProfessor (Long id, ProfessorDTO dto) {
        
        Professor entity = Professor.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.nome = dto.nome; 
        entity.idade = dto.idade;

        return entity;  
    }

    public void deleteProfessor(@PathParam("id")Long id) {
        Professor entity = Professor.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
    }
    
}
