package de.svennetz.grasser.tippspiel.members.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.svennetz.grasser.tippspiel.members.entities.MemberEntity;

@Stateless
public class MemberRepository implements IMemberRepository {
	@PersistenceContext
	private EntityManager entityManager;	

	@Override
	public List<MemberEntity> readList() {
		String statement = String.format("SELECT m FROM MemberEntity m");
		TypedQuery<MemberEntity> query = entityManager.createQuery(statement, MemberEntity.class);
		return query.getResultList();
	}

	@Override
	public MemberEntity readItem(int id) {
		String statement = String.format("SELECT m FROM MemberEntity m where m.id = :id");
		TypedQuery<MemberEntity> query = entityManager.createQuery(statement, MemberEntity.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
}
