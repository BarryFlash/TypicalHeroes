package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class KeysProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IKeys.class)
	public static final Capability<IKeys> KEYS_CAP = null;
	private IKeys instance = KEYS_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == KEYS_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == KEYS_CAP ? KEYS_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return KEYS_CAP.getStorage().writeNBT(KEYS_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		KEYS_CAP.getStorage().readNBT(KEYS_CAP, this.instance, null, nbt);
	}

}
