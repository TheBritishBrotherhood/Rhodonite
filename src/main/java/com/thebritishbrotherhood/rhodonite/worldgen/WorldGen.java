 package com.thebritishbrotherhood.rhodonite.worldgen;

 import com.thebritishbrotherhood.rhodonite.DevBlock;
 import java.util.Random;

 import net.minecraft.block.state.pattern.BlockMatcher;
 import net.minecraft.init.Blocks;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;

 import net.minecraft.world.chunk.IChunkGenerator;
 import net.minecraft.world.chunk.IChunkProvider;
 import net.minecraft.world.gen.feature.WorldGenMinable;
 import net.minecraftforge.fml.common.IWorldGenerator;

 public class WorldGen implements IWorldGenerator
 {
   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
   {
     switch (world.provider.getDimension())
     {
     case 0:
       break;

     case -1:
       break;

     case 1:
       generateEnd(world, random, chunkX * 16, chunkZ * 16);
     }
   }

   private void generateEnd(World world, Random rand, int chunkX, int chunkZ)
   {
     for (int i = 0; i < 18; i++) {
       int randPosX = chunkX + rand.nextInt(16);
       int randPosY = rand.nextInt(120);
       int randPosZ = chunkZ + rand.nextInt(16);
       new WorldGenMinable(DevBlock.RhodoniteOre.getDefaultState(), 3 + rand.nextInt(5), BlockMatcher.forBlock(Blocks.END_STONE))
         .generate(world, rand, new BlockPos(randPosX, randPosY, randPosZ));
     }
   }
 }
