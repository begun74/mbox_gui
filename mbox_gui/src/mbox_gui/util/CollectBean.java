package mbox_gui.util;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;

import mbox_gui.MyBean;
import mbox_gui.NavBean;

@ManagedBean
@SessionScoped 


public class CollectBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7423638834312196351L;
	private List<String> itemList;	
	private String selItem;
	
	private String message;
	
	@ManagedProperty(value="#{navBean}")
	private NavBean navBean;
	
	public CollectBean() {
		setItemList(new ArrayList<String>());
		getItemList().add("item 1");
		getItemList().add("item 2");
		getItemList().add("item 3");
		getItemList().add("item 4");
		getItemList().add("item 5");
	}

	public List<String> getItemList() {
		return itemList;
	}

	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}


	public NavBean getNavBean() {
		return navBean;
	}

	public void setNavBean(NavBean navBean) {
		this.navBean = navBean;
	}
	

	public String getMessage() {
		return navBean.getMessage();
	}
	public void setMessage(String message) {
		navBean.setMessage(message); 
	}

	public String getSelItems() {
		return selItem;
	}

	public void setSelItems(String selItem) {
		System.out.println("CollectBean.setSelItems - "+selItem);
		navBean.setMessage(selItem);
		this.selItem = selItem;
	}
	
	public String showBalance() {
		try { 
		Thread.sleep(1000);  System.out.println("showBalance"); 
		} catch(InterruptedException ie) {}
		return null;
	}

}
