package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class BatmanProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IBatman.class)
	public static final Capability<IBatman> BATMAN_CAP = null;
	private IBatman instance = BATMAN_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == BATMAN_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == BATMAN_CAP ? BATMAN_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return BATMAN_CAP.getStorage().writeNBT(BATMAN_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		BATMAN_CAP.getStorage().readNBT(BATMAN_CAP, this.instance, null, nbt);
	}

}
