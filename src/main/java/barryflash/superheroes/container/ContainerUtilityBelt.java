package barryflash.superheroes.container;

import barryflash.superheroes.items.ItemBatmanUtilityBelt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerUtilityBelt extends Container{
	private ItemBatmanUtilityBelt te;
	public ContainerUtilityBelt(EntityPlayer player, IInventory playersInv, ItemBatmanUtilityBelt te) {
	this.te = te;

	this.addSlotToContainer(new SlotItemHandler((IItemHandler) te, 0, 43, 22));
	this.addSlotToContainer(new SlotItemHandler((IItemHandler) te, 1, 61, 22));
	this.addSlotToContainer(new SlotItemHandler((IItemHandler) te, 2, 79, 22));
	this.addSlotToContainer(new SlotItemHandler((IItemHandler) te, 3, 97, 22));
	this.addSlotToContainer(new SlotItemHandler((IItemHandler) te, 4, 115, 22));
		
	int xPos = 7;
	int yPos = 53;
	
	for (int y = 0; y <3; ++y) {
		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playersInv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
		}
	}
	for (int x = 0; x < 9; ++x) {
		this.addSlotToContainer(new Slot(playersInv, x, xPos + x * 18, 99));
	}
	}
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
	    ItemStack previous = null;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (fromSlot < 9) {
	            // From TE Inventory to Player Inventory
	            if (!this.mergeItemStack(current, 9, 45, true))
	                return null;
	        } else {
	            // From Player Inventory to TE Inventory
	            if (!this.mergeItemStack(current, 0, 9, false))
	                return null;
	        }

	        if (current.getCount() == 0)
	            slot.putStack((ItemStack) null);
	        else
	            slot.onSlotChanged();

	        if (current.getCount() == previous.getCount())
	            return null;
	        slot.onTake(playerIn, current);
	    }
	    return previous;
	}
	

}
