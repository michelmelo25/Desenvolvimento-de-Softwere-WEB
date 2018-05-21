package ufc.com.teste;

import ufc.com.dao.AlunoDAO;
import ufc.com.model.Aluno;

public class TestePersistencia {
    public static void main(String[] args){
        AlunoDAO alunoDAO = new AlunoDAO();

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Michel");
        aluno1.setDataNascimento(java.sql.Date.valueOf("1997-04-25"));
        aluno1.setEmail("michel@mail.com");
        aluno1.setEndereco("Rua: marceneiros");

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Lucas");
        aluno2.setDataNascimento(java.sql.Date.valueOf("1997-02-08"));
        aluno2.setEmail("lucas@mail.com");
        aluno2.setEndereco("Rua: pipeiros");

        alunoDAO.addAluno(aluno1);
        alunoDAO.addAluno(aluno2);
    }
}
