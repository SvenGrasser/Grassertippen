package de.svennetz.grasser.tippspiel.Member;

import de.svennetz.grasser.tippspiel.entities.Member;

public class MemberSummary {
	private Member member;	
	
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
	public void setGold(Integer gold) {
		this.gold = gold;
	}
	public int getSilver() {
		return silver;
	}
	public void setSilver(Integer silver) {
		this.silver = silver;
	}
	public int getBronze() {
		return bronze;
	}
	public void setBronze(Integer bronze) {
		this.bronze = bronze;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}	
}
