package br.com.wt.conexao.dao;

import br.com.wt.conexao.Conexao;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Danilo
 */
public class DAO<T, ID extends Serializable> {

    private final Class<T> classe;
    private Conexao conexao = new Conexao();

    public DAO(Class<T> classe) {
        this.classe = classe;
    }

    public T save(T t){
        EntityManager entityManager = conexao.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            entityManager.close();
        }
        return t;
    }
    
    public T update(T t){
        EntityManager entityManager = conexao.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            entityManager.close();
        }
        return t;
    }
    
    public Boolean delete(T t){
        EntityManager entityManager = conexao.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }
    
     public List<T> listByNamedQuery(String namedQuery){
        EntityManager entityManager = conexao.getEntityManager();
        Query query = entityManager.createNamedQuery(namedQuery, classe);
        return (List<T>) query.getResultList();
    }
    
    public T findById(ID id){
        EntityManager entityManager = conexao.getEntityManager();
        return entityManager.find(classe, id);
    }
    
    public T findByNamedQuery(String namedQuery, Map<String, Object> params){
        EntityManager entityManager = conexao.getEntityManager();
        T resultado = null;
        
        try{
            Query query = entityManager.createNamedQuery(namedQuery, classe);
            
            if (params != null && !params.isEmpty()) {
                populateQueryParameters(query, params);
            }
            
            resultado = (T) query.getResultList().get(0);
            
        } catch (NoResultException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return resultado;
    }
    
    
    /**
     * http://uaihebert.com/?p=1414&page=3
     */
    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }

    
}