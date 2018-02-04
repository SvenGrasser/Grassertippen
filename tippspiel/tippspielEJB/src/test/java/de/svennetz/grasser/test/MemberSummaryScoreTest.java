package de.svennetz.grasser.test;

import static org.junit.Assert.*;

import org.junit.Test;

import de.svennetz.grasser.tippspiel.Member.MemberSummary;
import de.svennetz.grasser.tippspiel.Member.ScoreType;
import de.svennetz.grasser.tippspiel.entities.Member;

public class MemberSummaryScoreTest {

	@Test
	public void testAddScore_0() {
		MemberSummary memberSummary = createMemberSummary();
				
		assertTrue(memberSummary.getGold() == 0);
		assertTrue(memberSummary.getSilver() == 0);
		assertTrue(memberSummary.getBronze() == 0);
		assertTrue(memberSummary.getScore() == 0);
	}
	
	@Test
	public void testAddScore_Gold1Score5() {
		MemberSummary memberSummary = createMemberSummary();
		memberSummary.addScore(ScoreType.Gold);
		
		assertTrue(memberSummary.getGold() == 1);
		assertTrue(memberSummary.getScore() == 5);
	}
	
	@Test
	public void testAddScore_Silver1Score3() {
		MemberSummary memberSummary = createMemberSummary();
		memberSummary.addScore(ScoreType.Silver);
		
		assertTrue(memberSummary.getSilver() == 1);
		assertTrue(memberSummary.getScore() == 3);
	}
	
	@Test
	public void testAddScore_Bronze1Scor1() {
		MemberSummary memberSummary = createMemberSummary();
		memberSummary.addScore(ScoreType.Bronze);
		
		assertTrue(memberSummary.getBronze() == 1);
		assertTrue(memberSummary.getScore() == 1);
	}
	
	@Test
	public void testAddScore_Gold1Silver1Bronze1Score9() {
		MemberSummary memberSummary = createMemberSummary();
		memberSummary.addScore(ScoreType.Gold);
		memberSummary.addScore(ScoreType.Silver);
		memberSummary.addScore(ScoreType.Bronze);

		assertTrue(memberSummary.getGold() == 1);
		assertTrue(memberSummary.getSilver() == 1);
		assertTrue(memberSummary.getBronze() == 1);
		assertTrue(memberSummary.getScore() == 9);
	}

	private MemberSummary createMemberSummary() {
		Member member = createMember();
		MemberSummary memberSummary = new MemberSummary(member.getId(), member.getName(), member.getIsActive());
		return memberSummary;
	}

	private Member createMember() {
		Member member = new Member();
		member.setId(1);
		member.setName("Testmann");
		return member;
	}

}
