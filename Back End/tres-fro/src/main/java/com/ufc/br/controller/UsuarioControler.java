package com.ufc.br.controller;

import com.ufc.br.service.UsuarioServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioControler {

    @Autowired
//    private UsuarioServise usuarioServise;

    @RequestMapping("/usuario/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }

    @RequestMapping("/usuario/cadastro")
    public ModelAndView cadastrar(){
//        usuario so sera cadastrado se ele ja nao estiver
//        se o usuario foi cadastrado enviar um alerta de sucesso
//        caso contrario enviar alerta de erro
        ModelAndView mv = new ModelAndView("cadastro");
        return mv;
    }

}
