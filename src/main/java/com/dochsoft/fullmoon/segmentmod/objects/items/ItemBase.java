package com.dochsoft.fullmoon.segmentmod.objects.items;

import com.dochsoft.fullmoon.segmentmod.init.ItemInit;
import com.dochsoft.fullmoon.segmentmod.util.IHasModel;
import com.dochsoft.fullmoon.segmentmod.util.Reference;
import com.dochsoft.fullmoon.segmentmod.Segmentmod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Reference.nymphWarModCreativeTab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Segmentmod.proxy.registerItemRenderer(this, 0, "invent");
    }
}
