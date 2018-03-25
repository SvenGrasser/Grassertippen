package de.svennetz.grasser.tippspiel.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.entities.Tournament;

@Stateless
public class TournamentRepository implements ITournamentRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Tournament> readList() {
		String statement = String.format("SELECT t FROM Tournament t");
		TypedQuery<Tournament> queryTournament = entityManager.createQuery(statement, Tournament.class);
		return queryTournament.getResultList();
	}

}
