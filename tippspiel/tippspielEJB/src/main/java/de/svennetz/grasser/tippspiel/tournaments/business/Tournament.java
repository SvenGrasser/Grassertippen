package de.svennetz.grasser.tippspiel.tournaments.business;

public class Tournament {
	private int id;
	private String descriptionShort;
	
	public Tournament(int id, String descriptionShort) {
		this.setId(id);
		this.setDescriptionShort(descriptionShort);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getDescriptionShort() {
		return descriptionShort;
	}

	private void setDescriptionShort(String descriptionShort) {
		this.descriptionShort = descriptionShort;
	}	
}
