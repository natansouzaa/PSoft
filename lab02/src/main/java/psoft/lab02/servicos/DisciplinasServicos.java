package psoft.lab02.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import psoft.lab02.daos.RepositorioDisciplinas;
import psoft.lab02.daos.RepositorioDisciplinasDTO;
import psoft.lab02.entidades.Disciplina;
import psoft.lab02.entidades.DisciplinaDTO;

@Service
public class DisciplinasServicos {

    private RepositorioDisciplinas<Disciplina, Long> disciplinasDAO;
    private RepositorioDisciplinasDTO<Disciplina, Long> disciplinasDTODAO;

    public DisciplinasServicos(RepositorioDisciplinas<Disciplina, Long> disciplinasDAO, RepositorioDisciplinasDTO<Disciplina, Long> disciplinasDTODAO){
        super();
        this.disciplinasDAO = disciplinasDAO;
        this.disciplinasDTODAO = disciplinasDTODAO;
    }

    public List<DisciplinaDTO> retornaDisciplinas(){
        return this.disciplinasDTODAO.findAll();
    }

    public Optional<Disciplina> retornaDisciplina(Long id){
        return this.disciplinasDAO.findById(id);
    }

    public boolean existeNoBD(Long id){
        return this.disciplinasDAO.existsById(id);
    }

	public Optional<Disciplina> incrementaLikes(Long id) {
        int likesAntigos = this.disciplinasDAO.findById(id).get().getLikes();
        this.disciplinasDAO.findById(id).get().setLikes(likesAntigos + 1);
		return this.disciplinasDAO.findById(id);
	}

	public Optional<Disciplina> setDisciplina(Long id, double nota) {
        this.disciplinasDAO.findById(id).get().setNota(nota);
        return this.disciplinasDAO.findById(id);
	}

	public Optional<Disciplina> setDisciplina(Long id, String comentario) {
        String comentariosAntigos = this.disciplinasDAO.findById(id).get().getComentarios();
        this.disciplinasDAO.findById(id).get().setComentarios(comentariosAntigos + comentario + " | ");
        return this.disciplinasDAO.findById(id);
	}

	public List<Disciplina> rankingDisciplinasNotas() {
        return null;
	}

	public List<Disciplina> rankingDisciplinasLikes() {
		return null;
	}

}