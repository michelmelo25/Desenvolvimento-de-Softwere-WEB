package com.ufc.br.security;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;
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
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Pessoa pessoa = pessoaRepository.findByLogin(login);
        if(pessoa == null){
            throw new UsernameNotFoundException("Usuario nao encontrado");
        }
//        System.out.println(pessoa.getNome() + " " + pessoa.getAuthorities());
        System.out.println(pessoa.getId() + " " + pessoa.getNome() + " " + pessoa.getUsername() + " " + pessoa.getRoles());
        return new User(pessoa.getUsername(), pessoa.getPassword(),true,true,true,true, pessoa.getAuthorities());
    }
}
