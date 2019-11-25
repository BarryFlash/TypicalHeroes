package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ZodProvider implements ICapabilitySerializable<NBTBase> {
	
	@CapabilityInject(IZod.class)
	public static final Capability<IZod> ZOD_CAP = null;
	private IZod instance = ZOD_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == ZOD_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == ZOD_CAP ? ZOD_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return ZOD_CAP.getStorage().writeNBT(ZOD_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		ZOD_CAP.getStorage().readNBT(ZOD_CAP, this.instance, null, nbt);
	}

}
 