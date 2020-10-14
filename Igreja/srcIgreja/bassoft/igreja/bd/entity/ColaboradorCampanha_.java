package bassoft.igreja.bd.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-03-28T08:23:26.485-0300")
@StaticMetamodel(ColaboradorCampanha.class)
public class ColaboradorCampanha_ {
	public static volatile SingularAttribute<ColaboradorCampanha, Long> idColaboradorCampanha;
	public static volatile SingularAttribute<ColaboradorCampanha, Colaborador> colaborador;
	public static volatile SingularAttribute<ColaboradorCampanha, Campanha> campanha;
	public static volatile SingularAttribute<ColaboradorCampanha, Date> dataDoacao;
	public static volatile SingularAttribute<ColaboradorCampanha, String> observacao;
	public static volatile SingularAttribute<ColaboradorCampanha, Double> valor;
}
