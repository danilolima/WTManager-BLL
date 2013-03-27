package br.com.wt.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Danilo
 */
@Entity
@Table(name = "Tempo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tempo.findAll", query = "SELECT t FROM Tempo t"),
    @NamedQuery(name = "Tempo.findById", query = "SELECT t FROM Tempo t WHERE t.id = :id"),
    @NamedQuery(name = "Tempo.findByInicio", query = "SELECT t FROM Tempo t WHERE t.inicio = :inicio"),
    @NamedQuery(name = "Tempo.findByFim", query = "SELECT t FROM Tempo t WHERE t.fim = :fim")})
public class Tempo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fim;
    
    @JoinColumn(name = "atividade_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Atividade atividadeId;

    public Tempo() {
    }

    public Tempo(Integer id) {
        this.id = id;
    }

    public Tempo(Integer id, Date inicio, Date fim) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Atividade getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Atividade atividadeId) {
        this.atividadeId = atividadeId;
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
        if (!(object instanceof Tempo)) {
            return false;
        }
        Tempo other = (Tempo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.wt.entities.Tempo[ id=" + id + " ]";
    }

}
