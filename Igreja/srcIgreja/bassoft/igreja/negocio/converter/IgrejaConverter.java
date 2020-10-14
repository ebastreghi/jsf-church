package bassoft.igreja.negocio.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import bassoft.igreja.bd.dao.IgrejaDAO;
import bassoft.igreja.bd.entity.Igreja;

@FacesConverter(forClass=Igreja.class, value="converterIgreja")
public class IgrejaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if(string == null || string.isEmpty()){
			return null;
		}
		IgrejaDAO dao = new IgrejaDAO();
		Igreja igreja = null;
		try {
			Long id = Long.valueOf(string);
			igreja = dao.getIgrejaById(id);
		} catch (Exception e) {
			return null;
		}
		return igreja;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Igreja igreja = (Igreja) object;
		if(igreja == null || igreja.getIdIgreja() == null){
			return null;
		}
		return String.valueOf(igreja.getIdIgreja());
	}

}
