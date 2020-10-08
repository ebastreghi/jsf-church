package bassoft.igreja.negocio.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.LazyDataModel;

import bassoft.igreja.bd.dao.ColaboradorDAO;
import bassoft.igreja.bd.entity.Colaborador;
import bassoft.igreja.negocio.util.Mensagem;

@ManagedBean
@ViewScoped
public class FormColaboradorBean {
	
	private Colaborador colaborador = new Colaborador();
	private Colaborador selectedColaborador;
	private LazyDataModel<Colaborador> colaboradoresLazyDataModel;
	
	public void pesquisar(){
		colaboradoresLazyDataModel = new ColaboradorLazyList(colaborador);
	}
	
	public void carregarColaboradorSelecionado(ActionEvent event){
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		colaborador = colaboradorDAO.getColaboradorCompletoById(selectedColaborador.getIdColaborador());
		//colaborador = selectedColaborador;
	}
	
	public void salvar(ActionEvent event){
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		colaboradorDAO.salvar(colaborador);
		Mensagem.info("Mudanças realizadas com sucesso.");
	}
	
	public Colaborador getColaborador() {
		return colaborador;
	}
	
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	public Colaborador getSelectedColaborador() {
		return selectedColaborador;
	}
	
	public void setSelectedColaborador(Colaborador selectedColaborador) {
		this.selectedColaborador = selectedColaborador;
	}

	public LazyDataModel<Colaborador> getColaboradoresLazyDataModel() {
		return colaboradoresLazyDataModel;
	}

	public void setColaboradoresLazyDataModel(
			LazyDataModel<Colaborador> colaboradoresLazyDataModel) {
		this.colaboradoresLazyDataModel = colaboradoresLazyDataModel;
	}
	
	
}
