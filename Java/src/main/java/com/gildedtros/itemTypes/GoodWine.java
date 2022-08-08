package com.gildedtros.itemTypes;

import com.gildedtros.util.Const;

public class GoodWine extends DefaultItem {

	public GoodWine(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public void updateQuality() {
		//TODO unclear from requirements if the quality of good wine should increase 2X if sellIn is below 0. This was not implemented here, but should be discussed with the client
		if (quality < Const.QUALITY_LIMIT) {
			quality++;
		}
		sellIn--;
	} 
}
