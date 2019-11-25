package barryflash.superheroes.client.gui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import barryflash.superheroes.Reference;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.models.ModelHero;
import barryflash.superheroes.models.ModelIronManMark50;
import barryflash.superheroes.network.MessageSuitMakerCraft;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.recipes.SuitRecipes;
import barryflash.superheroes.recipes.TMURecipes;
import barryflash.superheroes.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.model.ModelLoader;

public class GuiSuitMaker extends GuiScreen {
	final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/container/suit_maker.png");
	final ResourceLocation textureBG = new ResourceLocation(Reference.MODID, "textures/gui/container/suit_maker_bg.png");
	final ResourceLocation textureBlackWidow = new ResourceLocation(Reference.MODID, "textures/gui/icons/blackwidowbody.png");
	final ResourceLocation textureHawkeye = new ResourceLocation(Reference.MODID, "textures/gui/icons/hawkeyebody.png");
	final ResourceLocation textureBatman = new ResourceLocation(Reference.MODID, "textures/gui/icons/batmanbody.png");
	final ResourceLocation textureIronMan = new ResourceLocation(Reference.MODID, "textures/gui/icons/ironmanbody.png");
	final ResourceLocation textureHulk = new ResourceLocation(Reference.MODID, "textures/gui/icons/hulkbody.png");
	final ResourceLocation textureSuperman = new ResourceLocation(Reference.MODID, "textures/gui/icons/supermanbody.png");
	final ResourceLocation textureWonderWoman = new ResourceLocation(Reference.MODID, "textures/gui/icons/wonderwomanbody.png");
	final ResourceLocation textureCaptainAmerica = new ResourceLocation(Reference.MODID, "textures/gui/icons/captainamericabody.png");
	final ResourceLocation textureThor = new ResourceLocation(Reference.MODID, "textures/gui/icons/thorbody.png");
	final ResourceLocation textureShazam = new ResourceLocation(Reference.MODID, "textures/gui/icons/shazambody.png");
	final ResourceLocation textureFlash = new ResourceLocation(Reference.MODID, "textures/gui/icons/flashbody.png");
	final ResourceLocation textureCyborg = new ResourceLocation(Reference.MODID, "textures/gui/icons/cyborgbody.png");
	final ResourceLocation textureZod = new ResourceLocation(Reference.MODID, "textures/gui/icons/generalzodbody.png");
	final ResourceLocation textureLoki = new ResourceLocation(Reference.MODID, "textures/gui/icons/lokibody.png");
	final ResourceLocation textureFusionChamber = new ResourceLocation(Reference.MODID, "textures/gui/fusion_chamber_recipe.png");
	final ResourceLocation textureFusionChamberFull = new ResourceLocation(Reference.MODID, "textures/gui/fusion_chamber_full.png");
	int guiHeight = 255;
	int guiWidth = 255;
	
	private final int tex_width = 223, tex_height = 152;
	int centerX = (width / 2) - tex_width / 2;
	int centerY = (height / 2) - tex_height / 2;
	private final int sliderWidth = 4, sliderHeight = 13;

	private int sliderX;

	private int sliderY;
	private int mouseX = 0;
	private int mouseY = 0;
	private boolean held = false;
	private List suits = new ArrayList();
	private int slideLine;
	private int moveLine = 0;
	private int suitID = 0;
	private GuiButtonSuitMaker button;
	private GuiButtonSuitMaker button2;
	final int ABILITIES = 0, CRAFT = 1;
	private boolean abilities = false;
	private boolean craft = false;
	 private boolean canCraft = false;
	 private int craftingPage = 0;
	 private int materialAmount = 0;
	 private int suitCrafting = 0;
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		button2.visible = false;
		button.visible = false;
		int centerX = (width / 2) - tex_width / 2;
		int centerY = (height / 2) - tex_height / 2;
		this.centerX = centerX;
		this.centerY = centerY;
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		if (held == true) {
			if (mouseY > centerY+13+(sliderHeight/2) && mouseY < centerY+tex_height-(sliderHeight/2)-13) {
				sliderY = mouseY-(sliderHeight/2);
				slideLine = mouseY-128;

			} else {
				if (mouseY < centerY+13+(sliderHeight/2)) {
					sliderY = centerY+14;
					slideLine = centerY - 115;
				} else if (mouseY > centerY+tex_height-(sliderHeight/2)-13){
					sliderY = centerY+tex_height-sliderHeight-14;
					slideLine = centerY+tex_height-128-12;
				}
			}
		}
		
		GlStateManager.pushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(textureBG);
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		drawTexturedModalRect(centerX + 12, centerY + 12, 0, 0, 44, 128);
	
		int moveSbar = centerY-((sliderY-(centerY/2))*2)-26-tex_height+14;
		int startpos = 0;
		
		if (suitID == -1) {
			startpos = 0;
			
		} else {
			startpos = 18*suitID;
		}
		int excess = 0;

		if (moveSbar+ startpos < -192) {
		excess = moveSbar + 192 + startpos;
		
		} else if (moveSbar+startpos+18 >= -192+tex_height-12) {
			excess = moveSbar + 192 + startpos-tex_height+13 + 18;
			
		}
		
		if (excess > -19 && excess <= 0 && suitID != 0) {
			
		drawTexturedModalRect(centerX + 12, centerY+12 + moveSbar+192 + startpos - excess, 0, 128, 44, 19+excess);
		} else if (excess < 5 && excess > 0) {
			
			drawTexturedModalRect(centerX + 12, centerY+12 + moveSbar+192 + startpos - excess, 0, 128, 44, 19-excess);
		}
		GlStateManager.popMatrix();
		moveLine = centerY-((sliderY-(centerY/2))*2)-26-tex_height+14;
		
