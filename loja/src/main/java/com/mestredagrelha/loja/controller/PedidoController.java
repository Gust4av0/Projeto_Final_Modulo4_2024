package com.mestredagrelha.loja.controller;

import com.mestredagrelha.loja.dto.ItensPedidoRequestDTO;
import com.mestredagrelha.loja.dto.PedidosRequestDTO;
import com.mestredagrelha.loja.dto.ProdutoRequestDTO;
import com.mestredagrelha.loja.model.*;
import com.mestredagrelha.loja.repository.ItensPedidoRepository;
import com.mestredagrelha.loja.repository.PedidosRepository;
import com.mestredagrelha.loja.repository.ProdutoRepository;
import com.mestredagrelha.loja.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Formattable;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("home")
public class PedidoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    @Autowired
    private PedidosRepository pedidosRepository;

    @ResponseBody
    @GetMapping("/buscar-pedidos")
    public ResponseEntity<List<Pedidos>> findAll(){
        List<Pedidos> pedidos = this.pedidosRepository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/criar-pedido")
    public ResponseEntity<Pedidos> save(@RequestBody PedidosRequestDTO pedidoDTO) {
        try {
            Usuario usuario = usuarioRepository.findById(pedidoDTO.usuario_id())
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não cadastrado"));

            // Cria o pedido
            Pedidos pedidos = new Pedidos();
            pedidos.setUsuario(usuario); // Relaciona o pedido ao usuário
            pedidos.setValor_total(pedidoDTO.valor_total()); // Define o valor total

            Pedidos pedidoSalvo = pedidosRepository.save(pedidos);

            //serve para associar os itens ao pedido
            for(Integer itemId : pedidoDTO.itemIds()){

                Produto produto = produtoRepository.findById(itemId)
                        .orElseThrow(() -> new IllegalArgumentException("Produto com ID" + itemId + "não encontrado"));

                ItensPedido itensPedido = new ItensPedido();
                itensPedido.setPedido_id(pedidoSalvo.getPedido_id());
                itensPedido.setProduto_id(produto.getProduto_id());
                itensPedido.setQuantidade(1);
                itensPedido.setPreco_unitario(produto.getPreco());
                itensPedido.setTotal(produto.getPreco());

                itensPedidoRepository.save(itensPedido);

            }

            return ResponseEntity.ok(pedidoSalvo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao criar pedido", e);
        }
    }

}
