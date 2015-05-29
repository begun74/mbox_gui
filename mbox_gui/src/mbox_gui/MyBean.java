package mbox_gui;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped 
public class MyBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8919828040321221334L;
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
		if (getName().equalsIgnoreCase("111"))
		{	
			getNavBean().getUser().setName(getName());
			getNavBean().getUser().setPass(getPass());
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
