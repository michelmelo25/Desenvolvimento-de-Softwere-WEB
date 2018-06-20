package com.ufc.br.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.ufc.br.model.Produto;
import com.ufc.br.model.Usuario;
import com.ufc.br.service.ProdutoService;
import com.ufc.br.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    private List<Produto> carrinho = new ArrayList<>();


    @RequestMapping("/produtos")
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

    @RequestMapping("/produto/add")
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

    @RequestMapping("/produto/pedido/{id}")
    public ModelAndView comprar(@PathVariable Long id){
        Produto produto = produtoService.buscarProdutoPorID(id);
//        System.out.println(produto.getNome());
//        System.out.println(produto.getPresco());
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

    //Add carrinho
    @RequestMapping("/produto/compra/addcarrinho/{id}") //{id}
    public  ModelAndView addCarrinho(@PathVariable Long id){
        Produto produto = produtoService.buscarProdutoPorID(id);
        carrinho.add(produto);
        ModelAndView mv = new ModelAndView("redirect:/produto/pedido/{id}");
        mv.addObject("carrinhoTemporario",carrinho);
        System.out.println(carrinho.toString());
        System.out.println("\n");
        return mv;
    }

    //Pagina Carrinho
    @RequestMapping("/carrinho")
    public  ModelAndView carrinho(){
        ModelAndView mv = new ModelAndView("carrinho");
        double valorT = 0;
        for(Produto p : carrinho){
            valorT += p.getPresco();
        }
        if(!carrinho.isEmpty()){
            mv.addObject("car", this.carrinho);
            mv.addObject("valcar",valorT);
        }else{
            mv = new ModelAndView("redirect:/home");
        }
        return mv;
    }

    @RequestMapping("/carrinho/excluir/{id}")
    public ModelAndView excluirCarrinho(@PathVariable Long id){
        for(Produto ele: carrinho){
            if(ele.getId().equals(id)){
                carrinho.remove(ele);
            }
        }
        System.out.println("-----------------------");
        System.out.println(carrinho.toString());
        System.out.println("\n");
        ModelAndView mv = new ModelAndView("redirect:/carrinho");
//        mv.addObject("carro",carrinho);
        return mv;
    }

    @RequestMapping("/deslogar")
    public ModelAndView deslogar(){
        carrinho.clear();
        System.out.println("---------------------");
        System.out.println(carrinho.toString());
        ModelAndView mv = new ModelAndView("redirect:/logout");
        return mv;
    }

}
