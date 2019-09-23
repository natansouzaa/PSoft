package com.example.demo.entidades;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DisciplinaDTO {

    private String nome;
    private double nota;

    @JsonCreator
    public DisciplinaDTO(String nome, double nota){
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return this.nome;
    }

    public double getNota() {
        return this.nota;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DisciplinaDTO)) {
            return false;
        }
        DisciplinaDTO disciplinaDTO = (DisciplinaDTO) o;
        return Objects.equals(nome, disciplinaDTO.nome) && nota == disciplinaDTO.nota;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, nota);
    }

}