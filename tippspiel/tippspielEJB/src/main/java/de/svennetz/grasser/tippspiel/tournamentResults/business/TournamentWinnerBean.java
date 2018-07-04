package de.svennetz.grasser.tippspiel.tournamentResults.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.svennetz.grasser.tippspiel.members.business.IMemberBean;
import de.svennetz.grasser.tippspiel.members.entities.MemberEntity;
import de.svennetz.grasser.tippspiel.tournamentResults.entities.TournamentResultEntity;
import de.svennetz.grasser.tippspiel.tournamentResults.repositories.ITournamentResultRepository;
import de.svennetz.grasser.tippspiel.tournaments.business.ITournamentBean;
import de.svennetz.grasser.tippspiel.tournaments.business.Tournament;

@Stateless
public class TournamentWinnerBean implements ITournamentWinnerBean {

	@EJB
	private IMemberBean memberBean;
	@EJB
	private ITournamentBean tournamentBean;
	@EJB
	private ITournamentResultRepository tournamentResultRepository;
	
	@Override
	public List<TournamentWinner> getTournamentWinners() {		
		List<Tournament> tournaments = tournamentBean.getTournaments();
		List<TournamentWinner> tournamentWinners = new ArrayList<TournamentWinner>();
		List<MemberEntity> members = memberBean.getMembers();
		
		for(Tournament tournament : tournaments) {			
			TournamentWinner tw = getWinner(members, tournament);
			tournamentWinners.add(tw);	
		}
		return tournamentWinners;
	}

	private TournamentWinner getWinner(List<MemberEntity> members, Tournament tournament) {
		List<TournamentResultEntity> tournamentResults = tournamentResultRepository.readFilteredList(tournament.getId(), true);
		TournamentWinner tournamentWinner = new TournamentWinner(tournament.getDescription());
	    TournamentResultEntity topTournamentResultEntity = null;		
		String winners = "";
		int result = 0;
		Double matchDayVictory = null;
		for(TournamentResultEntity tournamentResultEntity : tournamentResults) {
			if(topTournamentResultEntity == null) {
				result = tournamentResultEntity.getResult();
				matchDayVictory = tournamentResultEntity.getMatchDayVictory();
				topTournamentResultEntity = tournamentResultEntity;
				winners = appendWinner(members, winners, tournamentResultEntity);
			}				
			else if(tournamentResultEntity.getResult() == topTournamentResultEntity.getResult() &&
					tournamentResultEntity.getMatchDayVictory() == topTournamentResultEntity.getMatchDayVictory()) {
				winners += ",";
				winners = appendWinner(members, winners, tournamentResultEntity);
			}
			else {
				break;
			}
		}
		tournamentWinner.setWinner(winners);
		tournamentWinner.setResult(result);
		tournamentWinner.setMatchDayVictory(matchDayVictory);
		return tournamentWinner;
	}

	private String appendWinner(List<MemberEntity> members, String winners,
			TournamentResultEntity tournamentResultEntity) {
		MemberEntity member = members.stream().filter(m -> m.getId() == tournamentResultEntity.getMemberId()).findFirst().get();
		winners += member.getName();
		return winners;
	}

}
