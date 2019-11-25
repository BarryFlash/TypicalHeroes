package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class AquamanProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IAquaman.class)
	public static final Capability<IAquaman> AQUAMAN_CAP = null;
	private IAquaman instance = AQUAMAN_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == AQUAMAN_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == AQUAMAN_CAP ? AQUAMAN_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return AQUAMAN_CAP.getStorage().writeNBT(AQUAMAN_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		AQUAMAN_CAP.getStorage().readNBT(AQUAMAN_CAP, this.instance, null, nbt);
	}

}
