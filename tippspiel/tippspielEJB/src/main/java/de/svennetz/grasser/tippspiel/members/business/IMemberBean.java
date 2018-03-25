package de.svennetz.grasser.tippspiel.members.business;

import java.util.List;

import de.svennetz.grasser.tippspiel.members.entities.MemberEntity;

public interface IMemberBean {
	
	List<MemberEntity> getMembers();
	MemberEntity getMember(int id);
}
