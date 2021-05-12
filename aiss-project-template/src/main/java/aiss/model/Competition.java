package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Competition {

	private String name;
	private String country;
	private List<Team> teams;
	
	public Competition() {}
	
	public Competition(String name) {
		this.name = name;
	}
	
	public Competition(String name, String country) {
		this.name = name;
		this.country = country;
	}
	protected void setTeams(List<Team> t) {
		teams = t;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public List<Team> getTeams() {
		return teams;
	}
	
	public Team getTeam(String name) {
		if (teams==null)
			return null;
		
		Team team =null;
		for(Team t: teams)
			if (t.getName().equals(name))
			{
				team = t;
				break;
			}
		
		return team;
	}
	
	public void addTeam(Team t) {
		if (teams==null)
			teams = new ArrayList<Team>();
		teams.add(t);
	}
	
	public void deleteTeam(Team t) {
		teams.remove(t);
	}
	
	public void deleteTeam(String name) {
		Team t = getTeam(name);
		if (t!=null)
			teams.remove(t);
	}

}
