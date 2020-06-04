package br.com.udesc.atividade.dao;

import br.com.udesc.atividade.entidades.Atividades;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SYSADMIN
 */
public class AtividadesDAO extends DAO {

    public List<Atividades> listaOrdenada() {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("select s.nome from Atividades s order by s.id asc");
        return q.getResultList();
    }

    public Atividades buscarPorNome(String nome) {
        EntityManager em = getEntityManager();
        Query buscar = em.createNamedQuery("Atividades.nome");
        buscar.setParameter("nome", nome);
        return (Atividades) buscar.getSingleResult();
    }

    //condicionando crud conforme campo da tabela, no caso aqui o Id
    public Atividades getAtividadeById(long id) {
        return (Atividades) ler(Atividades.class, id);
    }

    public void removeAtividadeById(int id) {
        Atividades oAtividades = getAtividadeById(id);
        remover(oAtividades);
    }

    public void modifyAtividadeById(Atividades oAtividade) {
        Atividades valida = getAtividadeById(oAtividade.getId());
        if (valida != null) {
            atualizar(oAtividade);
        }
    }
}
