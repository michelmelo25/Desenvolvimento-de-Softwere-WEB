package com.ufc.br.controller;


import com.ufc.br.model.Pessoa;
import com.ufc.br.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


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
    public ModelAndView salvar(Pessoa pessoa, @RequestParam(value= "imagem")MultipartFile imagem){
        //salvar no banco
        pessoaService.salvar(pessoa, imagem);
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("mensagem", "Usuario Cadastrado com secesso");
//        ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
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

    @RequestMapping("/pessoa/logar")
    public String login(){
        return "login";
    }
}
