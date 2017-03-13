 package com.thebritishbrotherhood.rhodonite;


 import com.thebritishbrotherhood.rhodonite.CreativeTab.creativetab;
 import com.thebritishbrotherhood.rhodonite.proxies.ServerProxy;

 import net.minecraft.creativetab.CreativeTabs;
 import net.minecraft.init.Items;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.common.Mod;


 import net.minecraftforge.fml.common.SidedProxy;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry;


 @Mod(modid="rhodonite", name="rhodonite", version="0.0.1", acceptedMinecraftVersions="[1.10.2]")
 public class Rhodonite
 {
   public static final String MODID = "rhodonite";
   public static final String VERSION = "0.0.1";
   public static final String NAME = "rhodonite";
   public static Item item;
   public static final CreativeTabs tab = new creativetab("Rhodonite");

   @Mod.Instance("rhodonite")
   public static Rhodonite instance;
   @SidedProxy(serverSide="com.thebritishbrotherhood.rhodonite.proxies.ServerProxy", clientSide="com.thebritishbrotherhood.rhodonite.proxies.ClientProxy")
   public static ServerProxy proxy;

   @Mod.EventHandler
   public void init(FMLPreInitializationEvent event)
   {
    DevBlock.init();
    DevItem.init();

    GameRegistry.addSmelting(DevItem.RhodoniteDust, new ItemStack(DevItem.RhodoniteIngot), 0.0F);
   }

   @Mod.EventHandler
   public void init(FMLInitializationEvent event)
   {
    proxy.init(event);

    GameRegistry.addShapelessRecipe(new ItemStack(DevItem.RhodoniteNugget, 9), DevItem.RhodoniteIngot);
    GameRegistry.addShapelessRecipe(new ItemStack(DevItem.RhodoniteSharpeningKit), DevItem.HeartOfRhodonite, DevItem.InfusedRhodoniteCrystal);
    GameRegistry.addShapelessRecipe(new ItemStack(DevItem.RhodoniteIngot, 9), DevBlock.RhodoniteBlock);


    GameRegistry.addShapedRecipe(new ItemStack(DevItem.HeartOfRhodonite), "e e", "sxs", " s ", 'x', DevBlock.RhodoniteBlock, 's', DevItem.RhodoniteIngot, 'e', DevItem.RhodoniteNugget);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.RhodoniteCrystal), "xxx", "xsx", "xxx", 'x', DevItem.RhodoniteIngot, 's', DevItem.HeartOfRhodonite);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.InfusedRhodoniteCrystal), "exe", "xsx", "exe", 'x', DevItem.RhodoniteIngot, 's', DevItem.RhodoniteCrystal, 'e', Items.ENDER_EYE);
    GameRegistry.addShapedRecipe(new ItemStack(DevBlock.RhodoniteBlock), "xxx", "xxx", "xxx", 'x', DevItem.RhodoniteIngot);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.RhodoniteIngot), "xxx", "xxx", "xxx", 'x', DevItem.RhodoniteNugget);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.RhodoniteSwordBlade), "  s", " s ", "x  ", 'x', DevItem.InfusedRhodoniteCrystal, 's', DevItem.RhodoniteIngot);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.RhodoniteSwordHandle), "s  ", " s ", "x s", 'x', Items.STICK, 's', DevItem.RhodoniteIngot);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.RhodoniteSwordNoodle), "  e", " s ", "x  ", 'x', DevItem.RhodoniteSwordHandle, 's', DevItem.InfusedRhodoniteCrystal, 'e', DevItem.RhodoniteSwordBlade);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.rhodonitesword), "   ", " sx", "   ", 'x', DevItem.RhodoniteSharpeningKit, 's', DevItem.RhodoniteSwordNoodle);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.rhodonitepickaxe), "ere", " x ", " x ", 'x', Items.STICK, 'r', DevItem.InfusedRhodoniteCrystal, 'e', DevItem.RhodoniteIngot);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.RhodoniteBow), " rx", "e x", " rx", 'x', Items.STRING, 'r', DevItem.InfusedRhodoniteCrystal, 'e', DevItem.RhodoniteIngot);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.RhodoniteApple, 1, 1), "eee", "ese", "rxr", 'x', DevBlock.RhodoniteBlock, 's', Items.APPLE, 'e', Items.ENDER_PEARL, 'r', new ItemStack(Items.DYE, 1, 4));



    GameRegistry.addShapedRecipe(new ItemStack(DevItem.rhodonitehelmet), "xsx", "x x", "   ", 'x', DevItem.RhodoniteIngot, 's', DevItem.InfusedRhodoniteCrystal);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.rhodonitechest), "x x", "ses", "xxx", 'x', DevItem.RhodoniteIngot, 's', DevItem.InfusedRhodoniteCrystal, 'e', DevItem.HeartOfRhodonite);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.rhodonitelegs), "xxx", "x x", "x x", 'x', DevItem.RhodoniteIngot);
    GameRegistry.addShapedRecipe(new ItemStack(DevItem.rhodoniteboots), "   ", "x x", "s s", 'x', DevItem.RhodoniteIngot, 's', DevBlock.RhodoniteBlock);
   }
 }
