package br.com.wt.conexao.dao;

import br.com.wt.entities.Atividade;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class AtividadeDAO {
    private final DAO<Atividade, Integer> dao;

    public AtividadeDAO() {
        dao = new DAO<Atividade, Integer>(Atividade.class);
    }
    
    public Boolean adiciona(Atividade atividade){
        if(dao.save(atividade) != null){
            return true;
        }
        return false;
    }
    
    public Boolean atualiza(Atividade atividade){
        if(dao.update(atividade) != null){
            return true;
        }
        return false;
    }
    
    public Boolean apaga(Atividade atividade){
        return dao.delete(atividade);
    }
    
    public List<Atividade> lista(){
        return dao.listByNamedQuery("Atividade.findAll");
    }
    
    public Atividade buscaPorId(Integer id){
        Atividade atividade = dao.findById(id);
        
        if(atividade == null){
            return null;
        }
        return atividade;
    }
}
