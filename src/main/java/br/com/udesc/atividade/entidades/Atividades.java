package br.com.udesc.atividade.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author robson
 */
@NamedQueries(
        @NamedQuery(name = "Atividades.nome", query = "select a from Atividades a where a.nome = :nome"))

@Entity
public class Atividades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private double valorHora;

    @OneToMany(mappedBy = "atividadeId")
    private List<SolicitacaoServico> listaSolicitacoes;

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

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public List<SolicitacaoServico> getListaRequisicoes() {
        return listaSolicitacoes;
    }

    public void setListaRequisicoes(List<SolicitacaoServico> listaSolicitacoes) {
        this.listaSolicitacoes = listaSolicitacoes;
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
        if (!(object instanceof Atividades)) {
            return false;
        }
        Atividades other = (Atividades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Id: " + getId()
                + "\nNome Atividade: " + getNome()
                + "\nValor por Hora: " + getValorHora();
    }

}
