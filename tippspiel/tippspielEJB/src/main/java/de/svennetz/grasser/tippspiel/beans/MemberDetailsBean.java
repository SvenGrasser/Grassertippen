package de.svennetz.grasser.tippspiel.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.svennetz.grasser.tippspiel.Member.MemberDetails;
import de.svennetz.grasser.tippspiel.entities.Member;
import de.svennetz.grasser.tippspiel.entities.Tournament;
import de.svennetz.grasser.tippspiel.entities.TournamentResult;
import de.svennetz.grasser.tippspiel.repositories.IMemberRepository;
import de.svennetz.grasser.tippspiel.repositories.ITournamentRepository;
import de.svennetz.grasser.tippspiel.repositories.ITournamentResultRepository;

@Stateless
public class MemberDetailsBean implements IMemberDetailsBean {
	@EJB
	private IMemberRepository memberRepository;
	@EJB
	private ITournamentRepository tournamentRepository;
	@EJB
	private ITournamentResultRepository tournamentResultRepository;
	
	@Override
	public List<MemberDetails> getMemberDetails(int id) {
		List<MemberDetails> detailsList = new ArrayList<MemberDetails>();
		Member member = memberRepository.readItem(id);
		List<Tournament> tournaments = tournamentRepository.readList();
		List<Integer> tournamentIdList = new ArrayList<Integer>();
		for(Tournament tournament : tournaments) {
			tournamentIdList.add(tournament.getId());
			Integer position = getTournamentPosition(id, tournament.getId());			
			MemberDetails details = new MemberDetails(member, tournament);
			details.setPosition(position);
			detailsList.add(details);			
		}
			
		List<TournamentResult> tournamentResultList = tournamentResultRepository.readFilteredList(tournamentIdList, id);		
		fillDetailsList(detailsList, tournamentResultList);		
		return detailsList;
	}

	private void fillDetailsList(List<MemberDetails> detailsList, List<TournamentResult> tournamentResultList) {
		for(TournamentResult tr : tournamentResultList) {
			MemberDetails details = getMemberDetails(tr, detailsList);
			if(details != null) {
				details.setScore(tr.getResult());
			}
		}
	}

	private MemberDetails getMemberDetails(TournamentResult tr, List<MemberDetails> detailsList) {
		MemberDetails result = null;
		for(MemberDetails m : detailsList) {
			if(m.getTournament().getId() == tr.getTournamentId()) {
				result = m;
				break;
			}
		}
		return result;		
	}
	
	private Integer getTournamentPosition(int memberId, int tournamentId) {
		List<TournamentResult> result = tournamentResultRepository.readFilteredList(tournamentId, true);		
		Integer position = null;
		for(int i = 0; i < result.size(); i++) {
			if(result.get(i).getMemberId() == memberId) {
				position = i + 1;
				break;
			}
		}
		return position;
	}

}
