 package com.thebritishbrotherhood.rhodonite;

 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.item.ItemStack;

 import net.minecraftforge.fml.common.gameevent.TickEvent;


 public class EventHandler
 {
   @net.minecraftforge.fml.common.eventhandler.SubscribeEvent
   public void tick(TickEvent.PlayerTickEvent e)
   {
     if (!e.player.getEntityData().hasKey("wearingArmor")) {
       e.player.getEntityData().setBoolean("wearingArmor", false);
       e.player.getEntityData().setBoolean("canFly", e.player.capabilities.allowFlying);
     }

     ItemStack stack = e.player.inventory.armorItemInSlot(EntityEquipmentSlot.CHEST.getIndex());
     if ((stack != null) && ((stack.getItem() instanceof com.thebritishbrotherhood.rhodonite.armor.rhodonite.rhodonitechest))) {
       e.player.getEntityData().setBoolean("wearingArmor", true);
       e.player.capabilities.allowFlying = true;
     } else {
       e.player.getEntityData().setBoolean("wearingArmor", false);
       e.player.capabilities.allowFlying = e.player.getEntityData().getBoolean("canFly");
     }
   }
 }
