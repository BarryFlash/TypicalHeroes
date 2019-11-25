package barryflash.superheroes.entities.projectiles;

import barryflash.superheroes.capabilities.ISpecialEffects;
import barryflash.superheroes.capabilities.SpecialEffectsProvider;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.network.MessageGrappleContactToClient;
import barryflash.superheroes.network.MessageShooterToClient;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.network.Capabilities.MessageCapIntToServer;
import barryflash.superheroes.network.Capabilities.Hawkeye.MessageHawkeyeGrappleEntitiesToTracking;
import barryflash.superheroes.network.Capabilities.Hawkeye.MessageHawkeyeRemoveGrappleEntitiesToTracking;
import barryflash.superheroes.util.Utils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityTrickArrowGrapple extends EntityTrickArrow {

	public EntityPlayer shooter;
	public boolean contact;
	
	public EntityTrickArrowGrapple(World worldIn)
    {
        super(worldIn);
      
    }

    public EntityTrickArrowGrapple(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityTrickArrowGrapple(World worldIn, EntityLivingBase shooter)
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
	
		if (this.ticksExisted == 5) {
		if (this.getEntityId() != 0) {
		if (!world.isRemote) {
			if (this.shooter == null) {
				if (this.shootingEntity != null) {
					NetworkHandler.sendTo(new MessageShooterToClient(this.getEntityId(), this.shootingEntity.getEntityId()), (EntityPlayerMP) this.shootingEntity);
					this.shooter = (EntityPlayer) this.shootingEntity;
				}
			}
		}
		}
		
		if (shooter != null) {
			ISpecialEffects specialcap = shooter.getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
			
			if (specialcap != null) {
		
				if (!specialcap.getGrappleEntityList().contains(this)) {
					specialcap.addGrappleEntityToList(this);
					if (world.isRemote) {
						NetworkHandler.sendToServer(new MessageCapIntToServer(this.getEntityId(), "hawkeyeGrappleListAdd"));
					}
				}
			}
		}
		}
		if (shooter != null && contact == true) {
			
			Vec3d pVec = shooter.getPositionVector();
			Vec3d aVec = this.getPositionVector();
			double dis = pVec.distanceTo(aVec);
			double disX = new Vec3d(pVec.x, 0, 0).distanceTo(new Vec3d(aVec.x, 0, 0));
			double disY = new Vec3d(0, pVec.y, 0).distanceTo(new Vec3d(0, aVec.y, 0));
			double disZ = new Vec3d(0, 0, pVec.z).distanceTo(new Vec3d(0, 0, aVec.z));
			
			if (dis > 20) {
			
				double distX = this.posX - shooter.posX;
                double distZ = this.posZ - shooter.posZ;
                double distY = shooter.posY+1.5D - this.posY;
                double dir = MathHelper.atan2(distZ, distX);
                double speed = 1F / shooter.getDistance(this) * 34;
               if (disY > 10) {
                if (distY<0)
                {
                	
                	shooter.motionY += 1F / shooter.getDistance(this) * 8;
                }
               }
              
               if (disX > 10) {
                shooter.motionX = MathHelper.cos((float) dir) * speed;
               }
               if (disZ > 10) {
                shooter.motionZ = MathHelper.sin((float) dir) * speed;
               }
                
			} else {
				
				
				
				double distX = this.posX - shooter.posX;
                double distZ = this.posZ - shooter.posZ;
                double distY = shooter.posY+1.5D - this.posY;
                double dir = MathHelper.atan2(distZ, distX);
                double speed = 1F / shooter.getDistance(this) * 10;
                if (disY > 5) {
                if (distY<0)
                {
                	
                	shooter.motionY += 1F / shooter.getDistance(this) * (disY/3);
                }
                } 
                
              
                if (disX > 5) {
                shooter.motionX = MathHelper.cos((float) dir) * speed;
                } else if (distX > 2){
                	
                	shooter.motionX = MathHelper.cos((float) dir) * 1F / shooter.getDistance(this) * 1F;
                
                } else if (distX > 1){
                	
                	shooter.motionX = MathHelper.cos((float) dir) * 1F / shooter.getDistance(this) * 0.1F;
                }
                if (disZ > 5) {
                shooter.motionZ = MathHelper.sin((float) dir) * speed;
                } else if (distZ > 2){
                	
                	shooter.motionX = MathHelper.cos((float) dir) * 1F / shooter.getDistance(this) * 1F;
                
                } else if (distZ > 1){
                	shooter.motionZ = MathHelper.sin((float) dir) * 1F / shooter.getDistance(this) * 0.1F;
                }

			} 
		}
		
	}
	
	@Override
	public void onRemovedFromWorld() {
		if (shooter != null) {
			ISpecialEffects specialcap = shooter.getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
			
			if (specialcap != null) {

				specialcap.removeGrappleEntityToList(this);
				if (this.world.isRemote) {
					NetworkHandler.sendToServer(new MessageCapIntToServer(this.getEntityId(), "hawkeyeGrappleListRemove"));
				}
				
			}
		}
		super.onRemovedFromWorld();
	}

	protected void onHit(RayTraceResult raytrace) {
		// TODO Auto-generated method stub
		super.onHit(raytrace);
		if (raytrace.typeOfHit == raytrace.typeOfHit.BLOCK) {
			
			if (!world.isRemote) {
				if (this.shootingEntity != null) {
					contact = true;
					NetworkHandler.sendTo(new MessageGrappleContactToClient(this.getEntityId(), contact), (EntityPlayerMP) this.shootingEntity);
					
					
				}
			}
		}
	}
}
