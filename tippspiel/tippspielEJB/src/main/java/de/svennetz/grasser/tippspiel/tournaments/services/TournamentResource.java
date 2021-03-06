package de.svennetz.grasser.tippspiel.tournaments.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.svennetz.grasser.tippspiel.base.ResourceBase;
import de.svennetz.grasser.tippspiel.tournaments.business.ITournamentBean;
import de.svennetz.grasser.tippspiel.tournaments.business.Tournament;


@Path("tournaments")
@Stateless
public class TournamentResource extends ResourceBase {
	
	@EJB
	private ITournamentBean tournamentBean;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Tournament> getTournamentList() {		
		return tournamentBean.getTournaments();
	}
}
