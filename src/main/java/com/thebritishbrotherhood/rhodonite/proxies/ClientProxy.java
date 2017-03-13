package com.thebritishbrotherhood.rhodonite.proxies;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import static net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation;


public class ClientProxy extends ServerProxy {
    public void registerItemRenderer(Item item, int meta, String id) {
        setCustomModelResourceLocation(item, meta, new ModelResourceLocation("rhodonite:" + id, "inventory"));
    }

}

