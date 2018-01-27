package de.svennetz.grasser.tippspiel.repositories;

import java.util.List;

import de.svennetz.grasser.tippspiel.entities.Tournament;

public interface ITournamentRepository {
	List<Tournament> readList();
}
