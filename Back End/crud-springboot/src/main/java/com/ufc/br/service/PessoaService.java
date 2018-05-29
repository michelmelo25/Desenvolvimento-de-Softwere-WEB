package com.ufc.br.service;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaReposotory;

    public void salvar(Pessoa pessoa){
        pessoaReposotory.save(pessoa);
    }

}