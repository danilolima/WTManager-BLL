package br.com.wt.services;

import br.com.wt.conexao.dao.TempoDAO;
import br.com.wt.conexao.dao.UsuarioDAO;
import br.com.wt.entities.Tempo;
import br.com.wt.entities.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class UsuarioService {

    private UsuarioDAO usuarioDAO;
    private TempoDAO tempoDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
        this.tempoDAO = new TempoDAO();
    }

    public Usuario getUsuario(String chave) {
        Usuario usuario = null;
        usuario = this.usuarioDAO.buscaPorChave(chave);
        return usuario;
    }
    
    public Boolean adicionaTempo(Tempo tempo){
        if(tempo != null){
            tempo.setId(null);
            try{
                this.tempoDAO.atualiza(tempo);
                return true;
            }catch (Exception e){
                Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, e);
                return false;
            }
        }
        return false;
    }
}
