package ufc.com.dao;

import ufc.com.model.Proprietario;
import ufc.com.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProprietarioDAO {

    public void addProprietario(Proprietario proprietario){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(proprietario);
        manager.getTransaction().commit();

        fabrica.close();
        manager.close();
    }

    public void alterarProprietario(Proprietario proprietario){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        manager.getTransaction().begin();
        manager.merge(proprietario);
        manager.getTransaction().commit();

        fabrica.close();
        manager.close();
    }

    public void excluirProprietario(Long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        manager.getTransaction().begin();
        Proprietario proprietario = manager.find(Proprietario.class, id);
        manager.remove(proprietario);
        manager.getTransaction().commit();

        fabrica.close();
        manager.close();
    }

    public List<Proprietario> proprietarioList(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        List<Proprietario> proprietarios = manager.createQuery("select v from proprietario as v", Proprietario.class).getResultList();

        return  proprietarios;
    }
}
