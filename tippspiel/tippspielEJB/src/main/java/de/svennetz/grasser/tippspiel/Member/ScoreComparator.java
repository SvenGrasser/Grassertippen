package de.svennetz.grasser.tippspiel.Member;

import java.util.Comparator;

public class ScoreComparator implements Comparator<MemberSummary> {
	@Override
	public int compare(MemberSummary o1, MemberSummary o2) {
		return o2.getScore() - o1.getScore();
	}
}
