 package com.thebritishbrotherhood.rhodonite.weapons.Bow;

 import javax.annotation.Nullable;
 import com.thebritishbrotherhood.rhodonite.Rhodonite;
import net.minecraft.enchantment.EnchantmentHelper;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;

 import net.minecraft.entity.projectile.EntityArrow;
 import net.minecraft.init.Enchantments;
 import net.minecraft.init.Items;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemArrow;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.ActionResult;
 import net.minecraft.util.EnumActionResult;
 import net.minecraft.util.EnumHand;
 import net.minecraft.world.World;

 public class RhodoniteBow extends Item implements com.thebritishbrotherhood.rhodonite.ItemModelProvider
 {
   public RhodoniteBow()
   {
     setUnlocalizedName("RhodoniteBow");
     setRegistryName("RhodoniteBow");
     this.maxStackSize = 1;
     setMaxDamage(9596);
     setCreativeTab(Rhodonite.tab);
     addPropertyOverride(new net.minecraft.util.ResourceLocation("pull"), new net.minecraft.item.IItemPropertyGetter() {
       @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
       public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
         if (entityIn == null) {
           return 0.0F;
         }
         ItemStack itemstack = entityIn.getActiveItemStack();
         return (itemstack != null) && (itemstack.getItem() == Items.BOW) ? (stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F : 0.0F;
       }

     });
     addPropertyOverride(new net.minecraft.util.ResourceLocation("pulling"), new net.minecraft.item.IItemPropertyGetter() {
       @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
       public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
         return (entityIn != null) && (entityIn.isHandActive()) && (entityIn.getActiveItemStack() == stack) ? 1.0F : 0.0F;
       }
     });
   }

   private ItemStack findAmmo(EntityPlayer player) {
     if (isArrow(player.getHeldItem(EnumHand.OFF_HAND)))
       return player.getHeldItem(EnumHand.OFF_HAND);
     if (isArrow(player.getHeldItem(EnumHand.MAIN_HAND))) {
                return player.getHeldItem(EnumHand.MAIN_HAND);
     }
     for (int i = 0; i < player.inventory.getSizeInventory(); i++) {ItemStack itemstack = player.inventory.getStackInSlot(i);
         if (isArrow(itemstack)) {return itemstack;
       }
     }
       return null;
   }

   protected boolean isArrow(@Nullable ItemStack stack)
   {return (stack != null) && ((stack.getItem() instanceof ItemArrow));
   }



   public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
   {if ((entityLiving instanceof EntityPlayer)) {
       EntityPlayer entityplayer = (EntityPlayer)entityLiving;
       boolean flag = (entityplayer.capabilities.isCreativeMode) || (EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0);
       ItemStack itemstack = findAmmo(entityplayer);

       int i = getMaxItemUseDuration(stack) - timeLeft;
       i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, (EntityPlayer)entityLiving, i, (itemstack != null) || (flag));
       if (i < 0) { return;
       }
       if ((itemstack != null) || (flag)) {if (itemstack == null) {
           itemstack = new ItemStack(Items.ARROW);
         }
           float f = getArrowVelocity(i);
           if (f >= 0.1D) {boolean flag1 = (entityplayer.capabilities.isCreativeMode) || (((itemstack.getItem() instanceof ItemArrow)) && (((ItemArrow)itemstack.getItem()).isInfinite(itemstack, stack, entityplayer)));
               if (!worldIn.isRemote) {ItemArrow itemarrow = (ItemArrow)((itemstack.getItem() instanceof ItemArrow) ? itemstack.getItem() : Items.ARROW);EntityArrow entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);entityarrow.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 1.0F);
                   if (f == 1.0F) {entityarrow.setIsCritical(true);
             }

              entityarrow.setDamage(10.0D);

              int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

              if (j > 0) {
                entityarrow.setDamage(entityarrow.getDamage() + j * 0.5D + 0.5D);
             }

              int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);

              if (k > 0) {
                entityarrow.setKnockbackStrength(k);
             }

              if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                entityarrow.setFire(100);
             }

              stack.damageItem(1, entityplayer);

              if (flag1) {
                entityarrow.pickupStatus = net.minecraft.entity.projectile.EntityArrow.PickupStatus.CREATIVE_ONLY;
             }

              worldIn.spawnEntityInWorld(entityarrow);
           }

            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, net.minecraft.init.SoundEvents.ENTITY_ARROW_SHOOT, net.minecraft.util.SoundCategory.NEUTRAL, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (!flag1) {
              itemstack.stackSize -= 1;

              if (itemstack.stackSize == 0) {
                entityplayer.inventory.deleteStack(itemstack);
             }
           }

            entityplayer.addStat(net.minecraft.stats.StatList.getObjectUseStats(this));
         }
       }
     }
   }



   public static float getArrowVelocity(int charge)
   {
      float f = charge / 20.0F;
      f = (f * f + f * 2.0F) / 3.0F;

      if (f > 1.0F) {
        f = 1.0F;
     }

      return f;
   }



   public int getMaxItemUseDuration(ItemStack stack)
   {
     return 72000;
   }



   public net.minecraft.item.EnumAction getItemUseAction(ItemStack stack)
   {
     return net.minecraft.item.EnumAction.BOW;
   }

   public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
     boolean flag = findAmmo(playerIn) != null;

     ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemStackIn, worldIn, playerIn, hand, flag);
     if (ret != null) { return ret;
     }
     if ((!playerIn.capabilities.isCreativeMode) && (!flag)) {
       return !flag ? new ActionResult(EnumActionResult.FAIL, itemStackIn) : new ActionResult(EnumActionResult.PASS, itemStackIn);
     }
     playerIn.setActiveHand(hand);
     return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
   }


   public void registerItemModel(Item item)
   {
     Rhodonite.proxy.registerItemRenderer(this, 0, "RhodoniteBow");
   }





   public int getItemEnchantability()
   {
     return 1;
   }
 }
