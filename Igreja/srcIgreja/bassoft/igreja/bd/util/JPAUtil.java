package bassoft.igreja.bd.util;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;



public class JPAUtil {

	public static EntityManager getEntityManagerByFacesContext() {
		/*ELContext el = FacesContext.getCurrentInstance().getELContext();

		return (EntityManager) FacesContext.getCurrentInstance()
				.getApplication().getELResolver()
				.getValue(el, null, "entityManager");*/
		
		 return (EntityManager) FacesContext.getCurrentInstance() .getExternalContext().getRequestMap().get("entityManager");
	}

}
