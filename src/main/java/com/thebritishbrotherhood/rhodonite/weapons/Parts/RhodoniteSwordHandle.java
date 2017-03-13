/*    */ package com.thebritishbrotherhood.rhodonite.weapons.Parts;
/*    */ 
/*    */ import com.thebritishbrotherhood.rhodonite.Rhodonite;
/*    */
import net.minecraft.item.Item;
/*    */ 
/*    */ public class RhodoniteSwordHandle extends Item implements com.thebritishbrotherhood.rhodonite.ItemModelProvider
/*    */ {
/*    */   public RhodoniteSwordHandle()
/*    */   {
/* 10 */     setUnlocalizedName("RhodoniteSwordHandle");
/* 11 */     setRegistryName("RhodoniteSwordHandle");
/* 12 */     setCreativeTab(Rhodonite.tab);
/*    */   }
/*    */   
/*    */   public void registerItemModel(Item item) {
/* 16 */     Rhodonite.proxy.registerItemRenderer(this, 0, "RhodoniteSwordHandle");
/*    */   }
/*    */ }


/* Location:              C:\Users\curti\Desktop\Rhodonite-deobf.jar!\com\thebritishbrotherhood\rhodonite\weapons\Parts\RhodoniteSwordHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */