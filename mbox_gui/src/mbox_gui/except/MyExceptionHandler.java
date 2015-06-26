package mbox_gui.except;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.*;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class MyExceptionHandler extends ExceptionHandlerWrapper {
	
	private ExceptionHandler exceptionHandler;

	public MyExceptionHandler(ExceptionHandler exceptionHandler)
	{
		this.exceptionHandler = exceptionHandler;
	}
	
	
	
	@Override
	public ExceptionHandler getWrapped() 
	{
		//System.out.println("getWrapped"+" "+this.exceptionHandler );
		return this.exceptionHandler;
	}
	
	@Override
    public void handle() throws FacesException 
	{
		//System.out.println("handle()");
		
		for(Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();i.hasNext();)
        {
			ExceptionQueuedEvent exceptionQueuedEvent =i.next();
            //System.out.println("Iterating over ExceptionQueuedEvents.current:"+exceptionQueuedEvent.toString());
            
            ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext) exceptionQueuedEvent.getSource();
            
            Throwable throwable = exceptionQueuedEventContext.getException();
            
            if(throwable instanceof Throwable)
            {
            	System.out.println("Throwable!!!");
            	Throwable t = (Throwable)throwable;
                
                FacesContext facesContext = FacesContext.getCurrentInstance();
                 
                Map<String, Object> requestMap = facesContext.getExternalContext().getRequestMap();
                NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
                 
                try{System.out.println(t.getMessage()+"  "+t.getCause());
                    requestMap.put("currentView", t.getMessage());
                    facesContext.getExternalContext().getFlash().put("exceptioniNFO",t.getCause());
                    navigationHandler.handleNavigation(facesContext,null, "/error?faces-redirect=true");
                    facesContext.renderResponse();
                }finally{
                    i.remove();
                     
                }
            }
        }
		
	}

}
