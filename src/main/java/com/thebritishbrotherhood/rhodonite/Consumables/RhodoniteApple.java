 package com.thebritishbrotherhood.rhodonite.Consumables;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;
 import com.thebritishbrotherhood.rhodonite.ItemModelProvider;

 import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.MobEffects;
 import net.minecraft.item.EnumRarity;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemFood;
 import net.minecraft.item.ItemStack;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.world.World;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;


 public class RhodoniteApple
   extends ItemFood
   implements ItemModelProvider
 {
   public RhodoniteApple()
   {
     super(4, 2.0F, false);
     setHasSubtypes(true);
     setUnlocalizedName("RhodoniteApple");
     setRegistryName("RhodoniteApple");
     setCreativeTab(Rhodonite.tab);
     setAlwaysEdible().equals(Boolean.valueOf(true));
   }

   public RhodoniteApple(int amount, float saturation, boolean isWolfFood)
   {
     super(amount, saturation, isWolfFood);
     setHasSubtypes(true);
   }

   public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
   {
     tooltip.add("§9Effect: §rRegen");
     tooltip.add("§9Effect: §rWater Breathing");
     tooltip.add("§9Effect: §rResistance");
     tooltip.add("§9Effect: §rAbsorption");
   }

   @SideOnly(Side.CLIENT)
   public boolean hasEffect(ItemStack stack) {
     return stack.getMetadata() > 0;
   }

   public EnumRarity getRarity(ItemStack stack) {
     return stack.getMetadata() == 0 ? EnumRarity.RARE : EnumRarity.EPIC;
   }

   protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
   {
     if (!worldIn.isRemote)
     {
       if (stack.getMetadata() > 0)
       {

         player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 400, 1));
         player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 10000, 0));
         player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 6000, 0));
         player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 10000, 5));
       }
       else
       {
         player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 100, 1));
         player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 0));
       }
     }
   }



   @SideOnly(Side.CLIENT)
   public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
   {
     subItems.add(new ItemStack(itemIn, 1, 1));
   }

   public void registerItemModel(Item item)
   {
     Rhodonite.proxy.registerItemRenderer(this, 1, "RhodoniteApple");
   }
 }
