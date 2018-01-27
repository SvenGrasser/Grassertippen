package de.svennetz.grasser.tippspiel.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.entities.Member;

@Stateless
public class MemberRepository implements IMemberRepository {
	@PersistenceContext
	private EntityManager entityManager;	

	@Override
	public List<Member> readList() {
		String statement = String.format("SELECT m FROM Member m");
		TypedQuery<Member> query = entityManager.createQuery(statement, Member.class);
		return query.getResultList();
	}

	@Override
	public Member readItem(int id) {
		String statement = String.format("SELECT m FROM Member m where m.id = :id");
		TypedQuery<Member> query = entityManager.createQuery(statement, Member.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
}
