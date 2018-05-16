package ufc.com.teste;

import java.util.List;

import ufc.com.dao.ContatoDAO;
import ufc.com.modelo.Contato;

public class TestarContato {

    public static void main(String[] args) {
        Contato contato = new Contato();
        //contato.setId(1L);
        contato.setNome("Jonas");
        //contato.setEmail("contato@gmail.com");
        contato.setTelefone("98888-8888");
        //contato.setEndereco("Rua caninde");
        //contato.setId(1L);


        ContatoDAO dao = new ContatoDAO();
        dao.adicionar(contato);
        //dao.remove(1L);




        //contato = dao.recuperar(1L);
        //System.out.println(contato.getNome());

    }

}