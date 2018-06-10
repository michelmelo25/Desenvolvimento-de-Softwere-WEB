package com.ufc.br.controller;

import com.ufc.br.model.Produto;
import com.ufc.br.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping("/home/destaques")
    public ModelAndView listarHome(){
        List<Produto> listProduto = produtoService.listarProdutos();
//        System.out.println(listProduto.get(1).getPresco());
//        System.out.println(listProduto.get(1).getPresco().);
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("todosOsProdutos", listProduto);
        return mv;
    }

    @RequestMapping("/home/add")
    public ModelAndView addProduto(Produto produto, @RequestParam(value= "imagem")MultipartFile imagem){
        produto.setPromocao(false);
        produtoService.salvar(produto,imagem);
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("produto", produto);
        return mv;
    }

    @RequestMapping("/sobre")
    public ModelAndView sobre(){
        ModelAndView mv = new ModelAndView("sobre");
        return mv;
    }
}
