package barryflash.superheroes.client.gui;

import barryflash.superheroes.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiButtonSuitMaker extends GuiButton{

	final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/container/suit_maker.png");
	
	int buttonWidth = 50;
	int buttonHeight = 16;
	int u = 44;
	int v = 168;
	
	public GuiButtonSuitMaker(int buttonId, int x, int y, String text) {
		super(buttonId, x, y, 50, 16, text);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
		
		if (visible) {
			mc.renderEngine.bindTexture(texture);
			if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
				hovered = true;
			} else {
				hovered = false;
			}
			if (hovered) {
				v = 184;
				
				
				
			} else {
				v = 168;
				
				
			}
			drawTexturedModalRect(x, y, u, v, width, height);
		}
	}
}
