package barryflash.superheroes.client.gui;

import java.awt.Color;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.Reference;
import barryflash.superheroes.container.ContainerDnaExtractor;
import barryflash.superheroes.container.ContainerFuelGenerator;
import barryflash.superheroes.container.ContainerNanoCompacter;
import barryflash.superheroes.network.MessageFuelGeneratorAddConnection;
import barryflash.superheroes.network.MessageFuelGeneratorPlayer;
import barryflash.superheroes.network.MessageFuelGeneratorRemoveConnection;
import barryflash.superheroes.network.MessageFuelGeneratorRemoveConnectionServer;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntityFuelGenerator;
import barryflash.superheroes.tileentities.TileEntityNanoCompacter;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.energy.CapabilityEnergy;

public class GuiFuelGenerator extends GuiContainer {
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID, "textures/gui/fuel_generator.png");
	private final InventoryPlayer player;
	private final TileEntityFuelGenerator tileentity;
	private GuiTextField textX;
	private GuiTextField textY;
	private GuiTextField textZ;
	private boolean addPos = false;
	private int coords = 0;
	private boolean canClick = true;
	public GuiFuelGenerator(InventoryPlayer player, TileEntityFuelGenerator tileentity) {
		super(new ContainerFuelGenerator(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
		this.xSize = 176;
		this.ySize = 166;
	}
	@Override
	public void initGui() {
		tileentity.setPlayer(this.mc.player);
		NetworkHandler.sendToServer(new MessageFuelGeneratorPlayer(tileentity.getPos(), mc.player));
		textX = new GuiTextField(0, this.fontRenderer, this.width/2 - this.xSize/2 - 70, this.height/2 - this.ySize/2 + 30, 55, 15);
		textX.setMaxStringLength(23);
		textX.setText("X-coord");
		textY = new GuiTextField(0, this.fontRenderer, this.width/2 - this.xSize/2 - 70, this.height/2 - this.ySize/2 + 50, 55, 15);
		textY.setMaxStringLength(23);
		textY.setText("Y-coord");
		textZ = new GuiTextField(0, this.fontRenderer, this.width/2 - this.xSize/2 - 70, this.height/2 - this.ySize/2 + 70, 55, 15);
		textZ.setMaxStringLength(23);
		textZ.setText("Z-coord");
		
		super.initGui();

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
		if (addPos == true) {
			textX.drawTextBox();
			textY.drawTextBox();
			textZ.drawTextBox();
		}
		if (addPos == true) {
		if (isHovering(mouseX, mouseY, this.guiLeft -24, this.guiTop + 8, 15, 16)) {
				if (tileentity.getList().size() == 3) {
					drawHoveringText("No more connections possible.", mouseX, mouseY);
				} else {
				if (textX.getText().matches("[0-9]+") && textX.getText().length() > 0 && textY.getText().matches("[0-9]+") && textY.getText().length() > 0 && textZ.getText().matches("[0-9]+") && textZ.getText().length() > 0) {
				TileEntity tile = this.mc.world.getTileEntity(new BlockPos(Integer.parseInt(textX.getText()), Integer.parseInt(this.textY.getText()), Integer.parseInt(this.textZ.getText())));
				if (tile != null) {
					if (tile.hasCapability(CapabilityEnergy.ENERGY, null)) {
						if (tileentity.getList().contains(tile)) {
							drawHoveringText("Block already added.", mouseX, mouseY);
						}
					} else {
						drawHoveringText("Block does not use Forge Energy.", mouseX, mouseY);
					}
				} else {
					drawHoveringText("Coordinates are invalid.", mouseX, mouseY);
				}
				} else {
					drawHoveringText("Missing coordinates.", mouseX, mouseY);
				}
				}
			}
		}
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(new TextComponentTranslation("tile.fuel_generator.name").getFormattedText(), 5, 5, Color.DARK_GRAY.getRGB());
		this.fontRenderer.drawString("Inventory", 8, 72, Color.DARK_GRAY.getRGB());
		this.fontRenderer.drawString("Connections", -87, 12, Color.DARK_GRAY.getRGB());
		if (!addPos) {
		this.fontRenderer.drawString("(" + tileentity.getList().size() + "/3)", -70, 22, Color.DARK_GRAY.getRGB());
		}
		if (addPos == true) {
			this.fontRenderer.drawString("X:", -84, 34, Color.DARK_GRAY.getRGB());
			this.fontRenderer.drawString("Y:", -84, 54, Color.DARK_GRAY.getRGB());
			this.fontRenderer.drawString("Z:", -84, 74, Color.DARK_GRAY.getRGB());
		} else {
			GlStateManager.pushMatrix();
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			GlStateManager.translate(-165, 74, 0);
			int j = 0;
			for (int i = 0; i < tileentity.getList().size(); i++) {
				this.fontRenderer.drawString("• " + tileentity.getList().get(i).getBlockType().getLocalizedName() + ": ", 0, j, Color.DARK_GRAY.getRGB());
				this.fontRenderer.drawString(tileentity.getList().get(i).getPos().getX() + ", " + tileentity.getList().get(i).getPos().getY() + ", " + tileentity.getList().get(i).getPos().getZ(), 10, 10 + j, Color.DARK_GRAY.getRGB());
				j += 40;
			}
			GlStateManager.popMatrix();
		}

	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		int barY = tileentity.getEnergy() * 73/tileentity.getMaxEnergyStored();
		this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 7, 176, 31, 16, 73 - barY);
		
		if (tileentity.cookTime > 0) {
			int barX = tileentity.cookTime * 14/80;
		this.drawTexturedModalRect(this.guiLeft + 75, this.guiTop + 58, 176, 0, 14, barX);
		} else {
			this.drawTexturedModalRect(this.guiLeft + 75, this.guiTop + 58, 176, 0, 14, 14);
		}
		this.drawTexturedModalRect(this.guiLeft - 92, this.guiTop + 5, 0, 166, 87, 90);
		if (isHovering(mouseX, mouseY, this.guiLeft -24, this.guiTop + 8, 15, 16)) {
		this.drawTexturedModalRect(this.guiLeft - 24, this.guiTop + 8, 87, 198, 15, 16);
		} else {
			this.drawTexturedModalRect(this.guiLeft - 24, this.guiTop + 8, 87, 182, 15, 16);
		}
		if (tileentity.getList().size() > 0) {
			if (isHovering(mouseX, mouseY, this.guiLeft -34, this.guiTop + 36, 15, 16)) {
				this.drawTexturedModalRect(this.guiLeft - 34, this.guiTop + 36, 102, 176, 15, 10);
				} else {
					this.drawTexturedModalRect(this.guiLeft - 34, this.guiTop + 36, 102, 166, 15, 10);
				}
			if (tileentity.getList().size() > 1) {
				if (isHovering(mouseX, mouseY, this.guiLeft -34, this.guiTop + 56, 15, 16)) {
					this.drawTexturedModalRect(this.guiLeft - 34, this.guiTop + 56, 102, 176, 15, 10);
					} else {
						this.drawTexturedModalRect(this.guiLeft - 34, this.guiTop + 56, 102, 166, 15, 10);
					}
				if (tileentity.getList().size() > 2) {
					if (isHovering(mouseX, mouseY, this.guiLeft -34, this.guiTop + 76, 15, 16)) {
						this.drawTexturedModalRect(this.guiLeft - 34, this.guiTop + 76, 102, 176, 15, 10);
						} else {
							this.drawTexturedModalRect(this.guiLeft - 34, this.guiTop + 76, 102, 166, 15, 10);
						}
					}
				}
		}
		
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		// TODO Auto-generated method stub
		super.keyTyped(typedChar, keyCode);

		this.textX.textboxKeyTyped(typedChar, keyCode);
		this.textY.textboxKeyTyped(typedChar, keyCode);
		this.textZ.textboxKeyTyped(typedChar, keyCode);
		if (keyCode == Keyboard.KEY_TAB) {
			if (textY.isFocused()) {
				textY.setFocused(false);
				textZ.setFocused(true);
				textZ.setCursorPositionEnd();
				textZ.setSelectionPos(0);
			}
			if (textX.isFocused()) {
				textX.setFocused(false);
				
				textY.setCursorPositionEnd();
				textY.setSelectionPos(0);
				textY.setFocused(true);
			}
			
		}
		
		if(keyCode== Keyboard.KEY_E  &&  !this.textX.isFocused() && !this.textY.isFocused() && !this.textZ.isFocused()) super.keyTyped(typedChar, keyCode);

	}
	@Override
	public void updateScreen() {
		// TODO Auto-generated method stub
		super.updateScreen();
		this.textX.updateCursorCounter();
		this.textY.updateCursorCounter();
		this.textZ.updateCursorCounter();
	}
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		// TODO Auto-generated method stub
		super.mouseReleased(mouseX, mouseY, state);
		if (canClick == false) {
			canClick = true;
		}
	}
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		// TODO Auto-generated method stub
		super.mouseClicked(mouseX, mouseY, mouseButton);
		this.textX.mouseClicked(mouseX, mouseY, mouseButton);
		this.textY.mouseClicked(mouseX, mouseY, mouseButton);
		this.textZ.mouseClicked(mouseX, mouseY, mouseButton);
		if (addPos == false && canClick == true) {
		if (tileentity.getList().size() > 2) {
			if (isHovering(mouseX, mouseY, this.guiLeft -34, this.guiTop + 76, 15, 16)) {
				tileentity.removeFromList(2);
				NetworkHandler.sendToServer(new MessageFuelGeneratorRemoveConnectionServer(tileentity.getPos(), 2));
				canClick = false;
			} 
		}
		if (tileentity.getList().size() > 1) {
			if (isHovering(mouseX, mouseY, this.guiLeft -34, this.guiTop + 56, 15, 16)) {
				tileentity.removeFromList(1);
				NetworkHandler.sendToServer(new MessageFuelGeneratorRemoveConnectionServer(tileentity.getPos(), 1));
				canClick = false;
			}
			
		}
		if (tileentity.getList().size() > 0) {
			if (isHovering(mouseX, mouseY, this.guiLeft -34, this.guiTop + 36, 15, 16)) {
				tileentity.removeFromList(0);
				NetworkHandler.sendToServer(new MessageFuelGeneratorRemoveConnectionServer(tileentity.getPos(), 0));
				canClick = false;
			} 
			
		}
		}
		if (isHovering(mouseX, mouseY, this.guiLeft -24, this.guiTop + 8, 15, 16)) {
			if (addPos == true) {
				if (textX.getText().matches("[0-9]+") && textX.getText().length() > 0 && textY.getText().matches("[0-9]+") && textY.getText().length() > 0 && textZ.getText().matches("[0-9]+") && textZ.getText().length() > 0) {
				TileEntity tile = this.mc.world.getTileEntity(new BlockPos(Integer.parseInt(textX.getText()), Integer.parseInt(this.textY.getText()), Integer.parseInt(this.textZ.getText())));
				System.out.println(tile);
				if (tile != null) {
					if (tile.hasCapability(CapabilityEnergy.ENERGY, null)) {
						if (!tileentity.getList().contains(tile)) {
							addPos = false;
							tileentity.addToList(tile);
							NetworkHandler.sendToServer(new MessageFuelGeneratorAddConnection(tileentity.getPos(), tile.getPos()));
						}
					}
				}
				}
			} else {
				addPos = true;
			}
		}
	}

}
