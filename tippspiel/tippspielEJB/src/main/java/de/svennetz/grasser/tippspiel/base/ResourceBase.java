package de.svennetz.grasser.tippspiel.base;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import de.svennetz.base.logging.Log;

public abstract class ResourceBase {
	private Log log;
	
	public ResourceBase() {
		this.log = new Log(this.getClass());
	}

	@AroundInvoke
	protected Object doLog(InvocationContext ic) {
		Object obj = null;
		long startTime = System.currentTimeMillis();
		try {
			String message = getApplicationLogInfo();
			message += String.format(" %s=%s %s=%s", "action", "entering", "method", ic.getMethod().getName());
			log.info(message);
			obj = ic.proceed();
		} catch (Exception e) {
			String message = getApplicationLogInfo();
			message += String.format(" %s=%s %s=%s", "method", ic.getMethod().getName(), "exception", e.toString());
			log.error(message);
		} finally {
			long stopTime = System.currentTimeMillis();
			long elapsed = (stopTime - startTime);
			String message = getApplicationLogInfo();
			message += String.format(" %s=%s %s=%s %s=%s", "action", "exiting", "method", ic.getMethod().getName(), "duration", elapsed);
			log.info(message);
		}

		return obj;
	}
	
	private String getApplicationLogInfo( ) {		
		return String.format("%s=%s", "application", "tippspiel");
	}
}
