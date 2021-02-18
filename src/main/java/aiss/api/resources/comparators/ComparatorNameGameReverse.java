package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.api.Game;

public class ComparatorNameGameReverse implements Comparator<Game> {

	@Override
	public int compare(Game g1, Game g2) {
		return g2.getName().compareTo(g1.getName());
	}

}
