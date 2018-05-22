package de.svennetz.grasser.tippspiel.tournaments.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentEntity;

@Stateless
public class TournamentRepository implements ITournamentRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<TournamentEntity> readList() {
		String statement = String.format("SELECT t FROM TournamentEntity t ORDER BY t.tournamentType ASC");
		TypedQuery<TournamentEntity> queryTournament = entityManager.createQuery(statement, TournamentEntity.class);
		return queryTournament.getResultList();
	}

}
