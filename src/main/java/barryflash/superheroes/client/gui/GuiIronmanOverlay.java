package barryflash.superheroes.client.gui;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiIronmanOverlay extends GuiScreen {
	

	
	private final int tex_width = 92, tex_height = 50, overlay_width = 1200, overlay_height = 800;
	private int tickRight = 0;
	private int rightarm = 0;
	private int tickLeft = 0;
	private int leftarm = 0;
	private int tickUnibeam = 0;
	private int unibeam = 0;
	private int tickWeapon = 0;
	private int weapon = 0;
	private int tickMissiles = 0;
	private int missiles = 0;
	private int tickSword = 0;
	private int sword = 0;
	private int tickKnockback = 0;
	private int knockback = 0;
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer player = mc.player;
			IIronman ironmancap = player.getCapability(IronmanProvider.IRONMAN_CAP, null);
			if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == ModItems.IronManMk50Helmet) {
				if (!ironmancap.isAnimationInProgress()) {
				if (mc.gameSettings.thirdPersonView == 0) {
			int centerX = (width/2);
			int centerY = (height/2);
			int barXRight = ironmancap.getCooldown(0)*70/80; 
			int barXLeft = ironmancap.getCooldown(1)*70/80; 
			int barXUnibeam = ironmancap.getCooldown(2)*70/160; 
			int barXWeapon = ironmancap.getCooldown(3)*70/220; 
			int barXMissiles = ironmancap.getCooldown(4)*70/160; 
			int barXSword = ironmancap.getCooldown(5)*70/80; 
			int barXKnockback = ironmancap.getCooldown(6)*70/160; 
			if (ironmancap.getCooldownAccess(0)) {
				barXRight = ironmancap.getCooldown(0)*70/80; 
			} else {
				barXRight = 70;
			}
			if (ironmancap.getCooldownAccess(1)) {
				barXLeft = ironmancap.getCooldown(1)*70/80; 
			} else {
				barXLeft = 70;
			}
			if (ironmancap.getCooldownAccess(2)) {
				barXUnibeam = ironmancap.getCooldown(2)*70/160; 
			} else {
				barXUnibeam = 70;
			}
			if (ironmancap.getCooldownAccess(3)) {
				barXWeapon = ironmancap.getCooldown(3)*70/220; 
			} else {
				barXWeapon = 70;
			}
			if (ironmancap.getCooldownAccess(4)) {
				barXMissiles = ironmancap.getCooldown(4)*70/160; 
			} else {
				barXMissiles = 70;
			}
			if (ironmancap.getCooldownAccess(5)) {
				barXSword = ironmancap.getCooldown(5)*70/80; 
			} else {
				barXSword = 70;
			}
			if (ironmancap.getCooldownAccess(6)) {
				barXKnockback = ironmancap.getCooldown(6)*70/160;
			} else {
				barXKnockback = 70;
			}
			GlStateManager.pushMatrix(); {
			GlStateManager.translate(event.getResolution().getScaledWidth() - tex_width, (event.getResolution().getScaledHeight()/2) - 80, 0);
			GlStateManager.pushMatrix();
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
			mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/ironman_hudparts.png"));
			this.drawTexturedModalRect(0, -5, 0, 0, 92, 60);
			
			this.drawTexturedModalRect(0, 60, 0, 60, 84, 126);
			this.drawTexturedModalRect(-event.getResolution().getScaledWidth() + 92, 0, 98, 0, 100, 99);
			this.drawTexturedModalRect(-event.getResolution().getScaledWidth() + 92, 110, 102, 106, 95, 84);
			this.drawTexturedModalRect(-event.getResolution().getScaledWidth() + 92, 140, 103, 192, 74, 10);
			this.drawTexturedModalRect(-event.getResolution().getScaledWidth() + 92, 160, 103, 192, 74, 10);
			this.drawTexturedModalRect(-event.getResolution().getScaledWidth() + 92, 180, 103, 192, 74, 10);
			if (ironmancap.areCannonsActivated() || ironmancap.areKnockbackFistsActivated() || ironmancap.areMissilesActivated() || ironmancap.isSwordActivated()) {
			this.drawTexturedModalRect(centerX + 7, centerY + 40, 103, 192, 74, 10);
			}
	
			this.drawTexturedModalRect(-event.getResolution().getScaledWidth() + 94, 142, 105, 202, barXRight, 6);
			this.drawTexturedModalRect(-event.getResolution().getScaledWidth() + 94, 162, 105, 202, barXLeft, 6);
			this.drawTexturedModalRect(-event.getResolution().getScaledWidth() + 94, 182, 105, 202, barXUnibeam, 6);
			if (ironmancap.areCannonsActivated()) {
			this.drawTexturedModalRect(centerX + 9, centerY + 42, 105, 202, barXWeapon, 6);
			} else if (ironmancap.areKnockbackFistsActivated()) {
				this.drawTexturedModalRect(centerX + 9, centerY + 42, 105, 202, barXKnockback, 6);
			}
			else if (ironmancap.areMissilesActivated()) {
				this.drawTexturedModalRect(centerX + 9, centerY + 42, 105, 202, barXMissiles, 6);
			}
			else if (ironmancap.isSwordActivated()) {
				this.drawTexturedModalRect(centerX + 9, centerY + 42, 105, 202, barXSword, 6);
			}
			GlStateManager.popMatrix();
			mc.fontRenderer.drawString("Coordinates:", -event.getResolution().getScaledWidth() + 112, 5, 0x5BFCFF, true);
			mc.fontRenderer.drawString("X: " + (float)player.posX, -event.getResolution().getScaledWidth() + 112, 15, 0x5BFCFF, true);
			mc.fontRenderer.drawString("Y: " + (float)player.posY, -event.getResolution().getScaledWidth() + 112, 25, 0x5BFCFF, true);
			mc.fontRenderer.drawString("Z: " + (float)player.posZ, -event.getResolution().getScaledWidth() + 112, 35, 0x5BFCFF, true);
			mc.fontRenderer.drawString("Biome: " + player.getEntityWorld().getBiome(player.getPosition()).getBiomeName(), -event.getResolution().getScaledWidth() + 102, 45, 0x5BFCFF, true);
			//mc.fontRenderer.drawString("Dimension: " + DimensionType.getById(player.dimension).getName(), -event.getResolution().getScaledWidth() + 102, 55, 0x5BFCFF, true);
			mc.fontRenderer.drawString("Repulsors:", -event.getResolution().getScaledWidth() + 98, 113, 0x5BFCFF);
			mc.fontRenderer.drawString("Right:", -event.getResolution().getScaledWidth() + 98, 132, 0x5BFCFF);
			mc.fontRenderer.drawString("Left:", -event.getResolution().getScaledWidth() + 98, 152, 0x5BFCFF);
			mc.fontRenderer.drawString("Unibeam:", -event.getResolution().getScaledWidth() + 98, 172, 0x5BFCFF);
			if (ironmancap.repulsorsActivated()) {
				mc.fontRenderer.drawString("Activated", -event.getResolution().getScaledWidth() + 98, 122, 0x00FF00);
			} else {
				mc.fontRenderer.drawString("Deactivated", -event.getResolution().getScaledWidth() + 98, 122, 0xFF0000);
			}
			
			GlStateManager.pushMatrix(); {
				GlStateManager.translate(centerX + 5, centerY + 5, 0);
			
			mc.fontRenderer.drawString("Weapon Systems:", 0, 0 - 5 , 0x5BFCFF);
			mc.fontRenderer.drawString("ONLINE", 0 + 20, 0 + 5, 0x00FF00);
			mc.fontRenderer.drawString("Selected Weapon:", 0, 0 + 15, 0x5BFCFF);
			mc.fontRenderer.drawString("Flight Systems:", 0, 60 , 0x5BFCFF);
			mc.fontRenderer.drawString("ONLINE", 0 + 20, 60 + 10, 0x00FF00);
			mc.fontRenderer.drawString("Flight Mode:", 0, 60 + 20, 0x5BFCFF);
			mc.fontRenderer.drawString("Speed:", 25, 110 + 20, 0x5BFCFF);
			mc.fontRenderer.drawString((float)(player.getDistance(player.lastTickPosX, player.lastTickPosY, player.lastTickPosZ))*10 + "", 15, 120 + 20, 0x5BFCFF);
			if (ironmancap.isFlightMode()) {
				mc.fontRenderer.drawString("Normal", 5, 60 + 30, 0x5BFCFF);
			}
			else if (ironmancap.areWingsActivated()) {
				mc.fontRenderer.drawString("Wings", 5, 60 + 30, 0x5BFCFF);
			} 
			else if (ironmancap.isJetThrusterActivated()) {
				mc.fontRenderer.drawString("Jet Thruster", 5, 60 + 30, 0x5BFCFF);
			}
			else {
				mc.fontRenderer.drawString("None", 5, 60 + 30, 0x5BFCFF);
			}
			if (ironmancap.areCannonsActivated()) {
				mc.fontRenderer.drawString("Laser Cannons", 0, 0 + 25, 0x5BFCFF);
			}
			else if (ironmancap.areKnockbackFistsActivated()) {
				mc.fontRenderer.drawString("Knockback Fists", 0, 0 + 25, 0x5BFCFF);
			}
			else if (ironmancap.isSwordActivated()) {
				mc.fontRenderer.drawString("Dagger", 0, 0 + 25, 0x5BFCFF);
			}
			else if (ironmancap.areMissilesActivated()) {
				mc.fontRenderer.drawString("Missile", 0, 0 + 25, 0x5BFCFF);
			}
			else {
				mc.fontRenderer.drawString("None", 0, 25, 0x5BFCFF);
			}
			}GlStateManager.popMatrix();
			}GlStateManager.popMatrix();
		}
		}
		}
		}
	}
}
