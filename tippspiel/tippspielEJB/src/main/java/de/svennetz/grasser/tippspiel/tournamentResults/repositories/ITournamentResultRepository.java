package de.svennetz.grasser.tippspiel.tournamentResults.repositories;

import java.util.List;

import de.svennetz.grasser.tippspiel.tournamentResults.entities.TournamentResultEntity;

public interface ITournamentResultRepository {
	List<TournamentResultEntity> findAll();
	List<TournamentResultEntity> findAllByTournamentId(int tournamentId);
	List<TournamentResultEntity> findAllByMemberAndTournaments(List<Integer> tournamentIdList, int memberId);
}
