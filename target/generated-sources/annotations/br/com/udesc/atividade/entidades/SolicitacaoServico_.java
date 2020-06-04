package br.com.udesc.atividade.entidades;

import br.com.udesc.atividade.entidades.Atividades;
import br.com.udesc.atividade.entidades.DBA;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-04T00:30:25")
@StaticMetamodel(SolicitacaoServico.class)
public class SolicitacaoServico_ { 

    public static volatile SingularAttribute<SolicitacaoServico, Double> orcamento;
    public static volatile SingularAttribute<SolicitacaoServico, DBA> dbaId;
    public static volatile SingularAttribute<SolicitacaoServico, Date> data;
    public static volatile SingularAttribute<SolicitacaoServico, Atividades> atividadeId;
    public static volatile SingularAttribute<SolicitacaoServico, String> Situacao;
    public static volatile SingularAttribute<SolicitacaoServico, Long> id;

}