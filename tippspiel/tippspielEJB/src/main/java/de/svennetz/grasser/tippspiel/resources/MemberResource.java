package de.svennetz.grasser.tippspiel.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import de.svennetz.grasser.tippspiel.Member.MemberDetails;
import de.svennetz.grasser.tippspiel.Member.MemberSummary;
import de.svennetz.grasser.tippspiel.beans.IMemberDetailsBean;
import de.svennetz.grasser.tippspiel.beans.IMemberSummaryBean;



@Path("members")
@Stateless
public class MemberResource {	
	@EJB
	private IMemberSummaryBean memberSummaryBean;
	@EJB
	private IMemberDetailsBean memberDetailsBean;
	
	private static final Logger logger = LogManager.getLogger(MemberResource.class);
	
	public MemberResource() {
		BasicConfigurator.configure();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<MemberSummary> getMemberSummaryList() {
		logger.info("TIPPSPIEL +++ Request getMemberSummaryList");
		return memberSummaryBean.getMemberSummaryList();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("{id}")
	public List<MemberDetails> getMemberDetails(@PathParam("id") int id) {		
		return memberDetailsBean.getMemberDetails(id);
	}

}
