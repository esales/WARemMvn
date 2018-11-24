package dao;

import entidade.Professor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProfessorDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication4PU"); 
    private EntityManager entityManager;
            
    public ProfessorDAO(){
        this.entityManager = emf.createEntityManager();
    }
    
    public void cadastrar(Professor professor){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(professor);
        this.entityManager.getTransaction().commit();
    }
    
    public void excluir(Professor professor){
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(professor);
        this.entityManager.getTransaction().commit();
    }
    
    public void alterar(Professor professor){
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(professor);
        this.entityManager.getTransaction().commit();
    }
    
    public List<Professor> retornaTodos(){
        return this.entityManager.createQuery("from Professor").getResultList();
    }
}
