package br.com.udesc.atividade.dao;

import br.com.udesc.atividade.entidades.Server;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author robson
 */
public class ServerDAO extends DAO {

    public List<Server> listaOrdenada() {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("select s from Server s order by s.id asc");
        return q.getResultList();
    }

    public Server buscarEnderecoIP(String ip) {
        EntityManager em = getEntityManager();
        Query buscar = em.createNamedQuery("Server.buscarPorIP");
        buscar.setParameter("ip", ip);
        return (Server) buscar.getSingleResult();
    }

    //condicionando crud conforme campo da tabela, no caso aqui o Id
    public Server getServerById(long id) {
        return (Server) ler(Server.class, id);
    }

    public void removeServerById(int id) {
        Server oServer = getServerById(id);

        //chama o método remove do dao genérico
        remover(oServer);
    }

    public void modifyServerById(Server oServer) {
        Server valida = getServerById(oServer.getId());
        if (valida != null) {
            atualizar(oServer);
        }
    }

}
