package br.com.wt.conexao.dao;

import br.com.wt.entities.Seguimento;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class SeguimentoDAO {
    private final DAO<Seguimento, Integer> dao;

    public SeguimentoDAO() {
        dao = new DAO<Seguimento, Integer>(Seguimento.class);
    }
    
    public Boolean adiciona(Seguimento seguimento){
        if(dao.save(seguimento) != null){
            return true;
        }
        return false;
    }
    
    public Boolean atualiza(Seguimento seguimento){
        if(dao.update(seguimento) != null){
            return true;
        }
        return false;
    }
    
    public Boolean apaga(Seguimento seguimento){
        return dao.delete(seguimento);
    }
    
    public List<Seguimento> lista(){
        return dao.listByNamedQuery("Seguimento.findAll");
    }
}
