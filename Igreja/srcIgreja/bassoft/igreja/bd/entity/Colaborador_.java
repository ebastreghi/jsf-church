package bassoft.igreja.bd.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-06-05T11:48:42.149-0300")
@StaticMetamodel(Colaborador.class)
public class Colaborador_ {
	public static volatile SingularAttribute<Colaborador, Long> idColaborador;
	public static volatile SingularAttribute<Colaborador, String> nome;
	public static volatile SingularAttribute<Colaborador, String> cidade;
	public static volatile SingularAttribute<Colaborador, String> estado;
	public static volatile SingularAttribute<Colaborador, String> endereco;
	public static volatile SingularAttribute<Colaborador, String> telefone;
	public static volatile SingularAttribute<Colaborador, Date> dataNascimento;
	public static volatile SingularAttribute<Colaborador, Igreja> igreja;
	public static volatile ListAttribute<Colaborador, Ministerio> ministerios;
	public static volatile ListAttribute<Colaborador, ColaboradorCampanha> colaboradoresCampanhas;
}
