package de.svennetz.grasser.tippspiel.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.entities.Member;


@Stateless
public class MemberBean implements IMemberBean {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Member> getMembers() {
		return getMemberList();
	}

	private List<Member> getMemberList() {
		String statement = String.format("SELECT m FROM Member m");
		TypedQuery<Member> query = entityManager.createQuery(statement, Member.class);
		return query.getResultList();
	}
}
