package de.svennetz.grasser.tippspiel.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.svennetz.grasser.tippspiel.entities.Member;
import de.svennetz.grasser.tippspiel.repositories.IMemberRepository;


@Stateless
public class MemberBean implements IMemberBean {
	@EJB
	private IMemberRepository memberRepository;
	
	@Override
	public List<Member> getMembers() {
		return memberRepository.readList();
	}
	
	@Override
	public Member getMember(int id) {
		return memberRepository.readItem(id);
	}
}
