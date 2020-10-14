package bassoft.igreja.negocio.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import bassoft.igreja.bd.dao.ColaboradorCampanhaDAO;
import bassoft.igreja.bd.dao.ColaboradorDAO;
import bassoft.igreja.bd.dao.MinisterioDAO;
import bassoft.igreja.bd.entity.Colaborador;
import bassoft.igreja.negocio.util.Mensagem;
import bassoft.igreja.negocio.util.MesesEnum;
import bassoft.igreja.negocio.util.Util;

@ManagedBean
public class ColaboradorBean {
	private Colaborador colaborador = new Colaborador();
	private List<Colaborador> colaboradores;
	private List<Colaborador> colaboradoresAniversariante;
	private Long colaboradorId;
	private Integer mesAniversariante;
	
	public MesesEnum[] getMesesEnum(){
		return MesesEnum.values();
	}
	
	/*public List<SelectItem> getMesesEnum(){
		List<SelectItem> meses = new ArrayList<SelectItem>(MesesEnum.values().length);
		for(MesesEnum mes: MesesEnum.values()){
			meses.add(new SelectItem(mes.getCodigo(), mes.getDescricao()));
		}
		return meses;
	}*/
	
	public String salvar(){
		ColaboradorDAO colaboradorDao = new ColaboradorDAO();
		colaboradorDao.salvar(colaborador);
		Mensagem.info("O colaborador "+Util.aspasDuplas(colaborador.getNome())+" foi "+(colaboradorId==null ? "cadastrado" : "atualizado")+" com sucesso.");
		colaborador = null;
		colaboradorId = null;
		return null;
		//return "listarColaborador.xhtml?faces-redirect=true";
	}

	public void pesquisaColaboradoresAniversariantes(){
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		colaboradoresAniversariante = colaboradorDAO.colaboradoresesByMesAniversario(mesAniversariante);
	}
	
	public String excluir(){
		MinisterioDAO ministerioDAO = new MinisterioDAO();
		Long quantidadeColaboradorLider = ministerioDAO.countColaboradorLider(colaborador.getIdColaborador());
		ColaboradorCampanhaDAO colaboradorCampanhaDAO = new ColaboradorCampanhaDAO();
		Long quantidadeColaboradorCampanha = colaboradorCampanhaDAO.countColaboradorAndCampanha(colaborador, null);
		
		if (quantidadeColaboradorLider == 0 || quantidadeColaboradorLider == null){
			if (quantidadeColaboradorCampanha == 0 || quantidadeColaboradorCampanha == null){
				ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
				colaboradorDAO.excluir(colaborador);
			}else{
				Mensagem.warn("O colaborador "+colaborador.getNome()+" não pode ser excluido porque ele fez doação para alguma campanha.");
				return null;
			}
		}else{
			Mensagem.warn("O colaborador "+colaborador.getNome()+" não pode ser excluido porque ele é lider de um ministério.");
			return null;
		}
		return "listarColaborador.xhtml?faces-redirect=true";
	}

	public List<Colaborador> getColaboradores() {
		if(colaboradores == null){
			ColaboradorDAO dao = new ColaboradorDAO();
			colaboradores = dao.colaboradores();
		}
		return colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

	public Colaborador getColaborador() {
		if(colaboradorId != null && colaborador.getIdColaborador() == null){
			ColaboradorDAO dao = new ColaboradorDAO();
			colaborador = dao.getColaboradorById(colaboradorId);
		}
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Long getColaboradorId() {
		return colaboradorId;
	}

	public void setColaboradorId(Long colaboradorId) {
		this.colaboradorId = colaboradorId;
	}

	public Integer getMesAniversariante() {
		return mesAniversariante;
	}

	public void setMesAniversariante(Integer mesAniversariante) {
		this.mesAniversariante = mesAniversariante;
	}

	public List<Colaborador> getColaboradoresAniversariante() {
		return colaboradoresAniversariante;
	}

	public void setColaboradoresAniversariante(
			List<Colaborador> colaboradoresAniversariante) {
		this.colaboradoresAniversariante = colaboradoresAniversariante;
	}
	
	
}
