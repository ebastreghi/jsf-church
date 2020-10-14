package bassoft.igreja.bd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Igreja {
	
	@SequenceGenerator(name="seqIgreja", sequenceName="seq_igreja", allocationSize=1)
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqIgreja")
	private Long idIgreja;
	private String nome;
	private String cidade;
	private String estado;
	private String endereco;
	
	
	public Long getIdIgreja() {
		return idIgreja;
	}

	public void setIdIgreja(Long idIgreja) {
		this.idIgreja = idIgreja;
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
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
}
