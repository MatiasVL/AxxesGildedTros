package com.gildedtros.itemTypes;

import com.gildedtros.util.Const;

public class BackstagePass extends DefaultItem {
	public BackstagePass(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public void updateQuality() {
		sellIn--;
		
		if (sellIn < Const.SELL_BY_LIMIT) {
			quality = Const.MINIMUM_QUALITY;
		}
		else if (sellIn <= Const.BACKSTAGE_PASS_HIGH_URGENCY_TIME_LIMIT) {
			quality = quality + Const.BACKSTAGE_PASS_HIGH_URGENCY_QUALITY_INCREASE;
		}
		else if (sellIn <= Const.BACKSTAGE_PASS_URGENCY_TIME_LIMIT) {
			quality = quality + Const.BACKSTAGE_PASS_URGENCY_QUALITY_INCREASE;
		}
		else {
			quality++;
		}
		
		if (quality > Const.QUALITY_LIMIT) {
			quality = Const.QUALITY_LIMIT;
		}		
	} 
}
