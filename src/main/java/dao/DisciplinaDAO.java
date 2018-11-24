package dao;

import entidade.Disciplina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DisciplinaDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication4PU");
    private EntityManager entityManager;
            
    public DisciplinaDAO(){
        this.entityManager = emf.createEntityManager();
    }
    
    public void cadastrar(Disciplina disciplina){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(disciplina);
        this.entityManager.getTransaction().commit();
    }
    
    public void excluir(Disciplina disciplina){
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(disciplina);
        this.entityManager.getTransaction().commit();
    }
    
    public void alterar(Disciplina disciplina){
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(disciplina);
        this.entityManager.getTransaction().commit();
    }
    
    public List<Disciplina> retornaTodos(){
        return this.entityManager.createQuery("from Disciplina").getResultList();
    }
        
    public Disciplina retornarPorId(Long id){
        String sql = "FROM "+Disciplina.class.getName()+" WHERE id = :id";
        Query query = this.entityManager.createQuery(sql);
        query.setParameter("id", id);
        
        return (Disciplina) query.getSingleResult();
    }
}