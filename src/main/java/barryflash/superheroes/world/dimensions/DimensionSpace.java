package barryflash.superheroes.world.dimensions;

import barryflash.superheroes.init.ModDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.client.IRenderHandler;

public class DimensionSpace extends WorldProvider {

	@Override
	public DimensionType getDimensionType() {
		// TODO Auto-generated method stub
		return ModDimensions.spaceDimensionType;
	}
	@Override
	public String getSaveFolder() {
		// TODO Auto-generated method stub
		return "SPACE";
	}
	@Override
	public net.minecraft.world.gen.IChunkGenerator createChunkGenerator() {
		// TODO Auto-generated method stub
		return new SpaceChunkGenerator(world);
	}
	@Override
	public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
		// TODO Auto-generated method stub
		return new Vec3d(0.02, 0.005, 0.0);
	}

	@Override
//		@SideOnly(Side.CLIENT)
	public Vec3d getSkyColor(Entity cameraEntity, float partialTicks)
	{
		
		return new Vec3d(0, 0, 0);

	}

	@Override
	public boolean isSkyColored() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		// TODO Auto-generated method stub
		return 8.0F;
	}
	@Override
	public Vec3d getCloudColor(float partialTicks) {
		// TODO Auto-generated method stub
		return new Vec3d(0.01, 0, 0.05);
	}

	@Override
	public float getStarBrightness(float par1) {
		// TODO Auto-generated method stub
		return 6.0F;
	}
	
}
