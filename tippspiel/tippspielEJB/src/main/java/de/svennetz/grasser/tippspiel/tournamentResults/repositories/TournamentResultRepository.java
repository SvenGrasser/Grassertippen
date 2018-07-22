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
	public List<TournamentResultEntity> findAll() {
		String statement = String.format(
				"SELECT r FROM TournamentResultEntity r ORDER BY r.tournamentId ASC, r.result DESC, matchDayVictory DESC");
		return  entityManager.createQuery(statement, TournamentResultEntity.class).getResultList();
	}

	@Override
	public List<TournamentResultEntity> findAllByTournamentId(int tournamentId) {
		String statement = String.format("SELECT r FROM TournamentResultEntity r where r.tournamentId=:tournamentId ORDER BY r.result DESC, matchDayVictory DESC");
				
		TypedQuery<TournamentResultEntity> queryTournamentResult = entityManager
				.createQuery(statement, TournamentResultEntity.class);
		queryTournamentResult.setParameter("tournamentId", tournamentId);		
		return queryTournamentResult.getResultList();
	}

	@Override
	public List<TournamentResultEntity> findAllByMemberAndTournaments(List<Integer> tournamentIdList, int memberId) {
		String statement = String.format(
				"SELECT r FROM TournamentResultEntity r where r.memberId = :memberId and r.tournamentId in (:tournamentIdList)");
		TypedQuery<TournamentResultEntity> queryTournamentResult = entityManager
				.createQuery(statement, TournamentResultEntity.class);
		queryTournamentResult.setParameter("memberId", memberId);
		queryTournamentResult.setParameter("tournamentIdList", tournamentIdList);		
		return queryTournamentResult.getResultList();	
	}

}
