package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Competition;

public class ComparatorNameCompetitionReversed implements Comparator<Competition>{
	public int compare(Competition c1, Competition c2) {
		return c2.getName().compareTo(c1.getName());
	}
}
