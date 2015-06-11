package mbox_gui.util;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.*;
import javax.faces.event.AjaxBehaviorEvent;

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
	private List<String> listItems = new ArrayList<String>();	
	@ManagedProperty(value="#{navBean}")
	private NavBean navBean;

	
	public CollectBean() {
		System.out.println("CollectBean");
		
		int i =1;
		while (i<=100 ) 
			listItems.add("item "+ i++);

		listItems.add("bvv@minsk.gov.by");
		listItems.add("dim@minsk.gov.by");
		listItems.add("bvv2@minsk.gov.by");

		setItemList(listItems);
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
		Thread.sleep(500);  //System.out.println("showBalance"); 
		Iterator<String> iter = listItems.iterator();
		ArrayList new_itemList = new ArrayList();
		
		while(iter.hasNext()) 
		{
			String item = iter.next();
			if(item.indexOf(navBean.getMessage()) != -1) 
				new_itemList.add(item);
		}
		setItemList(new_itemList);
		
		} catch(InterruptedException ie) {}
		return null;
	}

}
