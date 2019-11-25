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

public class KeysStorage implements IStorage<IKeys>{
	
	@Override
	public NBTBase writeNBT(Capability<IKeys> capability, IKeys instance, EnumFacing side) {

		final NBTTagCompound tag = new NBTTagCompound();     

		
		return tag;
	}

	@Override
	public void readNBT(Capability<IKeys> capability, IKeys instance, EnumFacing side, NBTBase nbt) {

		final NBTTagCompound tag = (NBTTagCompound) nbt;
		
		

	}

}
