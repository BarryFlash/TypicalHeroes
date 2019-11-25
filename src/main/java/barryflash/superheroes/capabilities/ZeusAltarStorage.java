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

public class ZeusAltarStorage implements IStorage<IZeusAltar>{
	
	@Override
	public NBTBase writeNBT(Capability<IZeusAltar> capability, IZeusAltar instance, EnumFacing side) {

		return new NBTTagFloat(instance.getProgress()); 
	}

	@Override
	public void readNBT(Capability<IZeusAltar> capability, IZeusAltar instance, EnumFacing side, NBTBase nbt) {

		instance.setProgress(((NBTPrimitive) nbt).getInt());
		

	}

}
