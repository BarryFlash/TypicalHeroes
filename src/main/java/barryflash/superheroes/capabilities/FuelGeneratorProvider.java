package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class FuelGeneratorProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IFuelGenerator.class)
	public static final Capability<IFuelGenerator> FUEL_GENERATOR_CAP = null;
	private IFuelGenerator instance = FUEL_GENERATOR_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == FUEL_GENERATOR_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == FUEL_GENERATOR_CAP ? FUEL_GENERATOR_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return FUEL_GENERATOR_CAP.getStorage().writeNBT(FUEL_GENERATOR_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		FUEL_GENERATOR_CAP.getStorage().readNBT(FUEL_GENERATOR_CAP, this.instance, null, nbt);
	}

}
