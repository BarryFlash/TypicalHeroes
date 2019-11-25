package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ZeusAltarProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IZeusAltar.class)
	public static final Capability<IZeusAltar> ZEUS_ALTAR_CAP = null;
	private IZeusAltar instance = ZEUS_ALTAR_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == ZEUS_ALTAR_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == ZEUS_ALTAR_CAP ? ZEUS_ALTAR_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return ZEUS_ALTAR_CAP.getStorage().writeNBT(ZEUS_ALTAR_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		ZEUS_ALTAR_CAP.getStorage().readNBT(ZEUS_ALTAR_CAP, this.instance, null, nbt);
	}

}
