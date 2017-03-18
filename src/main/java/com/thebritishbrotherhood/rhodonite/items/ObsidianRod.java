package com.thebritishbrotherhood.rhodonite.items;

import com.thebritishbrotherhood.rhodonite.ItemModelProvider;
import com.thebritishbrotherhood.rhodonite.Rhodonite;


import net.minecraft.item.Item;

public class ObsidianRod extends Item implements ItemModelProvider
{
    public ObsidianRod()
    {
        setUnlocalizedName("ObsidianRod");
        setRegistryName("ObsidianRod");
        setCreativeTab(Rhodonite.tab);
    }

    public void registerItemModel(Item item) {
        Rhodonite.proxy.registerItemRenderer(this, 0, "ObsidianRod");
    }
}
