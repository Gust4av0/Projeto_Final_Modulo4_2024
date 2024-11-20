package com.mestredagrelha.loja.dto;

public record ItensPedidoRequestDTO(Integer item_pedido, Integer pedido_id, Integer produto_id, Integer categoria_id,
                                    Integer quantidade, Integer preco_unitario, Integer total) {
}
