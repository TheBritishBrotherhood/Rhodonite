 package com.thebritishbrotherhood.rhodonite.Tools;

 import com.thebritishbrotherhood.rhodonite.Rhodonite;
 import net.minecraft.item.Item;
         import net.minecraft.item.ItemSpade;


 public class rhodoniteshovel extends ItemSpade implements com.thebritishbrotherhood.rhodonite.ItemModelProvider
 {
       public static float attackDamage;
       private final Item.ToolMaterial material;

   public rhodoniteshovel(Item.ToolMaterial material)
   {
     super(material);
     setUnlocalizedName("rhodoniteshovel");
     setRegistryName("rhodoniteshovel");
     setCreativeTab(Rhodonite.tab);
     this.material = material;
     attackDamage = 2.0F + material.getDamageVsEntity();
   }

   public void registerItemModel(net.minecraft.item.Item item)
   {
     Rhodonite.proxy.registerItemRenderer(this, 0, "rhodoniteshovel");
   }
 }