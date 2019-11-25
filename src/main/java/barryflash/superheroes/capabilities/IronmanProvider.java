package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class IronmanProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IIronman.class)
	public static final Capability<IIronman> IRONMAN_CAP = null;
	private IIronman instance = IRONMAN_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == IRONMAN_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == IRONMAN_CAP ? IRONMAN_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return IRONMAN_CAP.getStorage().writeNBT(IRONMAN_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		IRONMAN_CAP.getStorage().readNBT(IRONMAN_CAP, this.instance, null, nbt);
	}

}
