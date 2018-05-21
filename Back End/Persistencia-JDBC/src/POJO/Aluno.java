package POJO;

import java.sql.Date;

public class Aluno {
    private  String nome;
    private  Date dataNascimento;
    private  Long matricula;
    private  String endereco;
    private  String email;

    public Aluno(String nome, Date dataNascimento, Long matricula, String endereco, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
        this.endereco = endereco;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
