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
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntitySonarCannonBlast extends EntityThrowable {


	public EntitySonarCannonBlast(World WorldIn) {
		super(WorldIn);
		float size = 0.2F;
		this.setSize(size, size);
	}

	public EntitySonarCannonBlast(World WorldIn, EntityLivingBase throwerIn) {
		super(WorldIn, throwerIn);
		
	}

	public EntitySonarCannonBlast(World WorldIn, double x, double y, double z) {
		super(WorldIn, x, y, z);
	}
	
	
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
	}
	
    @Override
    public void onUpdate() {
   
    	super.onUpdate();
    	
    	if (this.ticksExisted > 80) {
    		this.setDead();
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
			if (result.entityHit != null && result.entityHit != this.getThrower()) {
				if (result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 10)) {
					if (result.entityHit instanceof EntityLiving) {
						EntityLiving entity = (EntityLiving) result.entityHit;
						entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 20, 2));
					}
					this.setDead();
				}
				
			}
			
			
		}
		if (result.typeOfHit == result.typeOfHit.BLOCK) {
			if (world.getBlockState(result.getBlockPos()).getBlock() != Blocks.TALLGRASS && world.getBlockState(result.getBlockPos()).getBlock() != Blocks.DOUBLE_PLANT) {
				if (world.getBlockState(result.getBlockPos()).getBlock() == Blocks.GLASS || world.getBlockState(result.getBlockPos()).getBlock() == Blocks.GLASS_PANE || world.getBlockState(result.getBlockPos()).getBlock() == Blocks.STAINED_GLASS || world.getBlockState(result.getBlockPos()).getBlock() == Blocks.STAINED_GLASS_PANE) {
					world.setBlockToAir(result.getBlockPos());
					world.playSound(result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 1F, 1F, false);
				}
			this.setDead();
			}
		}
		
	}

}
