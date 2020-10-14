package bassoft.igreja.bd.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ColaboradorCampanha {

	@SequenceGenerator(name="seqColaboradorCampanha", sequenceName="seq_colaborador_campanha", allocationSize=1)
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqColaboradorCampanha")
	private Long idColaboradorCampanha;
	@ManyToOne
	@JoinColumn(name="idColaborador")
	private Colaborador colaborador = new Colaborador();
	@ManyToOne
	@JoinColumn(name="idCampanha")
	private Campanha campanha = new Campanha();
	@Temporal(TemporalType.DATE)
	private Date dataDoacao;
	private String observacao;
	private Double valor;
	
	
	public Long getIdColaboradorCampanha() {
		return idColaboradorCampanha;
	}

	public void setIdColaboradorCampanha(Long idColaboradorCampanha) {
		this.idColaboradorCampanha = idColaboradorCampanha;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}
	
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	public Campanha getCampanha() {
		return campanha;
	}
	
	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}
	
	public Date getDataDoacao() {
		return dataDoacao;
	}
	
	public void setDataDoacao(Date dataDoacao) {
		this.dataDoacao = dataDoacao;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
}
