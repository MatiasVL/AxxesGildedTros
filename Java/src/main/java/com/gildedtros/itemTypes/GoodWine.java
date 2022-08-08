package com.gildedtros.itemTypes;

import com.gildedtros.ItemExtension;
import com.gildedtros.util.Const;

public class GoodWine extends ItemExtension{

	public GoodWine(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public ItemExtension updateQuality() {
		if (quality < Const.QUALITY_LIMIT) {
			quality++;
		}
		sellIn--;
		return this;
	} 

}
