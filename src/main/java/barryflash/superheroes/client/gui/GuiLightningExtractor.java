package barryflash.superheroes.client.gui;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.Locale;

import barryflash.superheroes.Reference;
import barryflash.superheroes.container.ContainerDnaExtractor;
import barryflash.superheroes.container.ContainerLightningExtractor;
import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntityLightningExtractor;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

public class GuiLightningExtractor extends GuiContainer {
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID, "textures/gui/lightning_extractor.png");
	private final InventoryPlayer player;
	private final TileEntityLightningExtractor tileentity;
	
	public GuiLightningExtractor(InventoryPlayer player, TileEntityLightningExtractor tileentity) {
		super(new ContainerLightningExtractor(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
		this.xSize = 176;
		this.ySize = 194;
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
		if (isHovering(mouseX, mouseY, this.guiLeft + 152, this.guiTop + 21, 16, 73)) {
			drawHoveringText(NumberFormat.getNumberInstance(Locale.US).format(tileentity.getEnergy()) + "/" + NumberFormat.getNumberInstance(Locale.US).format(tileentity.getMaxEnergyStored()) + " FE", mouseX, mouseY);
		}
		if (isHovering(mouseX, mouseY, this.guiLeft + 8, this.guiTop + 21, 16, 73)) {
			drawHoveringText(NumberFormat.getNumberInstance(Locale.US).format(tileentity.lightning) + "/" + NumberFormat.getNumberInstance(Locale.US).format(1000) + " Lightning", mouseX, mouseY);
		}
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(new TextComponentTranslation("tile.lightning_extractor.name").getFormattedText(), 5, 5, Color.DARK_GRAY.getRGB());
		this.fontRenderer.drawString("Inventory", 8, 100, Color.DARK_GRAY.getRGB());
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		int barY = tileentity.getEnergy() * 73/tileentity.getMaxEnergyStored();
		this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 21, 176, 17, 16, 73 - barY);
		int barY2 = tileentity.lightning * 73/1000;
		this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 21, 176, 17, 16, 73 - barY2);
		int barX = tileentity.cookTime * 24/200;
		this.drawTexturedModalRect(this.guiLeft + 70, this.guiTop + 49, 176, 0, barX, 17);
	}
}
