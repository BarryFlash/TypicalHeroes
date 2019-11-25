package barryflash.superheroes.client.gui.container;

import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.ItemInfinityStoneSpace;
import barryflash.superheroes.items.ItemThanosGauntlet;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotInfinityGauntlet extends Slot {
	
	public SlotInfinityGauntlet(InventoryInfinityGauntlet gauntletInventory, int index, int xPos, int yPos)
	{
		super(gauntletInventory, index, xPos, yPos);
	}
	/*
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		if (this.slotNumber == 0){
	        return stack.getItem() == ModItems.infinitystone_soul;
	    	} else if (this.slotNumber == 1) {
	    		  return stack.getItem() == ModItems.infinitystone_reality;
	    	}	else if (this.slotNumber == 2) {
	    		  return stack.getItem() == ModItems.infinitystone_space;
	    	}else if (this.slotNumber == 3) {
	    		  return stack.getItem() == ModItems.infinitystone_power;
	    	}else if (this.slotNumber == 4) {
	    		  return stack.getItem() == ModItems.infinitystone_time;
	    	}else if (this.slotNumber == 5) {
	    		  return stack.getItem() == ModItems.infinitystone_mind;
	    	}
	    	else return false;
	}
	*/
}
