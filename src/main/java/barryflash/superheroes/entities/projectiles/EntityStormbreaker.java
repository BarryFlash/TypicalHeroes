package barryflash.superheroes.entities.projectiles;

import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityStormbreaker extends EntityThrowable {
	public EntityStormbreaker(World WorldIn) {

		super(WorldIn);
		float size = 0.5F;
		this.setSize(size, size);

	}

	public EntityStormbreaker(World WorldIn, EntityLivingBase throwerIn) {

		super(WorldIn, throwerIn);

	}

	public EntityStormbreaker(World WorldIn, double x, double y, double z) {

		super(WorldIn, x, y, z);

	}
	
	@Override
	public void onEntityUpdate() {
	
		super.onEntityUpdate();
	}

    @Override
    public void onUpdate() {
   

    	super.onUpdate();
    	if (this.throwableShake > 0) {
			this.throwableShake = 0;
		}
    	if (this.ticksExisted > 10) {
			this.motionX = 2 * this.getThrower().getPositionVector().x;
			this.motionY = 2 * this.getThrower().getPositionVector().y;
			this.motionZ = 2 * this.getThrower().getPositionVector().z;
		}
		
    }
	
    

   public void setHeadingFromThrower(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float inaccuracy)

   {

       float f = -MathHelper.sin(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);

       float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * 0.017453292F);

       float f2 = MathHelper.cos(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);

       this.shoot((double)f, (double)f1, (double)f2, 2.0F, inaccuracy);

       this.motionX += entityThrower.motionX;

       this.motionZ += entityThrower.motionZ;



       if (!entityThrower.onGround)

       {

           this.motionY += entityThrower.motionY;

       }

   }

	

	@Override

	protected float getGravityVelocity() {

		return 0.0F;

	}



	/**

	 * Called when this EntityThrowable hits a block or entity.

	 */

	@Override

	protected void onImpact(RayTraceResult result) {

		if (!world.isRemote) {

			if (result.entityHit != null) {

				if (result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4)) {
					
					
				}

			}
			
			setDead();

		}

	}

}
