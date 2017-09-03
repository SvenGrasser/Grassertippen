package de.svennetz.grasser.tippspiel.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.entities.Member;
import de.svennetz.grasser.tippspiel.entities.Tournament;
import de.svennetz.grasser.tippspiel.entities.TournamentResult;


@Stateless
public class MemberResultOverviewBean implements IMemberResultOverviewBean {
	@PersistenceContext
	private EntityManager entityManager;	
	@EJB
	IMemberBean memberBean;
	@EJB
	ITournamentBean tournamentBean;
	
	@Override
	public List<Member> getMemberResultOverviewList() {
		List<Member> members = memberBean.getMembers();
		List<Tournament> tournaments = tournamentBean.getTournaments();
		
		for (Member member : members) {
			setMemberMedals(member, tournaments);
		}
		return members;
	}
	
	private void setMemberMedals(Member m, List<Tournament> tournamentList) {
		String statement;
		for (Tournament tournament : tournamentList) {
			statement = String.format(
					"SELECT r FROM TournamentResult r where r.tournamentId = :tournamentId order by r.result desc");
			TypedQuery<TournamentResult> queryTournamentResult = entityManager
					.createQuery(statement, TournamentResult.class).setParameter("tournamentId", tournament.getId())
					.setMaxResults(3);

			setMemberMedal(m, queryTournamentResult.getResultList());
		}
	}
	
	private void setMemberMedal(Member m, List<TournamentResult> tournamentResultList) {
		if (m.getId() == tournamentResultList.get(0).getMemberId()) {
			int value = m.getGold() == null ? 0 : m.getGold();
			m.setGold(value + 1);
		} else if (m.getId() == tournamentResultList.get(1).getMemberId()) {
			int value = m.getSilver() == null ? 0 : m.getSilver();
			m.setSilver(value + 1);
		} else if (m.getId() == tournamentResultList.get(2).getMemberId()) {
			int value = m.getBronze() == null ? 0 : m.getBronze();
			m.setBronze(value + 1);
		}
	}
}
