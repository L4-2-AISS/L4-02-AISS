package aiss.model.repository;

import java.util.Collection;

import aiss.model.Competition;
import aiss.model.Team;

public interface CompetitionRepository {
	
	
	// Teams
	public void addTeam(Team t);
	public Collection<Team> getAllTeams();
	public Team getTeam(String teamName);
	public void updateTeam(Team t);
	public void deleteTeam(String teamName);
	
	// Competitions
	public void addCompetition(Competition c);
	public Collection<Competition> getAllCompetitions();
	public Competition getCompetition(String competitionName);
	public void updateCompetition(Competition c);
	public void deleteCompetition(String competitionName);
	public Collection<Team> getAll(String competitionName);
	public void addTeam(String competitionName, String teamName);
	public void removeTeam(String competitionName, String teamName); 

	
	
	
	

}
