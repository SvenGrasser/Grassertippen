package de.svennetz.grasser.tippspiel.tournamentResults.repositories;

import java.util.List;

import de.svennetz.grasser.tippspiel.tournamentResults.entities.TournamentResultEntity;

public interface ITournamentResultRepository {
	List<TournamentResultEntity> readSortedList();
	List<TournamentResultEntity> readFilteredList(int tournamentId, boolean sortedByResult);
	List<TournamentResultEntity> readFilteredList(List<Integer> tournamentIdList, int memberId);
}
