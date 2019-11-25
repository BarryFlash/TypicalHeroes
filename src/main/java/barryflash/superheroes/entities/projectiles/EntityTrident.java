package barryflash.superheroes.entities.projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityTrident extends EntityThrowable {

			
			public EntityTrident(World world)
{
			super(world);
			}
			
			public EntityTrident(World world, EntityLivingBase entity)
{
			super(world, entity);
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
			protected float getGravityVelocity()
			{
			return 0.005F;
			}

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
