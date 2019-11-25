package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PortalProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IPortal.class)
	public static final Capability<IPortal> PORTAL_CAP = null;
	private IPortal instance = PORTAL_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == PORTAL_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == PORTAL_CAP ? PORTAL_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return PORTAL_CAP.getStorage().writeNBT(PORTAL_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		PORTAL_CAP.getStorage().readNBT(PORTAL_CAP, this.instance, null, nbt);
	}

}
