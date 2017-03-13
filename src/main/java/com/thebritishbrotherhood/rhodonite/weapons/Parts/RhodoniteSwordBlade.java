 package com.thebritishbrotherhood.rhodonite.weapons.Parts;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;
 import com.thebritishbrotherhood.rhodonite.ItemModelProvider;

 import net.minecraft.item.Item;

 public class RhodoniteSwordBlade
   extends Item implements ItemModelProvider
 {
   public RhodoniteSwordBlade()
   {
     setUnlocalizedName("RhodoniteSwordBlade");
     setRegistryName("RhodoniteSwordBlade");
     setCreativeTab(Rhodonite.tab);
   }

   public void registerItemModel(Item item) {
     Rhodonite.proxy.registerItemRenderer(this, 0, "RhodoniteSwordBlade");
   }
 }
