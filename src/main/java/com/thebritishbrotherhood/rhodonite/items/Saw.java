 package com.thebritishbrotherhood.rhodonite.items;

 import com.thebritishbrotherhood.rhodonite.ItemModelProvider;
 import com.thebritishbrotherhood.rhodonite.Rhodonite;

import net.minecraft.item.Item;

 public class Saw extends Item implements ItemModelProvider
 {
   public Saw(ToolMaterial Saw)
   {
     setUnlocalizedName("Saw");
     setRegistryName("Saw");
     setCreativeTab(Rhodonite.tab);
   }

   public void registerItemModel(Item item) {
     Rhodonite.proxy.registerItemRenderer(this, 0, "Saw");
   }
 }
