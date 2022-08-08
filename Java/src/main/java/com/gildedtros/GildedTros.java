package com.gildedtros;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.gildedtros.itemTypes.BackstagePass;
import com.gildedtros.itemTypes.GoodWine;
import com.gildedtros.itemTypes.Normal;

class GildedTros {
    private static final Class<Item> NORMAL_CLASS = Item.class;

    private static final Map<String, String> SPECIALIZED_CLASSES =
    		Map.of(
				"Normal", Normal.class.getName(),
	            "Good Wine", GoodWine.class.getName(),
	            "Backstage pass", BackstagePass.class.getName());
    
//    private List<Item> items;
//
//    GildedTros(final List<Item> items) {
//        this.items = items;
//    }
		
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }
    
    public void updateQuality() {
    	List<Item> itemList = Arrays.asList(items);
    	this.items = (Item[]) itemList.stream().map(this::qualityUpdater).toArray();
    }

    private Item qualityUpdater(final Item item) {
        Class<?> clazz;

        try {
            clazz = Class.forName(SPECIALIZED_CLASSES.get(item.name));
        } catch (final Exception e) {
            clazz = NORMAL_CLASS;
        }

        try {
            return (Item) clazz.getConstructor(String.class, int.class, int.class)
                    .newInstance(item.name, item.sellIn, item.quality);
        } catch (Exception e) {
            // log failure for the item here
            e.printStackTrace();
        }

        // null item means it is unknown at the moment
        return null;
    }

//    public void updateQuality() {
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Good Wine")
//                    && !items[i].name.equals("Backstage passes for Re:Factor")
//                    && !items[i].name.equals("Backstage passes for HAXX"))
//            {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("B-DAWG Keychain")) {
//                        items[i].quality--;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality++;
//
//                    if (items[i].name.equals("Backstage passes for Re:Factor") || items[i].name.equals("Backstage passes for HAXX") ) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality++;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality++;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("B-DAWG Keychain")) {
//                items[i].sellIn--;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Good Wine")) {
//                    if (!items[i].name.equals("Backstage passes for Re:Factor") && !items[i].name.equals("Backstage passes for HAXX")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("B-DAWG Keychain")) {
//                                items[i].quality--;
//                            }
//                        }
//                    } else {
//                        items[i].quality = 0;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality++;
//                    }
//                }
//            }
//        }
//    }
}