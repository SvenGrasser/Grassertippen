package de.svennetz.grasser.tippspiel.tournaments.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentEntity;
import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentWinnerEntity;

@Stateless
public class TournamentRepository implements ITournamentRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<TournamentEntity> readList(Boolean sortByTournamentType) {
		String statement = String.format("SELECT t FROM TournamentEntity t");		
		if(sortByTournamentType) {
			statement += " ORDER BY t.tournamentType ASC";
		} else {
			statement += " ORDER BY t.date ASC";
		}
		
		TypedQuery<TournamentEntity> queryTournament = entityManager.createQuery(statement, TournamentEntity.class);
		return queryTournament.getResultList();
	}

	@Override
	public List<TournamentWinnerEntity> readList() {
		TypedQuery<TournamentWinnerEntity> query = entityManager.createQuery("SELECT DISTINCT t FROM TournamentWinnerEntity t INNER JOIN t.tournamentWinnerResults tr INNER JOIN tr.member m WHERE t.id=tr.tournamentId ORDER BY t.date ASC", TournamentWinnerEntity.class);
	    return query.getResultList();
	}
}
