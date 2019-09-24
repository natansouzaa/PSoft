package psoft.lab02.servicos;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psoft.lab02.daos.RepositorioDisciplinas;
import psoft.lab02.entidades.Disciplina;

@Service
public class DisciplinasServicos {

    @Autowired
    private RepositorioDisciplinas<Disciplina, Long> disciplinasDAO;

    public DisciplinasServicos() {}

    @PostConstruct
    public void initDisciplinas(){
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>(){};
        InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/disciplinas.json");
        try {
            List<Disciplina> disciplinas = mapper.readValue(inputStream, typeReference);
            this.disciplinasDAO.saveAll(disciplinas);
            System.out.println("Disciplinas salvas no sistema!");
        } catch (IOException e) {
            System.out.println("Nao foi possivel salvar as disciplinas: " + e.getMessage());
        }
    }

    public List<Disciplina> retornaDisciplinas(){
        return this.disciplinasDAO.findAll();
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