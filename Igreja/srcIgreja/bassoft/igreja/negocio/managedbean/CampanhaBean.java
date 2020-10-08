package bassoft.igreja.negocio.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import bassoft.igreja.bd.dao.CampanhaDAO;
import bassoft.igreja.bd.dao.ColaboradorCampanhaDAO;
import bassoft.igreja.bd.entity.Campanha;
import bassoft.igreja.negocio.util.Mensagem;
import bassoft.igreja.negocio.util.Util;

@ManagedBean
public class CampanhaBean {

	private Campanha campanha = new Campanha();
	private Long campanhaId;
	private List<Campanha> campanhas;

	public String salvar(){
		CampanhaDAO dao = new CampanhaDAO();
		dao.salvar(campanha);
		Mensagem.info("A campanha "+Util.aspasDuplas(campanha.getNome())+" foi "+(campanhaId==null ? "cadastrada" : "atualizada")+" com sucesso.");
		campanha = null;
		campanhaId = null;
		return null;
		//return "listarCampanha.xhtml?faces-redirect=true";
	}
	
	public String excluir(){
		ColaboradorCampanhaDAO colaboradorCampanhaDAO = new ColaboradorCampanhaDAO();
		Long quantidadeCampanhaDoacao = colaboradorCampanhaDAO.countColaboradorAndCampanha(null, campanha);
		if(quantidadeCampanhaDoacao > 0){
			Mensagem.warn("A campanha "+Util.aspasDuplas(campanha.getNome())+" não pode ser excluida porque existe doação para essa campanha.");
			return null;
		}
		CampanhaDAO dao = new CampanhaDAO();
		dao.excluir(campanha);
		return "listarCampanha.xhtml?faces-redirect=true";
	}

	public Campanha getCampanha() {
		if(campanhaId != null && campanha.getIdCampanha() == null){
			CampanhaDAO dao = new CampanhaDAO();
			campanha = dao.getCampanhaById(campanhaId);
		}
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}

	public Long getCampanhaId() {
		return campanhaId;
	}

	public void setCampanhaId(Long campanhaId) {
		this.campanhaId = campanhaId;
	}

	public List<Campanha> getCampanhas() {
		if(campanhas == null){
			CampanhaDAO dao = new CampanhaDAO();
			campanhas = dao.listar();
		}
		return campanhas;
	}

	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}
	
	
}
