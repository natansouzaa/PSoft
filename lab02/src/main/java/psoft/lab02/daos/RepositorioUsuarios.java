package psoft.lab02.daos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psoft.lab02.entidades.Usuario;

@Repository
public interface RepositorioUsuarios<T, ID extends Serializable> extends JpaRepository<Usuario, String>{

} 