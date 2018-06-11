package com.ufc.br.service;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;
import com.ufc.br.util.AulaFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaReposotory;

    public void salvar(Pessoa pessoa, MultipartFile imagem){
        pessoa.setSenha(new BCryptPasswordEncoder().encode(pessoa.getSenha()));

        String caminho = "images/" + pessoa.getNome() + ".png";
        AulaFileUtil.salvarImagem(caminho,imagem);
        pessoaReposotory.save(pessoa);
    }

    public List retornarLista(){
        return pessoaReposotory.findAll();
    }

    public void excluirPessoa(Long id){
        pessoaReposotory.deleteById(id);
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaReposotory.getOne(id);
    }
}
