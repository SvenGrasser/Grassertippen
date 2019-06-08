package de.svennetz.grasser.tippspiel.tournaments.entities;

public class TournamentAverageAllTippers {	

	private int id;	
	private Double averageAllTippers;
	
	public TournamentAverageAllTippers(int id, Double averageAllTippers) {
		this.id = id;
		this.averageAllTippers = averageAllTippers;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Double getAverageAllTippers() {
		return averageAllTippers;
	}

	public void setAverageAllTippers(Double averageAllTippers) {
		this.averageAllTippers = averageAllTippers;
	}
	
}
