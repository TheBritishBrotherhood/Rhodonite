 package com.thebritishbrotherhood.rhodonite.armor.rhodonite;

 import com.thebritishbrotherhood.rhodonite.DevItem;
 import com.thebritishbrotherhood.rhodonite.Rhodonite;
import com.thebritishbrotherhood.rhodonite.armor.BaseArmor;

 import java.util.List;
 import net.minecraft.entity.player.EntityPlayer;

 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;
 import net.minecraft.world.World;

 public class rhodonitechest extends BaseArmor implements com.thebritishbrotherhood.rhodonite.ItemModelProvider
 {
   public rhodonitechest(ItemArmor.ArmorMaterial rhodonitearmor)
   {
     super(rhodonitearmor, 0, EntityEquipmentSlot.CHEST, "rhodonitechest");
     setUnlocalizedName("rhodonitechest");
     setRegistryName("rhodonitechest");
   }


   public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack)
   {
     ItemStack head = entity.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
     ItemStack chest = entity.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
     ItemStack legs = entity.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
     ItemStack feet = entity.getItemStackFromSlot(EntityEquipmentSlot.FEET);
     if (((head != null) && (head.getItem() == DevItem.rhodonitehelmet) && (chest != null) && (chest.getItem() == DevItem.rhodonitechest) && (legs != null) && (legs.getItem() == DevItem.rhodonitelegs) && (feet != null) && (feet.getItem() == DevItem.rhodoniteboots)) || (entity.capabilities.isCreativeMode) || (entity.isSpectator())) {
       entity.capabilities.allowFlying = true;
     } else {
       entity.capabilities.isFlying = false;
       entity.capabilities.allowFlying = false;
     }
   }

   public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
   {
     tooltip.add("§9Ability: §rFlight");
     tooltip.add("§3Use: §rEquip The Full Set");
   }

   public void registerItemModel(Item item)
   {
     Rhodonite.proxy.registerItemRenderer(this, 0, "rhodonitechest");
   }
 }
