package de.svennetz.grasser.tippspiel.tournamentResults.business;

public class TournamentWinner {	
	private String tournament;	
	private String winner;
	
	public TournamentWinner(String tournament, String winner) {
		setTournament(tournament);
		setWinner(winner);
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

}
