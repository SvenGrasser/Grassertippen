package de.svennetz.grasser.tippspiel.memberSummaries.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.svennetz.grasser.tippspiel.members.entities.MemberEntity;
import de.svennetz.grasser.tippspiel.members.repositories.IMemberRepository;
import de.svennetz.grasser.tippspiel.tournamentResults.entities.TournamentResultEntity;
import de.svennetz.grasser.tippspiel.tournamentResults.repositories.ITournamentResultRepository;


@Stateless
public class MemberSummaryBean implements IMemberSummaryBean {
	@EJB
	private IMemberRepository memberRepository;
	@EJB
	private ITournamentResultRepository tournamentResultRepository;
	
	public MemberSummaryBean() {
		
	}
	
	public MemberSummaryBean(IMemberRepository memberRepository, ITournamentResultRepository tournamentResultRepository) {
		this.memberRepository = memberRepository;
		this.tournamentResultRepository = tournamentResultRepository;
	}
	
	@Override
	public List<MemberSummary> getMemberSummaryList() {
		List<MemberEntity> members = memberRepository.readList();
		List<TournamentResultEntity> tournamentResults = tournamentResultRepository.readSortedList();
		List<MemberSummary> memberSummaries = initMemberSummaries(members);
		
		fillMemberSummaries(tournamentResults, memberSummaries);
				
		Collections.sort(memberSummaries, new ScoreComparator());
		return memberSummaries;
	}

	private void fillMemberSummaries(List<TournamentResultEntity> tournamentResults, List<MemberSummary> memberSummaries) {
		int currentTournamentId = 0;
		int currentResultIndex = 0;
		int currentResult = 0;
		double currentMatchDayVictory = 0;
		for (TournamentResultEntity tr : tournamentResults ) {
			if(Integer.compare(currentTournamentId, tr.getTournamentId()) != 0) {
				currentTournamentId = tr.getTournamentId();
				currentResultIndex = 0;
				currentResult = 0;
				currentMatchDayVictory = 0;
			}
			
			if(currentResultIndex > 3) {
				continue;
			}
			
			if(isTournamentResultLessThanCurrentResult(currentResult, currentMatchDayVictory, tr)) {
				currentResultIndex = currentResultIndex + 1;
				currentResult = tr.getResult();
				currentMatchDayVictory = tr.getMatchDayVictory();
			}			
		
			if(currentResultIndex == 1) {
				MemberSummary memberSummary = getMemberSummary(memberSummaries, tr.getMemberId());				
				memberSummary.addScore(ScoreType.Gold);
			}
			else if(currentResultIndex == 2) {
				MemberSummary memberSummary = getMemberSummary(memberSummaries, tr.getMemberId());		
				memberSummary.addScore(ScoreType.Silver);
			}
			else if(currentResultIndex == 3) {
				MemberSummary memberSummary = getMemberSummary(memberSummaries, tr.getMemberId());		
				memberSummary.addScore(ScoreType.Bronze);
			}
		}
	}

	private boolean isTournamentResultLessThanCurrentResult(int currentResult, double currentMatchDayVictory, TournamentResultEntity tr) {
		return currentResult == 0  || Integer.compare(tr.getResult(), (currentResult)) == -1 || currentMatchDayVictory == 0 || tr.getMatchDayVictory() < currentMatchDayVictory;
	}

	private List<MemberSummary> initMemberSummaries(List<MemberEntity> members) {
		ArrayList<MemberSummary> memberSummaries = new ArrayList<MemberSummary>();
		for (MemberEntity member : members ) {
			MemberSummary memberSummary = new MemberSummary(member.getId(), member.getName(), member.getIsActive());
			memberSummaries.add(memberSummary);
		}
		return memberSummaries;
	}

	private MemberSummary getMemberSummary(List<MemberSummary> memberSummaries, int id) {
		for (MemberSummary memberSummary : memberSummaries) {
			if(memberSummary.getId() == id) {
				return memberSummary;
			}
		}
		return null;
	}	
}
