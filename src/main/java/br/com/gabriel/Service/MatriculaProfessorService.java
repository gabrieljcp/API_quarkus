package br.com.gabriel.Service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;


import br.com.gabriel.DTO.MatriculaProfessorDTO;
import br.com.gabriel.Model.Professor;
import br.com.gabriel.Model.Disciplina;
import br.com.gabriel.Model.MatriculaProfessor;
import br.com.gabriel.Repository.DisciplinaRepository;
import br.com.gabriel.Repository.MatriculaProfessorRepository;
//import br.com.gabriel.Repository.MatriculaRepository;
import br.com.gabriel.Repository.ProfessorRepository;

@ApplicationScoped
public class MatriculaProfessorService {

    @Inject
    private ProfessorRepository professorRepository;

    @Inject
    private DisciplinaRepository disciplinaRepository;

    @Inject
    private MatriculaProfessorRepository matriculaProfessorRepository;

    public void matricular(MatriculaProfessorDTO dto) {

        MatriculaProfessor matriculaProfessor = new MatriculaProfessor();
        Professor professor = professorRepository.findById(dto.professorId);
        if (professor == null) {
            throw new NotFoundException();
        }
        Disciplina disciplina = disciplinaRepository.findById(dto.disciplinaId);
        if (disciplina == null) {
            throw new NotFoundException();
        }
        matriculaProfessor.setProfessor(professor);
        matriculaProfessor.setDisciplina(disciplina);
        matriculaProfessor.persist();
    }

    public List<MatriculaProfessorDTO>buscarMatriculas() {

        List<MatriculaProfessorDTO> matriculasProfessorDTO = new ArrayList<>();
        List<MatriculaProfessor> matriculasProfessor = matriculaProfessorRepository.listAll();
        for (MatriculaProfessor matriculaProfessor : matriculasProfessor) {
            MatriculaProfessorDTO matriculaProfessorDTO = new MatriculaProfessorDTO();
            matriculaProfessorDTO.professorId = matriculaProfessor.professor.id;
            matriculaProfessorDTO.disciplinaId = matriculaProfessor.disciplina.id;
            matriculasProfessorDTO.add(matriculaProfessorDTO);

        }
        return matriculasProfessorDTO;
    }
}