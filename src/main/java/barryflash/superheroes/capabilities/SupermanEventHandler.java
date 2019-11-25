package barryflash.superheroes.capabilities;

import java.util.List;
import java.util.UUID;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.network.MessageCapToServer;
import barryflash.superheroes.network.MessageRaytraceDamage;
import barryflash.superheroes.network.MessageRemoveSpeedAttribute;
import barryflash.superheroes.network.MessageSpeedAttribute;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.network.Capabilities.MessageCapIntToServer;
import barryflash.superheroes.network.Capabilities.Superman.MessageSupermanFlightToTracking;
import barryflash.superheroes.network.Capabilities.Superman.MessageSupermanLaserHeatVisionToTracking;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SupermanEventHandler {
	
	public static DamageSource HeatVision = new DamageSource("HeatVision").setFireDamage();
	public static final String uuid4 = "574f0ad1-7c32-4b46-8f69-0af77ca18ed6";
	public static final AttributeModifier speedAttributeModifier = new AttributeModifier(UUID.fromString(uuid4), "th:superman_speed", 0.05D, 0).setSaved(true);

	@SubscribeEvent
	public void onFly(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.getEntity();
	
		ISuperman supercap = player.getCapability(SupermanProvider.SUPERMAN_CAP, null);
		if (ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots)) {
			
		
			if (!supercap.isAffectedByKryptonite()) {
			if (supercap.isFlying() && supercap.getFlyTicks() != 0) {
				player.eyeHeight = player.getDefaultEyeHeight() - 1.5F;
			} else {
				player.eyeHeight = player.getDefaultEyeHeight();
			}
		
		if (supercap.isFlying()) {
	
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
        	  if (supercap.getFlyTicks() < 10) {
        		  supercap.increaseFlyTicks();
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
        	
        	if (supercap.getFlyTicks() > 0) {
      			supercap.decreaseFlyTicks();		
        	}
  		} 
        } else {
        	if (supercap.getFlyTicks() > 0) {
      			supercap.decreaseFlyTicks();		
        	}
      			
        }
		
		}
		} else {
			if (supercap.getFlyTicks() > 0) {
				supercap.setFlyTicks(0);
			}
			player.motionX -= player.motionX/0.6;
			
			player.motionZ -= player.motionZ/0.6;
		}
		}
		}
	}
	

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void renderPlayer(RenderWorldLastEvent event) {
		for (int i = 0; i < Minecraft.getMinecraft().world.playerEntities.size(); i++) {
			EntityPlayer player = Minecraft.getMinecraft().world.playerEntities.get(i);
			ISuperman supercap = player.getCapability(SupermanProvider.SUPERMAN_CAP, null);
			if (supercap.isUsingHeatVision()) {
				float distance = 60;
				float distance2 = -0.2F;
				Vec3d vec3 = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);
				
				double x = player.posX + (distance *vec3.x);
				double y = player.posY + player.getEyeHeight() + (distance *vec3.y);
				double z = player.posZ + (distance *vec3.z);
				double x2 = player.posX + (distance2 *vec3.x);
				double y2 = player.posY + player.getEyeHeight() + (distance2 *vec3.y);
				double z2 = player.posZ + (distance2 *vec3.z);
				
			
			
				Vec3d fina = new Vec3d(0,0.1F,0.15F).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
				Vec3d fina2 = new Vec3d(0,0.1F,0.15F).rotateYaw(player.rotationYaw * -0.017453292F + (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
				Vec3d vector = new Vec3d(x, y, z);
				
				Utils.renderHeatVision(fina, vector, 1.0F, 0.03F, new float[] { 1.5F, 0.4F, 0.4F});
				Utils.renderHeatVision(fina2, vector, 1.0F, 0.03F, new float[] { 1.5F, 0.4F, 0.4F});
			}
		}
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onEntityRender(RenderLivingEvent.Pre<EntityLivingBase> event) {
		
		
		EntityPlayer player = Minecraft.getMinecraft().player;
		if (ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots)) {
			ISuperman supercap = player.getCapability(SupermanProvider.SUPERMAN_CAP, null);
			if (supercap.isUsingXRay()) {
			Entity entity = null;
		int k1 = player.getPosition().getX() + 20;
		 int l1 = player.getPosition().getX() - 20;
	     int i2 = player.getPosition().getY() + 20;
	     int i1 = player.getPosition().getY() - 20;
	     int j2 = player.getPosition().getZ() + 20;
	     int j1 = player.getPosition().getZ() - 20;
		
		  List<Entity> list = player.world.getEntitiesWithinAABBExcludingEntity(player, new AxisAlignedBB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
		  for (int k2 = 0; k2 < list.size(); ++k2)
		  {
			 
		  entity = (Entity)list.get(k2);
		
		  if (event.getEntity() == entity) {		  
			GlStateManager.pushMatrix();
			 GlStateManager.disableDepth();

             GlStateManager.depthMask( false );
	        GlStateManager.enableAlpha();
	        GlStateManager.enableBlend();
	        GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE);
	        GlStateManager.color(1, 1, 1, 0.8F);
		  }
		  } 
		  
			}
			    
		  }
		  
		}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onEntityRenderPost(RenderLivingEvent.Post<EntityLivingBase> event) {
		
	
		EntityPlayer player = Minecraft.getMinecraft().player;
		if (ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots)) {
			ISuperman supercap = player.getCapability(SupermanProvider.SUPERMAN_CAP, null);
			
			if (supercap.isUsingXRay()) {
		Entity entity = null;
		int k1 = player.getPosition().getX() + 20;
		 int l1 = player.getPosition().getX() - 20;
	     int i2 = player.getPosition().getY() + 20;
	     int i1 = player.getPosition().getY() - 20;
	     int j2 = player.getPosition().getZ() + 20;
	     int j1 = player.getPosition().getZ() - 20;
		
		  List<Entity> list = player.world.getEntitiesWithinAABBExcludingEntity(player, new AxisAlignedBB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
		  for (int k2 = 0; k2 < list.size(); ++k2)
		  {
			 
		  entity = (Entity)list.get(k2);
		  if (event.getEntity() == entity) {	
			  GlStateManager.enableDepth();
			
              GlStateManager.depthMask( true );
		  GlStateManager.disableBlend();
			GlStateManager.disableAlpha();
			 GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_CONSTANT_ALPHA);
			 GlStateManager.popMatrix();
		  }
		
		  }
			}
			
			
		  }
		}


	@SubscribeEvent
	public void onHeatVisionUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (player.world.isRemote) {
			if (ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots)) {
				ISuperman supercap = player.getCapability(SupermanProvider.SUPERMAN_CAP, null);
			if (supercap.isUsingHeatVision()) {
				supercap.increaseHeatVisionSoundTick();
				if (supercap.getHeatVisionSoundTick() > 2) {
					supercap.setHeatVisionSoundTick(0);
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
					NetworkHandler.sendToServer(new MessageRaytraceDamage(result.entityHit.getEntityId(), 20, "heatvision"));
					}
					}
				}
			}
			} 
			}
		}
	}

	@SubscribeEvent
	public void onHurt(LivingHurtEvent event) {
		if (event.getSource().getImmediateSource() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getSource().getImmediateSource();
			
			if (ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots)) {
				ISuperman supercap = player.getCapability(SupermanProvider.SUPERMAN_CAP, null);
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
		
			if (ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots)) {
				
				event.setCanceled(true);
			} else {
				event.setCanceled(false);
			}
		}
		
	}
 }
