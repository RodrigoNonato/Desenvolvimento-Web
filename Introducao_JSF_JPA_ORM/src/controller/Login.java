package controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import dao.LoginDAO;

@ManagedBean
@SessionScoped
public class Login implements Serializable
{
	private static final long serialVersionUID = 1094801825228386363L;
    
    private String pwd;
    private String msg;
    private String user;
 
    public String getPwd()
    {
    	return pwd;
    }
 
    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }
 
    public String getMsg()
    {
        return msg;
    }
 
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
 
    public String getUser()
    {
        return user;
    }
 
    public void setUser(String user)
    {
        this.user = user;
    }
 
    //Valida��o do Login
    public String validateUsernamePassword()
    {
        boolean valid = LoginDAO.validate(user, pwd);
        
        if (valid)
        {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("username", user);
            
            return "cadastraProduto";
        }
        
        else
        {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Nome de Usu�rio ou Senha Incorreto",
                            "Entre com o Usu�rio ou Senha Correto!!"));
            
            return "login";
        }
    }
 
    //Evento de Logout e Sess�o Inv�lida
    public String logout()
    {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        
        return "login";
    }
}