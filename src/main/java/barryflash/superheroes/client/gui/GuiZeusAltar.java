package barryflash.superheroes.client.gui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.IZeusAltar;
import barryflash.superheroes.capabilities.ZeusAltarProvider;
import barryflash.superheroes.recipes.ZeusAltarOfferings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiZeusAltar extends GuiScreen {
	final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/zeus_altar.png");
	int guiHeight = 255;
	int guiWidth = 255;
	
	private final int tex_width = 176, tex_height = 166, barWidth = 108, barHeight = 9;
	int centerX = (width / 2) - tex_width / 2;
	int centerY = (height / 2) - tex_height / 2;
	int mouseX = 0;
	int mouseY = 0;
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		int centerX = (width / 2) - tex_width / 2;
		int centerY = (height / 2) - tex_height / 2;
		this.centerX = centerX;
		this.centerY = centerY;
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		GlStateManager.pushMatrix();
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		drawTexturedModalRect(centerX, centerY, 0, 0, tex_width, tex_height);
		IZeusAltar zeusaltarCap = mc.player.getCapability(ZeusAltarProvider.ZEUS_ALTAR_CAP, null);
		int newBarWidth = barWidth/100 * zeusaltarCap.getProgress();
		drawTexturedModalRect(centerX + 32, centerY + tex_height - 49, 0, 166, 3+ newBarWidth, barHeight);
		drawTexturedModalRect(centerX + 20, centerY + 109, 0, 175, 132, 28);
		if (zeusaltarCap.isProgressComplete()) {
			if (isHovering(mouseX, mouseY, centerX + tex_width/2 - 25, centerY + tex_height - 30, 50, 16)) {
				drawTexturedModalRect(centerX + tex_width/2 - 25, centerY + tex_height - 30, 0, 236, 50, 16);
			} else {
				drawTexturedModalRect(centerX + tex_width/2 - 25, centerY + tex_height - 30, 0, 220, 50, 16);
			}
		} else {
			drawTexturedModalRect(centerX + tex_width/2 - 25, centerY + tex_height - 30, 0, 204, 50, 16);
		}
		GlStateManager.disableAlpha();
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
	
		drawCenteredString(fontRenderer, "Obtain", centerX + tex_width/2, centerY + tex_height - 27, 0xFFFFFF);
		drawCenteredString(fontRenderer, zeusaltarCap.getProgress() + "%", centerX + tex_width/2, centerY + tex_height - 49, 0x60BDC1);
		drawCenteredString(fontRenderer, "Zeus Altar", centerX + tex_width/2, centerY + 10, 0xAAFAFF);
		drawCenteredString(fontRenderer, "Faith:", centerX + tex_width/2, centerY + tex_height - 65, 0xAAFAFF);
		GlStateManager.pushMatrix();
		GlStateManager.translate(centerX + 20, centerY + 23, 0);
		GlStateManager.scale(0.5F, 0.5F, 0.5F);
		fontRenderer.drawSplitString("Bring your faith for Zeus to 100% and you shall receive a gift from the king of the gods himself.", 0, 0, 300, 0xAAFAFF);
		fontRenderer.drawSplitString("Right-Click the altar to give Zeus your offerings. Refer to the list below for what offerings are allowed and how much faith you gain from each.", 0, 40, 300, 0x555144);
		int j = 0;
		boolean g = false;
		boolean h = false;
		for(int i = 0; i < ZeusAltarOfferings.offerings.size(); i++) {
			if (!g) {
				fontRenderer.drawString( "" + ZeusAltarOfferings.offerings.get(i).getDisplayName() + " (" + ZeusAltarOfferings.offerings.get(i).getCount() + "%) " , -30, 80 + j, 0x555144);
				g = true;
			} else {
				if (!h) {
					fontRenderer.drawString( "" + ZeusAltarOfferings.offerings.get(i).getDisplayName() + " (" + ZeusAltarOfferings.offerings.get(i).getCount() + "%) " , 80, 80 + j, 0x555144);
					h = true;
				} else {
					fontRenderer.drawString( "" + ZeusAltarOfferings.offerings.get(i).getDisplayName() + " (" + ZeusAltarOfferings.offerings.get(i).getCount() + "%) " , 190, 80 + j, 0x555144);
					g = false;
					h = false;
					j += 15;
				}
			}
				
		}
		GlStateManager.color(1, 1, 1,1);
		GlStateManager.popMatrix();
		drawHorizontalLine(centerX + 40, centerX + 140, centerY + 37, new Color(85,81,68,255).getRGB());
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	public boolean isHovering(int mouseX, int mouseY, int posX, int posY, int width, int height) {
		if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		// TODO Auto-generated method stub
		super.keyTyped(typedChar, keyCode);
		if (keyCode == Keyboard.KEY_E) {
			mc.displayGuiScreen(null);
		}
	}
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		// TODO Auto-generated method stub
		super.mouseClicked(mouseX, mouseY, mouseButton);
		IZeusAltar zeusaltarCap = mc.player.getCapability(ZeusAltarProvider.ZEUS_ALTAR_CAP, null);
		if (zeusaltarCap.isProgressComplete()) {
			if (isHovering(mouseX, mouseY, centerX + tex_width/2 - 25, centerY + tex_height - 30, 50, 16)) {
				mc.displayGuiScreen(null);
				ZeusAltarOfferings.addLightningBolt();
				zeusaltarCap.setProgress(0);
			}
		}
	}
	@Override
	public boolean doesGuiPauseGame() {
		// TODO Auto-generated method stub
		return false;
	}
}
