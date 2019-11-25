package barryflash.superheroes.capabilities;

import java.util.ArrayList;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class FuelGeneratorStorage implements IStorage<IFuelGenerator>{
	
	@Override
	public NBTBase writeNBT(Capability<IFuelGenerator> capability, IFuelGenerator instance, EnumFacing side) {

		final NBTTagCompound tag = new NBTTagCompound();     
		ArrayList<TileEntity> list = instance.getList();
		if (list.size() > 0) {
			tag.setInteger("tile1posX", list.get(0).getPos().getX());
			tag.setInteger("tile1posY", list.get(0).getPos().getY());
			tag.setInteger("tile1posZ", list.get(0).getPos().getZ());
			if (list.size() > 1) {
				tag.setInteger("tile2posX", list.get(1).getPos().getX());
				tag.setInteger("tile2posY", list.get(1).getPos().getY());
				tag.setInteger("tile2posZ", list.get(1).getPos().getZ());
				if (list.size() > 2) {
					tag.setInteger("tile3posX", list.get(2).getPos().getX());
					tag.setInteger("tile3posY", list.get(2).getPos().getY());
					tag.setInteger("tile3posZ", list.get(2).getPos().getZ());
				}
			}
		}
		
		return tag;
	}

	@Override
	public void readNBT(Capability<IFuelGenerator> capability, IFuelGenerator instance, EnumFacing side, NBTBase nbt) {

		final NBTTagCompound tag = (NBTTagCompound) nbt;
		ArrayList<TileEntity> list = instance.getList();

		

	}

}
