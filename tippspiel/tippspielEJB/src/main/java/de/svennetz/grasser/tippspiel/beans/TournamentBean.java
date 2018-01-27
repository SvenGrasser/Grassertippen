package de.svennetz.grasser.tippspiel.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.svennetz.grasser.tippspiel.entities.Tournament;
import de.svennetz.grasser.tippspiel.repositories.ITournamentRepository;


@Stateless
public class TournamentBean implements ITournamentBean {
	@EJB
	private ITournamentRepository tournamentRepository;
	
	@Override
	public List<Tournament> getTournaments() {
		return tournamentRepository.readList();
	}
}
