package com.ufc.br.service;

import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void salvar(Usuario usuario){
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
    }

    public void atualizar(Usuario usuario){
        usuarioRepository.save(usuario);
    }


    public Usuario buscarProLogin(String login){
        return  usuarioRepository.findByLogin(login);
    }
}
