package br.com.wt.conexao.dao;

import br.com.wt.entities.Usuario;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Danilo
 */
public class UsuarioDAO {
    private final DAO<Usuario, Integer> dao;

    public UsuarioDAO() {
        dao = new DAO<Usuario, Integer>(Usuario.class);
    }
    
    public Boolean adiciona(Usuario usuario){
        if(dao.save(usuario) != null){
            return true;
        }
        return false;
    }
    
    public Boolean atualiza(Usuario usuario){
        if(dao.update(usuario) != null){
            return true;
        }
        return false;
    }
    
    public Boolean apaga(Usuario usuario){
        return dao.delete(usuario);
    }
    
    public Usuario buscaPorChave(String chave){
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("chave", chave);
        
        Usuario usuario = (Usuario) dao.findByNamedQuery("Usuario.findByChave", parametros);
        
        if(usuario == null){
            return null;
        }
        return usuario;
    }
    
    public Usuario buscaPorId(Integer id){
        Usuario usuario = dao.findById(id);
        
        if(usuario == null){
            return null;
        }
        return usuario;
    }
}
