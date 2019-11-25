package barryflash.superheroes.client.gui;

import barryflash.superheroes.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiButtonSuitMakerSlider extends GuiButton{

	final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/container/suit_maker.png");
	
	int buttonWidth = 4;
	int buttonHeight = 13;
	int u = 0;
	int v = 166;
	
	public GuiButtonSuitMakerSlider(int buttonId, int x, int y) {
		super(buttonId, x, y, 32, 32, "");
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
		
		if (visible) {
			mc.renderEngine.bindTexture(texture);

			drawTexturedModalRect(x, y, u, v, width, height);
		}
	}
}
