package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CyborgProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(ICyborg.class)
	public static final Capability<ICyborg> CYBORG_CAP = null;
	private ICyborg instance = CYBORG_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == CYBORG_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == CYBORG_CAP ? CYBORG_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return CYBORG_CAP.getStorage().writeNBT(CYBORG_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		CYBORG_CAP.getStorage().readNBT(CYBORG_CAP, this.instance, null, nbt);
	}

}
