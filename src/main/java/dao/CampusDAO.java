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
        this.entityManager = emf.createEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(campus);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
    
    public void excluir(Campus campus){
        this.entityManager = emf.createEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(this.entityManager.getReference(Campus.class, campus.getId()));
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
    
    public void alterar(Campus campus){
        this.entityManager = emf.createEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(campus);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
    
    public List<Campus> retornaTodos(){
        this.entityManager = emf.createEntityManager();
        List<Campus> listaRetorno = this.entityManager.createQuery("from Campus").getResultList();
        this.entityManager.close();
        return listaRetorno;
    }
    
    public Campus retornarPorId(Long id){
        this.entityManager = emf.createEntityManager();
        String sql = "FROM "+Campus.class.getName()+" WHERE id = :id";
        Query query = this.entityManager.createQuery(sql);
        query.setParameter("id", id);
        
        return (Campus) query.getSingleResult();
    }
}