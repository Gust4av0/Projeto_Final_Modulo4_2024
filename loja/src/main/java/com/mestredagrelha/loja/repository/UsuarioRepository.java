package com.mestredagrelha.loja.repository;

import com.mestredagrelha.loja.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
