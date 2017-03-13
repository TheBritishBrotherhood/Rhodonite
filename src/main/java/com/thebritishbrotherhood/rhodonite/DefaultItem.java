 package com.thebritishbrotherhood.rhodonite;

 import net.minecraft.item.Item;

 public class DefaultItem extends Item implements ItemModelProvider
 {
   private String name;


   public DefaultItem(String name) {
     this.name = name;
     setUnlocalizedName(name);
     setRegistryName(name);
     setCreativeTab(net.minecraft.creativetab.CreativeTabs.BUILDING_BLOCKS);
   }

   public void registerItemModel(Item item)
   {
     Rhodonite.proxy.registerItemRenderer(this, 0, this.name);
   }
 }
