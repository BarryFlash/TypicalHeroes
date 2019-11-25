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

public class EntityMissile extends EntityThrowable {
	public EntityMissile(World WorldIn) {

		super(WorldIn);
		float size = 0.5F;
		this.setSize(size, size);

	}

	public EntityMissile(World WorldIn, EntityLivingBase throwerIn) {

		super(WorldIn, throwerIn);

	}

	public EntityMissile(World WorldIn, double x, double y, double z) {

		super(WorldIn, x, y, z);

	}
	@Override
	public void onEntityUpdate() {
		if (this.world.isRemote) {
		this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY, this.posZ, 0, 0, 0);
		}
		if (this.ticksExisted > 80) {
			this.setDead();
		}
		
		super.onEntityUpdate();
	}

    @Override
    public void onUpdate() {
   

    	super.onUpdate();
    	if (this.throwableShake > 0) {
			this.throwableShake = 0;
		}

    }
	
    

   public void setHeadingFromThrower(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float inaccuracy)

   {

       float f = -MathHelper.sin(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);

       float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * 0.017453292F);

       float f2 = MathHelper.cos(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);

       this.shoot((double)f, (double)f1, (double)f2, 4.0F, inaccuracy);

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
			if (result.entityHit != this.getThrower()) {
			if (result.entityHit != null) {

				if (result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4)) {
					
					
				}
			}
			}
			this.world.createExplosion(null, result.hitVec.x, result.hitVec.y + 0.5F, result.hitVec.z, 2.0F, true);
			setDead();
			
		}

	}

}
