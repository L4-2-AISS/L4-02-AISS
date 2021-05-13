package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Team;

public class ComparatorNameTeamReversed implements Comparator<Team>{
	public int compare(Team t1, Team t2) {
		return t2.getName().compareTo(t1.getName());
	}
}
