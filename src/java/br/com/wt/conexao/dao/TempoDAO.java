package br.com.wt.conexao.dao;

import br.com.wt.entities.Tempo;

/**
 *
 * @author Danilo
 */
public class TempoDAO {
    private final DAO<Tempo, Integer> dao;

    public TempoDAO() {
        dao = new DAO<Tempo, Integer>(Tempo.class);
    }
    
    public Boolean adiciona(Tempo t){
        if(dao.save(t) != null){
            return true;
        }
        return false;
    }
    
    public Tempo buscaPorId(Integer id){
        Tempo atividade = dao.findById(id);
        
        if(atividade == null){
            return null;
        }
        return atividade;
    }
}
