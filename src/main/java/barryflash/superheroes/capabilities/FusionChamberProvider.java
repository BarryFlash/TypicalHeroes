package barryflash.superheroes.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class FusionChamberProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IFusionChamber.class)
	public static final Capability<IFusionChamber> FUSION_CHAMBER_CAP = null;
	private IFusionChamber instance = FUSION_CHAMBER_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == FUSION_CHAMBER_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == FUSION_CHAMBER_CAP ? FUSION_CHAMBER_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return FUSION_CHAMBER_CAP.getStorage().writeNBT(FUSION_CHAMBER_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		// TODO Auto-generated method stub
		FUSION_CHAMBER_CAP.getStorage().readNBT(FUSION_CHAMBER_CAP, this.instance, null, nbt);
	}

}
