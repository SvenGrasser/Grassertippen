package de.svennetz.grasser.tippspiel.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.entities.Tournament;


@Stateless
public class TournamentBean implements ITournamentBean {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Tournament> getTournaments() {
		String statement = String.format("SELECT t FROM Tournament t");
		TypedQuery<Tournament> queryTournament = entityManager.createQuery(statement, Tournament.class);
		return queryTournament.getResultList();
	}
}
