package com.mestredagrelha.loja.controller;

import com.mestredagrelha.loja.dto.ProdutoRequestDTO;
import com.mestredagrelha.loja.model.Produto;
import com.mestredagrelha.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class ProdutoController {

    @Autowired //ligar a classe repositório
    private ProdutoRepository produtoRepositorio;

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
        return "home";
    }
    @GetMapping("/sal")
    public String listarProdutosCategoriaSal(Model model) {
        List<Produto> produtos = this.produtoRepositorio.findAll();
        model.addAttribute("produtos", produtos);
        return "sal";
    }
    @GetMapping("/farofa")
    public String listarProdutosCategoriaFarofa(Model model) {
        List<Produto> produtos = this.produtoRepositorio.findAll();
        model.addAttribute("produtos", produtos);
        return "farofa";
    }
    @GetMapping("/molhos")
    public String listarProdutosCategoriaMolhos(Model model){
        List<Produto> produtos = this.produtoRepositorio.findAll();
        model.addAttribute("produtos", produtos);
        return "molhos";
    }
    @GetMapping("/temperos-especiarias")
    public String listarProdutosCategoriaTemperosEspeciarias(Model model){
        List<Produto> produtos = this.produtoRepositorio.findAll();
        model.addAttribute("produtos", produtos);
        return "temperos-especiarias";
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
}
