package de.svennetz.grasser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import de.svennetz.grasser.tippspiel.tournaments.business.ITournamentBean;
import de.svennetz.grasser.tippspiel.tournaments.business.Tournament;
import de.svennetz.grasser.tippspiel.tournaments.business.TournamentBean;
import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentEntity;
import de.svennetz.grasser.tippspiel.tournaments.repositories.ITournamentRepository;

@RunWith(MockitoJUnitRunner.class)
public class TournamentBeanTest {
	private ITournamentBean tournamentBean;

	@Mock
	ITournamentRepository mockRepository;

	@Before
	public void setup() {
		tournamentBean = new TournamentBean(mockRepository);
	}

	@Test
	public void testGetTournaments() {
		Mockito.when(mockRepository.readList()).thenReturn(new ArrayList<TournamentEntity>());

		List<Tournament> tournaments = tournamentBean.getTournaments();
		assertTrue(tournaments != null);
		assertTrue(Integer.compare(tournaments.size(), 0) == 0);
	}

}
