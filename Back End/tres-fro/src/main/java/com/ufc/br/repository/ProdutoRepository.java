package com.ufc.br.repository;

import com.ufc.br.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List findByPromocao(boolean promocao);
}
