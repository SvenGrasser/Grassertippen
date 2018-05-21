package de.svennetz.grasser.test.repositoryStubs;

import java.util.ArrayList;
import java.util.List;

import de.svennetz.grasser.tippspiel.members.entities.MemberEntity;
import de.svennetz.grasser.tippspiel.members.repositories.IMemberRepository;

public class MemberRepositoryStub implements IMemberRepository {
	private List<MemberEntity> memberList = new ArrayList<MemberEntity>();
	
	public MemberRepositoryStub() {
		for(int i = 0; i < 5; i++) {
			MemberEntity memberEntity = new MemberEntity();
			memberEntity.setId(i);
			memberEntity.setName("Name " + i);
			memberEntity.setIsActive(true);
			this.memberList.add(memberEntity);
		}
	}

	@Override
	public List<MemberEntity> readList() {
		return this.memberList;
	}

	@Override
	public MemberEntity readItem(int id) {
		if(id < this.memberList.size()) {
			return this.memberList.get(id);
		}
		return null;
	}

}
