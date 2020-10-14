package bassoft.igreja.bd.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-07T22:26:56.054-0300")
@StaticMetamodel(Campanha.class)
public class Campanha_ {
	public static volatile SingularAttribute<Campanha, Long> idCampanha;
	public static volatile SingularAttribute<Campanha, String> nome;
	public static volatile SingularAttribute<Campanha, Date> dataInicio;
	public static volatile SingularAttribute<Campanha, Date> dataFim;
	public static volatile ListAttribute<Campanha, ColaboradorCampanha> colaboradoresCampanhas;
}
