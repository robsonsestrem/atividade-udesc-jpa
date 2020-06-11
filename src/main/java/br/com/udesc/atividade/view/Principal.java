package br.com.udesc.atividade.view;

import br.com.udesc.atividade.dao.AtividadesDAO;
import br.com.udesc.atividade.dao.DBA_DAO;
import br.com.udesc.atividade.dao.SolicitacaoDAO;
import br.com.udesc.atividade.dao.ServerDAO;
import br.com.udesc.atividade.entidades.Atividades;
import br.com.udesc.atividade.entidades.DBA;
import br.com.udesc.atividade.entidades.SolicitacaoServico;
import br.com.udesc.atividade.entidades.Server;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author robson
 */
public class Principal {

    public static void main(String[] args) {
        try {
            Server oServer1 = new Server();
            oServer1.setHostname("sql01");
            oServer1.setIP("192.1.250.200");

            Server oServer2 = new Server();
            oServer2.setHostname("sql02");
            oServer2.setIP("192.1.250.203");

            Server oServer3 = new Server();
            oServer3.setHostname("sql03");
            oServer3.setIP("192.1.200.205");

            Server oServer4 = new Server();
            oServer4.setHostname("sql04");
            oServer4.setIP("192.1.200.199");

            ServerDAO dml = new ServerDAO();
            dml.salvar(oServer1);
            dml.salvar(oServer2);
            dml.salvar(oServer3);
            dml.salvar(oServer4);

            JOptionPane.showMessageDialog(null, "Dados de Servers Inseridos...");

            List<Server> servidores = new ArrayList<>();
            servidores.add(oServer1);
            servidores.add(oServer2);
            servidores.add(oServer3);
            servidores.add(oServer4);

            DBA oDba = new DBA();
            oDba.setNome("robson");
            oDba.setEmail("development@empresa.com.br");
            oDba.setServers(servidores);

            DBA oDba2 = new DBA();
            oDba2.setNome("sestrem");
            oDba2.setEmail("administering@empresa.com.br");
            oDba2.setServers(servidores);

            DBA_DAO dml2 = new DBA_DAO();
            dml2.salvar(oDba);
            dml2.salvar(oDba2);

            JOptionPane.showMessageDialog(null, "Cadastrado DBA's para realizar Atividades nos Servers...");

            Atividades oAtividades = new Atividades();
            oAtividades.setNome("Monitoramento");
            oAtividades.setValorHora(200);

            AtividadesDAO dml3 = new AtividadesDAO();
            dml3.salvar(oAtividades);

            JOptionPane.showMessageDialog(null, "Cadastrado tipos de atividades para atendimentos...");

            Date data = new Date();
            SolicitacaoServico solicitacao = new SolicitacaoServico();
            solicitacao.setOrcamento(200);
            solicitacao.setSituacao("Aprovado");
            solicitacao.setData(data);
            solicitacao.setDbaId(oDba);
            solicitacao.setAtividadeId(oAtividades);

            SolicitacaoDAO dml4 = new SolicitacaoDAO();
            dml4.salvar(solicitacao);

            JOptionPane.showMessageDialog(null, "Existindo Server, DBA e Atividades, foi realizado uma solicitação de manutenção.");

            //busca pelo Id
            ServerDAO busca = new ServerDAO();
            JOptionPane.showMessageDialog(null, "Busca Server pelo ID [1]: " + "\n" + busca.getServerById(1));

            //altera hostname pelo id
            ServerDAO altera = new ServerDAO();
            oServer2.setHostname("Host_Alterado");
            altera.modifyServerById(oServer2);
            JOptionPane.showMessageDialog(null, "Alterado nome do host [sql02] para [Host_Alterado]");

            //deletando server 2 pelo Id
            ServerDAO deletaID = new ServerDAO();
            deletaID.removeServerById(1);
            JOptionPane.showMessageDialog(null, "Deletado Server de Id [1]");

            ServerDAO buscaOrdenada = new ServerDAO();
            List<Server> hosts = new ArrayList<>();
            hosts = buscaOrdenada.listaOrdenada();
            JOptionPane.showMessageDialog(null, "Lista de Servers ordenados por id:");
            String resultset = "";
            for (int i = 0; i < hosts.size(); i++) {
                resultset += hosts.get(i).toString() + "\n";
            }
            JOptionPane.showMessageDialog(null, resultset);

            //Buscar por outro atributo e com NamedQuery
            ServerDAO buscarPorIP = new ServerDAO();
            Server ip = new Server();
            ip = buscarPorIP.buscarEnderecoIP("192.1.250.203");
            JOptionPane.showMessageDialog(null, "Busca do Server pelo IP 192.1.250.203:" + "\n" + ip.toString());

        } catch (Exception ex) {
            throw ex;
        }
    }
}
