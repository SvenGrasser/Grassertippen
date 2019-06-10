package de.svennetz.grasser.tippspiel.systemhealth;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

import de.svennetz.base.logging.Log;

@Stateless
public class SystemHealthTimerBean {
	private Log log;
	
	public SystemHealthTimerBean() {
		this.log = new Log(this.getClass());
	}
	
    @Schedule(second="*", minute="*/15",hour="*", persistent=false)
    public void checkSystem(){
    	this.log.info("Grassertippen works...");
    }
}
