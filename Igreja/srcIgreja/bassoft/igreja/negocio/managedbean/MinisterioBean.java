package bassoft.igreja.negocio.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import bassoft.igreja.bd.dao.MinisterioDAO;
import bassoft.igreja.bd.entity.Colaborador;
import bassoft.igreja.bd.entity.Ministerio;
import bassoft.igreja.negocio.util.Mensagem;
import bassoft.igreja.negocio.util.Util;

@ManagedBean
public class MinisterioBean {
	
	private Ministerio ministerio = new Ministerio();
	private Long idMinisterio;
	//private List<Ministerio> ministeriosWithNomeLider;
	private List<Ministerio> ministerios;
	
	
	public String salvar(){
		MinisterioDAO dao = new MinisterioDAO();
		dao.salvar(ministerio);
		Mensagem.info("O ministétio "+Util.aspasDuplas(ministerio.getNome())+" foi "+(idMinisterio==null ? "cadastrado" : "atualizado")+" com sucesso.");
		ministerio = null;
		idMinisterio = null;
		return null;
		//return "listarMinisterio.xhtml?faces-redirect=true";
	}
	
	public String excluir(){
		MinisterioDAO dao = new MinisterioDAO();
		Ministerio ministerioAux = dao.getMinisterioById(ministerio.getIdMinisterio());
		List<Colaborador> colaboradoresAux = ministerioAux.getColaboradores();
		if(colaboradoresAux == null || colaboradoresAux.size() == 0){
			dao.excluir(ministerioAux);
		}else{
			Mensagem.warn("Não é possível excluir um minístério com colaboradores associados a ele.");
			return null;
		}
		return "listarMinisterio.xhtml?faces-redirect=true";
	}
	
	public Ministerio getMinisterio() {
		if(idMinisterio != null && ministerio.getIdMinisterio() == null){
			MinisterioDAO dao = new MinisterioDAO();
			ministerio = dao.getMinisterioById(idMinisterio);
		}
		return ministerio;
	}

	public void setMinisterio(Ministerio ministerio) {
		this.ministerio = ministerio;
	}

	public Long getIdMinisterio() {
		return idMinisterio;
	}

	public void setIdMinisterio(Long idMinisterio) {
		this.idMinisterio = idMinisterio;
	}

	/*public List<Ministerio> getMinisteriosWithNomeLider() {
		if(ministeriosWithNomeLider == null){
			MinisterioDAO dao = new MinisterioDAO();
			try {
				ministeriosWithNomeLider = dao.ministeriosWithNomeLider();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ministeriosWithNomeLider;
	}

	public void setMinisteriosWithNomeLider(List<Ministerio> ministeriosWithNomeLider) {
		this.ministeriosWithNomeLider = ministeriosWithNomeLider;
	}*/

	public List<Ministerio> getMinisterios() {
		if(ministerios == null){
			MinisterioDAO dao = new MinisterioDAO();
			ministerios = dao.ministerios();
		}
		return ministerios;
	}

	public void setMinisterios(List<Ministerio> ministerios) {
		this.ministerios = ministerios;
	}
	
}
