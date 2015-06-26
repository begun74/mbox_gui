package mbox_gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.*;
import javax.faces.event.AjaxBehaviorEvent;






import mbox_gui.util.CollectBean;
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

	private String _yyyy="";
	private String _mm="";
	private String _dd="";
	private List <String> selListYYYY = new ArrayList<String>();
	
	
	@ManagedProperty(value="#{navBean}")
	private NavBean navBean;

	@ManagedProperty(value="#{collectBean}")
	private CollectBean collectBean;
	
	public MyBean() {
		Calendar rightNow = Calendar.getInstance();
		_yyyy = rightNow.get(Calendar.YEAR)+"";
		_mm = rightNow.get(Calendar.MONTH)+1 +"";
		_dd = rightNow.get(Calendar.DAY_OF_MONTH) +"";
		
		
	}

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

	public String submit()  {
		
		System.out.println("MyBean.submit  message - "+navBean.getMessage());
		System.out.println(getSelListYYYY()+" "+get_mm()+" "+get_dd());
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
	public String getMessage() {System.out.println(navBean.getMessage());
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
		navBean.setMessage(name);
		getCollectBean().showBalance();		
		System.out.println("navBean.getMessage() - " +navBean.getMessage());
	}
	public CollectBean getCollectBean() {
		return collectBean;
	}
	public void setCollectBean(CollectBean collectBean) {
		this.collectBean = collectBean;
	}
	public String get_yyyy() {
		return _yyyy;
	}
	public void set_yyyy(String _yyyy) {
		this._yyyy = _yyyy;
	}
	public String get_mm() {
		return _mm;
	}
	public void set_mm(String _mm) {
		this._mm = _mm;
	}
	public String get_dd() {
		return _dd;
	}
	public void set_dd(String _dd) {
		this._dd = _dd;
	}

	public List <String> getSelListYYYY() {
		return selListYYYY;
	}

	public void setSelListYYYY(List <String> selListYYYY) {
		this.selListYYYY = selListYYYY;
	}

}
