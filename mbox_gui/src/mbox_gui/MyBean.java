package mbox_gui;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.*;
import javax.faces.event.AjaxBehaviorEvent;


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
	private boolean passwordEditable = false;
	private String message;
	private String ajaxMessage;
	
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

	public String submit() {
		System.out.println("MyBean.submit  message - "+name);
		return "2?faces-redirect=true";
	}

	public NavBean getNavBean() {
		return navBean;
	}
	public void setNavBean(NavBean navBean) {
		this.navBean = navBean;
	}
	public boolean isPasswordEditable() {
		if(getPass().equals("ôûâ"))
		System.out.println("isPasswordEditable - "+getPass());
		
		message = getPass();
		return passwordEditable;
	}
	public void setPasswordEditable(boolean passwordEditable) {
		this.passwordEditable = passwordEditable;
		System.out.println("setPasswordEditable");

	}
	public String getMessage() {
		return navBean.getMessage();
	}
	public void setMessage(String message) {
		navBean.setMessage(message); 
	}
	public String getAjaxMessage() {
		return ajaxMessage;
	}
	public void setAjaxMessage(String ajaxMessage) {
		this.ajaxMessage = ajaxMessage;
	}
	
	public void namedChanged(AjaxBehaviorEvent event) {
		if(!(name.equals("222") || name.equals("111"))) 
			navBean.setMessage("namedChanged " + name +pass);
		else
			navBean.setMessage(null);
		System.out.println(navBean.getMessage());
	}

}
