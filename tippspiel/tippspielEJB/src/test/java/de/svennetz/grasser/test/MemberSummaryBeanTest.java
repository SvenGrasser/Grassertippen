package de.svennetz.grasser.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.svennetz.grasser.test.repositoryStubs.MemberRepositoryStub;
import de.svennetz.grasser.test.repositoryStubs.TournamentResultRepositoryStub;
import de.svennetz.grasser.tippspiel.memberSummaries.business.IMemberSummaryBean;
import de.svennetz.grasser.tippspiel.memberSummaries.business.MemberSummary;
import de.svennetz.grasser.tippspiel.memberSummaries.business.MemberSummaryBean;
import de.svennetz.grasser.tippspiel.members.repositories.IMemberRepository;
import de.svennetz.grasser.tippspiel.tournamentResults.repositories.ITournamentResultRepository;

public class MemberSummaryBeanTest {
	private IMemberSummaryBean memberSummaryBean;
	private IMemberRepository memberRepository;
	private ITournamentResultRepository tournamentResultRepository;
	
	@Before
	public void setup() {
		this.memberRepository = new MemberRepositoryStub();
		this.tournamentResultRepository = new TournamentResultRepositoryStub();
		this.memberSummaryBean = new MemberSummaryBean(memberRepository, tournamentResultRepository);
	}

	@Test
	public void testGetMemberSummaryList() {
		List<MemberSummary> memberSummaryList = this.memberSummaryBean.getMemberSummaryList();
		
		assertTrue(memberSummaryList != null);
		assertTrue(memberSummaryList.get(0).getGold() == 1);
		assertTrue(memberSummaryList.get(1).getSilver() == 1);
		assertTrue(memberSummaryList.get(2).getBronze() == 1);
		assertTrue(memberSummaryList.get(3).getBronze() == 0);
		assertTrue(memberSummaryList.get(4).getBronze() == 0);
	}

}
