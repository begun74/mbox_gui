package mbox_gui.util;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
	@ValidEmail 
	private String selItem;
	private String message;
	private List<String> listItems = new ArrayList<String>();
	private List<Integer> listYYYY = new ArrayList<Integer>();
	private List<Integer> listMM = new ArrayList<Integer>();
	private List<Integer> listDD = new ArrayList<Integer>();
	

	@ManagedProperty(value="#{navBean}")
	private NavBean navBean;

	
	public CollectBean() {

		Calendar rightNow = Calendar.getInstance();
		int yyyy=rightNow.get(Calendar.YEAR);
		int dd =1;
		int mm =1;
		
		int i =1;
		while (i<=100 ) 
			listItems.add("item "+ i++);

		

		setItemList(listItems);
		
		while(dd <=31)  getListDD().add(dd++);
		while(mm <=12)  getListMM().add(mm++);
		while(yyyy <=rightNow.get(Calendar.YEAR)+3)	getListYYYY().add(yyyy++);
		System.out.println("CollectBean");
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

	public String getSelItem() {
		return selItem;
	}

	public void setSelItem(String selItem) {
		System.out.println("CollectBean.setSelItems - "+selItem);
		navBean.setMessage(selItem);
		this.selItem = selItem;
	}
	
	public String showBalance() {
		try { //if(navBean.getMessage() == null) throw new Exception();
		Thread.sleep(200);  //System.out.println("showBalance"); 
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

	public List<Integer> getListMM() {
		return listMM;
	}

	public void setListMM(List<Integer> listMM) {
		this.listMM = listMM;
	}

	public List<Integer> getListYYYY() {
		return listYYYY;
	}

	public void setListYYYY(List<Integer> listYYYY) {
		this.listYYYY = listYYYY;
	}

	public List<Integer> getListDD() {
		return listDD;
	}

	public void setListDD(List<Integer> listDD) {
		this.listDD = listDD;
	}


}
