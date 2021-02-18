package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.api.GameShop;

public class ComparatorNameGameShop implements Comparator<GameShop> {

	@Override
	public int compare(GameShop gs1, GameShop gs2) {
		return gs1.getName().compareTo(gs2.getName());
	}

}
