package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class FlashProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IFlash.class)
	public static final Capability<IFlash> FLASH_CAP = null;
	private IFlash instance = FLASH_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == FLASH_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == FLASH_CAP ? FLASH_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return FLASH_CAP.getStorage().writeNBT(FLASH_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		FLASH_CAP.getStorage().readNBT(FLASH_CAP, this.instance, null, nbt);
	}

}
