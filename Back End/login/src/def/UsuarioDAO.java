package def;

import java.util.ArrayList;

public class UsuarioDAO {
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public void cadastrarPessoa(String login, String senha){
            usuarios.add(new Usuario(login,senha));
    }

    public Usuario buscarPessoa(String login, String senha){
        for (Usuario user: usuarios) {
            if(user.getLogin().equals(login) && user.getSenha().equals(senha)){
                return user;
            }
        }
        return null;
    }
}
