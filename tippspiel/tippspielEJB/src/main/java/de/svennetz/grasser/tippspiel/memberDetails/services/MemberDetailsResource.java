package de.svennetz.grasser.tippspiel.memberDetails.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.svennetz.base.logging.Log;
import de.svennetz.grasser.tippspiel.base.BaseResource;
import de.svennetz.grasser.tippspiel.memberDetails.business.IMemberDetailsBean;
import de.svennetz.grasser.tippspiel.memberDetails.business.MemberDetails;



@Path("members")
@Stateless
public class MemberDetailsResource extends BaseResource {	
	@EJB
	private IMemberDetailsBean memberDetailsBean;	
	private static final Log log = new Log(MemberDetailsResource.class);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("{id}")
	public List<MemberDetails> getMemberDetails(@PathParam("id") int id) {
		return memberDetailsBean.getMemberDetails(id);
	}

	@Override
	protected Log getLog() {
		return log;
	}

}
