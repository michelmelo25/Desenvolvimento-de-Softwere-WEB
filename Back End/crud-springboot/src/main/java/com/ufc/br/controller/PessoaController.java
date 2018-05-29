package com.ufc.br.controller;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;
import com.ufc.br.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping("/pessoa/formulario")
    public String formularioPessoa(){
        return "formulario";
    }

    @PostMapping("/pessoa/salvar")
    public String salvar(Pessoa pessoa){
        //salvar no banco
        pessoaService.salvar(pessoa);
        return "formulario";
    }

}
