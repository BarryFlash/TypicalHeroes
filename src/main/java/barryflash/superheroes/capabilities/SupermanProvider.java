package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SupermanProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(ISuperman.class)
	public static final Capability<ISuperman> SUPERMAN_CAP = null;
	private ISuperman instance = SUPERMAN_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == SUPERMAN_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == SUPERMAN_CAP ? SUPERMAN_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return SUPERMAN_CAP.getStorage().writeNBT(SUPERMAN_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		SUPERMAN_CAP.getStorage().readNBT(SUPERMAN_CAP, this.instance, null, nbt);
	}

}
