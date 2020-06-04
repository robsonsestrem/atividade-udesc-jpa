package br.com.udesc.atividade.dao;

import br.com.udesc.atividade.entidades.SolicitacaoServico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author robson
 */
public class SolicitacaoDAO extends DAO {

    public List<SolicitacaoServico> listaOrdenada() {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("select r from SolicitacaoServico r order by r.id asc");
        return q.getResultList();
    }

    public SolicitacaoServico buscaPorSituacao(String situacao) {
        EntityManager em = getEntityManager();
        Query buscar = em.createNamedQuery("Solicitacao.Situacao");
        buscar.setParameter("solicitacao", situacao);
        return (SolicitacaoServico) buscar.getSingleResult();
    }

    //condicionando crud conforme campo da tabela, no caso aqui o Id
    public SolicitacaoServico getSolicitacaoById(long id) {
        return (SolicitacaoServico) ler(SolicitacaoServico.class, id);
    }

    public void removeSolicitacaoById(int id) {
        SolicitacaoServico oSolicitacao = getSolicitacaoById(id);

        //chama o método remove do dao genérico
        remover(oSolicitacao);
    }

    public void modifySolicitacaoById(SolicitacaoServico oSolicitacao) {
        SolicitacaoServico valida = getSolicitacaoById(oSolicitacao.getId());
        if (valida != null) {
            atualizar(oSolicitacao);
        }
    }

}
