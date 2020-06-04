package br.com.udesc.atividade.dao;

import br.com.udesc.atividade.entidades.DBA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author robson
 */
public class DBA_DAO extends DAO {

    public List<DBA> listaOrdenada() {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("select d from DBA d order by d.id asc");
        return q.getResultList();
    }

    public DBA buscaPorNome(String nome) {
        EntityManager em = getEntityManager();
        Query buscar = em.createNamedQuery("DBA.buscarPorNome");
        buscar.setParameter("nome", nome);
        return (DBA) buscar.getSingleResult();
    }

    public DBA getDBAbyId(long id) {
        return (DBA) ler(DBA.class, id);
    }

    public void removeDBAById(int id) {
        DBA oDba = getDBAbyId(id);
        remover(oDba);
    }

    public void modifyDBAById(DBA oDba) {
        DBA valida = getDBAbyId(oDba.getId());
        if (valida != null) {
            atualizar(oDba);
        }
    }

}
