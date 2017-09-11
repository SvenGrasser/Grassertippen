package de.svennetz.grasser.tippspiel.beans;

import java.util.List;

import de.svennetz.grasser.tippspiel.Member.MemberDetails;

public interface IMemberDetailsBean {
	List<MemberDetails> getMemberDetails(int id);
}
