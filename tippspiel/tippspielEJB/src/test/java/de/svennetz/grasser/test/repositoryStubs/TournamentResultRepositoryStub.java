package de.svennetz.grasser.test.repositoryStubs;

import java.util.ArrayList;
import java.util.List;

import de.svennetz.grasser.tippspiel.tournamentResults.entities.TournamentResultEntity;
import de.svennetz.grasser.tippspiel.tournamentResults.repositories.ITournamentResultRepository;

public class TournamentResultRepositoryStub implements ITournamentResultRepository {
private List<TournamentResultEntity> tournamentResultEntityList = new ArrayList<TournamentResultEntity>();
	
	public TournamentResultRepositoryStub() {
		for(int i = 0; i < 5; i++) {
			TournamentResultEntity tournamentResultEntity = new TournamentResultEntity();
			tournamentResultEntity.setId(i);
			tournamentResultEntity.setTournamentId(1);
			tournamentResultEntity.setMemberId(i);
			if(i == 2 || i == 3) {
				tournamentResultEntity.setResult(1000 - 2);
				tournamentResultEntity.setMatchDayVictory(new Double(5 - i));
			} else {
				tournamentResultEntity.setResult(1000 - i);
				tournamentResultEntity.setMatchDayVictory(new Double(1));
			}
			tournamentResultEntityList.add(tournamentResultEntity);
		}
	}
	@Override
	public List<TournamentResultEntity> readSortedList() {
		return this.tournamentResultEntityList;
	}

	@Override
	public List<TournamentResultEntity> readFilteredList(int tournamentId, boolean sortedByResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TournamentResultEntity> readFilteredList(List<Integer> tournamentIdList, int memberId) {
		// TODO Auto-generated method stub
		return null;
	}

}
