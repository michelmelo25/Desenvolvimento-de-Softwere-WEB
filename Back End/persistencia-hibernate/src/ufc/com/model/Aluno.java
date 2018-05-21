package ufc.com.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "aluno")
public class Aluno {

    private  String nome;
    private  Date dataNascimento;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long matricula;
    private  String endereco;
    private  String email;

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

    public Long getMatricula() {
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
