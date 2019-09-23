package com.example.demo.controladores;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.demo.entidades.Disciplina;
import com.example.demo.entidades.DisciplinaDTO;
import com.example.demo.servicos.DisciplinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisciplinaController{

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping("/v1/api/disciplinas")
    public ResponseEntity<Disciplina> adicionaDisciplina(@RequestBody Disciplina novaDisciplina){
        return new ResponseEntity<Disciplina>(disciplinaService.adicionaDisciplina(novaDisciplina), HttpStatus.CREATED);
    }

    @RequestMapping("/v1/api/disciplinas")
    public ResponseEntity<HashMap<Integer, Disciplina>> retornaDisciplinas(){
        return new ResponseEntity<HashMap<Integer, Disciplina>>(disciplinaService.mostraDisciplinas(), HttpStatus.OK);
    }

    @RequestMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<DisciplinaDTO> retornaDisciplina(@PathVariable("id") int id){
        if(disciplinaService.existeNaLista(id) == null) { // Mudança aqui
            return ResponseEntity.notFound().build();
        }
        
        return new ResponseEntity<DisciplinaDTO>(disciplinaService.retornaDisciplina(id), HttpStatus.OK);
    }

    @PutMapping("/v1/api/disciplinas/{id}/nome")
    public ResponseEntity<Disciplina> setDisciplina(@PathVariable("id") int id, @RequestBody String nome){
        if(disciplinaService.existeNaLista(id) == null) { // Mudança aqui
            return ResponseEntity.notFound().build();
        }
        
        return new ResponseEntity<Disciplina>(disciplinaService.setDisciplina(id, nome), HttpStatus.OK);
    }

    @PutMapping("/v1/api/disciplinas/{id}/nota")
    public ResponseEntity<Disciplina> setDisciplina(@PathVariable("id") int id, @RequestBody double nota){
        if(disciplinaService.existeNaLista(id) == null) { // Mudança aqui
            return ResponseEntity.notFound().build();
        }
        
        return new ResponseEntity<Disciplina>(disciplinaService.setDisciplina(id, nota), HttpStatus.OK);
    }

    @DeleteMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> removeDisciplina(@PathVariable("id") int id){
        if(disciplinaService.existeNaLista(id) == null) { // Mudança aqui
            return ResponseEntity.notFound().build();
        }
       
        return new ResponseEntity<Disciplina>(disciplinaService.removeDisciplina(id), HttpStatus.OK);
    }

    @RequestMapping("/v1/api/disciplinas/ranking")
    public ResponseEntity<ArrayList<Disciplina>> rankingDisciplinas(){
        return new ResponseEntity<ArrayList<Disciplina>>(disciplinaService.rankingDisciplinas(), HttpStatus.OK);
    }

}