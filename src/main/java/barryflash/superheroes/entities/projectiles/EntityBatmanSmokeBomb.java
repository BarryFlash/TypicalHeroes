package barryflash.superheroes.entities.projectiles;

import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityBatmanSmokeBomb extends EntityThrowable{
	
	private boolean impacted;
	private int ticksInGround = 0;
	public EntityBatmanSmokeBomb(World WorldIn) {

		super(WorldIn);
		float size = 0.5F;
		this.setSize(size, size);

	}

	public EntityBatmanSmokeBomb(World WorldIn, EntityLivingBase throwerIn) {

		super(WorldIn, throwerIn);

	}

	public EntityBatmanSmokeBomb(World WorldIn, double x, double y, double z) {

		super(WorldIn, x, y, z);

	}
	

   
    

   public void setHeadingFromThrower(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float inaccuracy)

   {

       float f = -MathHelper.sin(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);

       float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * 0.017453292F);

       float f2 = MathHelper.cos(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
       this.shoot((double)f, (double)f1, (double)f2, 1.0F, inaccuracy);

       this.motionX += entityThrower.motionX;

       this.motionZ += entityThrower.motionZ;



       if (!entityThrower.onGround)

       {

           this.motionY += entityThrower.motionY;

       }

   }

	

	@Override

	protected float getGravityVelocity() {

		return 0.03025F;

	}

	@Override
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

	
	@Override
	protected void onImpact(RayTraceResult result) {

	
		if (result != null) {
				
					this.impacted = true;
					this.motionX = 0;
					this.motionY = 0;
					this.motionZ = 0;

		
		}
		

	}
}

