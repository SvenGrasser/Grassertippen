package de.svennetz.grasser.tippspiel.members.repositories;

import java.util.List;

import de.svennetz.grasser.tippspiel.members.entities.MemberEntity;


public interface IMemberRepository {	
	List<MemberEntity> findAll();
	MemberEntity findById(int id);
}
