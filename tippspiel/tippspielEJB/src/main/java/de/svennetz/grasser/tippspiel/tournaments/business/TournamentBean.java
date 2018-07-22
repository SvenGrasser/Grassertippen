package de.svennetz.grasser.tippspiel.tournaments.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentEntity;
import de.svennetz.grasser.tippspiel.tournaments.repositories.ITournamentRepository;


@Stateless
public class TournamentBean implements ITournamentBean {
	@EJB
	private ITournamentRepository tournamentRepository;
	
	public TournamentBean() {
	}
	
	public TournamentBean(ITournamentRepository repository) {
		tournamentRepository = repository;
	}
	
	@Override
	public List<Tournament> getTournaments() {
		List<TournamentEntity> tournamentEntities = tournamentRepository.findAll();
		
		List<Tournament> tournaments = new ArrayList<Tournament>(tournamentEntities.size());
		for(TournamentEntity tournamentEntity : tournamentEntities) {
			Tournament tournament = new Tournament(tournamentEntity.getId(), tournamentEntity.getDescriptionShort(), tournamentEntity.getDescription());
			tournaments.add(tournament);
		}
		
		return tournaments;
	}
}
