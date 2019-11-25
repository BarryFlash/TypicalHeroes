package barryflash.superheroes.entities.projectiles;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityTrickArrowSmoke extends EntityTrickArrow {
	private boolean impacted;
	private int ticksInGround = 0;
	public EntityTrickArrowSmoke(World worldIn)
    {
        super(worldIn);
      
    }

    public EntityTrickArrowSmoke(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityTrickArrowSmoke(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
    }

	@Override
	protected ItemStack getArrowStack() {
		// TODO Auto-generated method stub
		return ItemStack.EMPTY;
	}

	public void onUpdate() {
		// TODO Auto-generated method stub
		super.onUpdate();
		if (impacted) {
			this.ticksInGround++;
			if (ticksInGround > 120) {
				this.setDead();
				this.ticksInGround = 0;
			}
			
			for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / (16 / 2)) {

				for (double phi = 0; phi < Math.PI; phi += Math.PI / 8) {

					

					double x = (2.2D) * Math.cos(theta) * Math.sin(phi);

					double y = (2) * Math.cos(phi);

					double z = (2.2D) * Math.sin(theta) * Math.sin(phi);
					double x2 = (1.2D) * Math.cos(theta) * Math.sin(phi);

					double y2 = (1) * Math.cos(phi);

					double z2 = (1.2D) * Math.sin(theta) * Math.sin(phi);



				
					//ParticleSpawnerDoctorStrangeShields.spawnParticle("ironman_repulsor", (double) this.posX + x, (double) this.posY + y + ((5)/2), (double) this.posZ + z, 0, 0, 0);
					world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) this.posX + x, (double) this.posY + y + ((2)/2), (double) this.posZ + z, 0, 0, 0);
					world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) this.posX + x2, (double) this.posY + y2 + ((1)/2), (double) this.posZ + z2, 0, 0, 0);
					

				}
			}
		
	
	            
		}
	}
	protected void onHit(RayTraceResult raytraceResultIn) {
		// TODO Auto-generated method stub
		super.onHit(raytraceResultIn);
		if (raytraceResultIn != null) {
			
			this.impacted = true;
			this.motionX = 0;
			this.motionY = 0;
			this.motionZ = 0;


		}
	}

}
