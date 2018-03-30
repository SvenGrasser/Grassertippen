package de.svennetz.grasser.tippspiel.memberSummaries.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.svennetz.base.logging.Log;
import de.svennetz.grasser.tippspiel.memberSummaries.business.IMemberSummaryBean;
import de.svennetz.grasser.tippspiel.memberSummaries.business.MemberSummary;

@Path("members")
@Stateless
public class MemberSummaryResource {	
	@EJB
	private IMemberSummaryBean memberSummaryBean;
	
	private static final Log log = new Log(MemberSummaryResource.class);
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<MemberSummary> getMemberSummaryList() {
		log.info("getMemberSummaryList");
		return memberSummaryBean.getMemberSummaryList();
	}
}
