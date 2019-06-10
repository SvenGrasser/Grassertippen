package de.svennetz.grasser.tippspiel.tournaments.repositories;

import java.util.List;

import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentAverageAllTippers;
import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentWinnerEntity;

public interface ITournamentWinnerRepository {
	List<TournamentWinnerEntity> findAll();
	List<TournamentAverageAllTippers> findAllAverageTippers();
}
