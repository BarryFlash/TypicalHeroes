package barryflash.superheroes.entities.projectiles;

import org.lwjgl.input.Mouse;

import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IWasp;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.WaspProvider;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityWaspBlast extends EntityThrowable {
	public EntityWaspBlast(World WorldIn) {

		super(WorldIn);
		float size = 0.5F;
		this.setSize(size, size);

	}

	public EntityWaspBlast(World WorldIn, EntityLivingBase throwerIn) {

		super(WorldIn, throwerIn);

	}

	public EntityWaspBlast(World WorldIn, double x, double y, double z) {

		super(WorldIn, x, y, z);

	}
	@Override
	public void onEntityUpdate() {
		if (this.world.isRemote) {
		ParticleSpawnerDoctorStrangeShields.spawnParticle("wasp", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, null);
		ParticleSpawnerDoctorStrangeShields.spawnParticle("wasp2", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, null);
		}
		if (this.ticksExisted > 60) {
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

       this.shoot((double)f, (double)f1, (double)f2, 1.0F, inaccuracy);

       this.motionX += entityThrower.motionX;

       this.motionZ += entityThrower.motionZ;
       IWasp waspcap = entityThrower.getCapability(WaspProvider.WASP_CAP, null);
       int sdistance = 1;
		
		double playerPitch = Math.toRadians(entityThrower.rotationPitch);
		double shorzDistance = sdistance * Math.cos(playerPitch);

		double playerYaw = Math.toRadians(entityThrower.rotationYaw + 130);
		double playerYaw2 = Math.toRadians(entityThrower.rotationYaw + 40);
		

		
       double sposX = entityThrower.posX +(shorzDistance * Math.cos(playerYaw));
       double sposZ = entityThrower.posZ + (shorzDistance * Math.sin(playerYaw));
       double spos2X = entityThrower.posX +(shorzDistance * Math.cos(playerYaw2));
       double spos2Z = entityThrower.posZ + (shorzDistance * Math.sin(playerYaw2));
      
	
     if (waspcap.shotFromLeftArm()) {
   		this.posX = spos2X;
   		this.posZ = spos2Z;
   		
     }
     if (waspcap.shotFromRightArm()) {
    		this.posX = sposX;
    		this.posZ = sposZ;
      }
    
          

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

				if (result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 6)) {
					
					result.entityHit.addVelocity(this.motionX * 1.4000000238418579D, 0.6,this.motionZ * 1.4000000238418579D);
			
				}

			}

			setDead();

		}

	}

}
