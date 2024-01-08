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
                incQualityUpTo50(item);

                if (item.sellIn < 11)
                    incQualityUpTo50(item);

                if (item.sellIn < 6)
                    incQualityUpTo50(item);
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
        if (item.quality < 50)
            item.quality++;
    }
}
