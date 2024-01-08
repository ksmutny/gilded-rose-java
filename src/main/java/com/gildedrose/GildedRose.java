package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                incQualityUpTo50(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                int adjustment;

                if (item.sellIn <= 5)
                    adjustment = 3;
                else if (item.sellIn <= 10)
                    adjustment = 2;
                else
                    adjustment = 1;

                incQualityUpTo50(item, adjustment);
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

            } else {
                if (item.quality > 0)
                    item.quality--;
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros"))
                item.sellIn--;

            if (item.sellIn < 0)
                if (!item.name.equals("Aged Brie"))
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0)
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros"))
                                item.quality--;
                    } else {
                        item.quality = 0;
                    }
                else
                    incQualityUpTo50(item);
        }
    }

    private void incQualityUpTo50(Item item) {
        incQualityUpTo50(item, 1);
    }

    private void incQualityUpTo50(Item item, int adjustment) {
        item.quality = Math.min(50, item.quality + adjustment);
    }
}
