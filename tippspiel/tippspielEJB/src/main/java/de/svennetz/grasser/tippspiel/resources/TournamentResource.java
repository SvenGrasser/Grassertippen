package de.svennetz.grasser.tippspiel.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.svennetz.grasser.tippspiel.beans.ITournamentBean;
import de.svennetz.grasser.tippspiel.entities.Tournament;


@Path("tournaments")
@Stateless
public class TournamentResource {
	
	@EJB
	private ITournamentBean tournamentBean;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Tournament> getTournamentList() {		
		return tournamentBean.getTournaments();
	}

}
