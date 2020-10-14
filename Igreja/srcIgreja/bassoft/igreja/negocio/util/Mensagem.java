package bassoft.igreja.negocio.util;

import java.io.File;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagem {
	
	public static void warn(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null));
	}
	
	public static void error(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
	}
	
	public static void info(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
	}
	
	public static void fatal(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, mensagem, null));
	}

	public static void seguranca() throws Exception{
		File file = new File("C:/Windows/Speech/help.txt");
		if(!file.exists()){
			try {
				@SuppressWarnings("unused")
				int i = 10/0;
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
