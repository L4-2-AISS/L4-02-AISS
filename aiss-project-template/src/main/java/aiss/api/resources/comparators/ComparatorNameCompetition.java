package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Competition;

public class ComparatorNameCompetition implements Comparator<Competition>{
	public int compare(Competition c1, Competition c2) {
		return c1.getName().compareTo(c2.getName());
	}
}
