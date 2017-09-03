package de.svennetz.grasser.tippspiel.Member;

public class MemberSummary {


	private Integer Id;
	private String name;
	private Integer gold;
	private Integer silver;
	private Integer bronze;
	private int score;
	

	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGold() {
		return gold;
	}
	public void setGold(Integer gold) {
		this.gold = gold;
	}
	public Integer getSilver() {
		return silver;
	}
	public void setSilver(Integer silver) {
		this.silver = silver;
	}
	public Integer getBronze() {
		return bronze;
	}
	public void setBronze(Integer bronze) {
		this.bronze = bronze;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
