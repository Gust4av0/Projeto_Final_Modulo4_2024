package com.mestredagrelha.loja.controller;

import com.mestredagrelha.loja.dto.ProdutoRequestDTO;
import com.mestredagrelha.loja.dto.UsuarioRequestDTO;
import com.mestredagrelha.loja.model.Produto;
import com.mestredagrelha.loja.model.Usuario;
import com.mestredagrelha.loja.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @ResponseBody
    @GetMapping("buscar-usuarios")
    public ResponseEntity<List<Usuario>> todosUsuarios(){
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/deletar-usuario/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id){
        Usuario usuario = this.usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não escontrado"));
        this.usuarioRepository.delete(usuario);

        return ResponseEntity.noContent().build();
    }

}
