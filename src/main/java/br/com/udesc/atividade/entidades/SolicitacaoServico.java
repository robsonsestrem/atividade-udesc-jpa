package br.com.udesc.atividade.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author robson
 */
@NamedQueries(
        @NamedQuery(name = "SolicitacaoServico.Situacao", query = "select r from SolicitacaoServico r where r.Situacao = :solicitacaoservico"))

@Entity
public class SolicitacaoServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double orcamento;
    private String Situacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    //vários atendimentos de um profissional
    @ManyToOne
    private DBA dbaId;

    //uma atividade pode ter várias solicitações em tempos diferentes
    @ManyToOne
    private Atividades atividadeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public DBA getDbaId() {
        return dbaId;
    }

    public void setDbaId(DBA dbaId) {
        this.dbaId = dbaId;
    }

    public Atividades getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Atividades atividadeId) {
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
        if (!(object instanceof SolicitacaoServico)) {
            return false;
        }
        SolicitacaoServico other = (SolicitacaoServico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Id: " + getId()
                + "\nOrçamento: " + getOrcamento()
                + "\nSituação: " + getSituacao();
    }

}
