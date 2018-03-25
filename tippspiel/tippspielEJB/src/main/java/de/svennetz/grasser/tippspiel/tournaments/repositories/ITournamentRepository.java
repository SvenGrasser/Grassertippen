package de.svennetz.grasser.tippspiel.tournaments.repositories;

import java.util.List;

import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentEntity;

public interface ITournamentRepository {
	List<TournamentEntity> readList();
}
