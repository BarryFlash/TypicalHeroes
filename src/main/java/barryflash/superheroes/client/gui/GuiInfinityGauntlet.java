package barryflash.superheroes.client.gui;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.client.gui.container.ContainerInfinityGauntlet;
import barryflash.superheroes.client.gui.container.InventoryInfinityGauntlet;
import barryflash.superheroes.items.ItemThanosGauntlet;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiInfinityGauntlet extends GuiContainer {

	private final ItemStack infinityGauntletStack;
	private IInventory playerInv;
	
	public GuiInfinityGauntlet(IInventory playerInv, ItemStack infinityGauntletStack) {
		super(new ContainerInfinityGauntlet(playerInv, infinityGauntletStack));
	
		this.xSize = 175;
		this.ySize = 143;
		
		this.infinityGauntletStack = infinityGauntletStack;
		this.playerInv = playerInv;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/infinitygauntlet_gui.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		  //this.fontRendererObj.drawString(this.infinityGauntletStack.getDisplayName(), 8, 6, 4210752);
		
	        this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	}


}
