package de.svennetz.grasser.tippspiel.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.Member.MemberSummary;
import de.svennetz.grasser.tippspiel.Member.ScoreComparator;
import de.svennetz.grasser.tippspiel.entities.Member;
import de.svennetz.grasser.tippspiel.entities.Tournament;
import de.svennetz.grasser.tippspiel.entities.TournamentResult;


@Stateless
public class MemberSummaryBean implements IMemberSummaryBean {
	@PersistenceContext
	private EntityManager entityManager;	
	@EJB
	private IMemberBean memberBean;
	@EJB
	private ITournamentBean tournamentBean;
	
	private final int Score_Gold = 5;
	private final int Score_Silver = 3;
	private final int Score_Bronze = 1;
		
	
	@Override
	public List<MemberSummary> getMemberSummaryList() {
		List<Member> members = memberBean.getMembers();
		List<Tournament> tournaments = tournamentBean.getTournaments();
		
		ArrayList<MemberSummary> memberSummaries = new ArrayList<MemberSummary>();
		for (Member member : members) {
			MemberSummary memberSummary = new MemberSummary(member);
			memberSummaries.add(memberSummary);
			fillMemberSummaries(memberSummary, member, tournaments);
		}
				
		Collections.sort(memberSummaries, new ScoreComparator());
		return memberSummaries;
	}
	
	private void fillMemberSummaries(MemberSummary memberSummary, Member m, List<Tournament> tournamentList) {
		String statement;
		for (Tournament tournament : tournamentList) {
			statement = String.format(
					"SELECT r FROM TournamentResult r where r.tournamentId = :tournamentId order by r.result desc");
			TypedQuery<TournamentResult> queryTournamentResult = entityManager
					.createQuery(statement, TournamentResult.class).setParameter("tournamentId", tournament.getId())
					.setMaxResults(3);

			fillMemberSummary(memberSummary, m, queryTournamentResult.getResultList());
		}
	}
	
	private void fillMemberSummary(MemberSummary memberSummary, Member m, List<TournamentResult> tournamentResultList) {
				
		if (m.getId() == tournamentResultList.get(0).getMemberId()) {
			memberSummary.setGold(memberSummary.getGold() + 1);
			memberSummary.setScore(memberSummary.getScore() + Score_Gold);
		} else if (m.getId() == tournamentResultList.get(1).getMemberId()) {
			memberSummary.setSilver(memberSummary.getSilver() + 1);
			memberSummary.setScore(memberSummary.getScore() + Score_Silver);
		} else if (m.getId() == tournamentResultList.get(2).getMemberId()) {
			memberSummary.setBronze(memberSummary.getBronze() + 1);
			memberSummary.setScore(memberSummary.getScore() + Score_Bronze);
		}
	}
}
