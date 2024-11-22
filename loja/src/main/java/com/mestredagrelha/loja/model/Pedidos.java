package com.mestredagrelha.loja.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pedido_id;

    //Muitos pedidos para 1 usuário
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column
    private LocalDateTime data_pedido;
    private Integer valor_total;

    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    public LocalDateTime getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(LocalDateTime data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Integer getValor_total() {
        return valor_total;
    }

    public void setValor_total(Integer valor_total) {
        this.valor_total = valor_total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
