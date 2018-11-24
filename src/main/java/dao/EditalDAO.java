package dao;

import entidade.Edital;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EditalDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication4PU"); 
    private EntityManager entityManager;
            
    public EditalDAO(){
        this.entityManager = emf.createEntityManager();
    }
    
    public void cadastrar(Edital edital){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(edital);
        this.entityManager.getTransaction().commit();
    }
    
    public void excluir(Edital edital){
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(edital);
        this.entityManager.getTransaction().commit();
    }
    
    public void alterar(Edital edital){
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(edital);
        this.entityManager.getTransaction().commit();
    }
    
    public List<Edital> retornaTodos(){
        return this.entityManager.createQuery("from Edital").getResultList();
    }
}