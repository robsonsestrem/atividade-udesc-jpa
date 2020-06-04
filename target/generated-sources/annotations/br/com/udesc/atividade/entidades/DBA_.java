package br.com.udesc.atividade.entidades;

import br.com.udesc.atividade.entidades.Server;
import br.com.udesc.atividade.entidades.SolicitacaoServico;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-04T00:30:25")
@StaticMetamodel(DBA.class)
public class DBA_ { 

    public static volatile ListAttribute<DBA, Server> servers;
    public static volatile ListAttribute<DBA, SolicitacaoServico> ListaSolicitacoes;
    public static volatile SingularAttribute<DBA, String> nome;
    public static volatile SingularAttribute<DBA, Long> id;
    public static volatile SingularAttribute<DBA, String> email;

}