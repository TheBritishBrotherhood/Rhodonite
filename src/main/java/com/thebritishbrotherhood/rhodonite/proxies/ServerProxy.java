 package com.thebritishbrotherhood.rhodonite.proxies;

 import com.thebritishbrotherhood.rhodonite.EventHandler;
 import net.minecraft.item.Item;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

 import static net.minecraftforge.common.MinecraftForge.EVENT_BUS;
 import static net.minecraftforge.fml.common.registry.GameRegistry.registerWorldGenerator;


 public class ServerProxy
 {
   public void registerItemRenderer(Item item, int meta, String id)
   {
     EVENT_BUS.register(new EventHandler());
   }
     public void init(FMLInitializationEvent event) {
     registerWorldGenerator(new com.thebritishbrotherhood.rhodonite.worldgen.WorldGen(), 8);
   }
 }
