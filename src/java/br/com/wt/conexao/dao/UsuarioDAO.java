package br.com.wt.conexao.dao;

import br.com.wt.entities.Tempo;
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
        
        Usuario usuario = (Usuario) dao.buscaPorNamedQuery("Usuario.findByChave", parametros);
        
        if(usuario == null){
            return null;
        }
        return usuario;
    }
    
    public Usuario buscaPorId(Integer id){
        Usuario usuario = dao.buscaPorId(Usuario.class, id);
        
        if(usuario == null){
            return null;
        }
        return usuario;
    }
    
    public Boolean atualiza(Usuario t){
        if(dao.persiste(t, "atualizar") != null){
            return true;
        }
        return false;
    }
}
