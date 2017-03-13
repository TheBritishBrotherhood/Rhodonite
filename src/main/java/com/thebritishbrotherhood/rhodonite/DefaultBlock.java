 package com.thebritishbrotherhood.rhodonite;

 import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;

   public class DefaultBlock extends Block implements ItemModelProvider
 {
   private String name;

   public DefaultBlock(String name)
   {
     super(net.minecraft.block.material.Material.ROCK);
     this.name = name;
     setUnlocalizedName(name);
     setRegistryName(name);
     setCreativeTab(net.minecraft.creativetab.CreativeTabs.BUILDING_BLOCKS);
   }

   public void registerItemModel(Item item)
   {
     Rhodonite.proxy.registerItemRenderer(item, 0, this.name);
   }
 }
