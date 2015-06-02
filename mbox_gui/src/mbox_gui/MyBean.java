package mbox_gui;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import mbox_gui.util.AuthorizBean;
import mbox_gui.view.User;


@ManagedBean
@RequestScoped 
public class MyBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 891988040311334L;
	private String name="";
	private String pass="";
	
	@ManagedProperty(value="#{navBean}")
	private NavBean navBean;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String login() {
			//getNavBean().getUser().setName(getName());
			//getNavBean().getUser().setPass(getPass());
			
			if(getNavBean().getAuthorizBean().isLogin(getName(),getPass()))
			{
				User user = new User();
				user.setName(name);
				user.setPass(pass);
				getNavBean().setUser(user);
				return "1/1?faces-redirect=true";
			}
			else return null;
	}
	public NavBean getNavBean() {
		return navBean;
	}
	public void setNavBean(NavBean navBean) {
		this.navBean = navBean;
	}

}
