package de.svennetz.grasser.tippspiel.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.svennetz.grasser.tippspiel.Member.MemberSummary;
import de.svennetz.grasser.tippspiel.Member.ScoreComparator;
import de.svennetz.grasser.tippspiel.Member.ScoreType;
import de.svennetz.grasser.tippspiel.entities.Member;
import de.svennetz.grasser.tippspiel.entities.TournamentResult;
import de.svennetz.grasser.tippspiel.repositories.IMemberRepository;
import de.svennetz.grasser.tippspiel.repositories.ITournamentResultRepository;


@Stateless
public class MemberSummaryBean implements IMemberSummaryBean {
	@EJB
	private IMemberRepository memberRepository;
	@EJB
	private ITournamentResultRepository tournamentResultRepository;
		
	
	@Override
	public List<MemberSummary> getMemberSummaryList() {
		List<Member> members = memberRepository.readList();
		List<TournamentResult> tournamentResults = tournamentResultRepository.readSortedList();
		List<MemberSummary> memberSummaries = initMemberSummaries(members);
		
		fillMemberSummaries(tournamentResults, memberSummaries);
				
		Collections.sort(memberSummaries, new ScoreComparator());
		return memberSummaries;
	}

	private void fillMemberSummaries(List<TournamentResult> tournamentResults, List<MemberSummary> memberSummaries) {
		int currentTournamentId = 0;
		int currentResultIndex = 0;
		int currentResult = 0;
		for (TournamentResult tr : tournamentResults ) {
			if(Integer.compare(currentTournamentId, tr.getTournamentId()) != 0) {
				currentTournamentId = tr.getTournamentId();
				currentResultIndex = 0;
				currentResult = 0;
			}
			
			if(currentResultIndex > 3) {
				continue;
			}
			
			if(currentResult == 0 || Integer.compare(tr.getResult(), (currentResult)) == -1) {
				currentResultIndex = currentResultIndex + 1;
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

	private List<MemberSummary> initMemberSummaries(List<Member> members) {
		ArrayList<MemberSummary> memberSummaries = new ArrayList<MemberSummary>();
		for (Member member : members ) {
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
