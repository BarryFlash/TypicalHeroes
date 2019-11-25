package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class WonderWomanProvider implements ICapabilitySerializable<NBTBase> {
	
	@CapabilityInject(IWonderWoman.class)
	public static final Capability<IWonderWoman> WONDERWOMAN_CAP = null;
	private IWonderWoman instance = WONDERWOMAN_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == WONDERWOMAN_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == WONDERWOMAN_CAP ? WONDERWOMAN_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return WONDERWOMAN_CAP.getStorage().writeNBT(WONDERWOMAN_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		WONDERWOMAN_CAP.getStorage().readNBT(WONDERWOMAN_CAP, this.instance, null, nbt);
	}

}
 