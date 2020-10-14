package bassoft.igreja.bd.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Colaborador {
	
	@SequenceGenerator(name="seqColaborador", sequenceName="seq_colaborador", allocationSize=1)
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqColaborador")
	private Long idColaborador;
	private String nome;
	private String cidade;
	private String estado;
	private String endereco;
	private String telefone;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@ManyToOne 
	@JoinColumn(name="idIgreja")
	private Igreja igreja;// = new Igreja();   /*instanciar dentro do entity para não precisar usar converter*/
	@ManyToMany
	@JoinTable(name="colaborador_ministerio",
			   joinColumns=@JoinColumn(name="idcolaborador"),
			   inverseJoinColumns=@JoinColumn(name="idministerio")
			  )
	private List<Ministerio> ministerios;
	@OneToMany(mappedBy="colaborador")
	private List<ColaboradorCampanha> colaboradoresCampanhas;
	
	
	
	public Long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Igreja getIgreja() {
		return igreja;
	}
	
	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}
	
	public List<Ministerio> getMinisterios() {
		return ministerios;
	}
	
	public void setMinisterios(List<Ministerio> ministerios) {
		this.ministerios = ministerios;
	}

	public List<ColaboradorCampanha> getColaboradoresCampanhas() {
		return colaboradoresCampanhas;
	}

	public void setColaboradoresCampanhas(List<ColaboradorCampanha> colaboradoresCampanhas) {
		this.colaboradoresCampanhas = colaboradoresCampanhas;
	}


}
