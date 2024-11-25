package com.mestredagrelha.loja.controller;


import com.mestredagrelha.loja.dto.ItensPedidoRequestDTO;
import com.mestredagrelha.loja.model.ItensPedido;
import com.mestredagrelha.loja.model.Pedidos;
import com.mestredagrelha.loja.repository.ItensPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("home")
public class ItensPedidoController {

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;


    @ResponseBody
    @GetMapping("/buscar-itens-pedidos")
    public ResponseEntity<List<ItensPedido>> pedidos() {
        List<ItensPedido> itensPedidos = this.itensPedidoRepository.findAll();
        return ResponseEntity.ok(itensPedidos);
    }

    @PostMapping("/criar-itens-pedidos")
    public ResponseEntity<ItensPedido> itensPedidos(@RequestBody ItensPedidoRequestDTO itensDTO){
        ItensPedido itensPedido = new ItensPedido();
        itensPedido.setItem_pedido(itensDTO.item_pedido());
        itensPedido.setPedido_id(itensDTO.pedido_id());
        itensPedido.setProduto_id(itensDTO.produto_id());
        itensPedido.setCategoria_id(itensDTO.categoria_id());
        itensPedido.setQuantidade(itensDTO.quantidade());
        itensPedido.setPreco_unitario(itensDTO.preco_unitario());
        int total = itensDTO.quantidade() * itensDTO.preco_unitario();

        itensPedido.setTotal(total);

        ItensPedido itemSalvo = this.itensPedidoRepository.save(itensPedido);
        return ResponseEntity.ok(itemSalvo);
    }
}
