 package com.thebritishbrotherhood.rhodonite.weapons.Swords;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemSword;

 public class rhodonitesword extends ItemSword implements com.thebritishbrotherhood.rhodonite.ItemModelProvider
 {
   public static float attackDamage;
   private final Item.ToolMaterial material;

   public rhodonitesword(Item.ToolMaterial material)
   {
     super(material);
     setUnlocalizedName("rhodonitesword");
     setRegistryName("rhodonitesword");
     setCreativeTab(Rhodonite.tab);
     this.material = material;
     attackDamage = 38.0F + material.getDamageVsEntity();
   }

   public void registerItemModel(net.minecraft.item.Item item)
   {
     Rhodonite.proxy.registerItemRenderer(this, 0, "rhodonitesword");
   }
 }
