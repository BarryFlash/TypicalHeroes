package barryflash.superheroes.capabilities;

import java.util.Random;
import java.util.UUID;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemHulkArmor;
import barryflash.superheroes.items.armor.ItemShazamArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.network.MessageCapToClient;
import barryflash.superheroes.network.MessageCapToServer;
import barryflash.superheroes.network.MessageRaytraceDamage;
import barryflash.superheroes.network.MessageRemoveSpeedAttribute;
import barryflash.superheroes.network.MessageSpeedAttribute;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ShazamEventHandler {
	
	public static final String uuid4 = "5b666062-2fde-4509-bbb5-904fcb309de8";
	
	public static final AttributeModifier speedAttributeModifier = new AttributeModifier(UUID.fromString(uuid4), "th:shazam_speed", 0.05, 0).setSaved(true);
	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
	
	 EntityPlayer player = event.getEntityPlayer();
	 if (ItemShazamArmor.isWearingShazam(player)) {
	 IShazam shazamcap = player.getCapability(ShazamProvider.SHAZAM_CAP, null);

	 IShazam oldshazamcap = event.getOriginal().getCapability(ShazamProvider.SHAZAM_CAP, null);
	 
	 
	 shazamcap.setShazam(oldshazamcap.isShazam());
	 }
	
	}
	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		if (ItemShazamArmor.isWearingShazam(event.player)) {
		IShazam shazamcap = event.player.getCapability(ShazamProvider.SHAZAM_CAP, null);

	 if (shazamcap != null && event.player != null) { 
		 if (shazamcap.isShazam()) {
				NetworkHandler.sendTo(new MessageCapToClient(shazamcap.isShazam(), "shazam", event.player.getEntityId()), (EntityPlayerMP) event.player);
		 }
		}
		}
	}
	@SubscribeEvent
	public void onPlayerJoin(PlayerLoggedInEvent event) {
		if (ItemShazamArmor.isWearingShazam(event.player)) {
		IShazam shazamcap = event.player.getCapability(ShazamProvider.SHAZAM_CAP, null);
		if (shazamcap != null && event.player != null) { 
			if (shazamcap.isShazam()) {
				NetworkHandler.sendTo(new MessageCapToClient(shazamcap.isShazam(), "shazam", event.player.getEntityId()), (EntityPlayerMP) event.player);
			}
		}
		}
	}
	
	@SubscribeEvent
	public void onFly(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.getEntity();
		IShazam shazamcap = player.getCapability(ShazamProvider.SHAZAM_CAP, null);
	
		if (ItemShazamArmor.isWearingShazam(player)) {
			
			
			if (shazamcap.isShazam() && shazamcap.isFlying() && shazamcap.getFlyTicks() != 0) {
				player.eyeHeight = player.getDefaultEyeHeight() - 1.5F;
			} else {
				player.eyeHeight = player.getDefaultEyeHeight();
			}
		
		if (shazamcap.isShazam() && shazamcap.isFlying()) {
			
			
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

		     }
		        if ((player.motionY < 0.0D) && (player.isSneaking()))
		        {
		          player.motionY /= 1.10D;
		   
		        }
		}
        if (player.moveForward >= 0.001F && !player.onGround) {
        	
        	
			
          if ((player.motionX <= 4.0D) || (player.motionZ <= 4.0D))
          {
        	  if (shazamcap.getFlyTicks() < 10) {
        	  shazamcap.incrementFlyTicks();
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
        	
        	if (shazamcap.getFlyTicks() > 0) {
      			shazamcap.decrementFlyTicks();	
        	}
  		} 
        } else {
        	if (shazamcap.getFlyTicks() > 0) {
        		shazamcap.decrementFlyTicks();		
        	}
      			
        }
		
		} else {
			shazamcap.setFlyTicks(0);
			shazamcap.setFlight(false);
		}
		} else {
			if (shazamcap.isShootingLightningBeam()) {
				shazamcap.stopShootingLightningBeam();
			}
			if (shazamcap.isShazam()) {
				shazamcap.setShazam(false);
				if (player.world.isRemote) {
				NetworkHandler.sendToServer(new MessageRemoveSpeedAttribute("shazam"));
				}
			}
		}
		}
	}
	
	


	@SubscribeEvent
	public void livingUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (ItemShazamArmor.isWearingShazam(player)) {
			
				IShazam shazamcap = player.getCapability(ShazamProvider.SHAZAM_CAP, null);
		
				if (shazamcap.isShootingLightningBeam()) {
					shazamcap.incrementSoundTicks();
					if (shazamcap.getSoundTicks() > 4) {
						shazamcap.setSoundTicks(0);
					
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
						NetworkHandler.sendToServer(new MessageRaytraceDamage(result.entityHit.getEntityId(), 20, "shock"));
						}
						}
					}
					
				} 
			}
		}
	}
	@SubscribeEvent
	public void onHurt(LivingHurtEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IShazam shazamcap = player.getCapability(ShazamProvider.SHAZAM_CAP, null);
			if (shazamcap.isLightning()) {
				event.setAmount(0);
			}
		}
		if (event.getSource().getTrueSource() instanceof EntityLightningBolt) {
			if (event.getEntity() instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.getEntity();
				IShazam shazamcap = player.getCapability(ShazamProvider.SHAZAM_CAP, null);
				if (shazamcap.isShazam()) {
					event.setAmount(0);
				}
			}
		}
		if (event.getSource().getTrueSource() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
			IShazam shazamcap = player.getCapability(ShazamProvider.SHAZAM_CAP, null);
			if (ItemShazamArmor.isWearingShazam(player) && shazamcap.isShazam()) {
			
				float yaw = player.rotationYaw;
				float pitch = player.rotationPitch;
				float f = 5;
				double motionX = (double)(-MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
				double motionZ = (double)(MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
				double motionY = (double)(-MathHelper.sin((pitch) / 180.0F * (float)Math.PI) * f);
				event.getEntity().motionX = motionX;
				event.getEntity().motionY = motionY *2;
				event.getEntity().motionZ = motionZ;

			}
			}
		
	}
	@SubscribeEvent
	public void onFall(LivingFallEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IShazam shazamcap = player.getCapability(ShazamProvider.SHAZAM_CAP, null);
			if (ItemShazamArmor.isWearingShazam(player) && shazamcap.isShazam()) {
				
				event.setCanceled(true);
			} else {
				event.setCanceled(false);
			}
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void renderPlayer(RenderWorldLastEvent event) {
		for (int i = 0; i < Minecraft.getMinecraft().world.playerEntities.size(); i++) {
			EntityPlayer player = Minecraft.getMinecraft().world.playerEntities.get(i);
			IShazam shazamcap = player.getCapability(ShazamProvider.SHAZAM_CAP, null);
			if (ItemShazamArmor.isWearingShazam(player) && shazamcap.isShazam()) {
				if (shazamcap.isShootingLightningBeam()) {
					if (!shazamcap.isLightning()) {
						shazamcap.setLightning();
						NetworkHandler.sendToServer(new MessageCapToServer(shazamcap.isLightning(), "shazamLightning"));
					}
				
					float distance = 35;
					float distance2 = 0.5F;
					Vec3d vec3 = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);
					
					double x = player.posX + (distance *vec3.x);
					double y = player.posY + player.height/2 + 0.5  + (distance *vec3.y);
					double z = player.posZ + (distance *vec3.z);
					double x2 = player.posX + (distance2 *vec3.x);
					double y2 = player.posY + player.height/2 + 0.5 + (distance2 *vec3.y);
					double z2 = player.posZ + (distance2 *vec3.z);
					
					Vec3d fina = new Vec3d(0,0,-0.4F).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
					
					//if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
					//fina = new Vec3d(0,0F,-0.7F).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
					//} else {
						
					//}
				
					Vec3d vector = new Vec3d(x, y, z);
				
					 Vec3d middleAdd = fina.add(vector);
					  Vec3d middle = new Vec3d(middleAdd.x/2, middleAdd.y/2, middleAdd.z/2);
					  Vec3d fqAdd = fina.add(middle);
					  Vec3d firstQuarter = new Vec3d(fqAdd.x/2, fqAdd.y/2, fqAdd.z/2);
					  Vec3d lqAdd = middle.add(vector);
					  Vec3d lastQuarter = new Vec3d(lqAdd.x/2, lqAdd.y/2, lqAdd.z/2);
					Random r = player.world.rand;
					//for (int j = 0; j < 3; j++) {
					
					float width = (float) (fina.distanceTo(vector)/15);
					if (fina.distanceTo(vector) > 10) {
						width = 1F;
					}
					
					float randS = r.nextFloat()*width;
					float randH = r.nextFloat()*width;
					float randS1 = r.nextFloat()*width;
					float randH1 = r.nextFloat()*width;
					float randS2 = r.nextFloat()*width;
					float randH2 = r.nextFloat()*width;
					float randS3 = r.nextFloat()*width;
					float randH3 = r.nextFloat()*width;
					double fqX = firstQuarter.x + randS - width/2;
					double fqY = firstQuarter.y + randH;
					double fqZ = firstQuarter.z + randS - width/2;
					double mX = middle.x + randS1 - width/2;
					double mY = middle.y + randH1;
					double mZ = middle.z + randS1 - width/2;
					double lqX = lastQuarter.x + randS2 - width/2;
					double lqY = lastQuarter.y + randH2;
					double lqZ = lastQuarter.z + randS2 - width/2;
					Vec3d randFQ = new Vec3d(fqX, fqY, fqZ);
					Vec3d randM = new Vec3d(mX, mY, mZ);
					Vec3d randLQ = new Vec3d(lqX, lqY, lqZ);
					Vec3d randE = new Vec3d(fqX, fqY, fqZ);
					
					Utils.renderLaser2(fina, randFQ, 0.6F, 0.08F, new float[] { 0.9F, 0.7F, 0.1F});
					Utils.renderLaser2(randFQ, randM, 0.6F, 0.08F, new float[] { 0.9F, 0.7F, 0.1F});
					Utils.renderLaser2(randM, randLQ, 0.6F, 0.08F, new float[] { 0.9F, 0.7F, 0.1F});
					Utils.renderLaser2(randLQ, vector, 0.6F, 0.08F, new float[] { 0.9F, 0.7F, 0.1F});
					
					Vec3d Rfina = new Vec3d(0,0,0.4F).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
					//if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
					//Rfina = new Vec3d(0,0F,0.7F).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
					//} else {
						
					//}
				
			
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
				
					Utils.renderLaser2(Rfina, RrandFQ, 0.6F, 0.08F, new float[] { 0.9F, 0.7F, 0.1F});
					Utils.renderLaser2(RrandFQ, RrandM, 0.6F, 0.08F, new float[] { 0.9F, 0.7F, 0.1F});
					Utils.renderLaser2(RrandM, RrandLQ, 0.6F, 0.08F, new float[] { 0.9F, 0.7F, 0.1F});
					Utils.renderLaser2(RrandLQ, vector, 0.6F, 0.08F, new float[] { 0.9F, 0.7F, 0.1F});
					
				
				}
			if (shazamcap.isLightning()) {
				if (shazamcap.getTransitionTicks() < 120) {
					shazamcap.incrementTransitionTicks();
				} else {
					shazamcap.setTransitionTicks(0);
					shazamcap.unsetLightning();
					NetworkHandler.sendToServer(new MessageCapToServer(shazamcap.isLightning(), "shazamLightning"));
					shazamcap.setLightningTicks(0);
				}
				if (shazamcap.getLightningTicks() < 5) {
					shazamcap.incrementLightningTicks();
				}else {
					shazamcap.setLightningTicks(0);
				}
				float side;
				 float up;
				 float eside;
				 float eup;
				 float eside2;
				 float eup2;
				

				 float addZ;
				 float addX;
				 double startX = 0;
				 double startY = 0;
				 double startZ = 0;
				
				 double endX = 0;
				 double endY = 0;
				 double endZ = 0;
				 double endX2 = 0;
				 double endY2 = 0;
				 double endZ2 = 0;
				 float vert;
				 float hor;
				if (shazamcap.getLightningTicks() == 0) {

				Random r = player.world.rand;
				 side = r.nextFloat()*player.width*1.2F;
				 up = r.nextFloat() * player.height-0.2F;
				 eside = r.nextFloat()*player.width*1.2F;
				 eup = r.nextFloat() * player.height-0.2F;
				 eside2 = r.nextFloat()*player.width*1.2F;
				 eup2 = r.nextFloat() * player.height-0.2F;
				

				 addZ = r.nextFloat()/4;
				 addX = r.nextFloat()/4;
				 startX = player.posX - 0.2F + side - player.width/2;
				 startY = player.posY + up;
				 startZ = (player.posZ - 0.2F + side - player.width/2) + addZ;
				
				 endX = (player.posX + eside - player.width/2) - addX;
				 endY = player.posY + eup;
				 endZ = player.posZ + eside - player.width/2;
				 endX2 = (player.posX + eside2 - player.width/2);
				 endY2 = player.posY + eup2;
				 endZ2 = player.posZ + eside2 - player.width/2;
				 vert = r.nextFloat();
				 hor = r.nextFloat();
					}
					
			for (int j = 0; j < 4; j++) {
				GlStateManager.pushMatrix();
				GlStateManager.rotate(180.0F - Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
				Utils.renderLaser2(new Vec3d(startX, startY, startZ), new Vec3d(endX, endY, endZ), 0.6F, 0.04F, new float[] { 0.9F, 0.7F, 0.1F});
				Utils.renderLaser2(new Vec3d(endX, endY, endZ), new Vec3d(endX2, endY2, endZ2), 0.6F, 0.04F, new float[] { 0.9F, 0.7F, 0.1F});
				GlStateManager.popMatrix();
					
			}
				
			}
		} else {
			if (shazamcap.getTransitionTicks() > 0) {
				shazamcap.setTransitionTicks(0);
				shazamcap.unsetLightning();
				NetworkHandler.sendToServer(new MessageCapToServer(shazamcap.isLightning(), "shazamLightning"));
				shazamcap.setLightningTicks(0);
			}
		}
		}
	}
}
