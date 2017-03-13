package com.thebritishbrotherhood.rhodonite.CreativeTab;

import net.minecraft.creativetab.CreativeTabs;

   public class creativetab extends CreativeTabs
 {
   public creativetab(String label)
   {
     super(label);
   }

   public net.minecraft.item.Item getTabIconItem() { return com.thebritishbrotherhood.rhodonite.DevItem.rhodonitesword; }
 }
