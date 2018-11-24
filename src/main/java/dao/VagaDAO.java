package dao;

import entidade.Vaga;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VagaDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication4PU"); 
    private EntityManager entityManager;
            
    public VagaDAO(){
        this.entityManager = emf.createEntityManager();
    }
    
    public void cadastrar(Vaga vaga){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(vaga);
        this.entityManager.getTransaction().commit();
    }
    
    public void excluir(Vaga vaga){
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(vaga);
        this.entityManager.getTransaction().commit();
    }
    
    public void alterar(Vaga vaga){
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(vaga);
        this.entityManager.getTransaction().commit();
    }
    
    public List<Vaga> retornaTodos(){
        return this.entityManager.createQuery("from Vaga").getResultList();
    }
}
