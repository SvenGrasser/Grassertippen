package de.svennetz.grasser.tippspiel.tournaments.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
}
