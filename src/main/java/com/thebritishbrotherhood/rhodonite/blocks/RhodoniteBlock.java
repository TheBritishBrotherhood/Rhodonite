 package com.thebritishbrotherhood.rhodonite.blocks;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;
 import com.thebritishbrotherhood.rhodonite.ItemModelProvider;


import net.minecraft.block.Block;

 import net.minecraft.item.Item;

 public class RhodoniteBlock extends Block implements ItemModelProvider
 {
   public RhodoniteBlock()
   {
     super(net.minecraft.block.material.Material.IRON);
     setDefaultState(this.blockState.getBaseState());
     setHarvestLevel("pickaxe", 3);
     setUnlocalizedName("RhodoniteBlock");
     setRegistryName("RhodoniteBlock");
     setCreativeTab(Rhodonite.tab);
     setResistance(8.0F);
     setHardness(35.0F);
   }


   public void registerItemModel(Item item)
   {
     Rhodonite.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "RhodoniteBlock");
   }
 }
