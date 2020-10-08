package bassoft.igreja.negocio.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import bassoft.igreja.bd.dao.IgrejaDAO;
import bassoft.igreja.bd.entity.Igreja;
import bassoft.igreja.negocio.util.Mensagem;
import bassoft.igreja.negocio.util.Util;

@ManagedBean
public class IgrejaBean {
	private Igreja igreja = new Igreja();
	private Long igrejaId;
	private List<Igreja> listIgreja;
	private IgrejaDAO igrejaDAO = new IgrejaDAO();
	
	public String salvar(){
		
		igrejaDAO.salvar(igreja);
		Mensagem.info("A igreja "+Util.aspasDuplas(igreja.getNome())+" foi "+(igrejaId==null ? "cadastrada" : "atualizada")+" com sucesso.");
		igreja = null;
		igrejaId = null;
		return null;
		//return "listarIgreja.xhtml?faces-redirect=true";
	}

	public String excluir(){
		igrejaDAO.excluir(igreja);
		return "listarIgreja.xhtml?faces-redirect=true";
	}
	
	public Igreja getIgreja() {
		if(igrejaId != null && igreja.getIdIgreja() == null){
			igreja = igrejaDAO.getIgrejaById(igrejaId);
		}
		return igreja;
	}
	
	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}
	
	public Long getIgrejaId() {
		return igrejaId;
	}

	public void setIgrejaId(Long igrejaId) {
		this.igrejaId = igrejaId;
	}

	public List<Igreja> getListIgreja() {
		if(listIgreja == null){
			listIgreja = igrejaDAO.listIgreja();
		}
		return listIgreja;
	}

	public void setListIgreja(List<Igreja> listIgreja) {
		this.listIgreja = listIgreja;
	}
	
	
}
