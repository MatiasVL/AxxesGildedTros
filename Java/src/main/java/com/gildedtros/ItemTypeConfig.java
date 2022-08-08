package com.gildedtros;

import java.util.Map;

import com.gildedtros.itemTypes.BackstagePass;
import com.gildedtros.itemTypes.GoodWine;
import com.gildedtros.itemTypes.LegendaryItem;
import com.gildedtros.itemTypes.SmellyItem;
import com.gildedtros.itemTypes.DefaultItem;

public class ItemTypeConfig {
	public static final Class<DefaultItem> DEFAULT_CLASS = DefaultItem.class;

	public static final Map<String, String> SPECIALIZED_CLASSES = Map.of(
            "Good Wine", GoodWine.class.getName(),
            "B-DAWG Keychain", LegendaryItem.class.getName(),
            "Backstage passes for Re:Factor", BackstagePass.class.getName(),
            "Backstage passes for HAXX", BackstagePass.class.getName(),
            "Duplicate Code", SmellyItem.class.getName(),
            "Long Methods", SmellyItem.class.getName(),
            "Ugly Variable Names", SmellyItem.class.getName());
}
