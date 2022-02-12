package br.com.udesc.atividade.entidades;

import br.com.udesc.atividade.entidades.DBA;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-05T14:07:42")
@StaticMetamodel(Server.class)
public class Server_ { 

    public static volatile SingularAttribute<Server, String> hostname;
    public static volatile SingularAttribute<Server, String> IP;
    public static volatile SingularAttribute<Server, Long> id;
    public static volatile ListAttribute<Server, DBA> profissionais;

}