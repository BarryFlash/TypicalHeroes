package barryflash.superheroes.entities.projectiles;

import java.util.ArrayList;
import java.util.List;

import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.ISpecialEffects;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.SpecialEffectsProvider;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.network.MessageCapToClient;
import barryflash.superheroes.network.MessageShootingPlayerToClient;
import barryflash.superheroes.network.NetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityTrickArrowElectric extends EntityTrickArrow {
	public static boolean lightning;
	public ArrayList<Entity> entityList = new ArrayList<Entity>();
	public static int tick = 0;
	public EntityTrickArrowElectric(World worldIn)
    {
        super(worldIn);
      
    }

    public EntityTrickArrowElectric(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityTrickArrowElectric(World worldIn, EntityLivingBase shooter)
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
		
        	
        	 if (this.inGround)
	            {
        		 if (this.timeInGround > 20) {
        		 if (!entityList.isEmpty()) {
       				  entityList.clear();
       			  }
	        		double k1 = this.getPosition().getX() + 5.5;
	     		    double l1 = this.getPosition().getX() - 5.5;
	     		    double i2 = this.getPosition().getY() + 5.5;
	     		    double i1 = this.getPosition().getY() - 5.5;
	     		    double j2 = this.getPosition().getZ() + 5.5;
	     		    double j1 = this.getPosition().getZ() - 5.5;
	 	       		
	 	       		  List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, new AxisAlignedBB(k1, i2, j2, l1, i1, j1));
	 	       		  for (int k2 = 0; k2 < list.size(); ++k2)
	 	       		  {
	 	       		  Entity entity = (Entity)list.get(k2);
	 	       		  if (entity instanceof EntityLivingBase) {
	 	       			  
	 	       			 if (!entityList.contains(entity) && entity != this.shootingEntity) {
	 	       				 entityList.add(entity);
	 	       			 }
	 	       		}
	 	       		  
 	       		  }
        		 
        		 if (!this.entityList.isEmpty()) {
        			 if (this.timeInGround % 5 == 0) {
        			 for (int i = 0; i < this.entityList.size(); i++) {
        				 Entity entity = this.entityList.get(i);
        				 this.entityList.get(i).attackEntityFrom(DamageSource.LIGHTNING_BOLT, 1F);
        				 if (entity instanceof EntityPlayer) {
        		       			if (ItemIronmanMark50Armor.isWearingFullSet((EntityPlayer) entity, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
        		       				IIronman ironmancap = entity.getCapability(IronmanProvider.IRONMAN_CAP, null);
        		       				if (!ironmancap.isIronmanDisabled()) {
        		       				ironmancap.setIronmanDisabled(true);
        		       				}
        		       				world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, entity.posX, entity.posY + entity.height/2, entity.posZ, 0, 0.01, 0);
        		       			}
        		       		}
        			 }
        			 }
        		 }
        		 }
        		 tick = this.timeInGround;
        		 lightning = true;
        		if (this.timeInGround > 120) {
        			if (!this.entityList.isEmpty()) {
        			this.entityList.clear();
        			}
        			if (!world.isRemote) {
        			this.setDead();
        			}
        		}
        		  
	            } else {
	            	lightning = false;
	            }
        
	}
	
	protected void onHit(RayTraceResult raytraceResultIn) {
		// TODO Auto-generated method stub
		super.onHit(raytraceResultIn);
		if (!world.isRemote) {
		NetworkHandler.sendTo(new MessageShootingPlayerToClient(this.getEntityId(), this.shootingEntity.getEntityId()), (EntityPlayerMP) this.shootingEntity);
		}
		if (raytraceResultIn != null) {
		if (raytraceResultIn.entityHit != null) {
			ISpecialEffects supercap = raytraceResultIn.entityHit.getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
			if (supercap != null) {
			supercap.setShock(true);
			if (!world.isRemote) {
			NetworkHandler.sendTo(new MessageCapToClient(supercap.isShocked(), "shock", raytraceResultIn.entityHit.getEntityId()), (EntityPlayerMP) this.shootingEntity);
			}
			}
			if (raytraceResultIn.entityHit instanceof EntityPlayer) {
       			if (ItemIronmanMark50Armor.isWearingFullSet((EntityPlayer) raytraceResultIn.entityHit, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
       				IIronman ironmancap = raytraceResultIn.entityHit.getCapability(IronmanProvider.IRONMAN_CAP, null);
       				if (!ironmancap.isIronmanDisabled()) {
       				ironmancap.setIronmanDisabled(true);
       				}
       			}
       		}
		} else if (raytraceResultIn.typeOfHit != null && raytraceResultIn.typeOfHit == raytraceResultIn.typeOfHit.BLOCK) {

       		
       		}
		}
			
			
	}
}
