package de.svennetz.grasser.tippspiel.Member;

import de.svennetz.grasser.tippspiel.entities.Member;

public class MemberSummary {
	private Member member;	
	private MemberDetails memberDetails;	
	private int gold;
	private int silver;
	private int bronze;
	private int score;
	
	public MemberSummary(Member member) {
		this.setMember(member);
	}
	
	public Member getMember() {
		return member;
	}	
	
	public void setMember(Member member) {
		this.member = member;
	}

	public int getGold() {
		return gold;
	}
	public int getSilver() {
		return silver;
	}
	public int getBronze() {
		return bronze;
	}
	public int getScore() {
		return score;
	}
	
	public void addScore(ScoreType scoreType) {
		int scoreValue = 0;
		switch(scoreType) {
			case Gold:
				this.gold = this.gold + 1;
				scoreValue = ScoreValues.Score_Gold;
				break;
			case Silver:
				this.silver = this.silver + 1;
				scoreValue = ScoreValues.Score_Silver;
				break;
			case Bronze:
				this.bronze = this.bronze + 1;
				scoreValue = ScoreValues.Score_Bronze;
				break;
			default:
				break;
		}
		this.score = this.score + scoreValue;
	}

	public MemberDetails getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(MemberDetails memberDetails) {
		this.memberDetails = memberDetails;
	}	
}
