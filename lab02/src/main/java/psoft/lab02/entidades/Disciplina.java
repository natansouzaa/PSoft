package psoft.lab02.entidades;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;




@Entity
public class Disciplina {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private double nota;
    private int likes;
    private String comentarios;

    public Disciplina(){
        super();
    }

    @JsonCreator
    public Disciplina(Long id, String nome, double nota, int likes, String comentarios){
        super();
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.likes = likes;
        this.comentarios = comentarios;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    } 

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Disciplina)) {
            return false;
        }
        Disciplina disciplina = (Disciplina) o;
        return id == disciplina.id && Objects.equals(nome, disciplina.nome) && nota == disciplina.nota && likes == disciplina.likes && Objects.equals(comentarios, disciplina.comentarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nota, likes, comentarios);
    }

}