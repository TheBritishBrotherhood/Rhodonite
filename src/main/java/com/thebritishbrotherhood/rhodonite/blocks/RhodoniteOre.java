 package com.thebritishbrotherhood.rhodonite.blocks;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;
 import com.thebritishbrotherhood.rhodonite.DevItem;
 import com.thebritishbrotherhood.rhodonite.ItemModelProvider;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Random;

import net.minecraft.block.Block;
 import net.minecraft.block.material.Material;

 import net.minecraft.block.state.IBlockState;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.IBlockAccess;

 public class RhodoniteOre
   extends Block implements ItemModelProvider
 {
   private Random rand = new Random();

   public RhodoniteOre() {
     super(Material.ROCK);
     setDefaultState(this.blockState.getBaseState());
     setHarvestLevel("pickaxe", 4);
     setUnlocalizedName("RhodoniteOre");
     setRegistryName("RhodoniteOre");
     setCreativeTab(Rhodonite.tab);
     setResistance(8.0F);
     setHardness(25.0F);
   }


   public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
   {
     tooltip.add("§9Can Be Found In The End");
   }

   public void registerItemModel(Item item)
   {
     Rhodonite.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "RhodoniteOre");
   }

   public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
   {
     List<ItemStack> drops = new ArrayList();
     drops.add(new ItemStack(DevItem.RhodoniteDust));
     if (this.rand.nextInt(10) < 4) drops.add(new ItemStack(DevItem.RhodoniteDust));
     return drops;
   }

   public int quantityDropped(Random random)
   {
     return 1;
   }
 }
