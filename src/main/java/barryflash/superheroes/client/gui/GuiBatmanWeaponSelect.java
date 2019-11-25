package barryflash.superheroes.client.gui;

import java.io.IOException;

import barryflash.superheroes.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiBatmanWeaponSelect extends GuiScreen {
	final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/batman_weaponselect.png");

	int guiHeight = 255;
	int guiWidth = 255;
	
	private final int tex_width = 180, tex_height = 12;
	
	
	 
	GuiButton abilities;
	
	
	final int ABILITIES = 0, EYE = 1;
	
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		updateScreen();
		
		int centerX = (width / 2) - guiWidth / 2;
		int centerY = (height / 2) - guiHeight / 2;
		GlStateManager.pushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
		GlStateManager.popMatrix();
		if (isHovering(mouseX, mouseY, centerX + 84, centerY + 1, 88, 22)) {
			System.out.println("BUTTON");
		}
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
	public void initGui() {
		buttonList.clear();
		int centerY = (height / 2) - guiHeight / 2;
		//buttonList.add(abilities = new GuiButton(ABILITIES, (width/2) - 45, centerY + 110, 100, 20, "Abilities"));
		
		super.initGui();
	}
	
	public void updateButtons() {
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		
		switch (button.id) {
		case ABILITIES:
			
			break;
		
		}
		updateButtons();
		super.actionPerformed(button);
	}
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	
	
}
