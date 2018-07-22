package de.svennetz.grasser.tippspiel.tournamentResults.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import de.svennetz.grasser.tippspiel.members.entities.MemberEntity;

@Entity
@Table(name="t_member_tournament_result")
public class TournamentWinnerResultEntity {@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "MemberId")
	private int memberId; 
	
	@Column(name = "TournamentId")
	private int tournamentId; 

	@Column(name = "Result")
	private int result;

	@Column(name = "MatchDayVictory")
	private Double matchDayVictory;
	
	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}

	@OneToOne
	@JoinColumn(name="MemberId", referencedColumnName="id", insertable=false, updatable=false)
	private MemberEntity member;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Double getMatchDayVictory() {
		return matchDayVictory;
	}

	public void setMatchDayVictory(Double matchDayVictory) {
		this.matchDayVictory = matchDayVictory;
	} 

}
