 package com.thebritishbrotherhood.rhodonite.items;

 import com.thebritishbrotherhood.rhodonite.ItemModelProvider;
 import com.thebritishbrotherhood.rhodonite.Rhodonite;


import net.minecraft.item.Item;

 public class RhodoniteNugget extends Item implements ItemModelProvider
 {
   public RhodoniteNugget()
   {
     setUnlocalizedName("RhodoniteNugget");
     setRegistryName("RhodoniteNugget");
     setCreativeTab(Rhodonite.tab);
   }

   public void registerItemModel(Item item) {
     Rhodonite.proxy.registerItemRenderer(this, 0, "RhodoniteNugget");
   }
 }
