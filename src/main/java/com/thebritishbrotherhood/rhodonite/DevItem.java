 package com.thebritishbrotherhood.rhodonite;

 import com.thebritishbrotherhood.rhodonite.Consumables.RhodoniteApple;
 import com.thebritishbrotherhood.rhodonite.Tools.rhodonitepickaxe;
 import com.thebritishbrotherhood.rhodonite.Tools.rhodoniteshovel;
 import com.thebritishbrotherhood.rhodonite.armor.rhodonite.rhodonitelegs;
 import com.thebritishbrotherhood.rhodonite.items.HeartOfRhodonite;
 import com.thebritishbrotherhood.rhodonite.items.InfusedRhodoniteCrystal;
 import com.thebritishbrotherhood.rhodonite.items.RhodoniteCrystal;
 import com.thebritishbrotherhood.rhodonite.items.RhodoniteDust;
 import com.thebritishbrotherhood.rhodonite.items.RhodoniteIngot;
 import com.thebritishbrotherhood.rhodonite.items.RhodoniteNugget;
 import com.thebritishbrotherhood.rhodonite.items.RhodoniteSharpeningKit;
 import com.thebritishbrotherhood.rhodonite.weapons.Parts.RhodoniteSwordHandle;
 import com.thebritishbrotherhood.rhodonite.weapons.Swords.RhodoniteSwordNoodle;
 import net.minecraft.init.SoundEvents;
 import net.minecraft.item.Item;

 import net.minecraft.item.ItemArmor;
 import net.minecraftforge.common.util.EnumHelper;
 import net.minecraftforge.fml.common.registry.GameRegistry;

 public class DevItem
 {
   public static Item rhodonitesword;
   public static Item RhodoniteSwordNoodle;
   public static Item rhodonitepickaxe;
   public static Item RhodoniteIngot;
   public static Item RhodoniteDust;
   public static Item RhodoniteCrystal;
   public static Item InfusedRhodoniteCrystal;
   public static RhodoniteApple RhodoniteApple;
   public static Item rhodoniteboots;
   public static Item rhodonitelegs;
   public static Item rhodonitechest;
   public static Item rhodonitehelmet;
   public static Item HeartOfRhodonite;
   public static Item RhodoniteBow;
   public static Item RhodoniteSwordHandle;
   public static Item RhodoniteSwordBlade;
   public static Item RhodoniteSharpeningKit;
   public static Item RhodoniteNugget;
   public static Item rhodoniteshovel;
   public static Item.ToolMaterial rhodoniteswordA = EnumHelper.addToolMaterial("rhodonitesword", 1, 9556, 7.0F, 34.0F, 64);
   public static Item.ToolMaterial rhodoniteswordB = EnumHelper.addToolMaterial("RhodoniteSwordNoodle", 1, 1223, 7.0F, 12.0F, 0);

   public static ItemArmor.ArmorMaterial rhodonitearmor = EnumHelper.addArmorMaterial("rhodonitearmor", "rhodonite:rhodonitearmor", 45, new int[] { 4, 8, 11, 6 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);

   public static Item.ToolMaterial rhodonitepickaxeA = EnumHelper.addToolMaterial("rhodonitepickaxe", 5, 9556, 40.0F, 2.0F, 64);
   public static Item.ToolMaterial rhodoniteshovelA = EnumHelper.addToolMaterial("rhodoniteshovel", 5, 9556, 20.0F, 2.0F, 64);

   public static void init()
   {
     RhodoniteIngot = register(new RhodoniteIngot());
     RhodoniteDust = register(new RhodoniteDust());
     RhodoniteNugget = register(new RhodoniteNugget());
     RhodoniteSwordNoodle = register(new RhodoniteSwordNoodle(rhodoniteswordB));
     rhodonitesword = register(new com.thebritishbrotherhood.rhodonite.weapons.Swords.rhodonitesword(rhodoniteswordA));
     rhodonitepickaxe = register(new rhodonitepickaxe(rhodonitepickaxeA));
     rhodoniteshovel = register(new rhodoniteshovel(rhodoniteshovelA));
     RhodoniteBow = register(new com.thebritishbrotherhood.rhodonite.weapons.Bow.RhodoniteBow());
     RhodoniteCrystal = register(new RhodoniteCrystal());
     InfusedRhodoniteCrystal = register(new InfusedRhodoniteCrystal());
     rhodonitehelmet = register(new com.thebritishbrotherhood.rhodonite.armor.rhodonite.rhodonitehelmet(rhodonitearmor));
     rhodonitechest = register(new com.thebritishbrotherhood.rhodonite.armor.rhodonite.rhodonitechest(rhodonitearmor));
     rhodonitelegs = register(new rhodonitelegs(rhodonitearmor));
     rhodoniteboots = register(new com.thebritishbrotherhood.rhodonite.armor.rhodonite.rhodoniteboots(rhodonitearmor));
     RhodoniteApple = (RhodoniteApple)register(new RhodoniteApple());
     HeartOfRhodonite = register(new HeartOfRhodonite());
     RhodoniteSwordHandle = register(new RhodoniteSwordHandle());
     RhodoniteSwordBlade = register(new com.thebritishbrotherhood.rhodonite.weapons.Parts.RhodoniteSwordBlade());
     RhodoniteSharpeningKit = register(new RhodoniteSharpeningKit());
   }


   private static <T extends Item> T register(T item)
   {
     GameRegistry.register(item);
     if ((item instanceof ItemModelProvider)) {
       ((ItemModelProvider)item).registerItemModel(item);
     }
     return item;
   }
 }
