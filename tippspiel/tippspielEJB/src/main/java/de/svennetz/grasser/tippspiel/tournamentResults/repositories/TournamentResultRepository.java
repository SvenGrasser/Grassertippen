package de.svennetz.grasser.tippspiel.tournamentResults.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.tournamentResults.entities.TournamentResultEntity;

@Stateless
public class TournamentResultRepository implements ITournamentResultRepository {

	@PersistenceContext
	private EntityManager entityManager;	
	
	@Override
	public List<TournamentResultEntity> readSortedList() {
		String statement = String.format(
				"SELECT r FROM TournamentResultEntity r ORDER BY r.tournamentId, r.result DESC");
		return  entityManager.createQuery(statement, TournamentResultEntity.class).getResultList();
	}

	@Override
	public List<TournamentResultEntity> readFilteredList(int tournamentId, boolean sortedByResult) {
		String statement = String.format("SELECT r FROM TournamentResultEntity r where r.tournamentId=:tournamentId");
		if(sortedByResult) {
			statement += " ORDER BY Result DESC";
		}
		
		TypedQuery<TournamentResultEntity> queryTournamentResult = entityManager
				.createQuery(statement, TournamentResultEntity.class);
		queryTournamentResult.setParameter("tournamentId", tournamentId);		
		return queryTournamentResult.getResultList();
	}

	@Override
	public List<TournamentResultEntity> readFilteredList(List<Integer> tournamentIdList, int memberId) {
		String statement = String.format(
				"SELECT r FROM TournamentResultEntity r where r.memberId = :memberId and r.tournamentId in (:tournamentIdList)");
		TypedQuery<TournamentResultEntity> queryTournamentResult = entityManager
				.createQuery(statement, TournamentResultEntity.class);
		queryTournamentResult.setParameter("memberId", memberId);
		queryTournamentResult.setParameter("tournamentIdList", tournamentIdList);		
		return queryTournamentResult.getResultList();	
	}

}
