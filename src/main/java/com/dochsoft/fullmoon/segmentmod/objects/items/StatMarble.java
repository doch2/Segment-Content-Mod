package com.dochsoft.fullmoon.segmentmod.objects.items;

import net.minecraft.command.CommandGameMode;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.swing.text.html.parser.Entity;

public class StatMarble extends ItemBase {
    public StatMarble(String name) {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityPlayer, EnumHand enumHand) {
        ItemStack item = entityPlayer.getHeldItem(enumHand);

        item.damageItem(1, entityPlayer);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }
}
