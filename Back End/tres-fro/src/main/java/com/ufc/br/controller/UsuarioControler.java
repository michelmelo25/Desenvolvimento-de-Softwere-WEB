package com.ufc.br.controller;

import com.ufc.br.model.Usuario;
import com.ufc.br.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioControler {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/usuario/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }

    @RequestMapping("/usuario/cadastro")
    public ModelAndView cadastrar(Usuario usuario){
//        usuario so sera cadastrado se ele ja nao estiver
//        se o usuario foi cadastrado enviar um alerta de sucesso
//        caso contrario enviar alerta de erro

        System.out.println(usuario.getNome());
        usuarioService.salvar(usuario);
        ModelAndView mv = new ModelAndView("redirect:/home");
        return mv;
    }

}
