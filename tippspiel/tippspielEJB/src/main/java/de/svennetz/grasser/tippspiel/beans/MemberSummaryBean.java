package de.svennetz.grasser.tippspiel.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.svennetz.grasser.tippspiel.Member.MemberSummary;
import de.svennetz.grasser.tippspiel.Member.ScoreComparator;
import de.svennetz.grasser.tippspiel.Member.ScoreType;
import de.svennetz.grasser.tippspiel.entities.Member;
import de.svennetz.grasser.tippspiel.entities.TournamentResult;


@Stateless
public class MemberSummaryBean implements IMemberSummaryBean {
	@PersistenceContext
	private EntityManager entityManager;	
	@EJB
	private IMemberBean memberBean;
	@EJB
	private ITournamentBean tournamentBean;
		
	
	@Override
	public List<MemberSummary> getMemberSummaryList() {
		List<Member> members = memberBean.getMembers();
		List<TournamentResult> tournamentResults = getTournamentResults();
		List<MemberSummary> memberSummaries = initMemberSummaries(members);
		
		int currentTournamentId = 0;
		int currentResultIndex = 0;
		int currentResult = 0;
		for (TournamentResult tr : tournamentResults ) {
			if(Integer.compare(currentTournamentId, tr.getTournamentId()) != 0) {
				currentTournamentId = tr.getTournamentId();
				currentResultIndex = 0;
				currentResult = 0;
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
				
		Collections.sort(memberSummaries, new ScoreComparator());
		return memberSummaries;
	}

	private List<MemberSummary> initMemberSummaries(List<Member> members) {
		ArrayList<MemberSummary> memberSummaries = new ArrayList<MemberSummary>();
		for (Member member : members ) {
			MemberSummary memberSummary = new MemberSummary(member);
			memberSummaries.add(memberSummary);
		}
		return memberSummaries;
	}

	private MemberSummary getMemberSummary(List<MemberSummary> memberSummaries, int id) {
		for (MemberSummary memberSummary : memberSummaries) {
			if(memberSummary.getMember().getId() == id) {
				return memberSummary;
			}
		}
		return null;
	}
	
	private List<TournamentResult> getTournamentResults() {			  
		String statement = String.format(
				"SELECT r FROM TournamentResult r order by r.tournamentId, r.result desc");
		return  entityManager.createQuery(statement, TournamentResult.class).getResultList();
	}	
}
