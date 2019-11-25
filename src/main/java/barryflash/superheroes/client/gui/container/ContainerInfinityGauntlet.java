package barryflash.superheroes.client.gui.container;

import barryflash.superheroes.capabilities.IThanos;
import barryflash.superheroes.capabilities.ThanosProvider;
import barryflash.superheroes.items.ItemInfinityStoneMind;
import barryflash.superheroes.items.ItemInfinityStonePower;
import barryflash.superheroes.items.ItemInfinityStoneReality;
import barryflash.superheroes.items.ItemInfinityStoneSoul;
import barryflash.superheroes.items.ItemInfinityStoneSpace;
import barryflash.superheroes.items.ItemInfinityStoneTime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerInfinityGauntlet extends Container {

	 public InventoryInfinityGauntlet infinityGauntletInventory;

	    public IInventory inventoryPlayer;
	private IItemHandler handler;
	public ContainerInfinityGauntlet(IInventory playerInventory, ItemStack heldItem) {
		   InventoryInfinityGauntlet gauntletInventory = (InventoryInfinityGauntlet) heldItem.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		   this.inventoryPlayer = playerInventory;
		
	        this.infinityGauntletInventory = gauntletInventory;
	       
	       
		   this.addSlotToContainer(new SlotInfinityGauntlet(gauntletInventory, 0, 34, 8));
		   this.addSlotToContainer(new SlotInfinityGauntlet(gauntletInventory, 1, 52, 8));
		   this.addSlotToContainer(new SlotInfinityGauntlet(gauntletInventory, 2, 70, 8));
		   this.addSlotToContainer(new SlotInfinityGauntlet(gauntletInventory, 3, 88, 8));
		   this.addSlotToContainer(new SlotInfinityGauntlet(gauntletInventory, 4, 106, 8));
		   this.addSlotToContainer(new SlotInfinityGauntlet(gauntletInventory, 5, 124, 8));
		   int xPos = 8;
		   int yPos = 62;
		   		
		   for (int y = 0; y < 3; ++y) {
		   	for (int x = 0; x < 9; ++x) {
		   		this.addSlotToContainer(new Slot(playerInventory, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
		   	}
		   }
	  		
		   for (int x = 0; x < 9; ++x) {
		   	this.addSlotToContainer(new Slot(playerInventory, x, xPos + x * 18, yPos + 58));
		   }
	}
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return !playerIn.isSpectator();
	}
	
	 public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber) {

	        ItemStack itemstack = null;

	        Slot slot = (Slot) this.inventorySlots.get(slotNumber);

	        if (slot != null && slot.getHasStack()) {

	            ItemStack itemstack1 = slot.getStack();

	            itemstack = itemstack1.copy();

	            if (slotNumber < 6) {

	                if (!this.mergeItemStack(itemstack1, 5, this.inventorySlots.size(), true)) {

	                    return null;

	                }

	            } else {

	                if (!infinityGauntletInventory.isItemValidForSlot(slotNumber, itemstack1)) {

	                    return null;

	                } else if (!this.mergeItemStack(itemstack1, 0, 5, false)) {

	                    return null;

	                }

	            }

	            if (itemstack1.getCount() == 0) {

	                slot.putStack((ItemStack) null);

	            } else {

	                slot.onSlotChanged();

	            }

	        }

	        return itemstack;

	    }



	    @Override

	    public void onContainerClosed(EntityPlayer player) {

	    	infinityGauntletInventory.saveContents();

	        player.inventory.setInventorySlotContents(player.inventory.currentItem, infinityGauntletInventory.infinityGauntletStack);
	        IThanos thanoscap = player.getCapability(ThanosProvider.THANOS_CAP, null);
	        ItemStack soul = infinityGauntletInventory.getStackInSlot(0);
	        ItemStack reality = infinityGauntletInventory.getStackInSlot(1);
	        ItemStack space = infinityGauntletInventory.getStackInSlot(2);
	        ItemStack power = infinityGauntletInventory.getStackInSlot(3);
	        ItemStack time = infinityGauntletInventory.getStackInSlot(4);
	        ItemStack mind = infinityGauntletInventory.getStackInSlot(5);
	       if (soul != null) {
	    	   if(soul.getItem() instanceof ItemInfinityStoneSoul) {
	    		thanoscap.setUsingSoulStone();
	    	   }	  
	       } else {
	    	   thanoscap.unsetUsingSoulStone();
	       }
	       if (space != null) {
	    	   if(space.getItem() instanceof ItemInfinityStoneSpace) {
	    		thanoscap.setUsingSpaceStone();
	    	   }	  
	       } else {
	    	   thanoscap.unsetUsingSpaceStone();
	       }
	       if (reality != null) {
	    	   if(reality.getItem() instanceof ItemInfinityStoneReality) {
	    		thanoscap.setUsingRealityStone();
	    	   }	  
	       } else {
	    	   thanoscap.unsetUsingRealityStone();
	       }
	       if (power != null) {
	    	   if(power.getItem() instanceof ItemInfinityStonePower) {
	    		thanoscap.setUsingPowerStone();
	    	   }	  
	       } else {
	    	   thanoscap.unsetUsingPowerStone();
	       }
	       if (mind != null) {
	    	   if(mind.getItem() instanceof ItemInfinityStoneMind) {
	    		thanoscap.setUsingMindStone();
	    	   }	  
	       } else {
	    		thanoscap.unsetUsingMindStone();
	       }
	       if (time != null) {
	    	   if(time.getItem() instanceof ItemInfinityStoneTime) {
	    		thanoscap.setUsingTimeStone();
	    	   }	  
	       } else {
	    	   thanoscap.unsetUsingTimeStone();
	       }

	        super.onContainerClosed(player);

	    }



	    @Override
	    public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
	    	  int clickedSlot = slotId - infinityGauntletInventory.getSizeInventory() - 27;



		        if (clickedSlot == player.inventory.currentItem)

		            return null;
		      
	    	return super.slotClick(slotId, dragType, clickTypeIn, player);
	    }
	
	
	
}