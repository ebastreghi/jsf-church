package bassoft.igreja.negocio.managedbean;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import bassoft.igreja.bd.dao.ColaboradorDAO;
import bassoft.igreja.bd.entity.Colaborador;

public class ColaboradorLazyList extends LazyDataModel<Colaborador> {

	private static final long serialVersionUID = 1L;
	Colaborador colaborador;
	
	public ColaboradorLazyList(Colaborador colaborador){
		this.colaborador = colaborador;
	}
	
	@Override
	public List<Colaborador> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters){
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		
		if(getRowCount() <= 0){
			setRowCount(colaboradorDAO.countColaboradoresParaPaginacao(colaborador));
		}
		List<Colaborador> aux = colaboradorDAO.listarColaboradoresComPaginacao(first, pageSize, colaborador);
		return aux;
	}

}
