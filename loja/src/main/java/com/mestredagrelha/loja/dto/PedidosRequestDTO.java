package com.mestredagrelha.loja.dto;

import com.mestredagrelha.loja.model.ItensPedido;

import java.time.LocalDateTime;
import java.util.List;

public record PedidosRequestDTO(
        Integer pedido_id, Integer usuario_id, LocalDateTime data_pedido, Integer valor_total, List<PedidosRequestDTO> itensPedidos, List<Integer> itemIds
) {
}
