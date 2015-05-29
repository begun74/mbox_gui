package mbox_gui;

import java.io.Serializable;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

@ManagedBean

public class AuthorizationListener implements PhaseListener , Serializable{
	 
/**
	 * 
	 */
	private static final long serialVersionUID = -4262922656197664710L;

	@ManagedProperty(value="#{navBean}")
	private NavBean nB;
	
public void afterPhase(PhaseEvent event) {
	//System.out.println("AuthorizationListener - '" + event.getPhaseId() + "'  '" + event.getSource());
	/*
 
	FacesContext facesContext = event.getFacesContext();
	String currentPage = facesContext.getViewRoot().getViewId();
 
	boolean isLoginPage = (currentPage.lastIndexOf("login.xhtml") > -1);
		
	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
 
	if(session==null){
		NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
		nh.handleNavigation(facesContext, null, "loginPage");
	}
 
	else{
		Object currentUser = getnB().getUser().getName();
 
		if (!isLoginPage && (currentUser == null || currentUser == "")) {
			NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
			nh.handleNavigation(facesContext, null, "loginPage");	
		}
		
		
	} */
}
 
	public void beforePhase(PhaseEvent event) {
		//System.out.println("AuthorizationListener - '" + event.getPhaseId() + "'  '" + event.getSource());

	}
 
	public PhaseId getPhaseId() {
		
		return PhaseId.RESTORE_VIEW;
	}

	private NavBean getnB() {
		return nB;
	}

	private void setnB(NavBean nB) {
		this.nB = nB;
	}
}
