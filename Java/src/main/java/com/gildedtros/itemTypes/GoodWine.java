package com.gildedtros.itemTypes;

import com.gildedtros.Item;
import com.gildedtros.util.Const;

public class GoodWine extends Item{

	public GoodWine(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public void updateQuality() {
		if (quality < Const.QUALITY_LIMIT) {
			quality++;
		}
		sellIn--;
	} 

}
