package de.svennetz.grasser.tippspiel.tournaments.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_tournament")
public class TournamentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "TournamentType")
	private int tournamentType;
	
	@Column(name = "Description_Short")
	private String descriptionShort;
	
	@Column(name = "Description")
	private String description;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescriptionShort() {
		return descriptionShort;
	}

	public void setDescriptionShort(String descriptionShort) {
		this.descriptionShort = descriptionShort;
	}

	public int getTournamentType() {
		return tournamentType;
	}

	public void setTournamentType(int tournamentType) {
		this.tournamentType = tournamentType;
	}	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}
