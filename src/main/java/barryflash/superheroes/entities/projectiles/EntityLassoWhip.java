package barryflash.superheroes.entities.projectiles;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;

import net.minecraft.util.DamageSource;

import net.minecraft.util.EnumParticleTypes;

import net.minecraft.util.datafix.DataFixer;

import net.minecraft.util.math.MathHelper;

import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityLassoWhip extends EntityThrowable {


	public EntityLassoWhip(World worldIn) {

		super(worldIn);

		float size = 1.0f;

		this.setSize(size, size);

		this.isInvisible();

	}



	public EntityLassoWhip(World worldIn, EntityLivingBase throwerIn) {

		super(worldIn, throwerIn);

		this.setLocationAndAngles(throwerIn.posX, throwerIn.posY + throwerIn.getEyeHeight(), throwerIn.posZ, throwerIn.rotationYaw, throwerIn.rotationPitch);

		this.setPosition(this.posX, this.posY, this.posZ);

		this.motionX = -MathHelper.sin((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F);

		this.motionY = -MathHelper.sin((rotationPitch / 180F) * 3.141593F);

		this.motionZ = MathHelper.cos((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F);

		this.shoot(motionX, motionY, motionZ, getSpeed(), 1.0F);

	}

	

	@Override

	public void onEntityUpdate() {
	
		super.onEntityUpdate();
		if (ticksExisted > 30) {

			setDead();

		}
	
	}



	public static void registerFixes(DataFixer fixer) {

		EntityThrowable.registerFixesThrowable(fixer, "LassoWhip");

	}



	@Override

	protected float getGravityVelocity() {

		return 0.0f;

	}



	protected float getSpeed() {

		return 0.00000001f;

	}



	/**

	 * Called when this EntityThrowable hits a block or entity.

	 */

	@Override

	protected void onImpact(RayTraceResult result) {

		if (!this.getEntityWorld().isRemote) {

			if (result.entityHit != null && result.entityHit != this.getThrower()) {

				

				if (result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 3)) {

				}
			
				if(this.inWater = true) {
					setDead();
				}

			}

			setDead();

		}

	}



	public int getFireSize() {

		return 1;

	}
	
	
	

}