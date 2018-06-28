package com.ufc.br.service;

import com.ufc.br.model.Produto;
import com.ufc.br.repository.ProdutoRepository;
import com.ufc.br.util.AulaFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void salvar(Produto produto, MultipartFile imagem){
        String caminho = "imagens/" + produto.getNome() + ".jpg";
        AulaFileUtil.salvarImagem(caminho,imagem);
        produto.setCaminhoImagem(caminho);
        produtoRepository.save(produto);
    }

    public void atualizar(Produto produto){
        produtoRepository.save(produto);
    }

    public List promocao(boolean promocao){
        return produtoRepository.findByPromocaoAndQtdIsGreaterThan(promocao, new Long(0));
    }

    public void excluirProduto(Long id){
        produtoRepository.deleteById(id);
    }

//    funcao retorna um lista com os produtos relacionados a busta
    public List buscarProduto(String nome){
        return  produtoRepository.findByNomeContainsAndQtdIsGreaterThan(nome,new Long(0));
    }

    public Produto buscarProdutoPorID(Long id){
        return produtoRepository.getOne(id);
    }

    public List listarProdutos(){return produtoRepository.findAll();}

    public List tipo(String tipo){ return produtoRepository.findByTipoAndQtdIsGreaterThan(tipo,new Long(0));}
}
