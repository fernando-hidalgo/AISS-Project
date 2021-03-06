package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.api.Game;

public class ComparatorGeneroGame implements Comparator<Game> {

	@Override
	public int compare(Game g1, Game g2) {
		if(g1.getGenero() == null && g2.getGenero() == null) {
			return 0;
		} else if(g1.getGenero() == null && g2.getGenero() != null){
			return 1;
		}else if(g1.getGenero() != null && g2.getGenero() == null) {
			return -1;
		}else {
		return g1.getGenero().compareTo(g2.getGenero());
		}
	}

}
