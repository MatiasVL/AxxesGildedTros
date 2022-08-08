package com.gildedtros;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedTrosTest {
	@Test
	void testAllItemsForOnePeriod() {
		Item[] items = buildNewItems();
		GildedTros app = new GildedTros(items);
		app.updateQuality();
		assertEquals("Ring of Cleansening Code, 9, 19", app.items[0].toString());
		assertEquals("Good Wine, 1, 1", app.items[1].toString());
		assertEquals("Elixir of the SOLID, 4, 6", app.items[2].toString());
		assertEquals("B-DAWG Keychain, 0, 80", app.items[3].toString());
		assertEquals("B-DAWG Keychain, -1, 80", app.items[4].toString());
		assertEquals("Backstage passes for Re:Factor, 14, 21", app.items[5].toString());
		assertEquals("Backstage passes for Re:Factor, 9, 50", app.items[6].toString());
		assertEquals("Backstage passes for HAXX, 4, 50", app.items[7].toString());
        assertEquals("Duplicate Code, 2, 4", app.items[8].toString());
        assertEquals("Long Methods, 2, 4", app.items[9].toString());
        assertEquals("Ugly Variable Names, 2, 4", app.items[10].toString());
	}
	
	
	@Test
	void testAllItemsFor5Periods() {
		Item[] items = buildNewItems();
		GildedTros app = new GildedTros(items);
		for (int i = 0; i < 5; i++) {
			app.updateQuality();
		}
		assertEquals("Ring of Cleansening Code, 5, 15", app.items[0].toString());
		assertEquals("Good Wine, -3, 5", app.items[1].toString());
		assertEquals("Elixir of the SOLID, 0, 2", app.items[2].toString());
		assertEquals("B-DAWG Keychain, 0, 80", app.items[3].toString());
		assertEquals("B-DAWG Keychain, -1, 80", app.items[4].toString());
		assertEquals("Backstage passes for Re:Factor, 10, 25", app.items[5].toString());
		assertEquals("Backstage passes for Re:Factor, 5, 50", app.items[6].toString());
		assertEquals("Backstage passes for HAXX, 0, 50", app.items[7].toString());
        assertEquals("Duplicate Code, -2, 0", app.items[8].toString());
        assertEquals("Long Methods, -2, 0", app.items[9].toString());
        assertEquals("Ugly Variable Names, -2, 0", app.items[10].toString());
	}
	
	@Test
	void testAllItemsFor12Periods() {
		Item[] items = buildNewItems();
		GildedTros app = new GildedTros(items);
		for (int i = 0; i < 12; i++) {
			app.updateQuality();
		}
		assertEquals("Ring of Cleansening Code, -2, 6", app.items[0].toString());
		assertEquals("Good Wine, -10, 12", app.items[1].toString());
		assertEquals("Elixir of the SOLID, -7, 0", app.items[2].toString());
		assertEquals("B-DAWG Keychain, 0, 80", app.items[3].toString());
		assertEquals("B-DAWG Keychain, -1, 80", app.items[4].toString());
		assertEquals("Backstage passes for Re:Factor, 3, 41", app.items[5].toString());
		assertEquals("Backstage passes for Re:Factor, -2, 0", app.items[6].toString());
		assertEquals("Backstage passes for HAXX, -7, 0", app.items[7].toString());
        assertEquals("Duplicate Code, -9, 0", app.items[8].toString());
        assertEquals("Long Methods, -9, 0", app.items[9].toString());
        assertEquals("Ugly Variable Names, -9, 0", app.items[10].toString());
	}
	
	private Item[] buildNewItems() {
		Item[] items = new Item[] { 
				new Item("Ring of Cleansening Code", 10, 20), 
				new Item("Good Wine", 2, 0),
				new Item("Elixir of the SOLID", 5, 7), 
				new Item("B-DAWG Keychain", 0, 80),
				new Item("B-DAWG Keychain", -1, 80), 
				new Item("Backstage passes for Re:Factor", 15, 20),
				new Item("Backstage passes for Re:Factor", 10, 49), 
				new Item("Backstage passes for HAXX", 5, 49),
				new Item("Duplicate Code", 3, 6), 
				new Item("Long Methods", 3, 6),
				new Item("Ugly Variable Names", 3, 6) 
		};
		return items;
	}
}
