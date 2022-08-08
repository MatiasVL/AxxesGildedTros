package com.gildedtros.itemTypes;

import com.gildedtros.Item;
import com.gildedtros.util.Const;

public class Normal extends Item {
	

	public Normal(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public void updateQuality() {
		if (sellIn < Const.SELL_BY_LIMIT) {
			quality = quality - Const.QUALITY_DECREASE_OVERTIME_ITEMS;
		}
		else {
			quality--;
		}
		if (quality < Const.MINIMUM_QUALITY) {
			quality = Const.MINIMUM_QUALITY;
		}

		sellIn--;
	} 

}
