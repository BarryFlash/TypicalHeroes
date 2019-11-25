package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ShazamProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IShazam.class)
	public static final Capability<IShazam> SHAZAM_CAP = null;
	private IShazam instance = SHAZAM_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == SHAZAM_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == SHAZAM_CAP ? SHAZAM_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return SHAZAM_CAP.getStorage().writeNBT(SHAZAM_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		SHAZAM_CAP.getStorage().readNBT(SHAZAM_CAP, this.instance, null, nbt);
	}

}
