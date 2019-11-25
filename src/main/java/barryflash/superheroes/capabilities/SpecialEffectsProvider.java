package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SpecialEffectsProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(ISpecialEffects.class)
	public static final Capability<ISpecialEffects> SPECIALEFFECTS_CAP = null;
	private ISpecialEffects instance = SPECIALEFFECTS_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == SPECIALEFFECTS_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == SPECIALEFFECTS_CAP ? SPECIALEFFECTS_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return SPECIALEFFECTS_CAP.getStorage().writeNBT(SPECIALEFFECTS_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		SPECIALEFFECTS_CAP.getStorage().readNBT(SPECIALEFFECTS_CAP, this.instance, null, nbt);
	}

}
