package com.gildedtros.itemTypes;

import com.gildedtros.ItemExtension;
import com.gildedtros.util.Const;

public class Normal extends ItemExtension {
	

	public Normal(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public ItemExtension updateQuality() {
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
		return this;
	} 

}
