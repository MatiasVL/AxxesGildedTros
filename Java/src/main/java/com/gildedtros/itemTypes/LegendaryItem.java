package com.gildedtros.itemTypes;

import com.gildedtros.NormalItem;

public class LegendaryItem extends NormalItem{

	public LegendaryItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public NormalItem updateQuality() {
		return this;
	} 
}
