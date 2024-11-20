package com.mestredagrelha.loja.controller;

import com.mestredagrelha.loja.dto.ProdutoRequestDTO;
import com.mestredagrelha.loja.model.Categoria;
import com.mestredagrelha.loja.model.Produto;
import com.mestredagrelha.loja.repository.CategoriaRepository;
import com.mestredagrelha.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class ProdutoController {

    @Autowired //ligar a classe repositório
    private ProdutoRepository produtoRepositorio;

    private CategoriaRepository categoriaRepository;

    @ResponseBody
    @GetMapping("/buscar-produtos")
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = this.produtoRepositorio.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("")
    public String listarTodosProdutosHome(Model model) {
        List<Produto> produtos = this.produtoRepositorio.findAll();
        model.addAttribute("produtos", produtos);
        return "loja";
    }

    @GetMapping("/admin")
    public String produtosTelaAdmin(Model model){
        List<Produto> produtos = this.produtoRepositorio.findAll();
        model.addAttribute("admin", produtos);
        return "admin";
    }

    @ResponseBody
    @PostMapping("/cadastrar-produtos")
    public ResponseEntity<Produto> save(@RequestBody ProdutoRequestDTO dto){
        if(dto.nome().isEmpty()){
            return ResponseEntity.status(400).build();
        }
        Produto produto = new Produto();
        produto.setProduto_id(dto.produto_id());
        produto.setCategoria_id(dto.categoria_id());
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setEstoque(dto.estoque());
        produto.setImagem(dto.imagem());

        this.produtoRepositorio.save(produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/deletar-produto/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id){
        Produto produto = this.produtoRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não escontrado"));
        this.produtoRepositorio.delete(produto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar-produto/{id}")
    public ResponseEntity<Produto> atualizarProduto (@PathVariable Integer id, @RequestBody Produto produtoAtualizado){
        Produto produtoExistente = this.produtoRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        produtoExistente.setCategoria_id(produtoAtualizado.getCategoria_id());
        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setDescricao(produtoAtualizado.getDescricao());
        produtoExistente.setPreco(produtoAtualizado.getPreco());
        produtoExistente.setEstoque(produtoAtualizado.getEstoque());
        produtoExistente.setImagem(produtoAtualizado.getImagem());

        Produto produtoSalvo = this.produtoRepositorio.save(produtoExistente);
        return ResponseEntity.ok(produtoSalvo);
    }
}
