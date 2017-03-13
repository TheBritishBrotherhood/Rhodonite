 package com.thebritishbrotherhood.rhodonite.Plants;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;
 import java.util.Random;
 import javax.annotation.Nullable;

import net.minecraft.block.Block;
 import net.minecraft.block.BlockDirt;

 import net.minecraft.block.BlockTallGrass;

 import net.minecraft.block.IGrowable;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.properties.IProperty;
 import net.minecraft.block.properties.PropertyBool;
 import net.minecraft.block.state.BlockStateContainer;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.init.Blocks;
 import net.minecraft.item.Item;
 import net.minecraft.util.BlockRenderLayer;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.IBlockAccess;
 import net.minecraft.world.World;



 public class RhodonitePlant extends Block implements IGrowable
 {
   public static final PropertyBool SNOWY = PropertyBool.create("snowy");

   public RhodonitePlant()
   {
     super(Material.PLANTS);
     setDefaultState(this.blockState.getBaseState().withProperty(SNOWY, Boolean.valueOf(false)));
     setTickRandomly(true);
     setUnlocalizedName("RhodonitePlant");
     setRegistryName("RhodonitePlant");
     setCreativeTab(Rhodonite.tab);
   }





   public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
   {
     Block block = worldIn.getBlockState(pos.up()).getBlock();
     return state.withProperty(SNOWY, Boolean.valueOf((block == Blocks.SNOW) || (block == Blocks.SNOW_LAYER)));
   }

   public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
   {
     if (!worldIn.isRemote)
     {
       if ((worldIn.getLightFromNeighbors(pos.up()) < 4) && (worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2))
       {
         worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState());


       }
       else if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
       {
         for (int i = 0; i < 4; i++)
         {
           BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

           if ((blockpos.getY() >= 0) && (blockpos.getY() < 256) && (!worldIn.isBlockLoaded(blockpos)))
           {
             return;
           }

           IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
           IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

           if ((iblockstate1.getBlock() == Blocks.DIRT) && (iblockstate1.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT) && (worldIn.getLightFromNeighbors(blockpos.up()) >= 4) && (iblockstate.getLightOpacity(worldIn, pos.up()) <= 2))
           {
             worldIn.setBlockState(blockpos, Blocks.GRASS.getDefaultState());
           }
         }
       }
     }
   }





   @Nullable
   public Item getItemDropped(IBlockState state, Random rand, int fortune)
   {
     return Blocks.DIRT.getItemDropped(Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), rand, fortune);
   }




   public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
   {
     return true;
   }

   public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
   {
     return true;
   }

   public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
   {
     BlockPos blockpos = pos.up();

     for (int i = 0; i < 128; i++)
     {
       BlockPos blockpos1 = blockpos;
       int j = 0;

       for (;;)
       {
         if (j >= i / 16)
         {
           if (!worldIn.isAirBlock(blockpos1))
             break;
           if (rand.nextInt(8) == 0)
           {
             worldIn.getBiome(blockpos1).plantFlower(worldIn, rand, blockpos1); break;
           }


           IBlockState iblockstate1 = Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS);

           if (Blocks.TALLGRASS.canBlockStay(worldIn, blockpos1, iblockstate1))
           {
             worldIn.setBlockState(blockpos1, iblockstate1, 3);
           }
           break;
         }




         blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);

         if ((worldIn.getBlockState(blockpos1.down()).getBlock() != Blocks.GRASS) || (worldIn.getBlockState(blockpos1).isNormalCube())) {
           break;
         }


         j++;
       }
     }
   }

   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
   public BlockRenderLayer getBlockLayer()
   {
     return BlockRenderLayer.CUTOUT_MIPPED;
   }




   public int getMetaFromState(IBlockState state)
   {
     return 0;
   }

   protected BlockStateContainer createBlockState()
   {
     return new BlockStateContainer(this, new IProperty[] { SNOWY });
   }
 }
