package br.com.udesc.atividade.entidades;

import br.com.udesc.atividade.entidades.SolicitacaoServico;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-05T14:07:42")
@StaticMetamodel(Atividades.class)
public class Atividades_ { 

    public static volatile ListAttribute<Atividades, SolicitacaoServico> listaSolicitacoes;
    public static volatile SingularAttribute<Atividades, String> nome;
    public static volatile SingularAttribute<Atividades, Double> valorHora;
    public static volatile SingularAttribute<Atividades, Long> id;

}