		int moveLine2 = centerY-((sliderY-(centerY/2))*2)-26-tex_height+14;
		GlStateManager.pushMatrix();
		GlStateManager.translate(centerX + 12, centerY+12 + moveLine2+192, 0);
		Color lineColor = new Color(111,212,219,206);
		if (moveLine2 > -192) {
		drawHorizontalLine(0, 43, 0, lineColor.getRGB());
		}
		if (moveLine2+31 > -192) {
		drawHorizontalLine(0, 43, 18, lineColor.getRGB());
		}
		if (moveLine2+49 > -192) {
		drawHorizontalLine(0, 43, 18*2, lineColor.getRGB());
		}
		if (moveLine2+67 > -192) {
		drawHorizontalLine(0, 43, 18*3, lineColor.getRGB());
		}
		if (moveLine2+85 > -192) {
		drawHorizontalLine(0, 43, 18*4, lineColor.getRGB());
		}
		if (moveLine2+103 > -192) {
		drawHorizontalLine(0, 43, 18*5, lineColor.getRGB());
		}
		if (moveLine2+121 > -192) {
		drawHorizontalLine(0, 43, 18*6, lineColor.getRGB());
		}
		if (moveLine2+139 < -192+tex_height-12 && moveLine2+139 > -192) {
		drawHorizontalLine(0, 43, 18*7+1, lineColor.getRGB());
		}
		if (moveLine2+157 < -192+tex_height-12 && moveLine2+157 > -192) {
		drawHorizontalLine(0, 43, 18*8, lineColor.getRGB());
		}
		if (moveLine2+175 < -192+tex_height-12 && moveLine2+175 > -192) {
		drawHorizontalLine(0, 43, 18*9, lineColor.getRGB());
		}
		if (moveLine2+193 < -192+tex_height-12 && moveLine2+193 > -192) {
		drawHorizontalLine(0, 43, 18*10, lineColor.getRGB());
		}
		if (moveLine2+211 < -192+tex_height-12 && moveLine2+211 > -192) {
		drawHorizontalLine(0, 43, 18*11, lineColor.getRGB());
		}
		if (moveLine2+229 < -192+tex_height-12 && moveLine2+229 > -192) {
		drawHorizontalLine(0, 43, 18*12, lineColor.getRGB());
		}
		if (moveLine2+247 < -192+tex_height-12 && moveLine2+247 > -192) {
		drawHorizontalLine(0, 43, 18*13, lineColor.getRGB());
		}
		if (moveLine2+265 < -192+tex_height-12 && moveLine2+265 > -192) {
		drawHorizontalLine(0, 43, 18*14, lineColor.getRGB());
		}
		if (moveLine2+283 < -192+tex_height-12 && moveLine2+283 > -192) {
			drawHorizontalLine(0, 43, 18*15, lineColor.getRGB());
			}
		GlStateManager.popMatrix();
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(centerX + 33, centerY + 12 + moveLine2+192, 0);
		GlStateManager.scale(0.5F, 0.5F, 0.5F);
		if (moveLine2 > -210) {
		drawCenteredString(fontRenderer, "Crafting", 0, 15, 0x5BFCFF);
		}
		if (moveLine2+18 > -210) {
		drawCenteredString(fontRenderer, (String) suits.get(0), 0, 18*3, 0x5BFCFF);
		}
		if (moveLine2+36 > -210) {
		drawCenteredString(fontRenderer, (String) suits.get(1), 0, 18*5, 0x5BFCFF);
		}
		if (moveLine2+54 > -210) {
		drawCenteredString(fontRenderer, (String) suits.get(2), 0, 18*7, 0x5BFCFF);
		}
		if (moveLine2+72 > -210) {
		drawCenteredString(fontRenderer, (String) suits.get(3), 0, 18*9, 0x5BFCFF);
		}
		if (moveLine2+90 > -210) {
		drawCenteredString(fontRenderer, (String) suits.get(4), 0, 18*11, 0x5BFCFF);
		}
		if (moveLine2+108 > -210) {
			drawCenteredString(fontRenderer, (String) suits.get(5), 0, 18*13, 0x5BFCFF);
		}
		if (moveLine2+(18*7) > -210 && moveLine2+(18*7) < -210+tex_height-12) {
			drawCenteredString(fontRenderer, (String) suits.get(6), 0, 18*(3 + (2*6)), 0x5BFCFF);
		}
		if (moveLine2+(18*8) > -210 && moveLine2+(18*8) < -210+tex_height-12) {
			drawCenteredString(fontRenderer, (String) suits.get(7), 0, 18*(3 + (2*7)), 0x5BFCFF);
		}
		if (moveLine2+(18*9) > -210 && moveLine2+(18*9) < -210+tex_height-12) {
			drawCenteredString(fontRenderer, (String) suits.get(8), 0, 18*(3 + (2*8)), 0x5BFCFF);
		}
		if (moveLine2+(18*10) > -210 && moveLine2+(18*10) < -210+tex_height-12) {
			drawCenteredString(fontRenderer, (String) suits.get(9), 0, 18*(3 + (2*9)), 0x5BFCFF);
		}
		if (moveLine2+(18*11) > -210 && moveLine2+(18*11) < -210+tex_height-12) {
			drawCenteredString(fontRenderer, (String) suits.get(10), 0, 18*(3 + (2*10)), 0x5BFCFF);
		}
		if (moveLine2+(18*12) > -210 && moveLine2+(18*12) < -210+tex_height-12) {
			drawCenteredString(fontRenderer, (String) suits.get(11), 0, 18*(3 + (2*11)), 0x5BFCFF);
		}
		if (moveLine2+(18*13) > -210 && moveLine2+(18*13) < -210+tex_height-12) {
			drawCenteredString(fontRenderer, (String) suits.get(12), 0, 18*(3 + (2*12)), 0x5BFCFF);
		}
		if (moveLine2+(18*14) > -210 && moveLine2+(18*14) < -210+tex_height-12) {
			drawCenteredString(fontRenderer, (String) suits.get(13), 0, 18*(3 + (2*13)), 0x5BFCFF);
		}
		GlStateManager.color(1, 1, 1, 1);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		drawTexturedModalRect(centerX, centerY, 0, 0, tex_width, tex_height);
		drawTexturedModalRect(sliderX, sliderY, 0, 152, sliderWidth, sliderHeight);
		GlStateManager.popMatrix();
		if (abilities == false && craft == false) {
		if (suitID > 0) {
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GlStateManager.translate(centerX+tex_width/2 - 35, centerY+31, 0);
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
			drawTexturedModalRect(0, 0, 1, 166, 40, 40);
			GlStateManager.popMatrix();
		}

		if (suitID == 0) {
			drawCenteredString(fontRenderer, "Typical Machine Unit", centerX+tex_width/2+10, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+60, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 -38, centerY+30, 0);
			fontRenderer.drawSplitString("This block is used to get information on all suits currently in the mod and how to obtain them. To view information for a hero, select the name of the suit on the left side of the screen.", 0, 0, 140, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
		} else if (suitID == -1) {
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GlStateManager.translate(centerX+tex_width/2 + 75, centerY+39, 0);
			if (craftingPage-8 < TMURecipes.recipes.size()) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2+75, centerY+129, 19, 9)) {
					drawTexturedModalRect(0, 90, 44, 227, 19, 9);
				} else {
				drawTexturedModalRect(0, 90, 44, 218, 19, 9);
				}
			}
			if (craftingPage > 0) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2+75-110, centerY+129, 19, 9)) {
					drawTexturedModalRect(-110, 90, 44, 209, 19, 9);
				} else {
				drawTexturedModalRect(-110, 90, 44, 200, 19, 9);
				}
				
			}
			if (craftingPage > 3) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2+75-50, centerY+129, 19, 9)) {
					drawTexturedModalRect(-50, 90, 53, 236, 9, 9);
				} else {
				drawTexturedModalRect(-50, 90, 44, 236, 9, 9);
				}
			}
			drawCenteredString(fontRenderer, ""+craftingPage, 15, -25, 0x5BFCFF);
			GlStateManager.popMatrix();
			
			if (craftingPage == 0) {
				drawCenteredString(fontRenderer, "Crafting Recipes", centerX+tex_width/2+10, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+60, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 -38, centerY+30, 0);
				fontRenderer.drawSplitString("All recipes associated with the Typical Heroes mod are located here. You can navigate the recipes page by page (they are sorted alphabetically) or by using the table of contents. Materials listed in the crafting section of a suit are also clickable, and take you directly to the recipe in this section.", 0, 0, 140, new Color(91,252,255,255).getRGB());
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
			} else if (craftingPage == 1) {
				drawCenteredString(fontRenderer, "Table of Contents", centerX+tex_width/2+10, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+60, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				
				GlStateManager.translate(centerX+tex_width/2 -38, centerY+30, 0);
				GlStateManager.scale(0.5F, 0.5F, 0.5F);
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30, 140, 4)) {
					drawString(fontRenderer, 1+". " + "Fusion Chamber", 0, 0, 0xC1FFFF);
				} else {
					drawString(fontRenderer, 1+". " + "Fusion Chamber", 0, 0, 0x5BFCFF);
				}
				int j = 15;
				if (TMURecipes.recipes.size() < 12) {
					for (int i = 0; i < TMURecipes.recipes.size(); i++) {
						if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+(j/2), 140, 4)) {
							drawString(fontRenderer, i+2+". " +((ItemStack)((ArrayList) TMURecipes.recipes.get(i)).get(0)).getDisplayName(), 0, j, 0xC1FFFF);
						} else {
							drawString(fontRenderer, i+2+". " +((ItemStack)((ArrayList) TMURecipes.recipes.get(i)).get(0)).getDisplayName(), 0, j, 0x5BFCFF);
						}
						j += 15;
					}
				} else {
					for (int i = 0; i < 12; i++) {
						if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+(j/2), 140, 4)) {
							drawString(fontRenderer, i+2+". " +((ItemStack)((ArrayList) TMURecipes.recipes.get(i)).get(0)).getDisplayName(), 0, j, 0xC1FFFF);
						} else {
							drawString(fontRenderer, i+2+". " +((ItemStack)((ArrayList) TMURecipes.recipes.get(i)).get(0)).getDisplayName(), 0, j, 0x5BFCFF);
						}
						j += 15;
					}
				}
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
			}else if (craftingPage == 2) {
				drawCenteredString(fontRenderer, "Table of Contents", centerX+tex_width/2+10, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+60, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 -38, centerY+30, 0);
				GlStateManager.scale(0.5F, 0.5F, 0.5F);
				int j = 0;
				if (TMURecipes.recipes.size() >= 13 && TMURecipes.recipes.size() < 25) {
					for (int i = 12; i < TMURecipes.recipes.size(); i++) {
						if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+(j/2), 140, 7)) {
							drawString(fontRenderer, i+2+". " +((ItemStack)((ArrayList) TMURecipes.recipes.get(i)).get(0)).getDisplayName(), 0, j, 0xC1FFFF);
						} else {
							drawString(fontRenderer, i+2+". " +((ItemStack)((ArrayList) TMURecipes.recipes.get(i)).get(0)).getDisplayName(), 0, j, 0x5BFCFF);
						}
						j += 15;
					}
				} else if (TMURecipes.recipes.size() >= 13){
					for (int i = 12; i < 25; i++) {
						if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+(j/2), 140, 4)) {
							drawString(fontRenderer, i+2+". " +((ItemStack)((ArrayList) TMURecipes.recipes.get(i)).get(0)).getDisplayName(), 0, j, 0xC1FFFF);
						} else {
							drawString(fontRenderer, i+2+". " +((ItemStack)((ArrayList) TMURecipes.recipes.get(i)).get(0)).getDisplayName(), 0, j, 0x5BFCFF);
						}
						j += 15;
					}
				}
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
			}else if (craftingPage == 3) {
				drawCenteredString(fontRenderer, "Table of Contents", centerX+tex_width/2+10, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+60, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 -38, centerY+30, 0);
				GlStateManager.scale(0.5F, 0.5F, 0.5F);
				int j = 0;
				if (TMURecipes.recipes.size() >= 25 && TMURecipes.recipes.size() < 38) {
					for (int i = 25; i < TMURecipes.recipes.size(); i++) {
						if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+(j/2), 140, 7)) {
							drawString(fontRenderer, i+2+". " +((ItemStack)((ArrayList) TMURecipes.recipes.get(i)).get(0)).getDisplayName(), 0, j, 0xC1FFFF);
						} else {
							drawString(fontRenderer, i+2+". " +((ItemStack)((ArrayList) TMURecipes.recipes.get(i)).get(0)).getDisplayName(), 0, j, 0x5BFCFF);
						}
						j += 15;
					}
				} else if (TMURecipes.recipes.size() >= 25){
					for (int i = 25; i < 38; i++) {
						if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+(j/2), 140, 4)) {
							drawString(fontRenderer, i+2+". " +((ItemStack)((ArrayList) TMURecipes.recipes.get(i)).get(0)).getDisplayName(), 0, j, 0xC1FFFF);
						} else {
							drawString(fontRenderer, i+2+". " +((ItemStack)((ArrayList) TMURecipes.recipes.get(i)).get(0)).getDisplayName(), 0, j, 0x5BFCFF);
						}
						j += 15;
					}
				}
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
			}else if (craftingPage > 3 && craftingPage - 9 < TMURecipes.recipes.size()) {
				drawRecipePage();
			}
			
		} else if (suitID == 1) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-40, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Natasha Romanoff", 5, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Black Widow", centerX+tex_width/2-34, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-35, centerX+tex_width/2+22, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("Black Widow is one of S.H.I.E.L.D.'s most talented agent. She prioritizes stealth and uses pistols, batons, and other weapons to subdue her opponents.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureBlackWidow);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		}else if (suitID == 2) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-30, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Clint Barton", 0, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Hawkeye", centerX+tex_width/2-32, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-33, centerX+tex_width/2+10, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("Hawkeye, a member of S.H.I.E.L.D, uses a powerful bow and a variety of arrows to shoot down any target.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureHawkeye);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		}else if (suitID == 3) {
			
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-30, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Bruce Wayme", 0, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Batman", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("Batman is one of the world's  smartest heroes. He uses his detective skills, different combat styles, and a collection of gadgets to take out Gotham's worst villains.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureBatman);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		}else if (suitID == 4) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-30, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Steve Rodgers", -5, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Captain America", centerX+tex_width/2-37, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+42, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("Captain America became a superhuman when injected with the Super Soldier serum. This allows him to run at fast speeds, utilize super-strength, and throw his mighty shield.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureCaptainAmerica);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		}else if (suitID == 5) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-40, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Victor Stone", 15, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Cyborg", centerX+tex_width/2-27, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-30, centerX+tex_width/2+10, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("Fused with alien technology, Victor Stone is able to become a living machine. Cyborg uses lasers and a powerful sonic canon to defeat his enemies.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureCyborg);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		}else if (suitID == 6) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-30, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Barry Allen", 0, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Flash", centerX+tex_width/2-35, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2-5, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("The Flash possesses super-speed that allows him to run at incredible speeds. He uses his agility to win the upper hand in combat.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureFlash);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		} else if (suitID == 7) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-30, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Tony Stark", 0, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Iron-Man", centerX+tex_width/2-35, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+12, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("The current Iron Man in the mod is Mark 50. It contains advanced nano-technology that can be used to create powerful and useful weapons.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureIronMan);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		} else if (suitID == 8) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-30, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Bruce Banner", 0, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Hulk", centerX+tex_width/2-35, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2-12, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("After being exposed to gamma radiation, Bruce Banner is able to turn into a ferocious green monster. The Hulk is very unpredictable and can smash up any situation.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureHulk);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		} else if (suitID == 9) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-30, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Loki Odinson", 0, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Loki", centerX+tex_width/2-35, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2-16, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("Loki is the God of Mischief and the adopted son of Odin. Loki utilizes trickery, magic, and illusions to help him win a fight.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureLoki);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		} else if (suitID == 10) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-30, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Billy Batson", 0, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Shazam", centerX+tex_width/2-35, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+4, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("After being gifted the powers of the gods from a wizard, Billy Batson transforms into Shazam. He possesses super-speed, flight, and lightning powers.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureShazam);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		} else if (suitID == 11) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-30, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Clark Kent", 0, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Superman", centerX+tex_width/2-35, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+16, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("Superman is a powerful Kryptonian that was sent to Earth as a child. Growing up on Earth, he  realized how his powers could be used to defend the planet from various threats.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureSuperman);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		} else if (suitID == 12) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-30, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Thor Odinson", 0, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Thor", centerX+tex_width/2-35, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2-10, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("Thor is the God of Thunder and the son of Odin. Wielding the magical hammer Mjolnir, Thor uses lightning powers and abilities to punish his enemies.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureThor);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		} else if (suitID == 13) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-30, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Diana Prince", 0, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "Wonder Woman", centerX+tex_width/2-35, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+36, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("Wonder Woman is an amazon warrior trained and raised in Themyscira. She has incredible strength, skill, and superspeed. She also possesses several mystical weapons.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureWonderWoman);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		} else if (suitID == 14) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2-30, centerY+75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawString(fontRenderer, "Dru-Zod", 5, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			drawString(fontRenderer, "General Zod", centerX+tex_width/2-35, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+26, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 + 15, centerY+28, 0);
			fontRenderer.drawSplitString("Zod is a powerful Kryptonian warrior that is set on re-establishing his planet on another. He utilizes his alien abilities such as laser vision in combat.", 0, 0, 85, new Color(91,252,255,255).getRGB());
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureZod);
			GlStateManager.translate(centerX+tex_width/2 - 34, centerY+33, 0);
			GlStateManager.scale(0.15F, 0.15F, 0.15F);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			GlStateManager.popMatrix();
		}
		
		if (suitID > 0) {
			button2.visible = true;
			button.visible = true;
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GlStateManager.translate(centerX+tex_width/2 - 36, centerY+30, 0);
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
			drawTexturedModalRect(0, 0, 0, 206, 42, 42);
			GlStateManager.popMatrix();
		}
		
		}
		if (abilities == true) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			if (isHovering(mouseX, mouseY, centerX+tex_width/2-38, centerY+125, 19, 9)) {
				drawTexturedModalRect(0, 90, 44, 209, 19, 9);
			} else {
			drawTexturedModalRect(0, 90, 44, 200, 19, 9);
			}
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
		}
		if (craft == true) {
			if (suitID != 4 && suitID != 5 && suitID != 6 && suitID != 8) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 - 30, centerY+35, 0);
			drawString(fontRenderer, "Materials:", 0, 0, 0x5BFCFF);
			GlStateManager.popMatrix();
			}
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GlStateManager.pushMatrix();
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
			GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);

			if (isHovering(mouseX, mouseY, centerX+tex_width/2-38, centerY+125, 19, 9)) {
				drawTexturedModalRect(0, 90, 44, 209, 19, 9);
			} else {
			drawTexturedModalRect(0, 90, 44, 200, 19, 9);
			}
			GlStateManager.popMatrix();
		}
		
		
		if (abilities == true) {
			if (suitID == 1) {
				drawString(fontRenderer, "Black Widow Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+60, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, Keybinding.Ability5.getDisplayName() + " - Widow's Bite", 0, 0, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
			if (suitID == 2) {
				drawString(fontRenderer, "Hawkeye Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+50, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, "Sharpshooter", 0, 0, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
			if (suitID == 3) {
			drawString(fontRenderer, "Batman Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
			drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+40, centerY+25, new Color(91,252,255,255).getRGB());
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
			drawString(fontRenderer, Keybinding.Ability5.getDisplayName() + " - Scroll Bat Gadgets", 0, 0, 0x5BFCFF);
			//drawString(fontRenderer, "Space - Glide", 0, 15, 0x5BFCFF);
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
			}
			if (suitID == 4) {
				drawString(fontRenderer, "Captain America Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+80, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, "Right click + Crouching", 0, 0, 0x5BFCFF);
				drawString(fontRenderer, " - Throw Shield", 0, 15, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
			if (suitID == 5) {
				drawString(fontRenderer, "Cyborg Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+45, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, Keybinding.Ability5.getDisplayName() + " - Sonar Cannon", 0, 0, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability4.getDisplayName() + " - Laser", 0, 15, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.flightTakeOff.getDisplayName() + " - Flight", 0, 30, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
			if (suitID == 6) {
				drawString(fontRenderer, "Flash Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+35, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, Keybinding.Ability5.getDisplayName() + " - Increase Speed", 0, 0, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability4.getDisplayName() + " - Decrease Speed", 0, 15, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability3.getDisplayName() + " - Phase", 0, 30, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
			if (suitID == 7) {
				drawString(fontRenderer, "Iron-Man Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+55, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, Keybinding.Ability2.getDisplayName() + " - Suit On/Off", 0, 0, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability5.getDisplayName() + " - Activate Repulsors", 0, 15, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability4.getDisplayName() + " - Scroll Weapons", 0, 30, 0x5BFCFF);
				//drawString(fontRenderer, Keybinding.Ability3.getDisplayName() + " - Shield", 0, 45, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability6.getDisplayName() + " - Reset Weapons", 0, 45, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability7.getDisplayName() + " - Scroll Flight Modes", 0, 60, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.flightTakeOff.getDisplayName() + " - Flight", 40, 75, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
			if (suitID == 8) {
				drawString(fontRenderer, "Hulk Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+25, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, Keybinding.Ability5.getDisplayName() + " + Jump - Leap", 0, 0, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability4.getDisplayName() + " - Smash", 0, 15, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability2.getDisplayName() + " - Transform", 0, 30, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
			if (suitID == 9) {
				drawString(fontRenderer, "Loki Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+25, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, Keybinding.Ability5.getDisplayName() + " - Teleport", 0, 0, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability4.getDisplayName() + " - Invisibility", 0, 15, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability3.getDisplayName() + " - Get Scepter", 0, 30, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
			if (suitID == 10) {
				drawString(fontRenderer, "Shazam Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+45, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, Keybinding.Ability5.getDisplayName() + " - Lightning Beams", 0, 0, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability2.getDisplayName() + " - Transform", 0, 15, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.flightTakeOff.getDisplayName() + " - Flight", 0, 30, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
			if (suitID == 11) {
				drawString(fontRenderer, "Superman Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+55, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, Keybinding.Ability5.getDisplayName() + " - Heat Vision", 0, 0, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability4.getDisplayName() + " - X-Ray", 0, 15, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.flightTakeOff.getDisplayName() + " - Flight", 0, 30, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
			if (suitID == 12) {
				drawString(fontRenderer, "Thor Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+35, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, Keybinding.Ability5.getDisplayName() + " - Lightning Beam", 0, 0, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability4.getDisplayName() + " - Get Mjolnir", 0, 15, 0x5BFCFF);
				drawString(fontRenderer, "Right click + Crouching", 0, 30, 0x5BFCFF);
				drawString(fontRenderer, "- Throw Hammer", 0, 45, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.flightTakeOff.getDisplayName() + " - Flight", 0, 60, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
			if (suitID == 13) {
				drawString(fontRenderer, "Wonder Woman Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+75, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, Keybinding.Ability5.getDisplayName() + " + Jump - Leap", 0, 0, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability4.getDisplayName() + " - Block with Bracelets", 0, 15, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability4.getDisplayName() + " + Shift - Bracelet Blast", 0, 30, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability3.getDisplayName() + " - Throw Tiara", 0, 45, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
			if (suitID == 14) {
				drawString(fontRenderer, "Zod Abilities", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+25, centerY+25, new Color(91,252,255,255).getRGB());
				GlStateManager.pushMatrix();
				GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
				drawString(fontRenderer, Keybinding.Ability5.getDisplayName() + " - Heat Vision", 0, 0, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.Ability4.getDisplayName() + " - X-Ray", 0, 15, 0x5BFCFF);
				drawString(fontRenderer, Keybinding.flightTakeOff.getDisplayName() + " - Flight", 0, 30, 0x5BFCFF);
				GlStateManager.color(1, 1, 1,1);
				GlStateManager.popMatrix();
				}
		}
		if (craft == true) {
			if (suitID == 1) {
				drawString(fontRenderer, "Craft Black Widow", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+50, centerY+25, new Color(91,252,255,255).getRGB());
				craft(SuitRecipes.blackwidow, SuitRecipes.blackwidowIngredients);
				suitCrafting = 1;
			}
			if (suitID == 2) {
				drawString(fontRenderer, "Craft Hawkeye", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+35, centerY+25, new Color(91,252,255,255).getRGB());
				craft(SuitRecipes.hawkeye, SuitRecipes.hawkeyeIngredients);
				suitCrafting = 2;
			}
			if (suitID == 3) {
				drawString(fontRenderer, "Craft Batman", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+30, centerY+25, new Color(91,252,255,255).getRGB());
				craft(SuitRecipes.batman, SuitRecipes.batmanIngredients);
				suitCrafting = 3;
			}
			if (suitID == 4) {
				drawString(fontRenderer, "Craft Captain America", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+75, centerY+25, new Color(91,252,255,255).getRGB());
				//craft(SuitRecipes.superman, SuitRecipes.supermanIngredients);
				drawFusionChamberRecipe(new ItemStack(ModItems.SUPERSOLDIER_SERUM, 4));
				suitCrafting = 4;
			}
			if (suitID == 5) {
				drawString(fontRenderer, "Craft Cyborg", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+35, centerY+25, new Color(91,252,255,255).getRGB());
				drawFusionChamberRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.MOTHER_BOX), 3));
				suitCrafting = 5;
			}
			if (suitID == 6) {
				drawString(fontRenderer, "Craft Flash", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+25, centerY+25, new Color(91,252,255,255).getRGB());
				drawFusionChamberRecipe(new ItemStack(ModItems.LIGHTNING_ESSENCE, 4));
				suitCrafting = 6;
			}
			if (suitID == 7) {
				drawString(fontRenderer, "Craft Iron-Man", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+45, centerY+25, new Color(91,252,255,255).getRGB());
				craft(SuitRecipes.ironman, SuitRecipes.ironmanIngredients);
				suitCrafting = 7;
			}
			if (suitID == 8) {
				drawString(fontRenderer, "Craft Hulk", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+15, centerY+25, new Color(91,252,255,255).getRGB());
				drawFusionChamberRecipe(new ItemStack(ModItems.RADIATION_VIAL, 4));
				suitCrafting = 8;
			}
			if (suitID == 9) {
				drawString(fontRenderer, "Craft Loki", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+15, centerY+25, new Color(91,252,255,255).getRGB());
				craft(SuitRecipes.loki, SuitRecipes.lokiIngredients);
				suitCrafting = 9;
			}
			if (suitID == 10) {
				drawString(fontRenderer, "Craft Shazam", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+35, centerY+25, new Color(91,252,255,255).getRGB());
				craft(SuitRecipes.shazam, SuitRecipes.shazamIngredients);
				suitCrafting = 10;
			}
			if (suitID == 11) {
				drawString(fontRenderer, "Craft Superman", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+45, centerY+25, new Color(91,252,255,255).getRGB());
				craft(SuitRecipes.superman, SuitRecipes.supermanIngredients);
				suitCrafting = 11;
			}
			if (suitID == 12) {
				drawString(fontRenderer, "Craft Thor", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+25, centerY+25, new Color(91,252,255,255).getRGB());
				craft(SuitRecipes.thor, SuitRecipes.thorIngredients);
				suitCrafting = 12;
			}
			if (suitID == 13) {
				drawString(fontRenderer, "Craft Wonder Woman", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+65, centerY+25, new Color(91,252,255,255).getRGB());
				craft(SuitRecipes.wonderwoman, SuitRecipes.wonderwomanIngredients);
				suitCrafting = 13;
			}
			if (suitID == 14) {
				drawString(fontRenderer, "Craft Zod", centerX+tex_width/2-36, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+15, centerY+25, new Color(91,252,255,255).getRGB());
				craft(SuitRecipes.zod, SuitRecipes.zodIngredients);
				suitCrafting = 14;
			}
		}
		button.drawButton(mc, mouseX, mouseY, partialTicks);
		button2.drawButton(mc, mouseX, mouseY, partialTicks);
		if (suitID > 0 && abilities == false && craft == false) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(centerX+tex_width/2 - 15, centerY+89, 0);
			//GlStateManager.scale(0.5F, 0.5F, 0.5F);
			drawCenteredString(fontRenderer, "Abilities", 0, 0, 0xFFFFFF);
			drawCenteredString(fontRenderer, "Craft", 0, 25, 0xFFFFFF);
			GlStateManager.color(1, 1, 1,1);
			GlStateManager.popMatrix();
		}
	}
	public boolean isHovering(int mouseX, int mouseY, int posX, int posY, int width, int height) {
		if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
			return true;
		} else {
			return false;
		}
	}
	public void drawFusionChamberRecipe(ItemStack stack) {
		GlStateManager.pushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GlStateManager.color(1, 1, 1);
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		GlStateManager.translate(centerX+tex_width/2, centerY+35, 0);
		drawTexturedModalRect(0, 0, 182, 157, 48, 82);
		this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, stack, 15, 65);
		this.itemRender.renderItemOverlayIntoGUI(this.fontRenderer, stack, 15, 65, TextFormatting.WHITE.toString()+stack.getCount());
		GlStateManager.disableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.color(1, 1, 1, 1);
		
		GlStateManager.popMatrix();
		if (isHovering(mouseX, mouseY, centerX+tex_width/2, centerY+35, 48, 48)) {
			drawHoveringText("FusionChamber", mouseX, mouseY);
		}
		if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 15, centerY+98, 18, 18)) {
			drawHoveringText(stack.getDisplayName(), mouseX, mouseY);
		}
	}
	public void drawRecipePage() {
		int index = -1;
		if (craftingPage > 8) {
			index = craftingPage-9;
		}
		if (index == -1) {
			GlStateManager.pushMatrix();
			GlStateManager.color(1, 1, 1, 1);
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureFusionChamber);
			if (craftingPage == 4) {
				drawCenteredString(fontRenderer, "Fusion Chamber", centerX+tex_width/2+20, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+80, centerY+25, new Color(91,252,255,255).getRGB());
			} else if (craftingPage == 5) {
				drawTexturedModalRect(centerX+tex_width/2 - 7, centerY+tex_height/2 - 5, 0, 0, 16, 16);
				drawCenteredString(fontRenderer, "Fusion Chamber", centerX+tex_width/2+20, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+80, centerY+25, new Color(91,252,255,255).getRGB());
				drawCenteredString(fontRenderer, "First Layer", centerX+tex_width/2+20, centerY+30, 0x5BFCFF);
			} else if (craftingPage == 6) {
				drawTexturedModalRect(centerX+tex_width/2-24, centerY+tex_height/2 - 20, 16, 0, 48, 48);
				drawCenteredString(fontRenderer, "Fusion Chamber", centerX+tex_width/2+20, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+80, centerY+25, new Color(91,252,255,255).getRGB());
				drawCenteredString(fontRenderer, "Second Layer", centerX+tex_width/2+20, centerY+30, 0x5BFCFF);
			} else if (craftingPage == 7) {
				drawTexturedModalRect(centerX+tex_width/2-24, centerY+tex_height/2 - 20, 64, 0, 48, 48);
				drawCenteredString(fontRenderer, "Fusion Chamber", centerX+tex_width/2+20, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+80, centerY+25, new Color(91,252,255,255).getRGB());
				drawCenteredString(fontRenderer, "Third Layer", centerX+tex_width/2+20, centerY+30, 0x5BFCFF);
			} else if (craftingPage == 8) {
				drawTexturedModalRect(centerX+tex_width/2-24, centerY+tex_height/2 - 20, 112, 0, 48, 48);
				drawCenteredString(fontRenderer, "Fusion Chamber", centerX+tex_width/2+20, centerY+15, 0x5BFCFF);
				drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+80, centerY+25, new Color(91,252,255,255).getRGB());
				drawCenteredString(fontRenderer, "Fourth Layer", centerX+tex_width/2+20, centerY+30, 0x5BFCFF);
				
			}
			GlStateManager.disableBlend();
			GlStateManager.disableAlpha();
			GlStateManager.color(1, 1, 1, 1);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureFusionChamberFull);
			GlStateManager.translate(centerX+tex_width/2+40, centerY+50, 0);
			GlStateManager.scale(0.5F, 0.5F, 1);
			if (craftingPage == 4) {	
				mc.fontRenderer.drawSplitString("The fusion chamber is a multi-block structure used to obtain certain suits. It is a 3x4x3 structure that the player must build. The instructions on how to build it are listed here, seperated by layer.", 0, 0, 100, 0x5BFCFF);
			} else if (craftingPage == 5) {	
				mc.fontRenderer.drawSplitString("The first layer of the Fusion Chamber is just 1 fusion chamber core block. This block is where the player stands to use the fusion chamber.", 0, 0, 100, 0x5BFCFF);
				
			} else if (craftingPage == 6) {
				mc.fontRenderer.drawSplitString("The second layer of the Fusion Chamber uses multiple blocks, including 6 fusion chamber shells, 1 fusion chamber control, and 1 fusion chamber door (which is also part of the next layer). The control and the door can be placed in any of the 4 middle sides of the chamber.", 0, 0, 100, 0x5BFCFF);
				
			} else if (craftingPage == 7) {
				mc.fontRenderer.drawSplitString("The third layer of the Fusion Chamber also uses multiple blocks, including 4 fusion chamber glass, 4 fusion chamber shells, and the top half of the fusion chamber door. The glass can be placed in any of the 4 middle sides and the shell goes in the 4 corners.", 0, 0, 100, 0x5BFCFF);
				
			} else if (craftingPage == 8) {
				mc.fontRenderer.drawSplitString("The fourth layer of the Fusion Chamber is the top and last layer. It is made entirely of fusion chamber shells.", 0, 0, 100, 0x5BFCFF);
				
			
			}
			GlStateManager.color(1, 1, 1, 1);
			GlStateManager.disableBlend();
			GlStateManager.disableAlpha();
			GlStateManager.popMatrix();
			if (craftingPage == 4) {
			GlStateManager.pushMatrix();
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureFusionChamberFull);
			GlStateManager.translate(centerX+tex_width/2+40, centerY+50, 0);
			GlStateManager.scale(0.4F, 0.4F, 1);
			drawTexturedModalRect(-230, -50, 0, 0, 256, 256);
			GlStateManager.color(1, 1, 1, 1);
			GlStateManager.disableBlend();
			GlStateManager.disableAlpha();
			GlStateManager.popMatrix();
			}
			if (craftingPage == 5) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 - 5, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_CORE).getDisplayName(), mouseX, mouseY);
				}
			}
			if (craftingPage == 6) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 - 21, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 - 21, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 - 21, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 - 5, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_DOOR).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 - 5, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 + 11, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 + 11, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_CONTROL).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 + 11, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK).getDisplayName(), mouseX, mouseY);
				}
			}
			if (craftingPage == 7) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 - 21, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 - 21, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_WINDOW).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 - 21, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 - 5, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_DOOR).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 - 5, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_WINDOW).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 + 11, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 + 11, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_WINDOW).getDisplayName(), mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 + 11, 16, 16)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK).getDisplayName(), mouseX, mouseY);
				}
			}
			if (craftingPage == 8) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 - 21, 48, 48)) {
					drawHoveringText(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK).getDisplayName(), mouseX, mouseY);
				}
			}
			
		} else {

		drawCenteredString(fontRenderer, ((ItemStack)((ArrayList) TMURecipes.recipes.get(index)).get(0)).getDisplayName(), centerX+tex_width/2+20, centerY+15, 0x5BFCFF);
		drawHorizontalLine(centerX+tex_width/2-38, centerX+tex_width/2+80, centerY+25, new Color(91,252,255,255).getRGB());
		GlStateManager.pushMatrix();
		GlStateManager.color(1, 1, 1, 1);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/suit_maker.png"));
		GlStateManager.translate(centerX+tex_width/2 - 34, centerY+50, 0);
		if (((String)((ArrayList) TMURecipes.recipes.get(index)).get(2)) == "crafting") {
		drawTexturedModalRect(0, 0, 94, 152, 54, 54);
		} else if (((String)((ArrayList) TMURecipes.recipes.get(index)).get(2)) == "crucible") {
			drawTexturedModalRect(15, 10, 148, 152, 26, 48);
		} else if (((String)((ArrayList) TMURecipes.recipes.get(index)).get(2)) == "compacter") {
			drawTexturedModalRect(15, 20, 197, 221, 18, 18);
			drawTexturedModalRect(39, 50, 197, 221, 18, 18);
		}
		drawTexturedModalRect(60, 20, 63, 200, 22, 15);
		drawTexturedModalRect(90, 20, 94, 152, 18, 18);
		GlStateManager.popMatrix();
		ItemStack slot = ((ItemStack)((ArrayList) TMURecipes.recipes.get(index)).get(0));
		ItemStack slot1 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(0));
		ItemStack slot2 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(1));
		ItemStack slot3 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(2));
		ItemStack slot4 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(3));
		ItemStack slot5 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(4));
		ItemStack slot6 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(5));
		ItemStack slot7 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(6));
		ItemStack slot8 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(7));
		ItemStack slot9 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(8));
		
		GlStateManager.pushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		GlStateManager.translate(centerX+tex_width/2 - 34, centerY+50, 0);
		GlStateManager.enableDepth();
		 RenderHelper.enableGUIStandardItemLighting();
		this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot, 91, 21);
		if (slot.getCount() > 1) {
			 this.itemRender.renderItemOverlayIntoGUI(this.fontRenderer, slot, 91, 21, TextFormatting.WHITE.toString()+slot.getCount());
		}
		if (((String)((ArrayList) TMURecipes.recipes.get(index)).get(2)) == "crafting") {
		if (!slot1.isEmpty()) {
			this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot1, 1, 1);
		}
		if (!slot2.isEmpty()) {
			this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot2, 19, 1);
		}
		if (!slot3.isEmpty()) {
			this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot3, 37, 1);
		}
		
		if (!slot4.isEmpty()) {
			this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot4, 1, 19);
		}
		if (!slot5.isEmpty()) {
			this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot5, 19, 19);
		}
		if (!slot6.isEmpty()) {
			this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot6, 37, 19);
		}
		
		if (!slot7.isEmpty()) {
			this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot7, 1, 37);
		}
		if (!slot8.isEmpty()) {
			this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot8, 19, 37);
		}
		if (!slot9.isEmpty()) {
			this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot9, 37, 37);
		}
		} else if (((String)((ArrayList) TMURecipes.recipes.get(index)).get(2)) == "crucible") {
			if (!slot1.isEmpty()) {
					this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot1, 10, -5);
				}
				if (!slot2.isEmpty()) {
					this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot2, 29, -5);
				}
				if (!slot3.isEmpty()) {
					this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot3, 19, -10);
				}
			} else if (((String)((ArrayList) TMURecipes.recipes.get(index)).get(2)) == "compacter") {
				this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, new ItemStack(ModBlocks.NANO_COMPACTER_BLOCK), 40, 20);
				this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, new ItemStack(Items.GLASS_BOTTLE), 40, 51);
				if (!slot1.isEmpty()) {
					this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot1, 16, 21);
				}
				if (!slot2.isEmpty()) {
					this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, slot2, 29, -5);
				}
			}
		GlStateManager.disableDepth();
		 RenderHelper.disableStandardItemLighting();
		GlStateManager.popMatrix();
		
		if (((String)((ArrayList) TMURecipes.recipes.get(index)).get(2)) == "crafting") {
		if (!slot1.isEmpty()) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2 -33, centerY+50, 18, 18)) {
				List<String> list = new ArrayList<String>();
				list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(0)).getDisplayName());
				drawHoveringText(list, mouseX, mouseY);
			}
		}
		if (!slot2.isEmpty()) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 19, centerY+50, 18, 18)) {
				List<String> list = new ArrayList<String>();
				list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(1)).getDisplayName());
				drawHoveringText(list, mouseX, mouseY);
			}
		}
		if (!slot3.isEmpty()) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 37, centerY+50, 18, 18)) {
				List<String> list = new ArrayList<String>();
				list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(2)).getDisplayName());
				drawHoveringText(list, mouseX, mouseY);
			}
		}
		if (!slot4.isEmpty()) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2 -33, centerY+50 + 19, 18, 18)) {
				List<String> list = new ArrayList<String>();
				list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(3)).getDisplayName());
				drawHoveringText(list, mouseX, mouseY);
			}
		}
		if (!slot5.isEmpty()) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 19, centerY+50 + 19, 18, 18)) {
				List<String> list = new ArrayList<String>();
				list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(4)).getDisplayName());
				drawHoveringText(list, mouseX, mouseY);
			}
		}
		if (!slot6.isEmpty()) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 37, centerY+50 + 19, 18, 18)) {
				List<String> list = new ArrayList<String>();
				list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(5)).getDisplayName());
				drawHoveringText(list, mouseX, mouseY);
			}
		}
		if (!slot7.isEmpty()) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2 -33, centerY+50 + 37, 18, 18)) {
				List<String> list = new ArrayList<String>();
				list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(6)).getDisplayName());
				drawHoveringText(list, mouseX, mouseY);
			}
		}
		if (!slot8.isEmpty()) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 19, centerY+50 + 37, 18, 18)) {
				List<String> list = new ArrayList<String>();
				list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(7)).getDisplayName());
				drawHoveringText(list, mouseX, mouseY);
			}
		}
		if (!slot9.isEmpty()) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 37, centerY+50 + 37, 18, 18)) {
				List<String> list = new ArrayList<String>();
				list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(8)).getDisplayName());
				drawHoveringText(list, mouseX, mouseY);
			}
		}
		} else if (((String)((ArrayList) TMURecipes.recipes.get(index)).get(2)) == "crucible") {
			if (!slot1.isEmpty()) {
				if (((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(0)).getCount() > 0) {
					GlStateManager.pushMatrix();
					GlStateManager.translate(centerX+tex_width/2 -20, centerY+58, 0);
					GlStateManager.scale(0.5F, 0.5F, 0.5F);
					drawCenteredString(fontRenderer, ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(0)).getCount()+"x", 0, 0, 0x5BFCFF);
					GlStateManager.popMatrix();
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -25, centerY+44, 18, 18)) {
					List<String> list = new ArrayList<String>();
					list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(0)).getDisplayName());
					drawHoveringText(list, mouseX, mouseY);
					
				}
			}
			if (!slot2.isEmpty()) {
				if (((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(1)).getCount() > 0) {
					GlStateManager.pushMatrix();
					GlStateManager.translate(centerX+tex_width/2  -34 + 34, centerY+58, 0);
					GlStateManager.scale(0.5F, 0.5F, 0.5F);
					drawCenteredString(fontRenderer, ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(1)).getCount()+"x", 0, 0, 0x5BFCFF);
					GlStateManager.popMatrix();
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 29, centerY+44, 18, 18)) {
					List<String> list = new ArrayList<String>();
					list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(1)).getDisplayName());
					drawHoveringText(list, mouseX, mouseY);
				}
			}
			if (!slot3.isEmpty()) {
				if (((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(2)).getCount() > 0) {
					GlStateManager.pushMatrix();
					GlStateManager.translate(centerX+tex_width/2  -34 + 24, centerY+48, 0);
					GlStateManager.scale(0.5F, 0.5F, 0.5F);
					drawCenteredString(fontRenderer, ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(2)).getCount()+"x", 0, 0, 0x5BFCFF);
					GlStateManager.popMatrix();
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 19, centerY+34, 18, 18)) {
					List<String> list = new ArrayList<String>();
					list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(2)).getDisplayName());
					drawHoveringText(list, mouseX, mouseY);
				}
			}
			} else if (((String)((ArrayList) TMURecipes.recipes.get(index)).get(2)) == "compacter") {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 34 + 15, centerY+70, 18, 18)) {
					List<String> list = new ArrayList<String>();
					list.add(((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(0)).getDisplayName());
					drawHoveringText(list, mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 34 + 39, centerY+100, 18, 18)) {
					List<String> list = new ArrayList<String>();
					list.add(new ItemStack(Items.GLASS_BOTTLE, 1).getDisplayName());
					drawHoveringText(list, mouseX, mouseY);
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 34 + 40, centerY+70, 18, 18)) {
					List<String> list = new ArrayList<String>();
					list.add(new ItemStack(ModBlocks.NANO_COMPACTER_BLOCK, 1).getDisplayName());
					drawHoveringText(list, mouseX, mouseY);
				}
			
			}
		if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 56, centerY+70, 18, 18)) {
			List<String> list = new ArrayList<String>();
			list.add(((ItemStack)((ArrayList) TMURecipes.recipes.get(index)).get(0)).getDisplayName());
			drawHoveringText(list, mouseX, mouseY);
			}
		}
	}
	public void craft(List suit, List<ItemStack> ingredients) {
		materialAmount = ingredients.size();
		drawMaterials(ingredients);
		GlStateManager.pushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		GlStateManager.translate(centerX+tex_width/2 - 38, centerY+35, 0);
		if (SuitRecipes.checkInventoryForIngredients(mc.player.inventory, ingredients)) {
			canCraft = true;
			if (isHovering(mouseX, mouseY, centerX+tex_width/2+2, centerY+120, 50, 16)) {
				drawTexturedModalRect(40, 85, 44, 184, 50, 16);
				
			} else {
			drawTexturedModalRect(40, 85, 44, 168, 50, 16);
			}
		} else {
			canCraft = false;
			drawTexturedModalRect(40, 85, 44, 152, 50, 16);
			
		}
		drawString(fontRenderer, "Craft", 51, 89, 0xFFFFFF);
		
		GlStateManager.popMatrix();
		if (canCraft != true) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2+2, centerY+120, 50, 16)) {
				drawHoveringText(SuitRecipes.neededIngredients(mc.player.inventory, suit), mouseX, mouseY);
			}
		}
	}
	public void drawMaterials(List<ItemStack> ingredients) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(centerX+tex_width/2 - 28, centerY+40, 0);
		GlStateManager.scale(0.5F, 0.5F, 0.5F);
		int j = 0;
		boolean g = false;
		for(int i = 0; i < ingredients.size(); i++) {
			
			if (!g) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 38, centerY+48+(j/2), 59, 8)) {

					drawString(fontRenderer, "- " + ingredients.get(i).getCount() + " " + ingredients.get(i).getDisplayName(), -10, 20 + j, 0xC1FFFF);
				} else {
					
					drawString(fontRenderer, "- " + ingredients.get(i).getCount() + " " + ingredients.get(i).getDisplayName(), -10, 20 + j, 0x5BFCFF);
				}
				g = true;
			} else {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 28, centerY+48+(j/2), 59, 8)) {
					drawString(fontRenderer, "- " + ingredients.get(i).getCount() + " " + ingredients.get(i).getDisplayName(), 120, 20 + j, 0xC1FFFF);
				} else {
					drawString(fontRenderer, "- " + ingredients.get(i).getCount() + " " + ingredients.get(i).getDisplayName(), 120, 20 + j, 0x5BFCFF);
				}
				g = false;
				j += 25;
			}
		}
		GlStateManager.color(1, 1, 1,1);
		GlStateManager.popMatrix();
	}
	@Override
	public void initGui() {
		// TODO Auto-generated method stub
		super.initGui();
		sliderX = (width / 2) - tex_width / 2 + 60;
		sliderY = (height / 2) - tex_height / 2 + 14;
		suits.add("Black Widow");
		suits.add("Hawkeye");
		suits.add("Batman");
		suits.add("Captain America");
		suits.add("Cyborg");
		suits.add("Flash");
		suits.add("Iron Man");
		suits.add("Hulk");
		suits.add("Loki");
		suits.add("Shazam");
		suits.add("Superman");
		suits.add("Thor");
		suits.add("Wonder Woman");
		suits.add("Zod");
		slideLine = ((height / 2) - tex_height / 2)-115;
		buttonList.clear();
		int centerY = (height / 2) - tex_height / 2;
		buttonList.add(button = new GuiButtonSuitMaker(ABILITIES, (width / 2) - tex_width/2 + 71, centerY + 85, "Abilities"));
		buttonList.add(button2 = new GuiButtonSuitMaker(CRAFT, (width / 2) - tex_width/2 + 71, centerY + 110, "Craft"));
	}
	@Override
	public void updateScreen() {
		// TODO Auto-generated method stub
		super.updateScreen();
		
	}
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
			case ABILITIES:
				abilities = true;
			
			break;
			case CRAFT:
				craft = true;
			break;
		
		}
		super.actionPerformed(button);
		
	}
	@Override
	public void handleMouseInput() throws IOException {
		// TODO Auto-generated method stub
		super.handleMouseInput();

		if (mouseX > centerX + 10 && mouseX < centerX+70 && mouseY > centerY + 10 && mouseY < centerY+tex_height-10) {
			int i = Integer.signum(Mouse.getEventDWheel());
			if (i == 1) {
				if (sliderY > centerY+14) {
					sliderY -= i*2;
					slideLine -= i*2;
				}
			} else if (i == -1) {
				if (sliderY < centerY+tex_height-sliderHeight-14) {
					sliderY -= i*2;
					slideLine -= i*2;
				}
			}
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
	public void tableOfContentsHover3() {
		List list = TMURecipes.recipes;
		if (list.size() > 0) {
			
			if (list.size() > 25) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30, 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(25)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(25)).get(0)));
					}
				}
			}
			if (list.size() > 26) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*1)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(26)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(26)).get(0)));
					}
				}
			}
			if (list.size() > 27) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*2)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(27)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(27)).get(0)));
					}
				}
			}
			if (list.size() > 28) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*3)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(28)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(28)).get(0)));
					}
				}
			}
			if (list.size() > 29) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*4)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(29)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(29)).get(0)));
					}
				}
			}
			if (list.size() > 30) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*5)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(30)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(30)).get(0)));
						
					}
				}
			}
			if (list.size() > 31) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*6)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(31)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(31)).get(0)));
					}
				}
			}
			if (list.size() > 32) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*7)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(32)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(32)).get(0)));
					}
				}
			}
			if (list.size() > 33) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*8)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(33)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(33)).get(0)));
					}
				}
			}
			if (list.size() > 34) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*9)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(34)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(34)).get(0)));
					}
				}
			}
			if (list.size() > 35) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*10)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(35)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(35)).get(0)));
					}
				}
			}
			if (list.size() > 36) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*11)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(36)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(36)).get(0)));
					}
				}
			}
			if (list.size() > 37) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*12)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(37)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(37)).get(0)));
					}
				}
			}
		}
	}
	public void tableOfContentsHover2() {
		List list = TMURecipes.recipes;
		if (list.size() > 0) {
			if (list.size() > 12) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30, 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(12)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(12)).get(0)));
					}
				}
			}
			if (list.size() > 13) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*1)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(13)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(13)).get(0)));
					}
				}
			}
			if (list.size() > 14) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*2)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(14)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(14)).get(0)));
					}
				}
			}
			if (list.size() > 15) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*3)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(15)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(15)).get(0)));
					}
				}
			}
			if (list.size() > 16) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*4)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(16)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(16)).get(0)));
					}
				}
			}
			if (list.size() > 17) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*5)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(17)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(17)).get(0)));
					}
				}
			}
			if (list.size() > 18) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*6)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(18)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(18)).get(0)));
					}
				}
			}
			if (list.size() > 19) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*7)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(19)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(19)).get(0)));
					}
				}
			}
			if (list.size() > 20) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*8)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(20)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(20)).get(0)));
					}
				}
			}
			if (list.size() > 21) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*9)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(21)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(21)).get(0)));
					}
				}
			}
			if (list.size() > 22) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*10)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(22)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(22)).get(0)));
					}
				}
			}
			if (list.size() > 23) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*11)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(23)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(23)).get(0)));
					}
				}
			}
			if (list.size() > 24) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*12)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(24)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(24)).get(0)));
					}
				}
			}
			
		}
	}
	public void tableOfContentsHover() {
		List list = TMURecipes.recipes;
		if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30, 140, 4)) {
			craftingPage = 4;
		}
		if (list.size() > 0) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*1)/2), 140, 4)) {
				if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(0)).get(0))) != 1) {
					craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(0)).get(0)));
				}
			}
			if (list.size() > 1) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*2)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(1)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(1)).get(0)));
					}
				}
			}
			if (list.size() > 2) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*3)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(2)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(2)).get(0)));
					}
				}
			}
			if (list.size() > 3) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*4)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(3)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(3)).get(0)));
					}
				}
			}
			if (list.size() > 4) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*5)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(4)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(4)).get(0)));
					}
				}
			}
			if (list.size() > 5) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*6)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(5)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(5)).get(0)));
					}
				}
			}
			if (list.size() > 6) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*7)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(6)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(6)).get(0)));
					}
				}
			}
			if (list.size() > 7) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*8)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(7)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(7)).get(0)));
					}
				}
			}
			if (list.size() > 8) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*9)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(8)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(8)).get(0)));
					}
				}
			}
			if (list.size() > 9) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*10)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(9)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(9)).get(0)));
					}
				}
			}
			if (list.size() > 10) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*11)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(10)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(10)).get(0)));
					}
				}
			}
			if (list.size() > 11) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 -38, centerY+30+((15*12)/2), 140, 4)) {
					if (TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(11)).get(0))) != 1) {
						craftingPage = TMURecipes.matchingCraftingPage(((ItemStack)((ArrayList)list.get(11)).get(0)));
					}
				}
			}
			
			
			
			
		}
	}
	public void materialHover(List<ItemStack> ingredients) {
		
		if (ingredients.size() > 0) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 38, centerY+48, 59, 8)) {
				if (TMURecipes.matchingCraftingPage(ingredients.get(0)) != -1) {
					
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = -1;
					craftingPage = TMURecipes.matchingCraftingPage(ingredients.get(0));
					craft = false;
					
				}else {
					mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
				}
			}
		}
			if (ingredients.size() > 1) {
				
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 28, centerY+48, 59, 8)) {
					if (TMURecipes.matchingCraftingPage(ingredients.get(1)) != -1) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						
						craftingPage = TMURecipes.matchingCraftingPage(ingredients.get(1));
						craft = false;
					}else {
						mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
					}
				}
			}
			if (ingredients.size() > 2) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 38, centerY+60, 59, 8)) {
					if (TMURecipes.matchingCraftingPage(ingredients.get(2)) != -1) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = TMURecipes.matchingCraftingPage(ingredients.get(2));
						craft = false;
					}else {
						mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
					}
				}
			}
			if (ingredients.size() > 3) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 28, centerY+60, 59, 8)) {
					if (TMURecipes.matchingCraftingPage(ingredients.get(3)) != -1) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = TMURecipes.matchingCraftingPage(ingredients.get(3));
						craft = false;
					}else {
						mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
					}
				}
			}
			if (ingredients.size() > 4) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 38, centerY+73, 59, 8)) {
					if (TMURecipes.matchingCraftingPage(ingredients.get(4)) != -1) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = TMURecipes.matchingCraftingPage(ingredients.get(4));
						craft = false;
					}else {
						mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
					}
				}
			}
			if (ingredients.size() > 5) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 28, centerY+73, 59, 8)) {
					if (TMURecipes.matchingCraftingPage(ingredients.get(5)) != -1) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = TMURecipes.matchingCraftingPage(ingredients.get(5));
						craft = false;
					}else {
						mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
					}
				}
			}
			if (ingredients.size() > 6) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 38, centerY+85, 59, 8)) {
					
					if (TMURecipes.matchingCraftingPage(ingredients.get(6)) != -1) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = TMURecipes.matchingCraftingPage(ingredients.get(6));
						craft = false;
					} else {
						mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
					}
					
				}
			}
			if (ingredients.size() > 7) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 28, centerY+85, 19, 9)) {
					
					if (TMURecipes.matchingCraftingPage(ingredients.get(7)) != -1) {
						suitID = -1;
						craftingPage = TMURecipes.matchingCraftingPage(ingredients.get(7));
						craft = false;
					}else {
						mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
					}
					
				}
			}
			
		
	}
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		// TODO Auto-generated method stub
		super.mouseClicked(mouseX, mouseY, mouseButton);
		
		
		
		if (suitID == -1) {
			int index = 0;
			if (craftingPage > 8) {
				index = craftingPage-9;
			
			
			ItemStack slot = ((ItemStack)((ArrayList) TMURecipes.recipes.get(index)).get(0));
			ItemStack slot1 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(0));
			ItemStack slot2 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(1));
			ItemStack slot3 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(2));
			ItemStack slot4 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(3));
			ItemStack slot5 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(4));
			ItemStack slot6 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(5));
			ItemStack slot7 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(6));
			ItemStack slot8 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(7));
			ItemStack slot9 = ((ItemStack)((ArrayList)((ArrayList) TMURecipes.recipes.get(index)).get(1)).get(8));
			if (((String)((ArrayList) TMURecipes.recipes.get(index)).get(2)) == "crafting") {
				if (!slot1.isEmpty()) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 -33, centerY+50, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(slot1) != -1) {
							mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
							craftingPage = TMURecipes.matchingCraftingPage(slot1);
						} else {
							mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
						}
					}
				}
				
				if (!slot2.isEmpty()) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 19, centerY+50, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(slot2) != -1) {
							mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
							craftingPage = TMURecipes.matchingCraftingPage(slot2);
						} else {
							mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
						}
					}
				}
				if (!slot3.isEmpty()) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 37, centerY+50, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(slot3) != -1) {
							mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
							craftingPage = TMURecipes.matchingCraftingPage(slot3);
						} else {
							mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
						}
					}
				}
				if (!slot4.isEmpty()) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 -33, centerY+50 + 19, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(slot4) != -1) {
							mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
							craftingPage = TMURecipes.matchingCraftingPage(slot4);
						} else {
							mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
						}
					}
				}
				if (!slot5.isEmpty()) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 19, centerY+50 + 19, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(slot5) != -1) {
							mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
							craftingPage = TMURecipes.matchingCraftingPage(slot5);
						} else {
							mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
						}
					}
				}
				if (!slot6.isEmpty()) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 37, centerY+50 + 19, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(slot6) != -1) {
							mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
							craftingPage = TMURecipes.matchingCraftingPage(slot6);
						} else {
							mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
						}
					}
				}
				if (!slot7.isEmpty()) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 -33, centerY+50 + 37, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(slot7) != -1) {
							mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
							craftingPage = TMURecipes.matchingCraftingPage(slot7);
						} else {
							mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
						}
					}
				}
				if (!slot8.isEmpty()) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 19, centerY+50 + 37, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(slot8) != -1) {
							mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
							craftingPage = TMURecipes.matchingCraftingPage(slot8);
						} else {
							mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
						}
					}
				}
				if (!slot9.isEmpty()) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 -34 + 37, centerY+50 + 37, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(slot9) != -1) {
							mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
							craftingPage = TMURecipes.matchingCraftingPage(slot9);
						} else {
							mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
						}
					}
				}
				} else if (((String)((ArrayList) TMURecipes.recipes.get(index)).get(2)) == "crucible") {
					if (!slot1.isEmpty()) {
						if (TMURecipes.matchingCraftingPage(slot1) != -1) {
							mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
							craftingPage = TMURecipes.matchingCraftingPage(slot1);
						} else {
							mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
						}
					}
					if (!slot2.isEmpty()) {
						if (TMURecipes.matchingCraftingPage(slot2) != -1) {
							mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
							craftingPage = TMURecipes.matchingCraftingPage(slot2);
						} else {
							mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
						}
					}
					if (!slot3.isEmpty()) {
						if (TMURecipes.matchingCraftingPage(slot3) != -1) {
							mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
							craftingPage = TMURecipes.matchingCraftingPage(slot3);
						} else {
							mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
						}
					}
					} else if (((String)((ArrayList) TMURecipes.recipes.get(index)).get(2)) == "compacter") {
						if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 34 + 15, centerY+70, 18, 18)) {
							if (!slot1.isEmpty()) {
								if (TMURecipes.matchingCraftingPage(slot1) != -1) {
									mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
									craftingPage = TMURecipes.matchingCraftingPage(slot1);
								} else {
									mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
								}
							}
						}
						if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 34 + 40, centerY+70, 18, 18)) {
							if (TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.NANO_COMPACTER_BLOCK)) != -1) {
								mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
								craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.NANO_COMPACTER_BLOCK));
							} else {
								mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
							}
						}
					}
			}
			if (isHovering(mouseX, mouseY, centerX+tex_width/2+75, centerY+129, 19, 9) && craftingPage - 8 < TMURecipes.recipes.size()) {
				craftingPage++;
			}
			if (isHovering(mouseX, mouseY, centerX+tex_width/2+75-110, centerY+129, 19, 9) && craftingPage != 0) {
				craftingPage--;
			}
			if (craftingPage > 3) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2+75-50, centerY+129, 19, 9)) {
					
					craftingPage = 1;
					
				}
			}
			
			if (craftingPage == 1 ) {
				tableOfContentsHover();
			}
			if (craftingPage == 2 ) {
				tableOfContentsHover2();
			}
			if (craftingPage == 3 ) {
				tableOfContentsHover3();
			}
			if (craftingPage == 5) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 - 5, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_CORE));
				}
			}
			if (craftingPage == 6) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 - 21, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 - 21, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 - 21, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 - 5, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_DOOR));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 - 5, 16, 16)) {
					
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 - 5, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 + 11, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 + 11, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_CONTROL));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 + 11, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				
			}
			if (craftingPage == 7) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 - 21, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 - 21, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_WINDOW));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 - 21, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 - 5, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_DOOR));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 - 5, 16, 16)) {
					
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 - 5, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_WINDOW));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 + 11, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 + 11, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_WINDOW));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 + 11, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				
			}
			if (craftingPage == 8) {
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 - 21, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 - 21, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 - 21, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 - 5, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 - 5, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 - 5, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 24, centerY+tex_height/2 + 11, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 - 7, centerY+tex_height/2 + 11, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 10, centerY+tex_height/2 + 11, 16, 16)) {
					craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
				}
				
			}
			
		}
		if (craft == true) {
			if (suitCrafting > 0) {
				if (suitCrafting == 1) {
					materialHover(SuitRecipes.blackwidowIngredients);
				}
				if (suitCrafting == 2) {
					materialHover(SuitRecipes.hawkeyeIngredients);
				}
				if (suitCrafting == 3) {
					materialHover(SuitRecipes.batmanIngredients);
				}
				if (suitCrafting == 4) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2, centerY+35, 48, 48)) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = 4;
						craft = false;
					}
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 15, centerY+98, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(new ItemStack(ModItems.SUPERSOLDIER_SERUM)) != -1) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModItems.SUPERSOLDIER_SERUM));
						craft = false;
						}
					}
					//materialHover(SuitRecipes.supermanIngredients);
				}
				if (suitCrafting == 5) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2, centerY+35, 48, 48)) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = 4;
						craft = false;
					}
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 15, centerY+98, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.MOTHER_BOX)) != -1) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.MOTHER_BOX));
						craft = false;
						}
					}
					//materialHover(SuitRecipes.waspIngredients);
				}
				if (suitCrafting == 6) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2, centerY+35, 48, 48)) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = 4;
						craft = false;
					}
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 15, centerY+98, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.MOTHER_BOX)) != -1) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModBlocks.MOTHER_BOX));
						craft = false;
						}
					}
					//materialHover(SuitRecipes.wonderwomanIngredients);
				}
				if (suitCrafting == 7) {
					materialHover(SuitRecipes.ironmanIngredients);
				}
				if (suitCrafting == 8) {
					if (isHovering(mouseX, mouseY, centerX+tex_width/2, centerY+35, 48, 48)) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = 4;
						craft = false;
					}
					if (isHovering(mouseX, mouseY, centerX+tex_width/2 + 15, centerY+98, 18, 18)) {
						if (TMURecipes.matchingCraftingPage(new ItemStack(ModItems.RADIATION_VIAL)) != -1) {
						mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
						suitID = -1;
						craftingPage = TMURecipes.matchingCraftingPage(new ItemStack(ModItems.RADIATION_VIAL));
						craft = false;
						}
					}
					//materialHover(SuitRecipes.wonderwomanIngredients);
				}
				if (suitCrafting == 9) {
					materialHover(SuitRecipes.lokiIngredients);
				}
				if (suitCrafting == 10) {
					//materialHover(SuitRecipes.wonderwomanIngredients);
				}
				if (suitCrafting == 11) {
					materialHover(SuitRecipes.supermanIngredients);
				}
				if (suitCrafting == 12) {
					materialHover(SuitRecipes.thorIngredients);
				}
				if (suitCrafting == 13) {
					materialHover(SuitRecipes.wonderwomanIngredients);
				}
				if (suitCrafting == 14) {
					materialHover(SuitRecipes.zodIngredients);
				}
			}
			
		}
		if (craft == true) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2+2, centerY+120, 50, 16)) {
				
				if (canCraft == true) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					if (suitID == 1) {
					NetworkHandler.sendToServer(new MessageSuitMakerCraft("blackwidow"));
					}
					if (suitID == 2) {
					NetworkHandler.sendToServer(new MessageSuitMakerCraft("hawkeye"));
					}
					if (suitID == 3) {
					NetworkHandler.sendToServer(new MessageSuitMakerCraft("batman"));
					}
					if (suitID == 7) {
						NetworkHandler.sendToServer(new MessageSuitMakerCraft("ironman"));
						}
					if (suitID == 9) {
						NetworkHandler.sendToServer(new MessageSuitMakerCraft("loki"));
						}
					if (suitID == 10) {
						NetworkHandler.sendToServer(new MessageSuitMakerCraft("shazam"));
						}
					if (suitID == 11) {
						NetworkHandler.sendToServer(new MessageSuitMakerCraft("superman"));
						}
					if (suitID == 12) {
						NetworkHandler.sendToServer(new MessageSuitMakerCraft("thor"));
						}
					if (suitID == 13) {
						NetworkHandler.sendToServer(new MessageSuitMakerCraft("wonderwoman"));
						}
					if (suitID == 14) {
						NetworkHandler.sendToServer(new MessageSuitMakerCraft("zod"));
						}
				}else {
					mc.player.playSound(SoundEvents.BLOCK_NOTE_BASS, 0.5f, 1f);
				}
			}
		}
		
		if (mouseX > sliderX-6 && mouseX < (sliderX+sliderWidth)+6 && mouseY > sliderY-6 && mouseY < (sliderY + sliderHeight)+6) {
		held = true;
		}
		if (abilities == true) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2-38, centerY+125, 19, 9)) {
				mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
				abilities = false;
			}
		}
		if (craft == true) {
			if (isHovering(mouseX, mouseY, centerX+tex_width/2-38, centerY+125, 19, 9)) {
				mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
				craft = false;
				canCraft = false;
			}
		}
			if (moveLine+31 > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192 && mouseY < centerY+12 + moveLine+192+18) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = -1;
					abilities = false;
					craft = false;
				}
			}
			if (moveLine+49 > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+18 && mouseY < centerY+12 + moveLine+192+(18*2)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 1;
					abilities = false;
					craft = false;
				}
			}
			if (moveLine+67 > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*2) && mouseY < centerY+12 + moveLine+192+(18*3)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 2;
					abilities = false;
					craft = false;
				}
			}
			if (moveLine+85 > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*3) && mouseY < centerY+12 + moveLine+192+(18*4)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 3;
					abilities = false;
					craft = false;
				}
			}
			if (moveLine+103 > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*4) && mouseY < centerY+12 + moveLine+192+(18*5)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 4;
					abilities = false;
					craft = false;
				}
			}
			if (moveLine+121 > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*5) && mouseY < centerY+12 + moveLine+192+(18*6)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 5;
					abilities = false;
					craft = false;
				}
			}
			if (moveLine+139 < -192+tex_height-8 && moveLine+139 > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*6) && mouseY < centerY+12 + moveLine+192+(18*7)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 6;
					abilities = false;
					craft = false;
					
				}
			}
			if (moveLine+(31+(18*7)) < -192+tex_height-8 && moveLine+(31+(18*7)) > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*7) && mouseY < centerY+12 + moveLine+192+(18*8)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 7;
					abilities = false;
					craft = false;
					
				}
			}
			if (moveLine+(31+(18*8)) < -192+tex_height-8 && moveLine+(31+(18*8)) > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*8) && mouseY < centerY+12 + moveLine+192+(18*9)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 8;
					abilities = false;
					craft = false;
					
				}
			}
			if (moveLine+(31+(18*9)) < -192+tex_height-8 && moveLine+(31+(18*9)) > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*9) && mouseY < centerY+12 + moveLine+192+(18*10)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 9;
					abilities = false;
					craft = false;
					
				}
			}
			if (moveLine+(31+(18*10)) < -192+tex_height-8 && moveLine+(31+(18*10)) > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*10) && mouseY < centerY+12 + moveLine+192+(18*11)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 10;
					abilities = false;
					craft = false;
					
				}
			}
			if (moveLine+(31+(18*11)) < -192+tex_height-8 && moveLine+(31+(18*11)) > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*11) && mouseY < centerY+12 + moveLine+192+(18*12)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 11;
					abilities = false;
					craft = false;
					
				}
			}
			if (moveLine+(31+(18*12)) < -192+tex_height-8 && moveLine+(31+(18*12)) > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*12) && mouseY < centerY+12 + moveLine+192+(18*13)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 12;
					abilities = false;
					craft = false;
					
				}
			}
			if (moveLine+(31+(18*13)) < -192+tex_height-8 && moveLine+(31+(18*13)) > -192) {
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*13) && mouseY < centerY+12 + moveLine+192+(18*14)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 13;
					abilities = false;
					craft = false;
					
				}
			}
			if (moveLine+(31+(18*14)) < -192+tex_height-8 && moveLine+(31+(18*14)) > -192) {
				
				if (mouseX > centerX+12 && mouseX < centerX+56 && mouseY > centerY+12 + moveLine+192+(18*14) && mouseY < centerY+12 + moveLine+192+(18*15)) {
					mc.player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.5f, 1f);
					suitID = 14;
					abilities = false;
					craft = false;
					
				}
			}
			
	}
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		// TODO Auto-generated method stub
		super.mouseReleased(mouseX, mouseY, state);
		held = false;
	}
	@Override
	protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
		// TODO Auto-generated method stub
		super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
		if (mouseX > sliderX && mouseX < (sliderX+sliderWidth) && mouseY > sliderY && mouseY < (sliderY + sliderHeight)) {
			sliderY = mouseY;
		}
	}
	@Override
	public boolean doesGuiPauseGame() {
		// TODO Auto-generated method stub
		return false;
	}
}
