package com.mestredagrelha.loja.dto;

import java.time.LocalDateTime;

public record UsuarioRequestDTO(Integer usuario_id, String nome, String email, String senha, String endereco,
                                String telefone, LocalDateTime data_cricao) {
}
