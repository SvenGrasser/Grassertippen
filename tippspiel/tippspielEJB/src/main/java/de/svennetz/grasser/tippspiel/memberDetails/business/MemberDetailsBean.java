package de.svennetz.grasser.tippspiel.memberDetails.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.svennetz.grasser.tippspiel.tournamentResults.entities.TournamentResultEntity;
import de.svennetz.grasser.tippspiel.tournamentResults.repositories.ITournamentResultRepository;
import de.svennetz.grasser.tippspiel.tournaments.entities.TournamentEntity;
import de.svennetz.grasser.tippspiel.tournaments.repositories.ITournamentRepository;

@Stateless
public class MemberDetailsBean implements IMemberDetailsBean {
	@EJB
	private ITournamentRepository tournamentRepository;
	@EJB
	private ITournamentResultRepository tournamentResultRepository;
	
	@Override
	public List<MemberDetails> getMemberDetails(int id) {
		List<MemberDetails> detailsList = new ArrayList<MemberDetails>();
		List<TournamentEntity> tournaments = tournamentRepository.findAll();
		List<Integer> tournamentIdList = new ArrayList<Integer>();
		for(TournamentEntity tournament : tournaments) {
			tournamentIdList.add(tournament.getId());
			Integer position = getTournamentPosition(id, tournament.getId());			
			MemberDetails details = new MemberDetails(tournament.getId(), tournament.getDescriptionShort());
			details.setPosition(position);
			detailsList.add(details);			
		}
			
		List<TournamentResultEntity> tournamentResultList = tournamentResultRepository.findAllByMemberAndTournaments(tournamentIdList, id);		
		fillDetailsList(detailsList, tournamentResultList);		
		return detailsList;
	}

	private void fillDetailsList(List<MemberDetails> detailsList, List<TournamentResultEntity> tournamentResultList) {
		for(TournamentResultEntity tr : tournamentResultList) {
			MemberDetails details = getMemberDetails(tr, detailsList);
			if(details != null) {
				details.setScore(tr.getResult());
				details.setMatchDayVictory(tr.getMatchDayVictory());
			}
		}
	}

	private MemberDetails getMemberDetails(TournamentResultEntity tr, List<MemberDetails> detailsList) {
		MemberDetails result = null;
		for(MemberDetails m : detailsList) {
			if(m.getTournamentId() == tr.getTournamentId()) {
				result = m;
				break;
			}
		}
		return result;		
	}
	
	private Integer getTournamentPosition(int memberId, int tournamentId) {
		List<TournamentResultEntity> result = tournamentResultRepository.findAllByTournamentId(tournamentId);		
		Integer position = null;
		Integer positionGroup = 1;
		Integer positionGroupCount = 0;
		Integer currentResult = null;
		Double currentMatchDayVictory = null;
		for(int i = 0; i < result.size(); i++) {	
			if(currentResult == null || Integer.compare(currentResult, result.get(i).getResult()) != 0 || result.get(i).getMatchDayVictory() < currentMatchDayVictory) {
				currentResult = result.get(i).getResult();
				currentMatchDayVictory = result.get(i).getMatchDayVictory();
				positionGroup += positionGroupCount;
				positionGroupCount = 1;				
			} else {
				positionGroupCount += 1;
			}
			if(result.get(i).getMemberId() == memberId) {
				position = positionGroup;
				break;
			} else {
				
			}
		}
		return position;
	}

}
