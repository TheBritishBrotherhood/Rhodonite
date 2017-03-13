 package com.thebritishbrotherhood.rhodonite.Tools;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemPickaxe;

 public class rhodonitepickaxe extends ItemPickaxe implements com.thebritishbrotherhood.rhodonite.ItemModelProvider
 {
   public static float attackDamage;
   private final Item.ToolMaterial material;

   public rhodonitepickaxe(Item.ToolMaterial material)
   {
     super(material);
     setUnlocalizedName("rhodonitepickaxe");
     setRegistryName("rhodonitepickaxe");
     setCreativeTab(Rhodonite.tab);
     this.material = material;
     attackDamage = 5.0F + material.getDamageVsEntity();
   }

   public void registerItemModel(net.minecraft.item.Item item)
   {
     Rhodonite.proxy.registerItemRenderer(this, 0, "rhodonitepickaxe");
   }
 }
