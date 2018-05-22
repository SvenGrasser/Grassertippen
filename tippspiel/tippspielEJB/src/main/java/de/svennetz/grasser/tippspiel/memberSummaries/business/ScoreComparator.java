package de.svennetz.grasser.tippspiel.memberSummaries.business;

import java.util.Comparator;

public class ScoreComparator implements Comparator<MemberSummary> {
	@Override
	public int compare(MemberSummary o1, MemberSummary o2) {
		int score2 = o2.getScore() + (o2.getIsActive() ? 1 : 0);
		int score1 = o1.getScore() + (o1.getIsActive() ? 1 : 0);
		return score2 - score1;
	}
}
