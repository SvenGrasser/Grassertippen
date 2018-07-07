package de.svennetz.grasser.tippspiel.tournamentResults.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.svennetz.grasser.tippspiel.base.ResourceBase;
import de.svennetz.grasser.tippspiel.tournamentResults.business.ITournamentWinnerBean;
import de.svennetz.grasser.tippspiel.tournamentResults.business.TournamentWinner;

@Path("tournamentWinners")
@Stateless
public class TournamentWinnerResource extends ResourceBase {

	@EJB
	private ITournamentWinnerBean tournamentWinnerBean;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<TournamentWinner> getTournamentList() {		
		return tournamentWinnerBean.getTournamentWinners();
	}
}
