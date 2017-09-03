package de.svennetz.grasser.tippspiel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_member")
public class Member {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Transient
	private Integer gold;
	
	@Transient
	private Integer silver;
	
	@Transient
	private Integer bronze;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGold() {
		return this.gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public Integer getSilver() {
		return silver;
	}
	public void setSilver(int silver) {
		this.silver = silver;
	}
	public Integer getBronze() {
		return bronze;
	}
	public void setBronze(int bronze) {
		this.bronze = bronze;
	}

}
