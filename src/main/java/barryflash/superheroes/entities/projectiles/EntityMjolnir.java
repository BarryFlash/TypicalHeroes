package barryflash.superheroes.entities.projectiles;

import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityMjolnir extends EntityThrowable {
	private boolean contacted = false;
	
	public EntityMjolnir(World WorldIn) {
		super(WorldIn);
		float size = 0.5F;
		this.setSize(size, size);
	}

	public EntityMjolnir(World WorldIn, EntityLivingBase throwerIn) {
		super(WorldIn, throwerIn);
	}

	public EntityMjolnir(World WorldIn, double x, double y, double z) {
		super(WorldIn, x, y, z);
	}
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
	}
	private void returnToPlayer() {
		double d0 = this.getThrower().posX - this.posX;

		double d1 = this.getThrower().posY  - this.posY + (double)(this.getThrower().height);

		d1 -= 0.6D;

		double d2 = this.getThrower().posZ - this.posZ;

		double d3 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);

		

		if (d3 >= 1.0E-7D)

		{

			float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;

			float f3 = (float)(-(Math.atan2(d1, d3) * 180.0D / Math.PI));

			this.setLocationAndAngles(this.posX, this.posY, this.posZ, f2, f3);

			float f4 = (float)d3 * 0.2F;
			this.shoot(d0, d1, d2, 2, 0);

		}
	}
    @Override
    public void onUpdate() {
   
    	super.onUpdate();
    	if (!world.isRemote) {
    		if (contacted == false) {
		    	if (this.ticksExisted > 30) {
		    		if (this.getThrower() != null) {
		    		contacted = true;
		    		}
				}
    		}
    	if (contacted == true) {
    		returnToPlayer();
    	}
    	if (this.ticksExisted > 120) {
    		EntityItem thorItem = new EntityItem(world, this.getThrower().posX, this.getThrower().posY + 0.1, this.getThrower().posZ, new ItemStack(ModItems.thor_hammer, 1));
			
			world.spawnEntity(thorItem);
			this.setDead();
    	}
    	}
    }
    
    @Override
    public void onCollideWithPlayer(EntityPlayer player) {
    	// TODO Auto-generated method stub
    	super.onCollideWithPlayer(player);
    	if (!world.isRemote) {
	    	if (contacted == true) {
	    		if (player == this.getThrower()) {

	    		
	    				EntityItem thorItem = new EntityItem(world, this.getThrower().posX, this.getThrower().posY + 0.1, this.getThrower().posZ, new ItemStack(ModItems.thor_hammer, 1));
	    				
	    				world.spawnEntity(thorItem);
	    			
	    			
	    			contacted = false;
	    			this.setDead();
	    		}
	    	}
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

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!world.isRemote) {
			if (result.entityHit != null) {
				if (result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 20)) {
					/*if (contacted == false) {
					contacted = true;
					}*/
				}
				
			}
			if (result.typeOfHit == result.typeOfHit.BLOCK) {
				if (world.getBlockState(result.getBlockPos()).getBlock() != Blocks.TALLGRASS && world.getBlockState(result.getBlockPos()).getBlock() != Blocks.DOUBLE_PLANT) {
				if (contacted == false) {
				contacted = true;
				}
				}
			}

		}

	}

}
