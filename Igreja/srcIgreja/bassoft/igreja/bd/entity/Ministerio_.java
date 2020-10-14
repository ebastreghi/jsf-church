package bassoft.igreja.bd.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-27T15:57:25.400-0300")
@StaticMetamodel(Ministerio.class)
public class Ministerio_ {
	public static volatile SingularAttribute<Ministerio, Long> idMinisterio;
	public static volatile SingularAttribute<Ministerio, String> nome;
	public static volatile SingularAttribute<Ministerio, Colaborador> colaboradorLider;
	public static volatile ListAttribute<Ministerio, Colaborador> colaboradores;
}
