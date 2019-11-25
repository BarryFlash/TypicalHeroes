package barryflash.superheroes.client.gui.container;

import barryflash.superheroes.capabilities.IThanos;
import barryflash.superheroes.capabilities.ThanosProvider;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.ItemInfinityStoneMind;
import barryflash.superheroes.items.ItemInfinityStonePower;
import barryflash.superheroes.items.ItemInfinityStoneReality;
import barryflash.superheroes.items.ItemInfinityStoneSoul;
import barryflash.superheroes.items.ItemInfinityStoneSpace;
import barryflash.superheroes.items.ItemInfinityStoneTime;
import barryflash.superheroes.items.ItemThanosGauntlet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemHandlerHelper;

public class InventoryInfinityGauntlet implements IInventory

{

	 public ItemStack[] slots;

	    

	    public ItemStack infinityGauntletStack;

	    public int inventoryStackLimit = 1;



	    public InventoryInfinityGauntlet(int slots, ItemStack infinityGauntletStack) {

	        this.slots = new ItemStack[slots];

	

	        this.infinityGauntletStack = infinityGauntletStack;



	        if (!infinityGauntletStack.hasTagCompound())

	            infinityGauntletStack.setTagCompound(new NBTTagCompound());



	        readFromNBT(infinityGauntletStack.getTagCompound());

	    }



	    @Override

	    public int getSizeInventory() {

	        return slots.length;

	    }



	    @Override

	    public ItemStack getStackInSlot(int par1) {

	        return this.slots[par1];

	    }



	    public ItemStack decrStackSize(int par1, int par2) {

	        if (this.slots[par1] != null) {

	            ItemStack itemstack;



	            if (this.slots[par1].getCount() <= par2) {

	                itemstack = this.slots[par1];

	                this.slots[par1] = null;

	                return itemstack;

	            } else {

	                itemstack = this.slots[par1].splitStack(par2);



	                if (this.slots[par1].getCount() == 0) {

	                    this.slots[par1] = null;

	                }



	                return itemstack;

	            }

	        } else {

	            return null;

	        }

	    }





	   
	    @Override
	    public ItemStack removeStackFromSlot(int slot) {
	    	// TODO Auto-generated method stub
	    	  if (this.slots[slot] != null) {

		            ItemStack itemstack = this.slots[slot];

		            this.slots[slot] = null;

		            return itemstack;

		        } else {

		            return null;

		        }
	    }


	    @Override

	    public void setInventorySlotContents(int slot, ItemStack stack) {

	        this.slots[slot] = stack;

	        if (stack != null && stack.getCount() > this.getInventoryStackLimit()) {

	            stack.setCount(this.getInventoryStackLimit());

	        }
	        

	    }



	    @Override
	    public String getName() {

	        return infinityGauntletStack.getDisplayName();

	    }
	  


	    @Override
	    public boolean hasCustomName() {

	        return false;

	    }



	    @Override
	    public int getInventoryStackLimit() {

	        return inventoryStackLimit;

	    }



	    @Override

	    public void markDirty() {

	    }


	    @Override
	    public boolean isUsableByPlayer(EntityPlayer player) {
	    	// TODO Auto-generated method stub
	    	return !player.isSpectator();
	    }



	    @Override
	    public void openInventory(EntityPlayer player) {

	    }
	   
	    


	    @Override

	    public void closeInventory(EntityPlayer player) {
	    	saveContents();
	    }



	    @Override

	    public boolean isItemValidForSlot(int slot, ItemStack stack) {
	    	/*	if (slot == 1){
	        return stack.getItem() == ModItems.infinitystone_soul;
	    	} else if (slot == 2) {
	    		  return stack.getItem() == ModItems.infinitystone_reality;
	    	}	else if (slot == 3) {
	    		  return stack.getItem() == ModItems.infinitystone_space;
	    	}else if (slot == 4) {
	    		  return stack.getItem() == ModItems.infinitystone_power;
	    	}else if (slot == 5) {
	    		  return stack.getItem() == ModItems.infinitystone_time;
	    	}else if (slot == 6) {
	    		  return stack.getItem() == ModItems.infinitystone_mind;
	    	}
	    	else */return false;
	    	
	    }



	    public void readFromNBT(NBTTagCompound tagCompound) {

	        NBTTagList nbttaglist = tagCompound.getTagList("Items", 10);

	        this.slots = new ItemStack[this.getSizeInventory()];

	        for (int i = 0; i < nbttaglist.tagCount(); ++i) {

	            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);

	            byte b0 = nbttagcompound1.getByte("Slot");

	            if (b0 >= 0 && b0 < this.slots.length) {

	                //this.slots[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);

	            }

	        }

	    }



	    public void writeToNBT(NBTTagCompound tagCompound) {

	        NBTTagList nbttaglist = new NBTTagList();

	        for (int i = 0; i < this.slots.length; ++i) {

	            if (this.slots[i] != null) {

	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();

	                nbttagcompound1.setByte("Slot", (byte) i);

	                this.slots[i].writeToNBT(nbttagcompound1);

	                nbttaglist.appendTag(nbttagcompound1);

	            }

	        }

	        tagCompound.setTag("Items", nbttaglist);

	    }



	    public void saveContents() {

	        for (int i = 0; i < getSizeInventory(); ++i) {

	            if (getStackInSlot(i) != null && getStackInSlot(i).getCount() == 0)

	                setInventorySlotContents(i, null);

	        }

	        writeToNBT(infinityGauntletStack.getTagCompound());

	    }



		@Override
		public ITextComponent getDisplayName() {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public int getField(int id) {
			// TODO Auto-generated method stub
			return 0;
		}



		@Override
		public void setField(int id, int value) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public int getFieldCount() {
			// TODO Auto-generated method stub
			return 0;
		}



		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}



		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

	}