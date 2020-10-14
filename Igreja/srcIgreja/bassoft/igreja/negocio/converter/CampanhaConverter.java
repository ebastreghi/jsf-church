package bassoft.igreja.negocio.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import bassoft.igreja.bd.dao.CampanhaDAO;
import bassoft.igreja.bd.entity.Campanha;

@FacesConverter(forClass=Campanha.class, value="converterCampanha")
public class CampanhaConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if(string == null || string.isEmpty()){
			return null;
		}
		CampanhaDAO dao = new CampanhaDAO();
		Campanha campanha = null;
		try {
			Long id = Long.valueOf(string);
			campanha = dao.getCampanhaById(id);
		} catch (Exception e) {
			return null;
		}
		return campanha;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Campanha campanha = (Campanha) object;
		if(campanha == null || campanha.getIdCampanha() == null){
			return null;
		}
		return String.valueOf(campanha.getIdCampanha());
	}

}
