package barryflash.superheroes.entities.projectiles;

import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.network.MessageUpdateBullet;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable {

	public boolean isLeft = false;
	
	public EntityBullet(World WorldIn) {
		super(WorldIn);
		float size = 0.2F;
		this.setSize(size, size);
	}

	public EntityBullet(World WorldIn, EntityLivingBase throwerIn) {
		super(WorldIn, throwerIn);
		
	}

	public EntityBullet(World WorldIn, double x, double y, double z) {
		super(WorldIn, x, y, z);
	}
	
	
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
	}
	
    @Override
    public void onUpdate() {
   
    	super.onUpdate();
    	
    	if (!world.isRemote) {
    		if (this.ticksExisted < 5) {
   			NetworkHandler.sendTo(new MessageUpdateBullet(this.getEntityId(), this.isLeft), (EntityPlayerMP) this.getThrower());
    		}
   		}
    	if (!world.isRemote) {

		    if (this.ticksExisted > 40) {
		    	this.setDead();
		    }
    	}
    }
    public void setLeft(boolean left) {
    	
    	this.isLeft = left;
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
			if (result.entityHit != null && result.entityHit != this.getThrower()) {
				if (result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 8)) {
					this.setDead();
				}
				
			}
			
			
		}
		if (result.typeOfHit == result.typeOfHit.BLOCK) {
			if (world.getBlockState(result.getBlockPos()).getBlock() != Blocks.TALLGRASS && world.getBlockState(result.getBlockPos()).getBlock() != Blocks.DOUBLE_PLANT) {
			this.setDead();
			}
		}
		
	}

}
