package dao;

import entidade.EixoProfissional;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EixoProfissionalDAO implements Serializable {
	
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication4PU");
    private EntityManager entityManager;
            
    public EixoProfissionalDAO(){
        this.entityManager = emf.createEntityManager();
    }
    
    public void cadastrar(EixoProfissional eixoProfissional){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(eixoProfissional);
        this.entityManager.getTransaction().commit();
    }
    
    public void excluir(EixoProfissional eixoProfissional){
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(eixoProfissional);
        this.entityManager.getTransaction().commit();
    }
    
    public void alterar(EixoProfissional eixoProfissional){
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(eixoProfissional);
        this.entityManager.getTransaction().commit();
    }
    
    public List<EixoProfissional> retornaTodos(){
        return this.entityManager.createQuery("from EixoProfissional").getResultList();
    }
    
    public EixoProfissional retornarPorId(Long id){
        String sql = "FROM "+EixoProfissional.class.getName()+" WHERE id = :id";
        Query query = this.entityManager.createQuery(sql);
        query.setParameter("id", id);
        
        return (EixoProfissional) query.getSingleResult();
    }
}
