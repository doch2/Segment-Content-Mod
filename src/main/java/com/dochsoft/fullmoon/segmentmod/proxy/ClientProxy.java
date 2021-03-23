package com.dochsoft.fullmoon.segmentmod.proxy;

import com.dochsoft.fullmoon.segmentmod.Segmentmod;
import com.dochsoft.fullmoon.segmentmod.client.gui.GuiOverlay;
import io.netty.buffer.ByteBufUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

import java.nio.charset.Charset;

public class ClientProxy extends CommonProxy {
    private static Minecraft minecraft = Minecraft.getMinecraft();
    public static final FMLEventChannel channel = NetworkRegistry.INSTANCE.newEventDrivenChannel("SEGMENT");

    public static String playerName = null;
    public static String playerMoney = null;

    public static String timerHour = null;
    public static String timerMinute = null;
    public static String timerSecond = null;

    public static String showTimer = null;


    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        channel.register(this);
        MinecraftForge.EVENT_BUS.register(new GuiOverlay());

        MinecraftForge.EVENT_BUS.register(new Segmentmod());
    }

    @Override
    public void postinit(FMLPostInitializationEvent event) {
        //InitFirebase.firebaseInit();
        //WriteFirebase.writeFirebase();
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }

    @SubscribeEvent
    public void onClientCustomPacket(FMLNetworkEvent.ClientCustomPacketEvent event) {
        FMLProxyPacket packet = event.getPacket();

        if (packet.channel().equalsIgnoreCase("SEGMENT")) {
            String packetData = new String(ByteBufUtil.getBytes(packet.payload()), Charset.forName("UTF-8"));
            String[] list = packetData.split("\\|\\|");
            if (packetData.startsWith("PLAYERNAME")) {
                if (list[1] == null) {
                    playerName = "steve22";
                } else {
                    playerName = list[1];
                }
            } else if (packetData.startsWith("MONEY")) {
                playerMoney = list[1];
            } else if (packetData.startsWith("TIMER")) {
                showTimer = list[1];
                timerHour = list[2];
                timerMinute = list[3];
                timerSecond = list[4];
            }
        }
    }

}
