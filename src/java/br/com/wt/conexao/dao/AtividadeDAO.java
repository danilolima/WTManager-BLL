package br.com.wt.conexao.dao;

import br.com.wt.entities.Atividade;

/**
 *
 * @author Danilo
 */
public class AtividadeDAO {
    private final DAO<Atividade, Integer> dao;

    public AtividadeDAO() {
        dao = new DAO<Atividade, Integer>(Atividade.class);
    }
    
    public Boolean atualiza(Atividade t){
        if(dao.update(t) != null){
            return true;
        }
        return false;
    }
    
    public Atividade buscaPorId(Integer id){
        Atividade atividade = dao.findById(id);
        
        if(atividade == null){
            return null;
        }
        return atividade;
    }
}
