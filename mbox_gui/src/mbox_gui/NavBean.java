package mbox_gui;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import mbox_gui.util.AuthorizBean;
import mbox_gui.view.User;

@ManagedBean
@SessionScoped
public class NavBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -504806999704103644L;
	
	private String message;
	
	@ManagedProperty(value="#{user}")
	private User user;


	@ManagedProperty(value="#{authorizBean}")
	private AuthorizBean authorizBean;

	public NavBean() {
		System.out.println("NavBean");
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
	}


	public AuthorizBean getAuthorizBean() {
		return authorizBean;
	}


	public void setAuthorizBean(AuthorizBean authorizBean) {
		this.authorizBean = authorizBean;
	}

	
	public String logout() {
		System.out.println("NavBean.logout");
		HttpSession s = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		s.invalidate();
			
		return "/login?faces-redirect=true";
}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
