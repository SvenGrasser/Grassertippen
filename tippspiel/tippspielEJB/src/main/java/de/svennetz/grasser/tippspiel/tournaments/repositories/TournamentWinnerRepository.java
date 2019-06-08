package de.svennetz.grasser.tippspiel.tournaments.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.tournaments.business.Tournament;
import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentAverageAllTippers;
import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentEntity;
import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentWinnerEntity;

@Stateless
public class TournamentWinnerRepository implements ITournamentWinnerRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<TournamentWinnerEntity> findAll() {
		TypedQuery<TournamentWinnerEntity> query = entityManager.createQuery("SELECT DISTINCT t FROM TournamentWinnerEntity t INNER JOIN t.tournamentWinnerResults tr INNER JOIN tr.member m WHERE t.id=tr.tournamentId ORDER BY t.date ASC", TournamentWinnerEntity.class);
	    return query.getResultList();
	}	

	@Override
	public List<TournamentAverageAllTippers> findAllAverageTippers() {
		String statement = String.format(
				"SELECT r.tournamentId, AVG(r.result) as averageAllTippers FROM TournamentResultEntity r GROUP BY r.tournamentId ORDER BY r.tournamentId ASC");
		List<Object[]> results = entityManager.createQuery(statement).getResultList();
		
		List<TournamentAverageAllTippers> tournamentsAverageAllTippers = new ArrayList<TournamentAverageAllTippers>();
		for(Object[] record : results) {
			TournamentAverageAllTippers tournamentAverageAllTippers = new TournamentAverageAllTippers((int)record[0], (Double)record[1]);
			tournamentsAverageAllTippers.add(tournamentAverageAllTippers);
		}
		
		return tournamentsAverageAllTippers;
	}
}
