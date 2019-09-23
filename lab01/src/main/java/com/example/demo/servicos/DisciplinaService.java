package com.example.demo.servicos;

import java.util.ArrayList;
import java.util.HashMap;


import com.example.demo.entidades.Disciplina;
import com.example.demo.entidades.DisciplinaDTO;

import org.springframework.stereotype.Service;

@Service
public class DisciplinaService{

    private HashMap<Integer, Disciplina> disciplinas;
    private int id;

    public DisciplinaService() {
        this.disciplinas = new HashMap<Integer, Disciplina>();
        this.id = 0;
    }
    public Disciplina adicionaDisciplina(Disciplina novaDisciplina) {
        novaDisciplina.setID(id);
        this.disciplinas.put(id, novaDisciplina); 
        this.id++;
        return novaDisciplina;
    }

    public HashMap<Integer, Disciplina> mostraDisciplinas() {
        return this.disciplinas;
    }

	public DisciplinaDTO retornaDisciplina(int id) {
        Disciplina saida = this.disciplinas.get(id);
        return new DisciplinaDTO(saida.getNome(), saida.getNota());
    }
    
    public Disciplina setDisciplina(int id, String nome){
        this.disciplinas.get(id).setNome(nome);
        return this.disciplinas.get(id);
    }

    public Disciplina setDisciplina(int id, double nota){
        this.disciplinas.get(id).setNota(nota);
        return this.disciplinas.get(id);
    }
	public Disciplina removeDisciplina(int id) {
        Disciplina saida = this.disciplinas.get(id);
        this.disciplinas.remove(id);
        return saida;
	}
	public ArrayList<Disciplina> rankingDisciplinas() {
        ArrayList<Disciplina> a = new ArrayList<Disciplina>();
        for (Disciplina d: this.disciplinas.values()){
            a.add(d);
        }
        for (int i = 0; i < a.size(); i++){
            for (int j = 0; j < a.size()-1; j++){
                if (a.get(j).getNota() < a.get(j + 1).getNota()){
                    Disciplina aux = a.get(j);
                    a.set(j, a.get(j + 1));
                    a.set(j + 1, aux);
                }
            } 
        }
        return a;
    }
    
	public String existeNaLista(int id) {
		if (this.disciplinas.containsKey(id)){
            return "chá";
        }
        return null;
	}

}