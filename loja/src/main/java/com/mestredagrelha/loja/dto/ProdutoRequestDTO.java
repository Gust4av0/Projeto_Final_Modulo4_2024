package com.mestredagrelha.loja.dto;

public record ProdutoRequestDTO(
        Integer produto_id, Integer categoria_id, String nome,
        String descricao, Integer preco, Integer estoque, String imagem
) {
}
