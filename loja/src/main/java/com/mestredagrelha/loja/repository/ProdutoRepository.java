package com.mestredagrelha.loja.repository;

import com.mestredagrelha.loja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
