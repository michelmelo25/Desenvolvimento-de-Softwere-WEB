package com.ufc.br.model;

import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Double presco;
    private String caminhoImagem;
    private Boolean promocao;
    private String tipo;
    private Long qtd;

    @Override
    public String toString() {
        return nome + " " + presco + "\n";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getQtd() {
        return qtd;
    }

    public void setQtd(Long qtd) {
        this.qtd = qtd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPresco() {
        return presco;
    }

    public void setPresco(Double presco) {
        this.presco = presco;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Boolean getPromocao() {
        return promocao;
    }

    public void setPromocao(Boolean promocao) {
        this.promocao = promocao;
    }
}
