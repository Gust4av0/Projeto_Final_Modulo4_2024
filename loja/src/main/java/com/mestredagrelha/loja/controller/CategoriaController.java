package com.mestredagrelha.loja.controller;

import com.mestredagrelha.loja.dto.CategoriaRequestDTO;
import com.mestredagrelha.loja.model.Categoria;
import com.mestredagrelha.loja.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepositorio;

    @ResponseBody
    @GetMapping("/buscar-categorias")
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> categorias = this.categoriaRepositorio.findAll();
        return ResponseEntity.ok(categorias);
    }

    @ResponseBody
    @PostMapping("/cadastrar-categorias")
    public ResponseEntity<Categoria> save(@RequestBody CategoriaRequestDTO dto){
        if (dto.nome().isEmpty()){
            return ResponseEntity.status(400).build();
        }
        Categoria categoria = new Categoria();
        categoria.setCategoria_id(dto.categoria_id());
        categoria.setNome(dto.nome());
        categoria.setDescricao(dto.descricao());

        this.categoriaRepositorio.save(categoria);
        return ResponseEntity.ok(categoria);
    }

}
