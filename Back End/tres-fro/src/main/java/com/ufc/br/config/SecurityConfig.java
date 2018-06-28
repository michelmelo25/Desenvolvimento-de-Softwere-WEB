package com.ufc.br.config;

import com.ufc.br.security.UserDetailsServiseImplementacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsServiseImplementacao userDetailsServiseImple;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/sobre").permitAll()
                .antMatchers("/home/add").hasRole("ADMIN")
                .antMatchers("/home/produtos").permitAll()
                .antMatchers("/search").permitAll()
                .antMatchers("/cadastro").permitAll()
                .antMatchers("/produto/pedido/{id}").hasAnyRole("USER","ADMIN")
                .antMatchers("/efetuar_compra/{id}").hasAnyRole("USER","ADMIN")
                .antMatchers("/usuario/perfil/{user}").hasAnyRole("USER","ADMIN")
                .antMatchers("/usuario/cadastro").permitAll()
                .antMatchers("/produtos/vodka").permitAll()
                .antMatchers("/produtos/whisky").permitAll()


                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/usuario/login")
                .permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("michel").password("123").roles("ADMIN");
        auth.userDetailsService(userDetailsServiseImple).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**", "/js/**");
        web.ignoring().antMatchers("/imagens/**");
    }
}
