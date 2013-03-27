package br.com.wt.services;

import br.com.wt.conexao.dao.AtividadeDAO;
import br.com.wt.conexao.dao.ClienteDAO;
import br.com.wt.conexao.dao.SeguimentoDAO;
import br.com.wt.conexao.dao.UsuarioDAO;
import br.com.wt.entities.Atividade;
import br.com.wt.entities.Cliente;
import br.com.wt.entities.Seguimento;
import br.com.wt.entities.Usuario;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class AdministradorService {
    private UsuarioDAO usuarioDAO;
    private ClienteDAO clienteDAO;
    private SeguimentoDAO seguimentoDAO;
    private AtividadeDAO atividadeDAO;
    
    public AdministradorService(){
        usuarioDAO = new UsuarioDAO();
        clienteDAO = new ClienteDAO();
        seguimentoDAO = new SeguimentoDAO();
        atividadeDAO = new AtividadeDAO();
    }
    
    /*
     * Métodos referentes a usuário
     */
    public void adicionaUsuario(Usuario usuario){
        if(usuario != null){
            usuario.setId(null);
            usuarioDAO.adiciona(usuario);
        }
    }
    
    public void atualizaUsuario(Usuario usuario){
        if(usuario != null){
            usuarioDAO.atualiza(usuario);
        }
    }
    
    public void apagaUsuario(Usuario usuario){
        if(usuario != null){
            usuarioDAO.apaga(usuario);
        }
    }
    
    public List<Usuario> listaUsuarios(){
        return usuarioDAO.lista();
    }
    
    
    /*
     * Métodos referentes a cliente
     */
    public void adicionaCliente(Cliente cliente){
        if(cliente != null){
            cliente.setId(null);
            clienteDAO.adiciona(cliente);
        }
    }
    
    public void atualizaCliente(Cliente cliente){
        if(cliente != null){
            clienteDAO.atualiza(cliente);
        }
    }
    
    public void apagaCliente(Cliente cliente){
        if(cliente != null){
            clienteDAO.apaga(cliente);
        }
    }
    
    public List<Cliente> listaClientes(){
        return clienteDAO.lista();
    }
    
    
    /*
     * Métodos referentes a seguimento
     */
    public void adicionaSeguimento(Seguimento seguimento){
        if(seguimento != null){
            seguimento.setId(null);
            seguimentoDAO.adiciona(seguimento);
        }
    }
    
    public void atualizaSeguimento(Seguimento seguimento){
        if(seguimento != null){
            seguimentoDAO.atualiza(seguimento);
        }
    }
    
    public void apagaSeguimento(Seguimento seguimento){
        if(seguimento != null){
            seguimentoDAO.apaga(seguimento);
        }
    }
    
    public List<Seguimento> listaSeguimentos(){
        return seguimentoDAO.lista();
    }
    
    
    /*
     * Métodos referentes a atividade
     */
    public void adicionaAtividade(Atividade atividade){
        if(atividade != null){
            atividade.setId(null);
            atividadeDAO.adiciona(atividade);
        }
    }
    
    public void atualizaAtividade(Atividade atividade){
        if(atividade != null){
            atividadeDAO.atualiza(atividade);
        }
    }
    
    public void apagaAtividade(Atividade atividade){
        if(atividade != null){
            atividadeDAO.apaga(atividade);
        }
    }
    
    public List<Atividade> listaAtividades(){
        return atividadeDAO.lista();
    }
}
