package ufc.com.dao;

import ufc.com.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class VeiculoDAO {

    public void addVeiculo(Veiculo veiculo){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(veiculo);
        manager.getTransaction().commit();

        fabrica.close();
        manager.close();
    }

    public void alterarVeiculo(Veiculo veiculo){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        manager.getTransaction().begin();
        manager.merge(veiculo);
        manager.getTransaction().commit();

        fabrica.close();
        manager.close();
    }

    public void excluirVeiculo(Long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        manager.getTransaction().begin();
        Veiculo veiculo = manager.find(Veiculo.class, id);
        manager.remove(veiculo);
        manager.getTransaction().commit();

        fabrica.close();
        manager.close();
    }

    public List<Veiculo> veiculoList(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
        EntityManager manager = fabrica.createEntityManager();

        List<Veiculo> veiculos = manager.createQuery("select v from veiculo as v", Veiculo.class).getResultList();

        return  veiculos;
    }

}
