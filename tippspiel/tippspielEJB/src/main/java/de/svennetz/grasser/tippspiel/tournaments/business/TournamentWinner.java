package de.svennetz.grasser.tippspiel.tournaments.business;

public class TournamentWinner {	
	private String tournament;	
	private String winner;
	private int result;
	private Double matchDayVictory;
	
	public TournamentWinner(String tournament) {
		setTournament(tournament);
	}

	public String getTournament() {
		return tournament;
	}

	public void setTournament(String tournament) {
		this.tournament = tournament;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Double getMatchDayVictory() {
		return matchDayVictory;
	}

	public void setMatchDayVictory(Double matchDayVictory) {
		this.matchDayVictory = matchDayVictory;
	}

}
