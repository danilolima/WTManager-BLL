package br.com.wt.conexao.dao;

import br.com.wt.entities.Seguimento;

/**
 *
 * @author Danilo
 */
public class SeguimentoDAO {
    private final DAO<Seguimento, Integer> dao;

    public SeguimentoDAO() {
        dao = new DAO<Seguimento, Integer>(Seguimento.class);
    }
}
