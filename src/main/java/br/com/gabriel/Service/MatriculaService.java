package br.com.gabriel.Service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import br.com.gabriel.DTO.MatriculaDTO;
import br.com.gabriel.Model.Aluno;
import br.com.gabriel.Model.Disciplina;
import br.com.gabriel.Model.Matricula;
import br.com.gabriel.Repository.AlunoRepository;
import br.com.gabriel.Repository.DisciplinaRepository;
import br.com.gabriel.Repository.MatriculaRepository;

@ApplicationScoped
public class MatriculaService {

    @Inject
    private AlunoRepository alunoRepository;

    @Inject
    private DisciplinaRepository disciplinaRepository;

    @Inject
    private MatriculaRepository matriculaRepository;

    public void matricular(MatriculaDTO dto) {

        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(dto.alunoId);
        if (aluno == null) {
            throw new NotFoundException();
        }
        Disciplina disciplina = disciplinaRepository.findById(dto.disciplinaId);
        if (disciplina == null) {
            throw new NotFoundException();
        }
        matricula.setAluno(aluno);
        matricula.setDisciplina(disciplina);
        matricula.persist();
    }

    public void buscarMatriculas() {

        List<MatriculaDTO> matriculasDTO = new ArrayList<>();
        List<Matricula> matriculas = matriculaRepository.listAll();
        for (Matricula matricula : matriculas) {
            MatriculaDTO matriculaDTO = new MatriculaDTO();
            matriculaDTO.alunoId = matricula.aluno.id;
            matriculaDTO.disciplinaId = matricula.disciplina.id;
            matriculasDTO.add(matriculaDTO);

        }

    }
}