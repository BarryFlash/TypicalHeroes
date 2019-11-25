package barryflash.superheroes.container;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotNanoCompacterOutput extends SlotItemHandler {

	public SlotNanoCompacterOutput(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isItemValid(ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}
}
