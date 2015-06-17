package mbox_gui.except;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class MyExcept extends ExceptionHandlerFactory {
	private ExceptionHandlerFactory parent;
	
	public MyExcept(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}
	
	@Override
	public ExceptionHandler getExceptionHandler() {
		ExceptionHandler eh = parent.getExceptionHandler();
        eh = new MyExceptionHandler(eh);
        
        return eh;
	}

}
