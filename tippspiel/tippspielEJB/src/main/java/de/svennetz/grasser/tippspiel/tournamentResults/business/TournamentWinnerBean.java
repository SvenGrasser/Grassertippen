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
			List<TournamentResultEntity> tournamentResults = tournamentResultRepository.readFilteredList(tournament.getId(), true);
			String winners = appendWinners(members, tournamentResults);
			TournamentWinner tw = new TournamentWinner(tournament.getDescription(), winners);
			tournamentWinners.add(tw);	
		}
		return tournamentWinners;
	}

	private String appendWinners(List<MemberEntity> members, List<TournamentResultEntity> tournamentResults) {
		TournamentResultEntity topTournamentResultEntity = null;		
		String winners = "";
		for(TournamentResultEntity tournamentResultEntity : tournamentResults) {
			if(topTournamentResultEntity == null) {
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
		return winners;
	}

	private String appendWinner(List<MemberEntity> members, String winners,
			TournamentResultEntity tournamentResultEntity) {
		MemberEntity member = members.stream().filter(m -> m.getId() == tournamentResultEntity.getMemberId()).findFirst().get();
		winners += member.getName();
		return winners;
	}

}
