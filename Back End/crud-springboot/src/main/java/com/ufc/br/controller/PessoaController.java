package com.ufc.br.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;
import com.ufc.br.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping("/pessoa/formulario")
    public ModelAndView formularioPessoa(){
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("pessoa",new Pessoa());
        return mv;
    }

    @PostMapping("/pessoa/salvar")
    public ModelAndView salvar(Pessoa pessoa){
        //salvar no banco
        pessoaService.salvar(pessoa);
        ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
//        "formulario"
        return mv;
    }

    @RequestMapping("/pessoa/listar")
    public ModelAndView listagem(){
        List<Pessoa> pessoaList = pessoaService.retornarLista();
        ModelAndView mv = new ModelAndView("pagina-listagem");
        mv.addObject("todasAsPessoas", pessoaList);
        return mv;
    }

    @RequestMapping("/pessoa/excluir/{id}")
    public ModelAndView excluir(@PathVariable Long id){
        pessoaService.excluirPessoa(id);
        ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
        return mv;
    }

    @RequestMapping("/pessoa/atualizar/{id}")
    public ModelAndView atualizar(@PathVariable Long id){
        Pessoa pessoa = pessoaService.buscarPorId(id);
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("pessoa", pessoa);
        return mv;
    }
}
