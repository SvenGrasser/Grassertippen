package de.svennetz.grasser.tippspiel.repositories;

import java.util.List;

import de.svennetz.grasser.tippspiel.entities.Member;


public interface IMemberRepository {	
	List<Member> readList();
	Member readItem(int id);
}
