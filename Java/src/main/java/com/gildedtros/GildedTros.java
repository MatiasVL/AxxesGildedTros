package com.gildedtros;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.gildedtros.itemTypes.DefaultItem;

class GildedTros {
    	Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }
    
    public void updateQuality() {
    	//Clearer debugging in separate steps
    	List<Item> itemList = Arrays.asList(items);
    	List<DefaultItem> itemExtensionList = itemList.stream().map(i -> new DefaultItem(i.name, i.sellIn, i.quality)).map(this::qualityUpdater).collect(Collectors.toList());
    	for (DefaultItem itemExtension : itemExtensionList) {
			itemExtension.updateQuality();
		}
    	items = itemExtensionList.toArray(new Item[itemExtensionList.size()]);
    }

    private DefaultItem qualityUpdater(final Item item) {
        Class<?> itemClass;
        DefaultItem defaultItem = null;

        try {
            itemClass = Class.forName(ItemTypeConfig.SPECIALIZED_CLASSES.get(item.name));
        } catch (NullPointerException | ClassNotFoundException e) {
            itemClass = ItemTypeConfig.DEFAULT_CLASS;
        }

        try {
        	defaultItem = (DefaultItem) itemClass.getConstructor(String.class, int.class, int.class).newInstance(item.name, item.sellIn, item.quality);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultItem;
    }

}