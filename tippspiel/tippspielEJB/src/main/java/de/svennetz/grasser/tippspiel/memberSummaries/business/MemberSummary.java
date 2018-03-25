package de.svennetz.grasser.tippspiel.Member;

public class MemberSummary {
	private int id;	
	private String name;
	private boolean isActive;
	private MemberDetails memberDetails;	
	private int gold;
	private int silver;
	private int bronze;
	private int score;
	
	public MemberSummary(int memberId, String memberName, boolean isActive) {
		this.id = memberId;
		this.name = memberName;
		this.isActive = isActive;
	}
	
	public int getId() {
		return id;
	}	
	public String getName() {
		return name;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public int getGold() {
		return gold;
	}
	public int getSilver() {
		return silver;
	}
	public int getBronze() {
		return bronze;
	}
	public int getScore() {
		return score;
	}
	
	public void addScore(ScoreType scoreType) {
		int scoreValue = 0;
		switch(scoreType) {
			case Gold:
				this.gold = this.gold + 1;
				scoreValue = ScoreValues.Score_Gold;
				break;
			case Silver:
				this.silver = this.silver + 1;
				scoreValue = ScoreValues.Score_Silver;
				break;
			case Bronze:
				this.bronze = this.bronze + 1;
				scoreValue = ScoreValues.Score_Bronze;
				break;
			default:
				break;
		}
		this.score = this.score + scoreValue;
	}

	public MemberDetails getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(MemberDetails memberDetails) {
		this.memberDetails = memberDetails;
	}	
}
