package de.svennetz.grasser.tippspiel.tournaments.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import de.svennetz.grasser.tippspiel.tournamentResults.entities.TournamentWinnerResultEntity;

@Entity
@Table(name="t_tournament")
public class TournamentWinnerEntity {	
	@Id
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Description_Short")
	private String descriptionShort;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="TournamentId")
	@OrderBy("result DESC, matchDayVictory DESC")
	private List<TournamentWinnerResultEntity> tournamentWinnerResults;

	@Column(name = "Date")
	private Date date;
	
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<TournamentWinnerResultEntity> getTournamentWinnerResults() {
		return tournamentWinnerResults;
	}

	public void setTournamentWinnerResults(List<TournamentWinnerResultEntity> tournamentWinnerResults) {
		this.tournamentWinnerResults = tournamentWinnerResults;
	}	
}
