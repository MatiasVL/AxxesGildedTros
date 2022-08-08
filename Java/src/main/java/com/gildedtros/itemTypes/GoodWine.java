package com.gildedtros.itemTypes;

import com.gildedtros.NormalItem;
import com.gildedtros.util.Const;

public class GoodWine extends NormalItem{

	public GoodWine(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public NormalItem updateQuality() {
		if (quality < Const.QUALITY_LIMIT) {
			quality++;
		}
		sellIn--;
		return this;
	} 

}
