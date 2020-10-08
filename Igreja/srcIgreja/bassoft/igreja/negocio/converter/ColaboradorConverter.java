package bassoft.igreja.negocio.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import bassoft.igreja.bd.dao.ColaboradorDAO;
import bassoft.igreja.bd.entity.Colaborador;

@FacesConverter(forClass=Colaborador.class, value="converterColaborador")
public class ColaboradorConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if(string == null || string.isEmpty()){
			return null;
		}
		ColaboradorDAO dao = new ColaboradorDAO();
		Colaborador colaborador = null;
		try {
			Long id = Long.valueOf(string);
			colaborador = dao.getColaboradorById(id);
		} catch (Exception e) {
			return null;
		}
		return colaborador;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Colaborador colaborador = (Colaborador) object;
		if(colaborador == null || colaborador.getIdColaborador() == null){
			return null;
		}
		return String.valueOf(colaborador.getIdColaborador());
	}


}
