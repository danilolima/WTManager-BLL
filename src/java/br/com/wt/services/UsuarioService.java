package br.com.wt.services;

import br.com.wt.conexao.dao.UsuarioDAO;
import br.com.wt.entities.Usuario;

/**
 *
 * @author Danilo
 */
public class UsuarioService {

    private static Usuario usuario;
    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario getUsuario(String chave) {
        usuario = this.usuarioDAO.buscaPorChave(chave);
        return usuario;
    }
}
