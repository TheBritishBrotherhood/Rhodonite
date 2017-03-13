 package com.thebritishbrotherhood.rhodonite.items;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;
 import com.thebritishbrotherhood.rhodonite.ItemModelProvider;


import net.minecraft.item.Item;

 public class RhodoniteSharpeningKit
   extends Item implements ItemModelProvider
 {
   public RhodoniteSharpeningKit()
   {
     setUnlocalizedName("RhodoniteSharpeningKit");
     setRegistryName("RhodoniteSharpeningKit");
     setCreativeTab(Rhodonite.tab);
   }

   public void registerItemModel(Item item) {
     Rhodonite.proxy.registerItemRenderer(this, 0, "RhodoniteSharpeningKit");
   }
 }

