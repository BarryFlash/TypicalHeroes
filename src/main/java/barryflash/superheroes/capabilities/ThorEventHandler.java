package barryflash.superheroes.capabilities;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemCyborgArmor;
import barryflash.superheroes.items.armor.ItemShazamArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.network.MessageRaytraceDamage;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ThorEventHandler {
	
	@SubscribeEvent
	public void onFly(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.getEntity();
	
		IThor thorcap = player.getCapability(ThorProvider.THOR_CAP, null);
		if (ItemThorArmor.isWearingFullSet(player)) {
			
		
	
			if (thorcap.isFlying() && thorcap.getFlyTicks() != 0) {
				player.eyeHeight = player.getDefaultEyeHeight() - 1.5F;
			} else {
				player.eyeHeight = player.getDefaultEyeHeight();
			}
		
		if (thorcap.isFlying()) {
	
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
        	  if (thorcap.getFlyTicks() < 10) {
        		  thorcap.incrementFlyTicks();
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
        	
        	if (thorcap.getFlyTicks() > 0) {
        		thorcap.decrementFlyTicks();
        	}
  		} 
        } else {
        	if (thorcap.getFlyTicks() > 0) {
        		thorcap.decrementFlyTicks();		
        	}
      			
        }
		}
		
	
		}
		}
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onRenderThor(RenderWorldLastEvent event) {
		for (int i = 0; i < Minecraft.getMinecraft().world.playerEntities.size(); i++) {
			EntityPlayer player = Minecraft.getMinecraft().world.playerEntities.get(i);
		if (ItemThorArmor.isWearingFullSet(player)) {
			IThor thorcap = player.getCapability(ThorProvider.THOR_CAP, null);
			if (thorcap.isShootingLightning()) {
				
				float distance = 35;
				float distance2 = 0.5F;
				Vec3d vec3 = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);
				
				double x = player.posX + (distance *vec3.x);
				double y = player.posY + player.height/2 + 0.5  + (distance *vec3.y);
				double z = player.posZ + (distance *vec3.z);
				double x2 = player.posX + (distance2 *vec3.x);
				double y2 = player.posY + player.height/2 + 0.5 + (distance2 *vec3.y);
				double z2 = player.posZ + (distance2 *vec3.z);
				
			
				
				Vec3d vector = new Vec3d(x, y, z);
				
				Vec3d Rfina;
				if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
				Rfina = new Vec3d(0,0F,0.7F).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
				} else {
					Rfina = new Vec3d(0,0,0.2F).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
				}
				Random r = player.world.rand;
				//for (int j = 0; j < 3; j++) {
				float width = (float) (Rfina.distanceTo(vector)/15);
				if (Rfina.distanceTo(vector) > 10) {
					width = 1F;
				}
				
				
				
			
		
				 Vec3d RmiddleAdd = Rfina.add(vector);
				  Vec3d Rmiddle = new Vec3d(RmiddleAdd.x/2, RmiddleAdd.y/2, RmiddleAdd.z/2);
				  Vec3d RfqAdd = Rfina.add(Rmiddle);
				  Vec3d RfirstQuarter = new Vec3d(RfqAdd.x/2, RfqAdd.y/2, RfqAdd.z/2);
				  Vec3d RlqAdd = Rmiddle.add(vector);
				  Vec3d RlastQuarter = new Vec3d(RlqAdd.x/2, RlqAdd.y/2, RlqAdd.z/2);
		
				//for (int j = 0; j < 3; j++) {
	
				float RrandS = r.nextFloat()*width;
				float RrandH = r.nextFloat()*width;
				float RrandS1 = r.nextFloat()*width;
				float RrandH1 = r.nextFloat()*width;
				float RrandS2 = r.nextFloat()*width;
				float RrandH2 = r.nextFloat()*width;
				float RrandS3 = r.nextFloat()*width;
				float RrandH3 = r.nextFloat()*width;
				double RfqX = RfirstQuarter.x + RrandS - width/2;
				double RfqY = RfirstQuarter.y + RrandH;
				double RfqZ = RfirstQuarter.z + RrandS - width/2;
				double RmX = Rmiddle.x + RrandS1 - width/2;
				double RmY = Rmiddle.y + RrandH1;
				double RmZ = Rmiddle.z + RrandS1 - width/2;
				double RlqX = RlastQuarter.x + RrandS2 - width/2;
				double RlqY = RlastQuarter.y + RrandH2;
				double RlqZ = RlastQuarter.z + RrandS2 - width/2;
				Vec3d RrandFQ = new Vec3d(RfqX, RfqY, RfqZ);
				Vec3d RrandM = new Vec3d(RmX, RmY, RmZ);
				Vec3d RrandLQ = new Vec3d(RlqX, RlqY, RlqZ);
				Vec3d RrandE = new Vec3d(RfqX, RfqY, RfqZ);
				
				Utils.renderLaser2(Rfina, RrandFQ, 0.6F, 0.08F, new float[] { 0.4F, 0.7F, 0.9F});
				Utils.renderLaser2(RrandFQ, RrandM, 0.6F, 0.08F, new float[] { 0.4F, 0.7F, 0.9F});
				Utils.renderLaser2(RrandM, RrandLQ, 0.6F, 0.08F, new float[] { 0.4F, 0.7F, 0.9F});
				Utils.renderLaser2(RrandLQ, vector, 0.6F, 0.08F, new float[] { 0.4F, 0.7F, 0.9F});
				
			}
		}
		}
	}
	@SubscribeEvent
	public void livingUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (ItemThorArmor.isWearingFullSet(player)) {
				IThor thorcap = player.getCapability(ThorProvider.THOR_CAP, null);
				if (thorcap.isShootingLightning()) {
					thorcap.incrementSoundTicks();
					if (thorcap.getSoundTicks() > 4) {
						thorcap.setSoundTicks(0);
					
						player.world.playSound(player, player.getPosition(), THSoundHandler.LIGHTNING, SoundCategory.PLAYERS, 0.4F, 1.0F);
					}
					RayTraceResult result = Utils.getMouseOverExtended(35);
					if (result != null) {
						if (result.typeOfHit == result.typeOfHit.BLOCK) {
							if (player.world.isRemote) {
								player.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, result.hitVec.x, result.hitVec.y, result.hitVec.z, 0, 0, 0);
							}
						} else if (result.typeOfHit == result.typeOfHit.ENTITY) {
						if (result.entityHit != null && result.entityHit != player) {
							Utils.knockbackEntity(player, result.entityHit, 5F);
							result.entityHit.motionY += 0.8F;
						NetworkHandler.sendToServer(new MessageRaytraceDamage(result.entityHit.getEntityId(), 15, "shock"));
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
		
			if (ItemThorArmor.isWearingFullSet(player)) {
				
				event.setCanceled(true);
			} else {
				event.setCanceled(false);
			}
		}
		
	}
	
}
