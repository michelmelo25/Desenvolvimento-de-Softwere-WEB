import java.util.ArrayList;

public class PessoaDAO {
	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public void cadastrarPessoas() {
		pessoas.add(new Pessoa("Michel","12345"));
	}
	
	public Pessoa buscarPessoa(String login, String senha) {
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
				return pessoa;
			}
		}
		
		
		return null;
	}

}
