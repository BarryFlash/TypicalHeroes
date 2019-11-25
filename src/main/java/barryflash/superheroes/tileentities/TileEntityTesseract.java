package barryflash.superheroes.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;

public class TileEntityTesseract extends TileEntity {

	private int particleCount = 0;
	
	public boolean addParticle() {
		if (particleCount < 3) {
			particleCount++;
			world.spawnParticle(EnumParticleTypes.CLOUD, pos.getX(), pos.getY(), pos.getZ(), 0, 0.03, 0);
			return true;
		}
		return false;
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("particleCount", this.particleCount);
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		this.particleCount = compound.getInteger("particleCount");
	}
}
