package br.com.udesc.atividade.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author robson
 */
@NamedQueries(
        @NamedQuery(name = "DBA.buscarPorNome", query = "select d from DBA d where d.nome = :nome"))
@Entity
public class DBA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;

    @ManyToMany
    @JoinTable(name = "ExecucaoDBAServer", joinColumns
            = {
                @JoinColumn(name = "dba_id")}, inverseJoinColumns
            = {
                @JoinColumn(name = "server_id")})
    private List<Server> servers;

    @OneToMany(mappedBy = "dbaId")
    private List<SolicitacaoServico> ListaSolicitacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SolicitacaoServico> getListaRequisicoes() {
        return ListaSolicitacoes;
    }

    public void setListaRequisicoes(List<SolicitacaoServico> ListaSolicitacoes) {
        this.ListaSolicitacoes = ListaSolicitacoes;
    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
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
        if (!(object instanceof DBA)) {
            return false;
        }
        DBA other = (DBA) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Id: " + getId()
                + "\nNome: " + getNome()
                + "\nEmail: " + getEmail();
    }

}
