package model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil
{
	public static void mensagem(String titulo, String mensagem)
	{
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensagem);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
}