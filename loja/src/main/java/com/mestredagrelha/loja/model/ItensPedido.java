package com.mestredagrelha.loja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido {

    @Id
    private Integer item_pedido;

    @Column
    private Integer pedido_id;
    private Integer produto_id;
    private Integer categoria_id;
    private Integer quantidade;
    private Integer preco_unitario;
    private Integer total;

    public Integer getItem_pedido() {
        return item_pedido;
    }

    public void setItem_pedido(Integer item_pedido) {
        this.item_pedido = item_pedido;
    }

    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Integer getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }

    public Integer getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(Integer preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
