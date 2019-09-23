package psoft.lab02.servicos;

import java.util.Optional;

import org.springframework.stereotype.Service;

import psoft.lab02.daos.RepositorioUsuarios;
import psoft.lab02.entidades.Usuario;

@Service
public class UsuariosServicos {

    private RepositorioUsuarios<Usuario, String> usuariosDAO;

    public UsuariosServicos(RepositorioUsuarios<Usuario, String> usuariosDAO){
        super();
        this.usuariosDAO = usuariosDAO;
    }

    public Usuario adicionaUsuario(Usuario usuario){
        return usuariosDAO.save(usuario);
    }

    public Optional<Usuario> retornaUsuario(String email){
        return this.usuariosDAO.findById(email);
    }

}