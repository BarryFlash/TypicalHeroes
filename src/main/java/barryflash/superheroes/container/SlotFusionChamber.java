package barryflash.superheroes.container;

import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.tileentities.TileEntityFusionChamber;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotFusionChamber extends SlotItemHandler {
	private TileEntityFusionChamber te;
	public SlotFusionChamber(IItemHandler itemHandler, int index, int xPosition, int yPosition, TileEntityFusionChamber te) {
		super(itemHandler, index, xPosition, yPosition);
		this.te = te;
	}
	@Override
	public boolean isItemValid(ItemStack stack) {
		if (te.built) {
		if (stack.getItem() == ModItems.RADIATION_VIAL || stack.getItem() == ModItems.SUPERSOLDIER_SERUM || stack.getItem() == Item.getItemFromBlock(ModBlocks.MOTHER_BOX) || stack.getItem() == ModItems.LIGHTNING_ESSENCE) {
			return true;
			
		} else {
			return false;
		}
		} else {
			return false;
		}
	}
}
