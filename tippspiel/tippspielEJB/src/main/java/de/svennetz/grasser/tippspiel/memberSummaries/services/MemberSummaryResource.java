package de.svennetz.grasser.tippspiel.memberSummaries.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.svennetz.grasser.tippspiel.base.ResourceBase;
import de.svennetz.grasser.tippspiel.memberSummaries.business.IMemberSummaryBean;
import de.svennetz.grasser.tippspiel.memberSummaries.business.MemberSummary;

@Path("members")
@Stateless
public class MemberSummaryResource extends ResourceBase {	
	@EJB
	private IMemberSummaryBean memberSummaryBean;	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<MemberSummary> getMemberSummaryList() {
		return memberSummaryBean.getMemberSummaryList();
	}
}

