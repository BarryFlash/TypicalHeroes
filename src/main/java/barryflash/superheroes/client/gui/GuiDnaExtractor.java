package barryflash.superheroes.client.gui;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.Locale;

import barryflash.superheroes.Reference;
import barryflash.superheroes.container.ContainerDnaExtractor;
import barryflash.superheroes.container.ContainerNanoCompacter;
import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntityNanoCompacter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.energy.CapabilityEnergy;

public class GuiDnaExtractor extends GuiContainer {
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID, "textures/gui/dna_extractor.png");
	private final InventoryPlayer player;
	private final TileEntityDnaExtractor tileentity;
	
	public GuiDnaExtractor(InventoryPlayer player, TileEntityDnaExtractor tileentity) {
		super(new ContainerDnaExtractor(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
		this.xSize = 176;
		this.ySize = 166;
	}
	public boolean isHovering(int mouseX, int mouseY, int posX, int posY, int width, int height) {
		if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
		if (isHovering(mouseX, mouseY, this.guiLeft + 152, this.guiTop + 7, 16, 73)) {
			drawHoveringText(NumberFormat.getNumberInstance(Locale.US).format(tileentity.getEnergy()) + "/" + NumberFormat.getNumberInstance(Locale.US).format(tileentity.getMaxEnergyStored()) + " FE", mouseX, mouseY);
		}
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(new TextComponentTranslation("tile.dna_extractor.name").getFormattedText(), 5, 5, Color.DARK_GRAY.getRGB());
		this.fontRenderer.drawString("Inventory", 8, 72, Color.DARK_GRAY.getRGB());
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		int barY = tileentity.getEnergy() * 73/tileentity.getMaxEnergyStored();
		this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 7, 176, 31, 16, 73 - barY);
		int barX = tileentity.cookTime * 29/200;
		this.drawTexturedModalRect(this.guiLeft + 67, this.guiTop + 38, 176, 14, barX, 10);
	}
	
	

}
