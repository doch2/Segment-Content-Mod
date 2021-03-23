package com.dochsoft.fullmoon.segmentmod.client.gui;

import com.dochsoft.fullmoon.segmentmod.proxy.ClientProxy;
import com.dochsoft.fullmoon.segmentmod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GuiOverlay extends Gui {
    public static Minecraft minecraft = Minecraft.getMinecraft();
    public static BufferedImage image = null;
    public static ResourceLocation location = null;

    private static boolean firstLoop = true;

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {
        if (event.isCanceled() || event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        getPlayerHeadImage();
        drawOverlay();
        if (firstLoop) {
            location = new InGameTextureHandler(minecraft.getTextureManager(), new DynamicTexture(image)).getTextureLocation();
            firstLoop = false;
        }
        drawPlayerHead(location);

        if (ClientProxy.showTimer != null && ClientProxy.showTimer.equalsIgnoreCase("true")) {
            drawTimer();
        }
    }

    public void getPlayerHeadImage() {
        if (image == null) {
            try{
                URL url = new URL("https://minotar.net/helm/"+ minecraft.player.getName() + "/16.png");
                image = ImageIO.read(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void drawPlayerHead(ResourceLocation resourceLocation) {
        ScaledResolution scaled = new ScaledResolution(minecraft);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();
        int x1 = width / 100;
        int y1 = width / 100;

        GL11.glPushMatrix();
        minecraft.getTextureManager().bindTexture(resourceLocation);
        GL11.glScalef(0.46f, 0.46f, 0.46f);
        drawModalRectWithCustomSizedTexture((x1 + 20), (y1 + 40), 0.0F, 0.0F, 32, 32, 32.0F, 32.0F);
        GL11.glPopMatrix();
    }

    public void drawOverlay() {
        ScaledResolution scaled = new ScaledResolution(minecraft);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();
        int x1 = width / 100;
        int y1 = width / 100;
        int x2 = width / 100 + 80;
        int y2 = width / 100 + 22;

        float xx = (float)width / 1280.0F;
        float yy = (float)height / 720.0F;

        GL11.glPushMatrix();
        //GlStateManager.enableBlend();
        GlStateManager.enableAlpha();
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        minecraft.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/segment_gameoverlay.png"));
        drawModalRectWithCustomSizedTexture(x1 + 2, y1 + 2, 0.0F, 0.0F, 1280, 720, 1280.0F, 720.0F);
       // GlStateManager.disableBlend();
        GlStateManager.disableAlpha();
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glScalef(1.2f, 1.2f, 1.2f);
        // (width / 2) + (width / 8)
        minecraft.fontRenderer.drawString(TextFormatting.GOLD + ClientProxy.playerMoney + TextFormatting.WHITE, (x1 + 27), y1 + 15.2F, 16777215, false);
        GL11.glPopMatrix();
    }

    public void drawTimer() {
        ScaledResolution scaled = new ScaledResolution(minecraft);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();
        int x1 = width / 100;
        int y1 = width / 100;
        float xx = (float)width / 1280.0F;
        float yy = (float)height / 720.0F;

        int textXLoc;
        float textYLoc;
        String backgroundImgPath;

        if (width < 800) {//1280 = 640, 1920 = 960
            textXLoc = (width / 2) + (width / 10) + 24;
            textYLoc = 8.1F;
            backgroundImgPath = "textures/gui/timer_1280.png";
        } else {
            textXLoc = (width / 2) + (width / 9) + 34;
            textYLoc = 9.2F;
            backgroundImgPath = "textures/gui/timer_1920.png";
        }

        GL11.glPushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.enableAlpha();
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glScaled((double) xx, (double) yy, 1.0D);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //GL11.glScalef(0.5F, 0.5F, 0.5F);
        minecraft.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, backgroundImgPath));
        drawModalRectWithCustomSizedTexture(x1 + 2, y1 + 2, 0.0F, 0.0F, 1280, 720, 1280.0F, 720.0F);
        GlStateManager.disableBlend();
        GlStateManager.disableAlpha();
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glScalef(1.4f, 1.4f, 1.4f);
        minecraft.fontRenderer.drawString(ClientProxy.timerHour + ":" + ClientProxy.timerMinute + ":" + ClientProxy.timerSecond, textXLoc, y1 + textYLoc, 16777215, false);
        GL11.glPopMatrix();
    }
}
