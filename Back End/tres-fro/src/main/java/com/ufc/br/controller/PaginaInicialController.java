package com.ufc.br.controller;

import com.ufc.br.model.Produto;
import com.ufc.br.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PaginaInicialController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping("/home")
    public ModelAndView paginaInicial(){
        List<Produto> listProduto = produtoService.promocao(true);
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("destaques", listProduto);
        return mv;
//        return "home";
    }
    @RequestMapping("")
    public ModelAndView inicioPadrao(){
        ModelAndView mv = new ModelAndView("home");
        return mv;
//        return "home";
    }
}
