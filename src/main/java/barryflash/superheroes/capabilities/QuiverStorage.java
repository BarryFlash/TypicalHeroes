package barryflash.superheroes.capabilities;

import barryflash.superheroes.network.MessageCapToClient;
import barryflash.superheroes.network.NetworkHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class QuiverStorage implements IStorage<IQuiver>{
	
	@Override
	public NBTBase writeNBT(Capability<IQuiver> capability, IQuiver instance, EnumFacing side) {
		final NBTTagCompound tag = new NBTTagCompound();     
		return tag;
	}

	@Override
	public void readNBT(Capability<IQuiver> capability, IQuiver instance, EnumFacing side, NBTBase nbt) {

		final NBTTagCompound tag = (NBTTagCompound) nbt;
		
	}

}
