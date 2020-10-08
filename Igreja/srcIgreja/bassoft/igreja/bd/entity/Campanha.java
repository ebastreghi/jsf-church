package bassoft.igreja.bd.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Campanha {
	
	@SequenceGenerator(name="seqCampanha", sequenceName="seq_campanha", allocationSize=1)
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqCampanha")
	private Long idCampanha;
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	@OneToMany(mappedBy="campanha")
	private List<ColaboradorCampanha> colaboradoresCampanhas;
	
	
	public Long getIdCampanha() {
		return idCampanha;
	}

	public void setIdCampanha(Long idCampanha) {
		this.idCampanha = idCampanha;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataFim() {
		return dataFim;
	}
	
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public List<ColaboradorCampanha> getColaboradoresCampanhas() {
		return colaboradoresCampanhas;
	}

	public void setColaboradoresCampanhas(List<ColaboradorCampanha> colaboradoresCampanhas) {
		this.colaboradoresCampanhas = colaboradoresCampanhas;
	}
	
}
