package de.svennetz.grasser.tippspiel.tournamentResults.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.svennetz.base.logging.Log;
import de.svennetz.grasser.tippspiel.base.BaseResource;
import de.svennetz.grasser.tippspiel.tournamentResults.business.ITournamentWinnerBean;
import de.svennetz.grasser.tippspiel.tournamentResults.business.TournamentWinner;

@Path("tournamentWinners")
@Stateless
public class TournamentWinnerResource extends BaseResource {

	@EJB
	private ITournamentWinnerBean tournamentWinnerBean;
	private static final Log log = new Log(TournamentWinnerResource.class);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<TournamentWinner> getTournamentList() {		
		return tournamentWinnerBean.getTournamentWinners();
	}

	@Override
	protected Log getLog() {
		return log;
	}
}
