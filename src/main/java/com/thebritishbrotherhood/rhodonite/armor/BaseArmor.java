 package com.thebritishbrotherhood.rhodonite.armor;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.item.ItemArmor;

 import net.minecraftforge.fml.relauncher.SideOnly;

 public class BaseArmor extends ItemArmor
 {
   public BaseArmor(ItemArmor.ArmorMaterial armorMaterial, int armorPreffix, EntityEquipmentSlot slot, String name)
   {
     super(armorMaterial, armorPreffix, slot);
     setMaxStackSize(1);
     setUnlocalizedName("BaseArmor");
     setCreativeTab(Rhodonite.tab);
   }

   @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
   public void initModel() {
     net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
   }
 }
