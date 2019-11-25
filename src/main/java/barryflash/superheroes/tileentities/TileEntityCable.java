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

public class TileEntityCable extends TileEntity implements ITickable {

	
	private CustomEnergyStorage storage = new CustomEnergyStorage(500, 20, 20);
	private int energy = storage.getEnergyStored();
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		storage.writeToNBT(compound);
		compound.setInteger("energyGUI", energy);
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		storage.readFromNBT(compound);
		energy = compound.getInteger("energyGUI");
	}
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY) return true;
		return super.hasCapability(capability, facing);
	}
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		if (capability == CapabilityEnergy.ENERGY) return (T) storage;
		return super.getCapability(capability, facing);
	}
	
	@Override
	public void update() {
			System.out.println(storage.getEnergyStored());
			if (storage.getEnergyStored() != 0) {
			energy = storage.getEnergyStored();
			}
			
			for (EnumFacing neighbor : EnumFacing.VALUES)

            {

                TileEntity e = world.getTileEntity(pos.offset(neighbor));
                EnumFacing from = neighbor.getOpposite();
                if (e == null)

                    continue;
                


                IEnergyStorage handler = null;
               
                if (e.hasCapability(CapabilityEnergy.ENERGY, from))

                {
                	
                    handler = e.getCapability(CapabilityEnergy.ENERGY, from);
                    if (handler != storage) {
                    if (handler.canReceive()) {
                    	
                    	int drain = storage.extractEnergy(20, true);

                        if (drain > 0) {

                            int filled = handler.receiveEnergy(drain, false);

                            storage.extractEnergy(filled, false);
		                   markDirty();
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

			this.energy = value;

		}
		

	}
}
