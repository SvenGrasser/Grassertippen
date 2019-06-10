package de.svennetz.grasser.tippspiel.tournaments.business;

public class Tournament {
	private int id;
	private String descriptionShort;
	private String description;
	
	public Tournament(int id, String descriptionShort, String description) {
		this.setId(id);
		this.setDescriptionShort(descriptionShort);
		this.setDescription(description);
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
	
	public String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		this.description = description;
	}	
}
