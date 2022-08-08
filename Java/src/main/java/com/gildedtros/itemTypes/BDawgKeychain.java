package com.gildedtros.itemTypes;

import com.gildedtros.ItemExtension;

public class BDawgKeychain extends ItemExtension{

	public BDawgKeychain(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public ItemExtension updateQuality() {
		return this;
	} 
}
