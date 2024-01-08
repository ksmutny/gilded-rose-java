package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) continue;

            int adjustment = qualityAdjustment(item);

            item.quality = clamp(item.quality + adjustment, 0, 50);
            item.sellIn--;
        }
    }

    private int qualityAdjustment(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return item.sellIn <= 0 ? 2 : 1;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.sellIn <= 0) return -item.quality;
                else if (item.sellIn <= 5) return 3;
                else if (item.sellIn <= 10) return 2;
                else return 1;
            default:
                return item.sellIn <= 0 ? -2 : -1;
        }
    }

    private int clamp(int value, int min, int max) {
        return Math.min(max, Math.max(min, value));
    }
}
