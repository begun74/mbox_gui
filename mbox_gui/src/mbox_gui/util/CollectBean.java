package mbox_gui.util;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;

@ManagedBean
@SessionScoped 


public class CollectBean {
	
	private List<String> itemList;	
	
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

}
