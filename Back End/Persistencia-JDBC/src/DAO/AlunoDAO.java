package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import POJO.Aluno;
import com.company.ConnectionFactory;

public class AlunoDAO {
    private Connection connection;

    public AlunoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void addAluno(Aluno aluno){
        String sql = "insert into alunos (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getEndereco());
            stmt.setDate(4, aluno.getDataNascimento());
            stmt.execute();
            System.out.println("Aluno " + aluno.getNome() + "inserido com sucesso!");
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Aluno> showAluno(){
        String sql = "Select * from alunos";
        List<Aluno> alunos = new ArrayList<>();
        try{

            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getLong("ID"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setDataNascimento(rs.getDate("dataNascimento"));
                alunos.add(aluno);
            }
            rs.close();
            stmt.close();
            return alunos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delAluno(Aluno aluno){
        String sql = "DELETE from alunos where ID = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, aluno.getMatricula());
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void setAluno(Aluno aluno){
        String sql = "update alunos set nome = ?, endereco = ?, dataNascimento = ?, email = ? where id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEndereco());
            stmt.setDate(3, aluno.getDataNascimento());
            stmt.setString(4, aluno.getEmail());
            stmt.setLong(5, aluno.getMatricula());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}