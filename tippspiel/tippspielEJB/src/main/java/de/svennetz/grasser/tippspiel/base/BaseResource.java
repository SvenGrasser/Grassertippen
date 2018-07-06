package de.svennetz.grasser.tippspiel.base;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import de.svennetz.base.logging.Log;

public abstract class BaseResource {

	protected abstract Log getLog();

	@AroundInvoke
	protected Object doLog(InvocationContext ic) {
		Object obj = null;
		try {
			String message = getApplicationLogInfo();
			message += String.format(" %s=%s %s=%s", "action", "entering", "method", ic.getMethod().getName());
			getLog().info(message);
			obj = ic.proceed();
		} catch (Exception e) {
			String message = getApplicationLogInfo();
			message += String.format(" %s=%s %s=%s", "method", ic.getMethod().getName(), "exception", e.toString());
			getLog().error(message);
		} finally {
			String message = getApplicationLogInfo();
			message += String.format(" %s=%s %s=%s", "action", "exiting", "method", ic.getMethod().getName());
			getLog().info(message);
		}

		return obj;
	}
	
	private String getApplicationLogInfo( ) {
		return String.format("%s=%s", "application", "tippspiel");
	}
}
