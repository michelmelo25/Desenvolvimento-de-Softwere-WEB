package ufc.com.dao;

import  ufc.com.modelo.Contato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ContatoDAO {

    public  void adicionar(Contato contato){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(contato);
        manager.getTransaction().commit();

        fabrica.close();
        manager.clear();
    }

    public  void altera(Contato contato){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        manager.getTransaction().begin();
        manager.merge(contato);
        manager.getTransaction().commit();

        fabrica.close();
        manager.clear();
    }

    public void remove(Long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        Contato contato = manager.find(Contato.class, id);

        manager.getTransaction().begin();
        manager.remove(id);
        manager.getTransaction().commit();

        fabrica.close();
        manager.close();
    }

    public Contato buscarPorID(Long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        Contato contato = manager.find(Contato.class, id);

        fabrica.close();
        manager.close();

        return  contato;
    }

    public List<Contato> listar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        List<Contato> contatos = manager.createQuery("select c from c", Contato.class).getResultList();

        fabrica.close();
        manager.close();

        return  contatos;
    }
}
