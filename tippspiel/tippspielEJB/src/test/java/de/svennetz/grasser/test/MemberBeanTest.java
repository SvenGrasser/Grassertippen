package de.svennetz.grasser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import de.svennetz.grasser.tippspiel.beans.IMemberBean;
import de.svennetz.grasser.tippspiel.beans.MemberBean;
import de.svennetz.grasser.tippspiel.entities.Member;
import de.svennetz.grasser.tippspiel.repositories.IMemberRepository;

@RunWith(MockitoJUnitRunner.class)
public class MemberBeanTest {
	private IMemberBean memberBean;

	@Mock
	IMemberRepository mockRepository;

	@Before
	public void setup() {
		memberBean = new MemberBean(mockRepository);
	}

	@Test
	public void testGetMembers() {
		Mockito.when(mockRepository.readList()).thenReturn(new ArrayList<Member>());

		List<Member> members = memberBean.getMembers();
		
		assertTrue(members != null);
		assertTrue(Integer.compare(members.size(), 0) == 0);
	}
	
	@Test
	public void testGetMember() {
		Mockito.when(mockRepository.readItem(1)).thenReturn(new Member());

		Member member = memberBean.getMember(1);
		
		assertTrue(member != null);
	}

}
