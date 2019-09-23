package psoft.lab02.daos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psoft.lab02.entidades.Disciplina;

@Repository
public interface RepositorioDisciplinas<T, ID extends Serializable> extends JpaRepository<Disciplina, Long>{

} 