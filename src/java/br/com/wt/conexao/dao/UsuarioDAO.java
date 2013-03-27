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
    
    public Boolean atualiza(Usuario t){
        if(dao.update(t) != null){
            return true;
        }
        return false;
    }
}
