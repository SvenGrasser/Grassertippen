package de.svennetz.grasser.tippspiel.beans;

import java.util.List;

import de.svennetz.grasser.tippspiel.Member.MemberSummary;


public interface IMemberSummaryBean {
	List<MemberSummary> getMemberResultOverviewList();
}
