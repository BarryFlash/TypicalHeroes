package barryflash.superheroes.capabilities;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityScepterBlast;
import barryflash.superheroes.entities.projectiles.EntitySonarCannonBlast;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemCyborgArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.network.MessageRaytraceDamage;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CyborgEventHandler {

	
	@SubscribeEvent
	public void onFly(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.getEntity();
	
		ICyborg cyborgcap = player.getCapability(CyborgProvider.CYBORG_CAP, null);
		if (ItemCyborgArmor.isWearingFullSet(player)) {
			
			if (cyborgcap.isFlying() && cyborgcap.getFlyTick() != 0) {
				player.eyeHeight = player.getDefaultEyeHeight() - 1.5F;
			} else {
				player.eyeHeight = player.getDefaultEyeHeight();
			}
		
		if (cyborgcap.isFlying()) {
	
		if (Keyboard.isCreated() && Keyboard.isKeyDown(57) && !player.onGround) {
			
		if (player.motionY > 0.01D) {
            player.motionY += 0.08499999910593033D;
          } else {
            player.motionY += 0.4269999991059303D;
          }
       
		} else if (!player.onGround){
			if (!player.isSneaking()) {
				if (player.motionY != 0) {
					player.motionY = 0;
				}
		        	/*if (up == false) {
 		        	if (player.motionY > -0.26) {
		        		player.motionY -= 0.02;
		        	} else {
		        		up = true;
		        		
		        	}
		        	} else {
		        		if (player.motionY < 0.2) {
		        	
		        			player.motionY += 0.1;
		        		} else {
		        			up = false;
		        			
		        		}
		        		
		        	} */
		     }
		        if ((player.motionY < 0.0D) && (player.isSneaking()))
		        {
		          player.motionY /= 1.10D;
		   
		        }
		}
        if (player.moveForward >= 0.001F && !player.onGround) {
        	
        	
			
          if ((player.motionX <= 4.0D) || (player.motionZ <= 4.0D))
          {
        	  if (cyborgcap.getFlyTick() < 10) {
        		  cyborgcap.incrementFlyTick();
        	  }
  			
  			
         	 Vec3d vec = player.getLookVec();

					player.motionX = vec.x / 2;

					player.motionY = vec.y / 2;

					player.motionZ = vec.z / 2;
         	 
         	if (player.isSprinting()) {
            player.motionX *= 9.6D;
            player.motionY *= 4.6D;
            player.motionZ *= 9.6D;
         	} else {
         		player.motionX *= 4.8D;
         		 player.motionY *= 2.8D;
                player.motionZ *= 4.8D;
         	}
          }else {
        	
        	if (cyborgcap.getFlyTick() > 0) {
        		cyborgcap.decrementFlyTick();	
        	}
  		} 
        } else {
        	if (cyborgcap.getFlyTick() > 0) {
        		cyborgcap.decrementFlyTick();	
        	}
      			
        }
		
		}
		
		}
		}
	}
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (ItemCyborgArmor.isWearingFullSet(player)) {
				ICyborg cyborgcap = player.getCapability(CyborgProvider.CYBORG_CAP, null);
				if (cyborgcap.isSonarCannon()) {
					if (cyborgcap.getSonarTick() < 5) {
						cyborgcap.incrementSonarTick();
					} else {
						cyborgcap.setSonarTick(0);
						EntitySonarCannonBlast projectile = new EntitySonarCannonBlast(player.world, player);
					    if (!player.world.isRemote) {
							projectile.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0, 0.0F);
							player.world.spawnEntity(projectile);
					    }
					}
				} else {
					if (cyborgcap.getSonarTick() != 0) {
						if (cyborgcap.getSonarTick() < 20) {
							cyborgcap.incrementSonarTick();
						} else {
							cyborgcap.setSonarTick(0);
						}
					}
				}
			}
		}
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void renderPlayer(RenderWorldLastEvent event) {
		for (int i = 0; i < Minecraft.getMinecraft().world.playerEntities.size(); i++) {
			EntityPlayer player = Minecraft.getMinecraft().world.playerEntities.get(i);
				ICyborg cyborgcap = player.getCapability(CyborgProvider.CYBORG_CAP, null);
				if (cyborgcap.isLaser()) {
				float distance = 60;
				float distance2 = -0.2F;
				Vec3d vec3 = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);
				
				double x = player.posX + (distance *vec3.x);
				double y = player.posY + player.getEyeHeight() + (distance *vec3.y);
				double z = player.posZ + (distance *vec3.z);
				double x2 = player.posX + (distance2 *vec3.x);
				double y2 = player.posY + player.getEyeHeight() + (distance2 *vec3.y);
				double z2 = player.posZ + (distance2 *vec3.z);
				
			

				Vec3d fina2 = new Vec3d(0,0.1F,0.15F).rotateYaw(player.rotationYaw * -0.017453292F + (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
				Vec3d vector = new Vec3d(x, y, z);
				
				//Utils.renderHeatVision(fina, vector, 1.0F, 0.03F, new float[] { 1.5F, 0.4F, 0.4F});
				Utils.renderHeatVision(fina2, vector, 1.0F, 0.03F, new float[] { 1.5F, 0.4F, 0.4F});
			}
		}
	}

	@SubscribeEvent
	public void onHeatVisionUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (player.world.isRemote) {
				if (ItemCyborgArmor.isWearingFullSet(player)) {
					ICyborg cyborgcap = player.getCapability(CyborgProvider.CYBORG_CAP, null);
					if (cyborgcap.isLaser()) {
				cyborgcap.incrementLaserTick();
				if (cyborgcap.getLaserTick() > 2) {
					cyborgcap.setLaserTick(0);
					player.world.playSound(player, player.getPosition(), THSoundHandler.HEATVISION, SoundCategory.PLAYERS, 0.4F, 1.0F);
				}
				
				RayTraceResult result = Utils.getMouseOverExtended(50);
				if (result != null) {
					if (result.typeOfHit == result.typeOfHit.BLOCK) {
						if (player.world.isRemote) {
							player.world.spawnParticle(EnumParticleTypes.FLAME, result.hitVec.x, result.hitVec.y, result.hitVec.z, 0, 0, 0);
						}
					} else if (result.typeOfHit == result.typeOfHit.ENTITY) {
					if (result.entityHit != null && result.entityHit != player) {
					NetworkHandler.sendToServer(new MessageRaytraceDamage(result.entityHit.getEntityId(), 12, "heatvision"));
					}
					}
				}
			}
			} 
			}
		}
	}
	@SubscribeEvent
	public void onFall(LivingFallEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
		
			if (ItemCyborgArmor.isWearingFullSet(player)) {
				
				event.setCanceled(true);
			} else {
				event.setCanceled(false);
			}
		}
		
	}
}
