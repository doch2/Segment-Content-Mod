package com.dochsoft.fullmoon.segmentmod.init;

import com.dochsoft.fullmoon.segmentmod.objects.items.ItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item NUMBER_ONE = new ItemBase("number_one");
    public static final Item NUMBER_TWO = new ItemBase("number_two");
    public static final Item NUMBER_THREE = new ItemBase("number_three");
    public static final Item NUMBER_FOUR = new ItemBase("number_four");
    public static final Item NUMBER_FIVE = new ItemBase("number_five");
    public static final Item NUMBER_SIX = new ItemBase("number_six");
    public static final Item NUMBER_SEVEN = new ItemBase("number_seven");
    public static final Item NUMBER_EIGHT = new ItemBase("number_eight");
    public static final Item NUMBER_NINE = new ItemBase("number_nine");
    public static final Item NUMBER_ZERO = new ItemBase("number_zero");

    public static final Item DOOR_OPEN_KEYCARD = new ItemBase("door_open_keycard");
    public static final Item DOOR_LOCK_KEYCARD = new ItemBase("door_lock_keycard");

    public static final Item DEFAULT_ADDON = new ItemBase("default_addon");
    public static final Item ITEM_ADDON = new ItemBase("item_addon");

    public static final Item PLAYER_STOP_ITEM = new ItemBase("player_stop_item");
    public static final Item PLAYER_LOCATION_CHANGE_ITEM = new ItemBase("player_location_change_item");
    public static final Item ALL_FREEZE_ITEM = new ItemBase("all_freeze_item");

    public static final Item SHOP_MAIN_TEXTURE = new ItemBase("shop_main_texture");

    public static final Item LEFT_ARROW = new ItemBase("left_arrow");
    public static final Item RIGHT_ARROW = new ItemBase("right_arrow");

    public static final Item SEGMENT_INFORMATION_TABLET = new ItemBase("segment_information_tablet");

    public static final Item GUI_BACKGROUND_ITEM = new ItemBase("gui_background_item");
    public static final Item GUI_AGREE_ITEM = new ItemBase("gui_agree_item");
    public static final Item GUI_DISAGREE_ITEM = new ItemBase("gui_disagree_item");
    public static final Item GUI_DOIT_ITEM = new ItemBase("gui_doit_item");
    public static final Item GUI_APPLY_ITEM = new ItemBase("gui_apply_item");
    public static final Item GUI_ROOMPRICE_ITEM = new ItemBase("gui_roomprice_item");
    public static final Item GUI_USEADDON_ITEM = new ItemBase("gui_useaddon_item");

    public static final Item MIRO_SUCCESS_ITEM = new ItemBase("miro_success_item");
    public static final Item JUMPMAP_SUCCESS_ITEM = new ItemBase("jumpmap_success_item");

    public static final Item WORLD_CHANGE_ITEM = new ItemBase("world_change_item");

}
