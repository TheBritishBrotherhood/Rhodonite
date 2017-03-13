 package com.thebritishbrotherhood.rhodonite.items;

 import com.thebritishbrotherhood.rhodonite.ItemModelProvider;
 import com.thebritishbrotherhood.rhodonite.Rhodonite;


import net.minecraft.item.Item;

 public class RhodoniteCrystal extends Item implements ItemModelProvider
 {
   public RhodoniteCrystal()
   {
     setUnlocalizedName("RhodoniteCrystal");
     setRegistryName("RhodoniteCrystal");
     setCreativeTab(Rhodonite.tab);
   }

   public void registerItemModel(Item item) {
     Rhodonite.proxy.registerItemRenderer(this, 0, "RhodoniteCrystal");
   }
 }

