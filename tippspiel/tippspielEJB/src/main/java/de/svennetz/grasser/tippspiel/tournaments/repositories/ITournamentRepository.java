package de.svennetz.grasser.tippspiel.tournaments.repositories;

import java.util.List;

import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentEntity;
import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentWinnerEntity;

public interface ITournamentRepository {
	List<TournamentEntity> readList(Boolean sortByTournamentType);
	List<TournamentWinnerEntity> readList();
}
