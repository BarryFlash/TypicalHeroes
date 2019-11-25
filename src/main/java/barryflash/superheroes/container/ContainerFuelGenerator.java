package barryflash.superheroes.container;

import java.util.ArrayList;

import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.tileentities.TileEntityFuelGenerator;
import barryflash.superheroes.tileentities.TileEntityNanoCompacter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerFuelGenerator extends Container {
	TileEntityFuelGenerator te;
	private int energy, cookTime;

	public ContainerFuelGenerator(InventoryPlayer inventoryPlayer, TileEntityFuelGenerator te) {
		this.te = te;
		if (te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
			IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
			
			addSlotToContainer(new SlotNanoCompacterInput(inventory, 0, 74, 38));
			for (int y = 0; y < 3; y++) {
				for (int x = 0; x < 9; x++) {
					addSlotToContainer(new Slot(inventoryPlayer, x + (y * 9) + 9, 8 + x * 18, 84 + y * 18));
				}
			}
			for (int i = 0; i < 9; i++) {
				addSlotToContainer(new Slot(inventoryPlayer, i, 8 + (i * 18), 142));
			}
		}
	}
	
	@Override

	public void updateProgressBar(int id, int data) 

	{

		this.te.setField(id, data);

	}

	

	@Override

	public void detectAndSendChanges() 

	{

		super.detectAndSendChanges();

		

		for(int i = 0; i < this.listeners.size(); ++i) 

		{

			IContainerListener listener = (IContainerListener)this.listeners.get(i);

			if(this.cookTime != this.te.getField(0)) listener.sendWindowProperty(this, 0, this.te.getField(0));
			if(this.energy != this.te.getField(1)) listener.sendWindowProperty(this, 1, this.te.getField(1));


		}

		
		this.cookTime = this.te.getField(0);
		this.energy = this.te.getField(1);

	}
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack stack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack stackInSlot = slot.getStack();
            stack = stackInSlot.copy();

            int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();

            if (index < containerSlots) {
                if (!this.mergeItemStack(stackInSlot, containerSlots, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(stackInSlot, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (stackInSlot.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            slot.onTake(player, stackInSlot);
        }
        return stack;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
