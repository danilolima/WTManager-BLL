package br.com.wt.conexao.dao;

import br.com.wt.entities.Cliente;

/**
 *
 * @author Danilo
 */
public class ClienteDAO {
    private final DAO<Cliente, Integer> dao;

    public ClienteDAO() {
        dao = new DAO<Cliente, Integer>(Cliente.class);
    }
}
