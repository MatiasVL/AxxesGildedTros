package com.gildedtros.itemTypes;

import com.gildedtros.util.Const;

public class SmellyItem extends DefaultItem{

	public SmellyItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public void updateQuality() {
		sellIn--;
		
		if (sellIn < Const.SELL_BY_LIMIT) {
			quality = quality - (Const.QUALITY_DECREASE_OVERTIME_ITEMS * Const.SMELLY_ITEMS_QUALITY_DECREASE_FACTOR);
		}
		else {
			quality = quality - (1 * Const.SMELLY_ITEMS_QUALITY_DECREASE_FACTOR);
		}
		if (quality < Const.MINIMUM_QUALITY) {
			quality = Const.MINIMUM_QUALITY;
		}
	} 
}
