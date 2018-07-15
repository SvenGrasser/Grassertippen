package de.svennetz.grasser.tippspiel.tournaments.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.svennetz.grasser.tippspiel.tournamentResults.entities.TournamentWinnerResultEntity;
import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentWinnerEntity;
import de.svennetz.grasser.tippspiel.tournaments.repositories.ITournamentRepository;

@Stateless
public class TournamentWinnerBean implements ITournamentWinnerBean {

	@EJB
	private ITournamentRepository tournamentRepository;

	@Override
	public List<TournamentWinner> getTournamentWinners() {
		List<TournamentWinner> tournamentWinners = new ArrayList<TournamentWinner>();
		List<TournamentWinnerEntity> tournamentWinnerEntity = tournamentRepository.readList();
		for (TournamentWinnerEntity tournament : tournamentWinnerEntity) {
			addWinners(tournamentWinners, tournament);
		}

		return tournamentWinners;
	}

	private void addWinners(List<TournamentWinner> tournamentWinners, TournamentWinnerEntity tournament) {
		TournamentWinner tw = new TournamentWinner(tournament.getDescriptionShort());
		String winners = "";
		int result = 0;
		Double matchDayVictory = null;
		for (TournamentWinnerResultEntity tournamentResult : tournament.getTournamentWinnerResults()) {
			if (result == 0 && matchDayVictory == null) {
				result = tournamentResult.getResult();
				matchDayVictory = tournamentResult.getMatchDayVictory();
				tw.setResult(tournamentResult.getResult());
				tw.setMatchDayVictory(tournamentResult.getMatchDayVictory());
				winners = appendWinner(winners, tournamentResult);
			} else if (result == tournamentResult.getResult()
					&& matchDayVictory == tournamentResult.getMatchDayVictory()) {
				winners = appendWinner(winners, tournamentResult);
			} else {
				break;
			}
		}
		tw.setWinner(winners);
		tournamentWinners.add(tw);
	}	

	private String appendWinner(String winners, TournamentWinnerResultEntity tournamentWinnerResultEntity) {
		if(!winners.isEmpty()) {
			winners += ", ";			
		}
		winners += tournamentWinnerResultEntity.getMember().getName();
		return winners;
	}
}
