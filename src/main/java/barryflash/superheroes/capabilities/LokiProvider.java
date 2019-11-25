package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class LokiProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(ILoki.class)
	public static final Capability<ILoki> LOKI_CAP = null;
	private ILoki instance = LOKI_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == LOKI_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == LOKI_CAP ? LOKI_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return LOKI_CAP.getStorage().writeNBT(LOKI_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		LOKI_CAP.getStorage().readNBT(LOKI_CAP, this.instance, null, nbt);
	}

}
