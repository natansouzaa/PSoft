package psoft.lab02.entidades;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class DisciplinaDTO {

    @Id
    private Long id;
    private String nome;

    public DisciplinaDTO(){
        super();
    }

    @JsonCreator
    public DisciplinaDTO(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DisciplinaDTO)) {
            return false;
        }
        DisciplinaDTO disciplinaDTO = (DisciplinaDTO) o;
        return Objects.equals(id, disciplinaDTO.id) && Objects.equals(nome, disciplinaDTO.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

}