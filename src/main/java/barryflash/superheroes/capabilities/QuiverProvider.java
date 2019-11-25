package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class QuiverProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IQuiver.class)
	public static final Capability<IQuiver> QUIVER_CAP = null;
	private IQuiver instance = QUIVER_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == QUIVER_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == QUIVER_CAP ? QUIVER_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return QUIVER_CAP.getStorage().writeNBT(QUIVER_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		QUIVER_CAP.getStorage().readNBT(QUIVER_CAP, this.instance, null, nbt);
	}

}
