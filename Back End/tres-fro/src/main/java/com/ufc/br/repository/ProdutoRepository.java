package com.ufc.br.repository;

import com.ufc.br.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

     List findByPromocaoAndQtdIsGreaterThan(boolean promocao, Long qtd);

     List findByNomeContainsAndQtdIsGreaterThan(String nome, Long qtd);

     List findByTipoAndQtdIsGreaterThan(String tipo, Long qtd);

}
