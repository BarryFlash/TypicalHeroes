package barryflash.superheroes.container;

import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotLightningExtractorOutput extends SlotItemHandler {
	public SlotLightningExtractorOutput(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}
	@Override
	public boolean isItemValid(ItemStack stack) {
		if (stack.getItem() == ModItems.LIGHTNING_ESSENCE) {
			return true;
		} else {
			return false;
		}
	}
}
