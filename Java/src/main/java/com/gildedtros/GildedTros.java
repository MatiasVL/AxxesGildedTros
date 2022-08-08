package com.gildedtros;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Good Wine")
                    && !items[i].name.equals("Backstage passes for Re:Factor")
                    && !items[i].name.equals("Backstage passes for HAXX"))
            {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("B-DAWG Keychain")) {
                        items[i].quality--;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality++;

                    if (items[i].name.equals("Backstage passes for Re:Factor") || items[i].name.equals("Backstage passes for HAXX") ) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality++;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality++;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("B-DAWG Keychain")) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Good Wine")) {
                    if (!items[i].name.equals("Backstage passes for Re:Factor") && !items[i].name.equals("Backstage passes for HAXX")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("B-DAWG Keychain")) {
                                items[i].quality--;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality++;
                    }
                }
            }
        }
    }
}