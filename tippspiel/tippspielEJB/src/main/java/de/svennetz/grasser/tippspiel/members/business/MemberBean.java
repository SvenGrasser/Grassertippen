package de.svennetz.grasser.tippspiel.members.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.svennetz.grasser.tippspiel.members.entities.MemberEntity;
import de.svennetz.grasser.tippspiel.members.repositories.IMemberRepository;


@Stateless
public class MemberBean implements IMemberBean {
	@EJB
	private IMemberRepository memberRepository;
	
	public MemberBean() {
	}
	
	public MemberBean(IMemberRepository repository) {
		memberRepository = repository;
	}
	
	@Override
	public List<MemberEntity> getMembers() {
		return memberRepository.findAll();
	}
	
	@Override
	public MemberEntity getMember(int id) {
		return memberRepository.findById(id);
	}
}
