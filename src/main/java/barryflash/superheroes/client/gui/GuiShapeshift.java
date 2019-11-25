package barryflash.superheroes.client.gui;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.mojang.authlib.GameProfile;

import barryflash.superheroes.Reference;
import barryflash.superheroes.network.MessageFuelGeneratorPlayer;
import barryflash.superheroes.network.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class GuiShapeshift extends GuiScreen {
	final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/shapeshift.png");
	private final int tex_width = 142, tex_height = 188;
	private GuiTextField text;
	private int centerX, centerY;
	@Override
	public void initGui() {
		centerX = (width / 2) - tex_width / 2;
		centerY = (height / 2) - tex_height / 2;
		text = new GuiTextField(0, this.fontRenderer, centerX + 20, centerY + 20, 100, 15);
		text.setMaxStringLength(16);
		text.setText("Input Username");

		super.initGui();

	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		drawTexturedModalRect(centerX, centerY, 0, 0, tex_width, tex_height);
		text.drawTextBox();
		this.fontRenderer.drawString("Shapeshift:", centerX + 10, centerY + 7, Color.DARK_GRAY.getRGB());
	
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	 public static void drawPlayerOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent, String username)
	    {
	        GlStateManager.enableColorMaterial();
	        GlStateManager.pushMatrix();
	        GlStateManager.translate((float)posX, (float)posY, 50.0F);
	        GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
	        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	        float f = ent.renderYawOffset;
	        float f1 = ent.rotationYaw;
	        float f2 = ent.rotationPitch;
	        float f3 = ent.prevRotationYawHead;
	        float f4 = ent.rotationYawHead;
	        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
	        RenderHelper.enableStandardItemLighting();
	        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
	        GlStateManager.rotate(-((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
	        ent.renderYawOffset = (float)Math.atan((double)(mouseX / 40.0F)) * 20.0F;
	        ent.rotationYaw = (float)Math.atan((double)(mouseX / 40.0F)) * 40.0F;
	        ent.rotationPitch = -((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F;
	        ent.rotationYawHead = ent.rotationYaw;
	        ent.prevRotationYawHead = ent.rotationYaw;
	        GlStateManager.translate(0.0F, 0.0F, 0.0F);
	        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
	     
	      //  ModelPlayer model = new ModelPlayer(0.0625F, allowUserInput);
	        rendermanager.setPlayerViewY(180.0F);
	        rendermanager.setRenderShadow(false);
	        rendermanager.renderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
	        rendermanager.setRenderShadow(true);
	        ent.renderYawOffset = f;
	        ent.rotationYaw = f1;
	        ent.rotationPitch = f2;
	        ent.prevRotationYawHead = f3;
	        ent.rotationYawHead = f4;
	        GlStateManager.popMatrix();
	        RenderHelper.disableStandardItemLighting();
	        GlStateManager.disableRescaleNormal();
	        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
	        GlStateManager.disableTexture2D();
	        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
	    }
	 
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		// TODO Auto-generated method stub
		super.keyTyped(typedChar, keyCode);

		this.text.textboxKeyTyped(typedChar, keyCode);
		
		
		if(keyCode== Keyboard.KEY_E  &&  !this.text.isFocused()) super.keyTyped(typedChar, keyCode);

	}
	@Override
	public void updateScreen() {
		// TODO Auto-generated method stub
		super.updateScreen();
		this.text.updateCursorCounter();
	}
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		// TODO Auto-generated method stub
		super.mouseClicked(mouseX, mouseY, mouseButton);
		this.text.mouseClicked(mouseX, mouseY, mouseButton);
	}
}
