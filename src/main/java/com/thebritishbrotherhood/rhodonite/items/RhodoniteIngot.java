 package com.thebritishbrotherhood.rhodonite.items;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;

import net.minecraft.item.Item;

 public class RhodoniteIngot extends Item implements com.thebritishbrotherhood.rhodonite.ItemModelProvider
 {
   public RhodoniteIngot()
   {
     setUnlocalizedName("RhodoniteIngot");
     setRegistryName("RhodoniteIngot");
     setCreativeTab(Rhodonite.tab);
   }

   public void registerItemModel(Item item) {
     Rhodonite.proxy.registerItemRenderer(this, 0, "RhodoniteIngot");
   }
 }
