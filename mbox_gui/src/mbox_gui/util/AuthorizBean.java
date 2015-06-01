package mbox_gui.util;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;



import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sun.faces.context.ApplicationMap;
import com.sun.faces.context.SessionMap;

import mbox_gui.view.User;


@ManagedBean
@ApplicationScoped 
public class AuthorizBean {

	
	
	private boolean login;
	//@ManagedProperty(value="#{user}")
	@ManagedProperty("#{user}")
	private User user;
	
	public AuthorizBean() {
		System.out.println("AuthorizBean");
	}

	public boolean isLogin(String name,String pass) {
		if(name.equals("222")) 
		{
			//HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			//user = new User();
			//user.setName(name);
			//user.setPass(pass);
			//session.setAttribute("user", user);
			//FacesContext.getCurrentInstance().getApplication().
			login=true;
		}
		System.out.println("AuthorizBean.login - " + login);
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}


}
