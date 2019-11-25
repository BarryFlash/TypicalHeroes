package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class DoctorStrangeProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IDoctorStrange.class)
	public static final Capability<IDoctorStrange> DOCTORSTRANGE_CAP = null;
	private IDoctorStrange instance = DOCTORSTRANGE_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == DOCTORSTRANGE_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == DOCTORSTRANGE_CAP ? DOCTORSTRANGE_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return DOCTORSTRANGE_CAP.getStorage().writeNBT(DOCTORSTRANGE_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		DOCTORSTRANGE_CAP.getStorage().readNBT(DOCTORSTRANGE_CAP, this.instance, null, nbt);
	}

}
