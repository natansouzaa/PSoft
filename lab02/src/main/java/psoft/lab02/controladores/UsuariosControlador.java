package psoft.lab02.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import psoft.lab02.entidades.Disciplina;
import psoft.lab02.entidades.DisciplinaDTO;
import psoft.lab02.entidades.Usuario;
import psoft.lab02.servicos.DisciplinasServicos;
import psoft.lab02.servicos.UsuariosServicos;

@RestController
public class UsuariosControlador {

    @Autowired
    private UsuariosServicos usuariosServicos;
    private DisciplinasServicos disciplinasServicos;

    //Adiciona um usuario com email, nome e senha. O email sera o login do usuario e deve ser um identificador unico
    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> adicionaUsuario(@RequestBody Usuario novoUsuario) {
        return new ResponseEntity<Usuario>(usuariosServicos.adicionaUsuario(novoUsuario), HttpStatus.CREATED);
    }

    //Retorna um JSON (com campos id, nome) com todas as disciplinas inseridas no sistema
    @GetMapping("/api/disciplinas")
    public ResponseEntity<List<DisciplinaDTO>> retornaDisciplinas() {
        return new ResponseEntity<List<DisciplinaDTO>>(disciplinasServicos.retornaDisciplinas(), HttpStatus.OK);
    }

    //Retorna um JSON que representa a disciplina completa (id, nome, nota, likes e comentarios) cujo identificador unico e id
    @GetMapping("/api/disciplinas/{id}")
    public ResponseEntity<Optional<Disciplina>> retornaDisciplina(@PathVariable("id") Long id){
        if(disciplinasServicos.existeNoBD(id) == false){ // Mudança aqui
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<Optional<Disciplina>>(disciplinasServicos.retornaDisciplina(id), HttpStatus.OK);
        }
    }

    @PutMapping("/api/disciplinas/likes/{id}")
    public ResponseEntity<Optional<Disciplina>> incrementaLikes(@PathVariable("id") Long id){
        if(disciplinasServicos.existeNoBD(id) == false){ // Mudança aqui
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<Optional<Disciplina>>(disciplinasServicos.incrementaLikes(id), HttpStatus.OK);
        }
    }

    @PutMapping("/api/disciplinas/nota/{id}")
    public ResponseEntity<Optional<Disciplina>> setDisciplina(@PathVariable("id") Long id, @RequestBody double nota){
        if(disciplinasServicos.existeNoBD(id) == false) { // Mudança aqui
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Optional<Disciplina>>(disciplinasServicos.setDisciplina(id, nota), HttpStatus.OK);
    }

    @PutMapping("/api/disciplinas/comentarios/{id}")
    public ResponseEntity<Optional<Disciplina>> setDisciplina(@PathVariable("id") Long id, @RequestBody String comentario){
        if(disciplinasServicos.existeNoBD(id) == false) { // Mudança aqui
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Optional<Disciplina>>(disciplinasServicos.setDisciplina(id, comentario), HttpStatus.OK);
    }

    @GetMapping("/api/disciplinas/ranking/notas")
    public ResponseEntity<List<Disciplina>> rankingDisciplinasNotas(){
        return new ResponseEntity<List<Disciplina>>(disciplinasServicos.rankingDisciplinasNotas(), HttpStatus.OK);
    }

    @GetMapping("/v1/api/disciplinas/ranking/likes")
    public ResponseEntity<List<Disciplina>> rankingDisciplinas(){
        return new ResponseEntity<List<Disciplina>>(disciplinasServicos.rankingDisciplinasLikes(), HttpStatus.OK);
    }

    /*@GetMapping("/v1/auth/usuarios/{email}")
    public ResponseEntity<Usuario> retornaUsuario(@PathVariable ("email") String email){
       Optional<Usuario> usuario = usuariosServicos.retornaUsuario(email);
       if (usuario.isPresent()){
           return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
       } else {
           return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
       }
    }*/

}