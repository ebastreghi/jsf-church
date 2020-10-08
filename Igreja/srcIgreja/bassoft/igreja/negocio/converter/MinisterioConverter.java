package bassoft.igreja.negocio.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import bassoft.igreja.bd.dao.MinisterioDAO;
import bassoft.igreja.bd.entity.Ministerio;

@FacesConverter(forClass=Ministerio.class, value="converterMinisterio")
public class MinisterioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if(string == null || string.isEmpty()){
			return null;
		}
		MinisterioDAO dao = new MinisterioDAO();
		Ministerio ministerio = null;
		try {
			Long id = Long.valueOf(string);
			ministerio = dao.getMinisterioById(id);
		} catch (Exception e) {
			return null;
		}
		return ministerio;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Ministerio ministerio = (Ministerio) object;
		if(ministerio == null || ministerio.getIdMinisterio() == null){
			return null;
		}
		return String.valueOf(ministerio.getIdMinisterio());
	}

}
