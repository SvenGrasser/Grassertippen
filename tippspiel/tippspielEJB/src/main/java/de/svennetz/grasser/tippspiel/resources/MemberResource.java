package de.svennetz.grasser.tippspiel.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.svennetz.grasser.tippspiel.Member.MemberDetails;
import de.svennetz.grasser.tippspiel.Member.MemberSummary;
import de.svennetz.grasser.tippspiel.beans.IMemberDetailsBean;
import de.svennetz.grasser.tippspiel.beans.IMemberSummaryBean;
import de.svennetz.grasser.utility.logging.Log;



@Path("members")
@Stateless
public class MemberResource {	
	@EJB
	private IMemberSummaryBean memberSummaryBean;
	@EJB
	private IMemberDetailsBean memberDetailsBean;
	
	private static final Log log = new Log(MemberResource.class);
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<MemberSummary> getMemberSummaryList() {
		log.info("getMemberSummaryList");
		return memberSummaryBean.getMemberSummaryList();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("{id}")
	public List<MemberDetails> getMemberDetails(@PathParam("id") int id) {
		log.info("getMemberDetails");		
		return memberDetailsBean.getMemberDetails(id);
	}

}
