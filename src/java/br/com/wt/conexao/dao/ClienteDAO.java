package br.com.wt.conexao.dao;

import br.com.wt.entities.Cliente;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class ClienteDAO {
    private final DAO<Cliente, Integer> dao;

    public ClienteDAO() {
        dao = new DAO<Cliente, Integer>(Cliente.class);
    }
    
    public Boolean adiciona(Cliente t){
        if(dao.save(t) != null){
            return true;
        }
        return false;
    }
    
    public Boolean atualiza(Cliente t){
        if(dao.update(t) != null){
            return true;
        }
        return false;
    }
    
    public Boolean apaga(Cliente cliente){
        return dao.delete(cliente);
    }
    
    public List<Cliente> lista(){
        return dao.listByNamedQuery("Cliente.findAll");
    }
}
