 package com.thebritishbrotherhood.rhodonite.items;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;
 import com.thebritishbrotherhood.rhodonite.ItemModelProvider;

 import java.util.List;

 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.world.World;

 public class HeartOfRhodonite extends Item implements ItemModelProvider
 {
   public HeartOfRhodonite()
   {
     setUnlocalizedName("HeartOfRhodonite");
     setRegistryName("HeartOfRhodonite");
     setCreativeTab(Rhodonite.tab);
   }

   public void registerItemModel(Item item)
   {
     Rhodonite.proxy.registerItemRenderer(this, 0, "HeartOfRhodonite");
   }

   public void onCreated(ItemStack itemstack, World world, EntityPlayer entity)
   {
     float var4 = 1.0F;
     int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * var4);
     int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * var4 + 1.62D);
     int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * var4);

     if (Math.random() * 100.0D <= 15.0D) {
       world.createExplosion(null, i, j, k, 2.0F, false);
     }
   }

   public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
   {
     tooltip.add("§9Very unstable upon crafting");
   }
 }
