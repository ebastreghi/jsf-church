package bassoft.igreja.bd.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Ministerio {
	
	@SequenceGenerator(name="seqMinisterio", sequenceName="seq_ministerio", allocationSize=1)
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqMinisterio")
	private Long idMinisterio;
	private String nome;
	@OneToOne
	@JoinColumn(name="idcolaboradorlider")
	private Colaborador colaboradorLider;// = new Colaborador();
	@ManyToMany(mappedBy="ministerios")
	private List<Colaborador> colaboradores;

	
	public Long getIdMinisterio() {
		return idMinisterio;
	}

	public void setIdMinisterio(Long idMinisterio) {
		this.idMinisterio = idMinisterio;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Colaborador getColaboradorLider() {
		return colaboradorLider;
	}

	public void setColaboradorLider(Colaborador colaboradorLider) {
		this.colaboradorLider = colaboradorLider;
	}

	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}
	
	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}
	
}
