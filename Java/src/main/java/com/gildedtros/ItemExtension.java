package com.gildedtros;

public class ItemExtension extends Item{

	public ItemExtension(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public ItemExtension updateQuality() {
		return this;
	} 

}
