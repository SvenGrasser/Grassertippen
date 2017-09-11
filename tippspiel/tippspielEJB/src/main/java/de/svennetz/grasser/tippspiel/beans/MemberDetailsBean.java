package de.svennetz.grasser.tippspiel.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.Member.MemberDetails;
import de.svennetz.grasser.tippspiel.entities.Member;
import de.svennetz.grasser.tippspiel.entities.Tournament;
import de.svennetz.grasser.tippspiel.entities.TournamentResult;

@Stateless
public class MemberDetailsBean implements IMemberDetailsBean {
	@PersistenceContext
	private EntityManager entityManager;	
	@EJB
	private IMemberBean memberBean;
	@EJB
	private ITournamentBean tournamentBean;
	
	@Override
	public List<MemberDetails> getMemberDetails(int id) {
		List<MemberDetails> detailsList = new ArrayList<MemberDetails>();
		
		Member member = memberBean.getMember(id);
		List<Tournament> tournaments = tournamentBean.getTournaments();
		List<Integer> tournamentIdList = new ArrayList<Integer>();
		for(Tournament tournament : tournaments) {
			tournamentIdList.add(tournament.getId());
			MemberDetails details = new MemberDetails(member, tournament);
			detailsList.add(details);
		}
			
		List<TournamentResult> tournamentResultList = getTournamentResultList(id, tournamentIdList);		
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

	private List<TournamentResult> getTournamentResultList(int id, List<Integer> tournamentIdList) {
		String statement = String.format(
				"SELECT r FROM TournamentResult r where r.memberId = :id and r.tournamentId in (:tournamentIdList)");
		TypedQuery<TournamentResult> queryTournamentResult = entityManager
				.createQuery(statement, TournamentResult.class);
		queryTournamentResult.setParameter("id", id);
		queryTournamentResult.setParameter("tournamentIdList", tournamentIdList);		
		List<TournamentResult> result = queryTournamentResult.getResultList();
		return result;
	}

}
