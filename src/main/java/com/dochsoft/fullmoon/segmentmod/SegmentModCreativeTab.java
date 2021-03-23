package com.dochsoft.fullmoon.segmentmod;

import com.dochsoft.fullmoon.segmentmod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SegmentModCreativeTab extends CreativeTabs {

    public SegmentModCreativeTab() {
        super("segmentModCreativeTab");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.NUMBER_ZERO);
    }
}
