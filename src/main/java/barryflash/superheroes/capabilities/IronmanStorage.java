package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class IronmanStorage implements IStorage<IIronman>{
	
	@Override
	public NBTBase writeNBT(Capability<IIronman> capability, IIronman instance, EnumFacing side) {

		final NBTTagCompound tag = new NBTTagCompound();     
		tag.setBoolean("cannons", instance.areCannonsActivated());
		
		return tag;
	}

	@Override
	public void readNBT(Capability<IIronman> capability, IIronman instance, EnumFacing side, NBTBase nbt) {

		final NBTTagCompound tag = (NBTTagCompound) nbt;
		instance.activateCannons(tag.getBoolean("cannons"));
		

	}

}
