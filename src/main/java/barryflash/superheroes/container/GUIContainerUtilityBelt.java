package barryflash.superheroes.container;

import barryflash.superheroes.Reference;
import barryflash.superheroes.items.ItemBatmanUtilityBelt;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GUIContainerUtilityBelt extends GuiContainer {
	public GUIContainerUtilityBelt(EntityPlayer player, IInventory playerInv, ItemBatmanUtilityBelt te) {
        super(new ContainerUtilityBelt(player, playerInv, te));

        this.xSize = 7;
        this.ySize = 53;
        GlStateManager.color(49.0f, 39.0f, 39.0f, 1.0f); 
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/BatmanUtilityBeltGUI"));
        this.drawTexturedModalRect(10, 10, 0, 0, 175, 135);
        this.fontRenderer.drawString("Batman Utility Belt", 6, 6, 1, true);
    }
	

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    }
}

