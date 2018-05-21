package ufc.com.dao;

import ufc.com.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoDAO {

    public void addAluno(Aluno aluno){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("persistencehib");
        EntityManager manager = fabrica.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(aluno);
        manager.getTransaction().commit();

        fabrica.close();
        manager.close();
    }

    public void updateAluno(Aluno aluno){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("persistencehib");
        EntityManager manager = fabrica.createEntityManager();

        manager.getTransaction().begin();
        manager.merge(aluno);
        manager.getTransaction().commit();

        fabrica.close();
        manager.close();
    }

    public void removeAluno(Long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("persistencehib");
        EntityManager manager = fabrica.createEntityManager();

        manager.getTransaction().begin();
        Aluno aluno = manager.find(Aluno.class, id);
        manager.remove(aluno);
        manager.getTransaction().commit();

        fabrica.close();
        manager.close();
    }

    public List<Aluno> Alunolist(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("persistencehib");
        EntityManager manager = fabrica.createEntityManager();

        List<Aluno> alunos = manager.createQuery("select v from aluno as v", Aluno.class).getResultList();

        return alunos;
    }
}
