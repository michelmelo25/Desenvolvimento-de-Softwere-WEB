package com.ufc.br.controller;

import com.ufc.br.model.Produto;
import com.ufc.br.model.Usuario;
import com.ufc.br.service.ProdutoService;
import com.ufc.br.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @RequestMapping("/home/produtos")
    public ModelAndView listarHome(){
        List<Produto> listProduto = produtoService.listarProdutos();
//        System.out.println(listProduto.get(1).getPresco());
//        System.out.println(listProduto.get(1).getPresco().);
        ModelAndView mv = new ModelAndView("produtos");
        mv.addObject("todosOsProdutos", listProduto);
        return mv;
    }

    @RequestMapping("/search")
    public ModelAndView pesquisa(String nome){
        List<Produto> listProduto = produtoService.buscarProduto(nome);
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("ProdutosBusca", listProduto);
        return mv;
    }

    @RequestMapping("/home/add")
    public ModelAndView addProduto(Produto produto, @RequestParam(value= "imagem")MultipartFile imagem){
        produto.setPromocao(false);
        produtoService.salvar(produto,imagem);
        ModelAndView mv = new ModelAndView("home");
        System.out.println(produto.toString());
        mv.addObject("produto", produto);
        return mv;
    }

    @RequestMapping("/sobre")
    public ModelAndView sobre(){
        ModelAndView mv = new ModelAndView("sobre");
        return mv;
    }

    @RequestMapping("/cadastro")
    public ModelAndView cadastro(){
        ModelAndView mv = new ModelAndView("cadastro");
        return mv;
    }

    @RequestMapping("/produto/pedido")
    public ModelAndView comprar(Produto produto){
        System.out.println(produto.getNome());
        System.out.println(produto.getPresco());
        List<Produto> l = new ArrayList<>();
        l.add(produto);
        ModelAndView mv = new ModelAndView("compra");
        mv.addObject("destaques",l);
        return mv;
    }

    //filtro Vodka
    @RequestMapping("/produtos/vodka")
    public ModelAndView vodka(){
        List<Produto> listProd = produtoService.tipo("vodka");
        ModelAndView mv = new ModelAndView("tags");
        mv.addObject("vodkas",listProd);
        return mv;
    }


    //filtro whisky
    @RequestMapping("/produtos/whisky")
    public ModelAndView whisky(){
        List<Produto> listProd = produtoService.tipo("whisky");
        ModelAndView mv = new ModelAndView("tags");
        mv.addObject("whiskys",listProd);
        return mv;
    }
}
