package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CaptainAmericaProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(ICaptainAmerica.class)
	public static final Capability<ICaptainAmerica> CAPTAINAMERICA_CAP = null;
	private ICaptainAmerica instance = CAPTAINAMERICA_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == CAPTAINAMERICA_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == CAPTAINAMERICA_CAP ? CAPTAINAMERICA_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return CAPTAINAMERICA_CAP.getStorage().writeNBT(CAPTAINAMERICA_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		CAPTAINAMERICA_CAP.getStorage().readNBT(CAPTAINAMERICA_CAP, this.instance, null, nbt);
	}

}
