package com.example.demo.entidades;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Disciplina{
    
    private int id;
    private String nome;
    private double nota;

    @JsonCreator
    public Disciplina(int id, String nome, double nota){
        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }

    public int getId() {
        return this.id;
    }

    public void setID(int i) {
        this.id=i;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return this.nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Disciplina)) {
            return false;
        }
        Disciplina disciplina = (Disciplina) o;
        return id == disciplina.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}