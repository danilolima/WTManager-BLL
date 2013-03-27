package br.com.wt.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Danilo
 */
@Entity
@Table(name = "Seguimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimento.findAll", query = "SELECT s FROM Seguimento s"),
    @NamedQuery(name = "Seguimento.findById", query = "SELECT s FROM Seguimento s WHERE s.id = :id"),
    @NamedQuery(name = "Seguimento.findByNome", query = "SELECT s FROM Seguimento s WHERE s.nome = :nome"),
    @NamedQuery(name = "Seguimento.findByDescricao", query = "SELECT s FROM Seguimento s WHERE s.descricao = :descricao")})
public class Seguimento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente clienteId;

    public Seguimento() {
    }

    public Seguimento(Integer id) {
        this.id = id;
    }

    public Seguimento(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimento)) {
            return false;
        }
        Seguimento other = (Seguimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.wt.entities.Seguimento[ id=" + id + " ]";
    }

}
