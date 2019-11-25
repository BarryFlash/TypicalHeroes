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

public class ShazamStorage implements IStorage<IShazam>{
	
	@Override
	public NBTBase writeNBT(Capability<IShazam> capability, IShazam instance, EnumFacing side) {

		final NBTTagCompound tag = new NBTTagCompound();     

		tag.setBoolean("shazam", instance.isShazam());
		return tag;
	}

	@Override
	public void readNBT(Capability<IShazam> capability, IShazam instance, EnumFacing side, NBTBase nbt) {

		final NBTTagCompound tag = (NBTTagCompound) nbt;
		instance.setShazam(tag.getBoolean("shazam"));
		

	}

}
