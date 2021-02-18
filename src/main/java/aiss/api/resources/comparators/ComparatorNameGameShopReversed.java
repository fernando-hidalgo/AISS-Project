package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.api.GameShop;

public class ComparatorNameGameShopReversed implements Comparator<GameShop> {

	@Override
	public int compare(GameShop gs1, GameShop gs2) {
		return gs2.getName().compareTo(gs1.getName());
	}

}
