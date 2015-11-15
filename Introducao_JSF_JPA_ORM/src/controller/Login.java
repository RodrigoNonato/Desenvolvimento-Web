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
 
    //Validação do Login
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
                            "Nome de Usuário ou Senha Incorreto",
                            "Entre com o Usuário ou Senha Correto!!"));
            
            return "login";
        }
    }
 
    //Evento de Logout e Sessão Inválida
    public String logout()
    {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        
        return "login";
    }
}