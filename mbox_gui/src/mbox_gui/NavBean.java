package mbox_gui;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mbox_gui.util.AuthorizBean;
import mbox_gui.view.User;

@ManagedBean
@SessionScoped
public class NavBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -504806999704103644L;
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
	}


	public AuthorizBean getAuthorizBean() {
		return authorizBean;
	}


	public void setAuthorizBean(AuthorizBean authorizBean) {
		this.authorizBean = authorizBean;
	}

}
