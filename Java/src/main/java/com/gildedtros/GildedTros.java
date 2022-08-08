package com.gildedtros;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.gildedtros.itemTypes.BackstagePass;
import com.gildedtros.itemTypes.GoodWine;
import com.gildedtros.itemTypes.Normal;

class GildedTros {
    private static final Class<ItemExtension> NORMAL_CLASS = ItemExtension.class;

    private static final Map<String, String> SPECIALIZED_CLASSES =
    		Map.of(
				"Normal", Normal.class.getName(),
	            "Good Wine", GoodWine.class.getName(),
	            "Backstage pass", BackstagePass.class.getName());
    
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }
    
    public void updateQuality() {
    	
    	List<Item> itemList = Arrays.asList(items);
    	List<ItemExtension> itemExtensionList = itemList.stream().map(i -> new ItemExtension(i.name, i.sellIn, i.quality)).map(this::qualityUpdater).collect(Collectors.toList());
    	for (ItemExtension itemExtension : itemExtensionList) {
			itemExtension.updateQuality();
		}
    	items = itemExtensionList.toArray(new Item[itemExtensionList.size()]);
    }

    private ItemExtension qualityUpdater(final Item item) {
        Class<?> clazz;

        try {
            clazz = Class.forName(SPECIALIZED_CLASSES.get(item.name));
        } catch (final Exception e) {
            clazz = NORMAL_CLASS;
        }

        try {
            return (ItemExtension) clazz.getConstructor(String.class, int.class, int.class)
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