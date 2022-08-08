package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {
	Item[] items = new Item[] { new Item("Ring of Cleansening Code", 10, 20), new Item("Good Wine", 2, 0),
			new Item("Elixir of the SOLID", 5, 7), new Item("B-DAWG Keychain", 0, 80),
			new Item("B-DAWG Keychain", -1, 80), new Item("Backstage passes for Re:Factor", 15, 20),
			new Item("Backstage passes for Re:Factor", 10, 49), new Item("Backstage passes for HAXX", 5, 49),
			// TODO uncomment and fix test after implementing additional functionality
//			 new Item("Duplicate Code", 3, 6),
//			 new Item("Long Methods", 3, 6),
//			 new Item("Ugly Variable Names", 3, 6)
	};

	@Test
	void testAllItemsForOnePeriod() {
		Item[] items = new Item[] { new Item("Ring of Cleansening Code", 10, 20), new Item("Good Wine", 2, 0),
				new Item("Elixir of the SOLID", 5, 7), new Item("B-DAWG Keychain", 0, 80),
				new Item("B-DAWG Keychain", -1, 80), new Item("Backstage passes for Re:Factor", 15, 20),
				new Item("Backstage passes for Re:Factor", 10, 49), new Item("Backstage passes for HAXX", 5, 49),
				// these smelly items do not work properly yet
				new Item("Duplicate Code", 3, 6), new Item("Long Methods", 3, 6),
				new Item("Ugly Variable Names", 3, 6) };
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
		// TODO uncomment and fix test after implementing additional functionality
//        assertEquals("fixme", app.items[8].toString());
//        assertEquals("fixme", app.items[9].toString());
//        assertEquals("fixme", app.items[10].toString());
	}

}
