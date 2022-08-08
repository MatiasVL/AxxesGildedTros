package com.gildedtros;

import com.gildedtros.util.Const;

public class NormalItem extends Item{

	public NormalItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public NormalItem updateQuality() {
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
