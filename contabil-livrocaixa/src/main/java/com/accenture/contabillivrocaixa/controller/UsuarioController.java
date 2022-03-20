package com.accenture.contabillivrocaixa.controller;

import com.accenture.contabillivrocaixa.entity.Usuario;
import com.accenture.contabillivrocaixa.repository.UsuarioRepository;
import com.accenture.contabillivrocaixa.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public Usuario insertUsuario (@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteUsuario (@PathVariable(value = "id") BigInteger id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Usuario> putUsuario(@PathVariable(value = "id") BigInteger id,
                                              @Valid @RequestBody Usuario newUsuario) {
        Optional<Usuario> oldUsuario = usuarioRepository.findById(id);
        if (oldUsuario.isPresent()) {
            Usuario usuario = oldUsuario.get();
            usuario.setDataCadastro(newUsuario.getDataCadastro());
            usuario.setNome(newUsuario.getNome());
            usuario.setLogin(newUsuario.getLogin());
            usuario.setSenha(newUsuario.getSenha());
            usuario.setTelefone(newUsuario.getTelefone());
            usuario.setEmail(newUsuario.getEmail());
            usuario.setPerfil(newUsuario.getPerfil());
            usuario.setStatus(newUsuario.getStatus());
            usuarioRepository.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Usuario> findByIdUsuario (@PathVariable(value = "id") BigInteger id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findByNomeOrEmailUsuario
            (@RequestParam(name = "nome", required = false) String nome,
             @RequestParam(name = "email", required = false) String email) {
        List<Usuario> listaUsuario = usuarioRepository.getUsuarioByNomeOrEmail(nome, email);
        if (!listaUsuario.isEmpty()) {
            return new ResponseEntity<List<Usuario>>(listaUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
