package br.com.wt.conexao.dao;

import br.com.wt.conexao.Conexao;
import java.io.Serializable;
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

    public T persiste(T t, String tipo){
        EntityManager entityManager = conexao.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            if("salvar".equals(tipo)){
                entityManager.persist(t);
            }else if("atualizar".equals(tipo)){
                entityManager.merge(t);
            }
            entityManager.getTransaction().commit();
            return t;
        } catch (Exception e) {
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            entityManager.close();
        }
        return null;
    }
    
    public void apaga(T t){
        EntityManager entityManager = conexao.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            entityManager.close();
        }
    }
    
    public T buscaPorId(Class<T> classe, ID id){
        EntityManager entityManager = conexao.getEntityManager();
        return entityManager.find(classe, id);
    }
    
    public T buscaPorNamedQuery(String namedQuery, Map<String, Object> parametros){
        EntityManager entityManager = conexao.getEntityManager();
        T resultado = null;
        
        try{
            Query query = entityManager.createNamedQuery(namedQuery);
            
            if (parametros != null && !parametros.isEmpty()) {
                populateQueryParameters(query, parametros);
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