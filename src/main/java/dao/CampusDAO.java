package dao;

import entidade.Campus;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CampusDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication4PU"); 
    private EntityManager entityManager;
            
    public CampusDAO(){
        this.entityManager = emf.createEntityManager();
    }
    
    public void cadastrar(Campus campus){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(campus);
        this.entityManager.getTransaction().commit();
    }
    
    public void excluir(Campus campus){
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(campus);
        this.entityManager.getTransaction().commit();
    }
    
    public void alterar(Campus campus){
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(campus);
        this.entityManager.getTransaction().commit();
    }
    
    public List<Campus> retornaTodos(){
        return this.entityManager.createQuery("from Campus").getResultList();
    }
    
    public Campus retornarPorId(Long id){
        String sql = "FROM "+Campus.class.getName()+" WHERE id = :id";
        Query query = this.entityManager.createQuery(sql);
        query.setParameter("id", id);
        
        return (Campus) query.getSingleResult();
    }
}