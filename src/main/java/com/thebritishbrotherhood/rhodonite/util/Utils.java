 package com.thebritishbrotherhood.rhodonite.util;

 import java.util.Random;
 import java.util.Set;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.client.renderer.RenderHelper;
 import net.minecraft.item.ItemStack;

 import net.minecraftforge.common.MinecraftForge;
 import net.minecraftforge.fml.common.discovery.ASMDataTable;

 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;

 public final class Utils
 {
   public static final Random RANDOM = new Random();

   public static ItemStack setUnbreakable(ItemStack stack)
   {
     NBTHelper.checkNBT(stack);
     stack.getTagCompound().setBoolean("Unbreakable", true);
     return stack;
   }

   public static void registerHandlers(Set<ASMDataTable.ASMData> eventHandlers) {
     for (ASMDataTable.ASMData data : eventHandlers) {
       try {
         Class<?> handlerClass = Class.forName(data.getClassName());
         Object handlerImpl = handlerClass.newInstance();
         MinecraftForge.EVENT_BUS.register(handlerImpl);
       }
       catch (Exception localException) {}
     }
   }

   @SideOnly(Side.CLIENT)
   public static void renderItemInWorld(ItemStack stack)
   {
     if ((stack != null) && (stack.getItem() != null)) {
       GlStateManager.pushMatrix();
       GlStateManager.disableLighting();
       GlStateManager.pushAttrib();
       RenderHelper.enableStandardItemLighting();
       Minecraft.getMinecraft().getRenderItem().renderItem(stack, net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.FIXED);
       RenderHelper.disableStandardItemLighting();
       GlStateManager.popAttrib();
       GlStateManager.enableLighting();
       GlStateManager.popMatrix();
     }
   }
 }
