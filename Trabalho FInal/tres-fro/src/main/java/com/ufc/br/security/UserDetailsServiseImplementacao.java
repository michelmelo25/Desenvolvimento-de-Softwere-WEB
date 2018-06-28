package com.ufc.br.security;

import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDetailsServiseImplementacao implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario nao encontrado");
        }
//        System.out.println(pessoa.getNome() + " " + pessoa.getAuthorities());
        System.out.println(usuario.getId() + " " + usuario.getNome() + " " + usuario.getUsername() + " " + usuario.getRoles().toString());
        return new User(usuario.getUsername(), usuario.getPassword(),true,true,true,true, usuario.getAuthorities());
    }
}
