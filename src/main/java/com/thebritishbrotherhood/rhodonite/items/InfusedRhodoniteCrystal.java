 package com.thebritishbrotherhood.rhodonite.items;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;

 import net.minecraft.item.Item;

 public class InfusedRhodoniteCrystal extends Item implements com.thebritishbrotherhood.rhodonite.ItemModelProvider
 {
   public InfusedRhodoniteCrystal()
   {
     setUnlocalizedName("InfusedRhodoniteCrystal");
     setRegistryName("InfusedRhodoniteCrystal");
     setCreativeTab(Rhodonite.tab);
   }

   public void registerItemModel(Item item) {
     Rhodonite.proxy.registerItemRenderer(this, 0, "InfusedRhodoniteCrystal");
   }
 }

