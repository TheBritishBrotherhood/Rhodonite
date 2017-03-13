 package com.thebritishbrotherhood.rhodonite;

 import com.thebritishbrotherhood.rhodonite.blocks.RhodoniteBlock;
 import com.thebritishbrotherhood.rhodonite.blocks.RhodoniteOre;
 import net.minecraft.block.Block;
 import net.minecraft.item.ItemBlock;
 import net.minecraftforge.fml.common.registry.GameRegistry;


 public class DevBlock
 {
   public static Block RhodoniteOre;
   public static Block RhodoniteBlock;

   public static void init()
   {
     RhodoniteOre = register(new RhodoniteOre());
     RhodoniteBlock = register(new RhodoniteBlock());
   }


   private static <T extends Block> T register(T block, ItemBlock itemBlock)
   {
     GameRegistry.register(block);
     if (itemBlock != null) {
       GameRegistry.register(itemBlock);
     }
     if ((block instanceof ItemModelProvider)) {
       ((ItemModelProvider)block).registerItemModel(itemBlock);
     }
     return block;
   }

   private static <T extends Block> T register(T block) {
     ItemBlock itemBlock = new ItemBlock(block);
     itemBlock.setRegistryName(block.getRegistryName());
     return register(block, itemBlock);
   }
 }
