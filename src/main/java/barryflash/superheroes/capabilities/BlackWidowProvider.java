package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class BlackWidowProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IBlackWidow.class)
	public static final Capability<IBlackWidow> BLACKWIDOW_CAP = null;
	private IBlackWidow instance = BLACKWIDOW_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == BLACKWIDOW_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == BLACKWIDOW_CAP ? BLACKWIDOW_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return BLACKWIDOW_CAP.getStorage().writeNBT(BLACKWIDOW_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		BLACKWIDOW_CAP.getStorage().readNBT(BLACKWIDOW_CAP, this.instance, null, nbt);
	}

}
