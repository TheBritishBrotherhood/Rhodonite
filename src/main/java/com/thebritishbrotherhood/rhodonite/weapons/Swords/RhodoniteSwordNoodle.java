 package com.thebritishbrotherhood.rhodonite.weapons.Swords;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;
 import net.minecraft.item.Item;

 import net.minecraft.item.ItemSword;

 public class RhodoniteSwordNoodle extends ItemSword implements com.thebritishbrotherhood.rhodonite.ItemModelProvider
 {
   public static float attackDamage;
   private final Item.ToolMaterial material;

   public RhodoniteSwordNoodle(Item.ToolMaterial material)
   {
     super(material);
     setUnlocalizedName("RhodoniteSwordNoodle");
     setRegistryName("RhodoniteSwordNoodle");
     setCreativeTab(Rhodonite.tab);
     this.material = material;
     attackDamage = 12.0F + material.getDamageVsEntity();
   }

   public void registerItemModel(Item item)
   {
     Rhodonite.proxy.registerItemRenderer(this, 0, "RhodoniteSwordNoodle");
   }
 }
