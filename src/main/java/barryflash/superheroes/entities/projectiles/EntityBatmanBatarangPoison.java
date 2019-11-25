package barryflash.superheroes.entities.projectiles;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityBatmanBatarangPoison extends EntityArrow {
	
	   public EntityBatmanBatarangPoison(World worldIn)
	    {
	        super(worldIn);
	      
	    }

	    public EntityBatmanBatarangPoison(World worldIn, double x, double y, double z)
	    {
	        super(worldIn, x, y, z);
	    }

	    public EntityBatmanBatarangPoison(World worldIn, EntityLivingBase shooter)
	    {
	        super(worldIn, shooter);
	    }

		@Override
		protected ItemStack getArrowStack() {
			// TODO Auto-generated method stub
			return ItemStack.EMPTY;
		}
		
		public void onUpdate() {
			// TODO Auto-generated method stub
			super.onUpdate();
			if (this.world.isRemote)
	        {
	            if (this.inGround)
	            {
	            	 for (int j = 0; j < 1; ++j)
	    	            {
	    	                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, (this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width) + 1.5, this.posY + (this.rand.nextDouble() - 0.5D), this.posZ + (this.rand.nextDouble() - 1.5D) * (double)this.width, 0, 3, 0, new int[0]);
	    	                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, (this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width) - 1.5, this.posY + (this.rand.nextDouble() - 0.5D), this.posZ + (this.rand.nextDouble() - 1.5D) * (double)this.width, 0, 3, 0, new int[0]);
	    	                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + (this.rand.nextDouble() - 0.5D), (this.posZ + (this.rand.nextDouble() - 1.5D) * (double)this.width) + 1.5, 0, 3, 0, new int[0]);
	    	                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + (this.rand.nextDouble() - 0.5D), (this.posZ + (this.rand.nextDouble() - 1.5D) * (double)this.width) - 1.5, 0, 3, 0, new int[0]);
	    	                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, (this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width) - 1.1, this.posY + (this.rand.nextDouble() - 0.5D), (this.posZ + (this.rand.nextDouble() - 1.5D) * (double)this.width) + 1.1, 0, 3, 0, new int[0]);
	    	                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, (this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width) - 1.1, this.posY + (this.rand.nextDouble() - 0.5D), (this.posZ + (this.rand.nextDouble() - 1.5D) * (double)this.width) - 1.1, 0, 3, 0, new int[0]);
	    	                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, (this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width) + 1.1, this.posY + (this.rand.nextDouble() - 0.5D), (this.posZ + (this.rand.nextDouble() - 1.5D) * (double)this.width) - 1.1, 0, 3, 0, new int[0]);
	    	                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, (this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width) + 1.1, this.posY + (this.rand.nextDouble() - 0.5D), (this.posZ + (this.rand.nextDouble() - 1.5D) * (double)this.width) + 1.1, 0, 3, 0, new int[0]);
	    	            
	    	            }
	                if (this.timeInGround % 5 == 0)
	                {
	                    this.spawnPotionParticles(1);
	                }
	            
	            }
	            else
	            {
	                this.spawnPotionParticles(2);
	            }
	        } else {
	        	 if (this.inGround)
		            {
	        		 if (this.timeInGround > 120) {
	        			 this.setDead();
	        		 }
	        		    double k1 = this.getPosition().getX() + 1.5;
	        		    double l1 = this.getPosition().getX() - 1.5;
	        		    double i2 = this.getPosition().getY() + 1.5;
	        		    double i1 = this.getPosition().getY() - 1.5;
	        		    double j2 = this.getPosition().getZ() + 1.5;
	        		    double j1 = this.getPosition().getZ() - 1.5;
	        		   
	   	       		  List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, new AxisAlignedBB(k1, i2, j2, l1, i1, j1));
	   	       		  for (int k2 = 0; k2 < list.size(); ++k2)
	   	       		  {
	   	       		  Entity entity = (Entity)list.get(k2);
	   	       		  if (entity instanceof EntityLivingBase) {
	   	       		((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.POISON, 300, 1, true, true));
	   	       		
	   	       		  }
	   	       		
	   	       		
	   	       		 
	   	       		  
	   	       		}
		            }
	        }
		}
		private void spawnPotionParticles(int particleCount)
	    {
	      

	        if (particleCount > 0)
	        {
	            double d0 = 0;
	            double d1 = 3;
	            double d2 = 0;

	            for (int j = 0; j < particleCount; ++j)
	            {
	                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, d0, d1, d2, new int[0]);
	            }
	        }
	    }
		protected void onHit(RayTraceResult raytraceResultIn) {
			
			super.onHit(raytraceResultIn);
			if (raytraceResultIn.entityHit != null) {
			((EntityLivingBase)raytraceResultIn.entityHit).addPotionEffect(new PotionEffect(MobEffects.POISON, 300, 1, true, true));
			}
		}
}
