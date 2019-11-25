package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SuperheroesProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(ISuperheroes.class)
	public static final Capability<ISuperheroes> SUPERHEROES_CAP = null;
	private ISuperheroes instance = SUPERHEROES_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == SUPERHEROES_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == SUPERHEROES_CAP ? SUPERHEROES_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return SUPERHEROES_CAP.getStorage().writeNBT(SUPERHEROES_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		SUPERHEROES_CAP.getStorage().readNBT(SUPERHEROES_CAP, this.instance, null, nbt);
	}

}
