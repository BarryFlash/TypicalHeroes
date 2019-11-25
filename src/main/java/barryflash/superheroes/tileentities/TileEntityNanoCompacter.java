package barryflash.superheroes.tileentities;

import barryflash.superheroes.energy.CustomEnergyStorage;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.recipes.NanoCompacterRecipes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityNanoCompacter extends TileEntity implements ITickable {

	ItemStackHandler inventory = new ItemStackHandler(3);
	private CustomEnergyStorage storage = new CustomEnergyStorage(5000, 30, 20);
	private int energy = storage.getEnergyStored();
	public int cookTime = 0;
	private ItemStack smelting = ItemStack.EMPTY;
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("inventory", inventory.serializeNBT());
		storage.writeToNBT(compound);
		compound.setInteger("energyGUI", energy);
		compound.setInteger("cookTime", cookTime);
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		storage.readFromNBT(compound);
		energy = compound.getInteger("energyGUI");
		cookTime = compound.getInteger("cookTime");
	}
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY) return true;
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		return super.hasCapability(capability, facing);
	}
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) inventory;
		if (capability == CapabilityEnergy.ENERGY) return (T) storage;
		return super.getCapability(capability, facing);
	}
	
	@Override
	public void update() {
			
			if (storage.getEnergyStored() != 0) {
			energy = storage.getEnergyStored();
			}
			if (!world.isRemote) {
			ItemStack[] inputs = new ItemStack[] {inventory.getStackInSlot(0), inventory.getStackInSlot(1)};
				
			if (storage.getEnergyStored() > 20) {
				if (cookTime > 0) {
					if(!inputs[0].isEmpty() && !inputs[1].isEmpty())
					{
						storage.extractEnergy(20, false);
						cookTime++;
					} else {
						cookTime = 0;
					}
					
					if (cookTime == 200) {
						inputs[0].shrink(1);
						inputs[1].shrink(1);
						inventory.setStackInSlot(0, inputs[0]);
						inventory.setStackInSlot(1, inputs[1]);
						if (!inventory.getStackInSlot(2).isEmpty()) {
							inventory.getStackInSlot(2).grow(1);
							
						} else {
							inventory.insertItem(2, smelting, false);
							
						}
						smelting = ItemStack.EMPTY;
						cookTime = 0;
						markDirty();
						return;
					}
				} else {
					if(!inputs[0].isEmpty() && !inputs[1].isEmpty())
					{
						ItemStack output = NanoCompacterRecipes.getInstance().getResult(inputs[0], inputs[1]);
						
						if(!output.isEmpty())
						{
							if (inventory.getStackInSlot(2).getItem() == output.getItem() || inventory.getStackInSlot(2).isEmpty()) {
								if (inventory.getStackInSlot(2).getCount() < 64) {
									smelting = output;
									cookTime++;
									markDirty();
								}
							}
						}
					}
				}
			}
			}
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public int getMaxEnergyStored()

	{

		return this.storage.getMaxEnergyStored();

	}
	public int getField(int id) 

	{

		switch(id) 

		{
		case 0:

			return this.cookTime;
		case 1:

			return this.energy;

		default:

			return 0;

		}

	}



	public void setField(int id, int value) 

	{

		switch(id) 

		{
		case 0:

			this.cookTime = value;

			break;
		case 1:

			this.energy = value;

		}
		

	}
}
