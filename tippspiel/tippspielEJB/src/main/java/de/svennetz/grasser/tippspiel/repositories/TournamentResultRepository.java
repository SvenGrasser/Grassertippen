package de.svennetz.grasser.tippspiel.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.entities.TournamentResult;

@Stateless
public class TournamentResultRepository implements ITournamentResultRepository {

	@PersistenceContext
	private EntityManager entityManager;	
	
	@Override
	public List<TournamentResult> readSortedList() {
		String statement = String.format(
				"SELECT r FROM TournamentResult r ORDER BY r.tournamentId, r.result DESC");
		return  entityManager.createQuery(statement, TournamentResult.class).getResultList();
	}

	@Override
	public List<TournamentResult> readFilteredList(int tournamentId, boolean sortedByResult) {
		String statement = String.format("SELECT r FROM TournamentResult r where r.tournamentId=:tournamentId");
		if(sortedByResult) {
			statement += " ORDER BY Result DESC";
		}
		
		TypedQuery<TournamentResult> queryTournamentResult = entityManager
				.createQuery(statement, TournamentResult.class);
		queryTournamentResult.setParameter("tournamentId", tournamentId);		
		return queryTournamentResult.getResultList();
	}

	@Override
	public List<TournamentResult> readFilteredList(List<Integer> tournamentIdList, int memberId) {
		String statement = String.format(
				"SELECT r FROM TournamentResult r where r.memberId = :memberId and r.tournamentId in (:tournamentIdList)");
		TypedQuery<TournamentResult> queryTournamentResult = entityManager
				.createQuery(statement, TournamentResult.class);
		queryTournamentResult.setParameter("memberId", memberId);
		queryTournamentResult.setParameter("tournamentIdList", tournamentIdList);		
		return queryTournamentResult.getResultList();	
	}

}
