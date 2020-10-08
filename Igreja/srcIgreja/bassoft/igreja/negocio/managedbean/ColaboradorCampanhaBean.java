package bassoft.igreja.negocio.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import bassoft.igreja.bd.dao.ColaboradorCampanhaDAO;
import bassoft.igreja.bd.entity.Campanha;
import bassoft.igreja.bd.entity.Colaborador;
import bassoft.igreja.bd.entity.ColaboradorCampanha;

@ManagedBean
public class ColaboradorCampanhaBean {

	private ColaboradorCampanha colaboradorCampanha = new ColaboradorCampanha();
	private Long colaboradorCampanhaId;
	private List<ColaboradorCampanha> colaboradoresCampanhas;
	private String pesquisaAutomatica;
	private String excluirCC;
	private String colaboradorId;
	private String campanhaId;

	public String salvar(){
		ColaboradorCampanhaDAO dao = new ColaboradorCampanhaDAO();
		dao.salvar(colaboradorCampanha);
		String url = "pesquisarDoacao.xhtml?faces-redirect=true&pesquisaAutomatica=true&colaboradorId="+colaboradorCampanha.getColaborador().getIdColaborador()+"&campanhaId="+colaboradorCampanha.getCampanha().getIdCampanha();
		return url;
	}
	
	public String excluir(){
		ColaboradorCampanhaDAO dao = new ColaboradorCampanhaDAO();
		dao.excluir(colaboradorCampanha);
		return "pesquisarDoacao.xhtml?faces-redirect=true&pesquisaAutomatica=true";
	}

	public void pesquisar(){
		ColaboradorCampanhaDAO dao = new ColaboradorCampanhaDAO();
		try {
			colaboradoresCampanhas = dao.listByColaboradorAndCampanha(colaboradorCampanha.getColaborador(), colaboradorCampanha.getCampanha());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Double getTotalPesquisa(){
		Double total = 0.0;
		if(colaboradoresCampanhas != null){
			for(ColaboradorCampanha cc : colaboradoresCampanhas){
				total += cc.getValor();
			}
		}
		return total;
	}
	
	public ColaboradorCampanha getColaboradorCampanha() {
		if(colaboradorCampanhaId != null && colaboradorCampanha.getIdColaboradorCampanha() == null){
			ColaboradorCampanhaDAO dao = new ColaboradorCampanhaDAO();
			colaboradorCampanha = dao.getColaboradorCampanhaById(colaboradorCampanhaId);
		}
		return colaboradorCampanha;
	}
	
	public void setColaboradorCampanha(ColaboradorCampanha colaboradorCampanha) {
		this.colaboradorCampanha = colaboradorCampanha;
	}
	
	public Long getColaboradorCampanhaId() {
		return colaboradorCampanhaId;
	}
	
	public void setColaboradorCampanhaId(Long colaboradorCampanhaId) {
		this.colaboradorCampanhaId = colaboradorCampanhaId;
	}

	public List<ColaboradorCampanha> getColaboradoresCampanhas() {
		if(pesquisaAutomatica != null && pesquisaAutomatica.equals("true")){
			Colaborador colaborador = new Colaborador();
			colaborador.setIdColaborador(Long.valueOf(colaboradorId));
			colaboradorCampanha.setColaborador(colaborador);
			Campanha campanha = new Campanha();
			campanha.setIdCampanha(Long.valueOf(campanhaId));
			colaboradorCampanha.setCampanha(campanha);
			pesquisaAutomatica = null;
			pesquisar();
		}
		return colaboradoresCampanhas;
	}

	public void setColaboradoresCampanhas(List<ColaboradorCampanha> colaboradoresCampanhas) {
		this.colaboradoresCampanhas = colaboradoresCampanhas;
	}

	public String getPesquisaAutomatica() {
		return pesquisaAutomatica;
	}

	public void setPesquisaAutomatica(String pesquisaAutomatica) {
		this.pesquisaAutomatica = pesquisaAutomatica;
	}

	public String getExcluirCC() {
		if(excluirCC != null && !excluirCC.isEmpty()){
			ColaboradorCampanhaDAO dao = new ColaboradorCampanhaDAO();
			dao.excluir(dao.getColaboradorCampanhaById(Long.valueOf(excluirCC)));
			excluirCC = null;
		}
		return excluirCC;
	}

	public void setExcluirCC(String excluirCC) {
		this.excluirCC = excluirCC;
	}

	public String getColaboradorId() {
		return colaboradorId;
	}

	public void setColaboradorId(String colaboradorId) {
		this.colaboradorId = colaboradorId;
	}

	public String getCampanhaId() {
		return campanhaId;
	}

	public void setCampanhaId(String campanhaId) {
		this.campanhaId = campanhaId;
	}


}
