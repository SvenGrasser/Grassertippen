package de.svennetz.grasser.tippspiel.repositories;

import java.util.List;

import de.svennetz.grasser.tippspiel.entities.TournamentResult;

public interface ITournamentResultRepository {
	List<TournamentResult> readSortedList();
	List<TournamentResult> readFilteredList(int tournamentId, boolean sortedByResult);
	List<TournamentResult> readFilteredList(List<Integer> tournamentIdList, int memberId);
}
