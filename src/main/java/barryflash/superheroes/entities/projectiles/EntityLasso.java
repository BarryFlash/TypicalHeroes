package barryflash.superheroes.entities.projectiles;

import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityLasso extends EntityThrowable {
	public EntityLasso(World WorldIn) {

		super(WorldIn);
		float size = 0.5F;
		this.setSize(size, size);

	}
	private static int bulletLife = 60;
	public EntityLasso(World WorldIn, EntityLivingBase throwerIn) {

		super(WorldIn, throwerIn);

	}

	public EntityLasso(World WorldIn, double x, double y, double z) {

		super(WorldIn, x, y, z);

	}
	

    

    

   public void setHeadingFromThrower(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float inaccuracy)

   {

       float f = -MathHelper.sin(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);

       float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * 0.017453292F);

       float f2 = MathHelper.cos(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);

       this.shoot((double)f, (double)f1, (double)f2, 0.2F, inaccuracy);

       this.motionX += entityThrower.motionX;

       this.motionZ += entityThrower.motionZ;



       if (!entityThrower.onGround)

       {

           this.motionY += entityThrower.motionY;

       }

   }

	

	@Override

	protected float getGravityVelocity() {

		return 0F;

	}



	/**

	 * Called when this EntityThrowable hits a block or entity.

	 */
	private float r = 0.0F, g = 0.5F, b = 0.5F;
	@Override

	protected void onImpact(RayTraceResult result) {
		EntityPlayer player = Minecraft.getMinecraft().player;
	
		if (!world.isRemote) {

			if (result.entityHit != null) {
				if (result.entityHit instanceof EntityLiving) {
					Vec3d vec = this.getThrower().getPositionVector();
					Vec3d evec = result.entityHit.getPositionVector();
				result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 2.0F);
				 result.entityHit.motionX = vec.x;
				 result.entityHit.motionX = vec.y;
				 result.entityHit.motionX = vec.z;
				
				System.out.println("Entity has been Lasso'd");


				}

			}

			setDead();

		}

	}
	@Override
	public void onUpdate() {
		if (ticksExisted > bulletLife) {

			setDead();
		}
	}
}


