package com.gildedtros.itemTypes;

import com.gildedtros.Item;

public class Normal extends Item {

	public Normal(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public void updateQuality() {
		sellIn--;
		quality--;
	} 

}
