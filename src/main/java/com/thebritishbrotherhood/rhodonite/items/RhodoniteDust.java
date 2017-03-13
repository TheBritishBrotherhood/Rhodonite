 package com.thebritishbrotherhood.rhodonite.items;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;

import net.minecraft.item.Item;

 public class RhodoniteDust extends Item implements com.thebritishbrotherhood.rhodonite.ItemModelProvider
 {
   public RhodoniteDust()
   {
     setUnlocalizedName("RhodoniteDust");
     setRegistryName("RhodoniteDust");
     setCreativeTab(Rhodonite.tab);
   }

   public void registerItemModel(Item item) {
     Rhodonite.proxy.registerItemRenderer(this, 0, "RhodoniteDust");
   }
 }
