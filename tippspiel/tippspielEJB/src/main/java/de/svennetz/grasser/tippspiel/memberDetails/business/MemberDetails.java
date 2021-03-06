package de.svennetz.grasser.tippspiel.memberDetails.business;

public class MemberDetails {
	private int tournamentId;
	private String tournamentDescriptionShort;
	private Integer score;
	private Integer position;
	private Double matchDayVictory;

	public MemberDetails(int tournamentId, String tournamentDescriptionShort) {
		this.tournamentId = tournamentId;
		this.tournamentDescriptionShort = tournamentDescriptionShort;
	}


	public int getTournamentId() {
		return tournamentId;
	}	
	public String getTournamentDescriptionShort() {
		return tournamentDescriptionShort;
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
	public Double getMatchDayVictory() {
		return matchDayVictory;
	}
	public void setMatchDayVictory(Double matchDayVictory) {
		this.matchDayVictory = matchDayVictory;
	}
}
