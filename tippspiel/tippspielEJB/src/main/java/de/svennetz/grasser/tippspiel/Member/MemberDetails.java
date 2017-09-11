package de.svennetz.grasser.tippspiel.Member;

import de.svennetz.grasser.tippspiel.entities.Member;
import de.svennetz.grasser.tippspiel.entities.Tournament;

public class MemberDetails {
	private Member member;
	private Tournament tournament;
	private Integer score;
	private Integer position;

	public MemberDetails(Member member, Tournament tournament) {
		this.setMember(member);
		this.setTournament(tournament);
	}

	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Tournament getTournament() {
		return tournament;
	}
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}

}
