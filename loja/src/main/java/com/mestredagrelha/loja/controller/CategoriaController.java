package com.mestredagrelha.loja.controller;

import com.mestredagrelha.loja.dto.CategoriaRequestDTO;
import com.mestredagrelha.loja.model.Categoria;
import com.mestredagrelha.loja.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @DeleteMapping("/deletar-categoria/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Integer id) {
        // Busca a categoria no repositório
        Categoria categoria = this.categoriaRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        // Deleta a categoria encontrada
        this.categoriaRepositorio.delete(categoria);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar-categoria/{id}")
    public ResponseEntity<Categoria> atualizarCategoria (@PathVariable Integer id, @RequestBody Categoria categoriaAtualizada){
        Categoria categoriaExistente = this.categoriaRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        categoriaExistente.setNome(categoriaAtualizada.getNome());
        categoriaExistente.setDescricao(categoriaAtualizada.getDescricao());

        Categoria categoriaSalva = this.categoriaRepositorio.save(categoriaExistente);
        return ResponseEntity.ok(categoriaSalva);
    }

}
