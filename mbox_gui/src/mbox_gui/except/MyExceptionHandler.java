package mbox_gui.except;

import java.util.Iterator;

import javax.faces.FacesException;
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
		System.out.println("getWrapped"+" "+this.exceptionHandler );
		return this.exceptionHandler;
	}
	
	@Override
    public void handle() throws FacesException 
	{
		System.out.println("handle()");
		
		for(Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();i.hasNext();)
        {
			ExceptionQueuedEvent exceptionQueuedEvent =i.next();
            System.out.println("Iterating over ExceptionQueuedEvents.current:"+exceptionQueuedEvent.toString());
            
            ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext) exceptionQueuedEvent.getSource();
            
            Throwable throwable = exceptionQueuedEventContext.getException();
        }
		
	}

}
