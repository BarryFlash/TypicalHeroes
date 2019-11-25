package barryflash.superheroes.capabilities;

import java.util.UUID;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemHulkArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.network.MessageCapToClient;
import barryflash.superheroes.network.MessageCapToServer;
import barryflash.superheroes.network.MessageExplosion;
import barryflash.superheroes.network.MessageRemoveSpeedAttribute;
import barryflash.superheroes.network.MessageSetBoundingBox;
import barryflash.superheroes.network.MessageShrink;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.network.Capabilities.MessageCapFloatToServer;
import barryflash.superheroes.util.Utils;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class HulkEventHandler {


	@SubscribeEvent
	public void onHulkUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (ItemHulkArmor.isWearingHulk(player)) {
				IHulk hulkcap = player.getCapability(HulkProvider.HULK_CAP, null);
				
				if (hulkcap.isTransforming()) {
					if (hulkcap.getTransformTick() < 30) {
						hulkcap.increaseTransformTick();
						hulkcap.addAlpha(0.5F/30.0F);
						hulkcap.addSize(0.2F/30.0F);
						NetworkHandler.sendToServer(new MessageCapFloatToServer(hulkcap.getAlpha(), "hulkAlpha"));
						NetworkHandler.sendToServer(new MessageCapFloatToServer(hulkcap.getSize(), "hulkSize"));
						player.eyeHeight = player.getEyeHeight() + 0.8F/30.0F;
		
					} else {
						hulkcap.setTransformTick(0);
						hulkcap.setAlpha(0.5F);
						hulkcap.setSize(0.2F);
						hulkcap.setTransformation(false);
						hulkcap.setHulk(true);
						
						NetworkHandler.sendToServer(new MessageCapFloatToServer(hulkcap.getAlpha(), "hulkAlpha"));
						NetworkHandler.sendToServer(new MessageCapFloatToServer(hulkcap.getSize(), "hulkSize"));
						NetworkHandler.sendToServer(new MessageCapToServer(hulkcap.isTransforming(), "hulkTransform"));
						NetworkHandler.sendToServer(new MessageCapToServer(hulkcap.isHulk(), "hulk"));
					}
				} else if (hulkcap.isDetransforming()) {
					if (hulkcap.getTransformTick() < 30) {
						hulkcap.increaseTransformTick();
							if (hulkcap.getTransformTick() == 20) {
								hulkcap.setHumanTransformation(true);
								NetworkHandler.sendToServer(new MessageCapToServer(hulkcap.isHumanTransforming(), "hulkHTransform"));
							}
							hulkcap.removeAlpha(0.5F/30.0F);
							hulkcap.removeSize(0.2F/30.0F);
							NetworkHandler.sendToServer(new MessageCapFloatToServer(hulkcap.getAlpha(), "hulkAlpha"));
							NetworkHandler.sendToServer(new MessageCapFloatToServer(hulkcap.getSize(), "hulkSize"));
							player.eyeHeight = player.getEyeHeight() - 0.8F/30.0F;
						} else {
							hulkcap.setTransformTick(0);
							hulkcap.setAlpha(0.0F);
							hulkcap.setSize(0.0F);
							hulkcap.setDetransforming(false);
							hulkcap.setHulk(false);
							
							NetworkHandler.sendToServer(new MessageCapFloatToServer(hulkcap.getAlpha(), "hulkAlpha"));
							NetworkHandler.sendToServer(new MessageCapFloatToServer(hulkcap.getSize(), "hulkSize"));
							NetworkHandler.sendToServer(new MessageCapToServer(hulkcap.isDetransforming(), "hulkDetransform"));
							NetworkHandler.sendToServer(new MessageCapToServer(hulkcap.isHulk(), "hulk"));
						}
					} 
				if (hulkcap.isHumanTransforming()) {
						if (hulkcap.getHTransformTick() < 30) {
							hulkcap.increaseHTransformTick();
							hulkcap.addHAlpha(0.9F/30.0F);
							NetworkHandler.sendToServer(new MessageCapFloatToServer(hulkcap.getHAlpha(), "hulkHAlpha"));
						} else {
							hulkcap.setHTransformTick(0);
							hulkcap.setHAlpha(0F);
							hulkcap.setHumanTransformation(false);
							NetworkHandler.sendToServer(new MessageCapFloatToServer(hulkcap.getHAlpha(), "hulkHAlpha"));
							NetworkHandler.sendToServer(new MessageCapToServer(hulkcap.isHumanTransforming(), "hulkHTransform"));
						}
					}
				
			}
		}
	}
	@SubscribeEvent
	public void onHulkTick(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		
			if (ItemHulkArmor.isWearingHulk(player)) {
				IHulk hulkcap = player.getCapability(HulkProvider.HULK_CAP, null);
				if (hulkcap.isHulk()) {
					if (player.width != 0.8D || player.height != 2.8) {
					//player.width = 0.8F;
					//player.height = 2.8F;
					//player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.8F, player.getEntityBoundingBox().minY + 2.8, player.getEntityBoundingBox().minZ + 0.8F));
					//NetworkHandler.sendToServer(new MessageSetBoundingBox(0.8F, 2.8F));
					}
					if (!hulkcap.isDetransforming()) {

					if (player.getEyeHeight() != player.getDefaultEyeHeight()+0.8F) {
						player.eyeHeight = player.getDefaultEyeHeight()+0.8F;
						
						
						
						
					}
					}
				} else {
					if (!hulkcap.isTransforming()) {
					if (player.getEyeHeight() != player.getDefaultEyeHeight()) {
						player.eyeHeight = player.getDefaultEyeHeight();
						player.width = 0.6F;
						player.height = 1.8F;
						player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + player.width, player.getEntityBoundingBox().minY + player.height, player.getEntityBoundingBox().minZ + player.width));
						
					}
					}
				}
			} else {
				if (player.getEyeHeight() != player.getDefaultEyeHeight()) {
					player.eyeHeight = player.getDefaultEyeHeight();
					player.width = 0.6F;
					player.height = 1.8F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + player.width, player.getEntityBoundingBox().minY + player.height, player.getEntityBoundingBox().minZ + player.width));
					
				}
			}
	}
	@SubscribeEvent
	public void onFall(LivingFallEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			 IHulk hulkcap = player.getCapability(HulkProvider.HULK_CAP, null);
			if (ItemHulkArmor.isWearingHulk(player) && hulkcap.isHulk()) {
				
				event.setCanceled(true);
			} else {
				event.setCanceled(false);
			}
		}
		
	}
	 
	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
	
	 EntityPlayer player = event.getEntityPlayer();
	 if (ItemHulkArmor.isWearingHulk(player)) {
	 IHulk hulkcap = player.getCapability(HulkProvider.HULK_CAP, null);

	 IHulk oldhulkcap = event.getOriginal().getCapability(HulkProvider.HULK_CAP, null);
	 
	 
	 hulkcap.setHulk(oldhulkcap.isHulk());
	 }
	
	}
	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event) {
	if (ItemHulkArmor.isWearingHulk(event.player)) {
		IHulk hulkcap = event.player.getCapability(HulkProvider.HULK_CAP, null);

	 if (hulkcap != null && event.player != null) { 
			if (hulkcap.isHulk()) {
				
				NetworkHandler.sendTo(new MessageCapToClient(hulkcap.isHulk(), "hulk", event.player.getEntityId()), (EntityPlayerMP) event.player);
			}
		}
	}
	}
	@SubscribeEvent
	public void onPlayerJoin(PlayerLoggedInEvent event) {
		if (ItemHulkArmor.isWearingHulk(event.player)) {
		IHulk hulkcap = event.player.getCapability(HulkProvider.HULK_CAP, null);
		if (hulkcap != null && event.player != null) { 
			if (hulkcap.isHulk()) {
				NetworkHandler.sendTo(new MessageCapToClient(hulkcap.isHulk(), "hulk", event.player.getEntityId()), (EntityPlayerMP) event.player);
			}
		}
		}
	}

	
	@SubscribeEvent
	public void onLeap(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IHulk hulkcap = player.getCapability(HulkProvider.HULK_CAP, null);
			IKeys keyscap = player.getCapability(KeysProvider.KEYS_CAP, null);
			if (ItemHulkArmor.isWearingHulk(player)) {
				if (hulkcap.isSmashCooldown()) {
					if (hulkcap.getSmashCooldownInt() < 40) {
						hulkcap.increaseSmashCooldownInt();
					} else {
						hulkcap.setSmashCooldownInt(0);
						hulkcap.setSmashCooldown(false);
					}
				}
			if (player.world.isRemote) {
			if (hulkcap.isHulk()) {
				
				
					if (player.isSneaking() && player.collidedHorizontally) {
						hulkcap.setWallCliming(true);
						if (keyscap.isSpaceDown()) {
							player.motionY = 0;
							player.motionY += 0.05D;
						} else if (!player.onGround) {
							player.motionY = 0;
							
						}
					} else {
						hulkcap.setWallCliming(false);
					}
				
					if (player.fallDistance > 10 && !hulkcap.isWallClimbing()) {
						hulkcap.setSmash(true);
						
						
					}
					if (hulkcap.isSmash()) {
						if (player.isSneaking() && keyscap.isFDown()) {
						if (player.collidedVertically) {
							hulkcap.setSmash(false);
							NetworkHandler.sendToServer(new MessageExplosion(5F));
						}
						}else {
							hulkcap.setSmash(false);
						}
					}
				
				if (keyscap.isSpaceDown() && keyscap.isRDown()) {
					if (hulkcap.isLeaping()) {
						if (!player.onGround) {
							hulkcap.increaseLTick();
						
						double parabola;
						parabola = (-(1D/106D) * (Math.pow(hulkcap.getLTick()/10F, 2)) + 1D);
						player.motionY = parabola;

					if (player.moveForward >= 0.001F && hulkcap.getUp()) {
					Vec3d vec = player.getLookVec();

					player.motionX = vec.x / 2;

					

					player.motionZ = vec.z / 2;
      	
					player.motionX *= 4.8D;
					
					player.motionZ *= 4.8D;
					} else {
						if (hulkcap.getLeapTick() < 5){
							hulkcap.increaseLeapTick();
						} else {
							if (hulkcap.getUp()) {
								hulkcap.setUp(false);
							}
						}
					}
						} else {
							hulkcap.setLTick(0);
						}
					}
						
				} else {
					if (hulkcap.getLTick() != 0) {
						hulkcap.setLTick(0);
					}
					if (hulkcap.getLeapTick() != 0) {
					hulkcap.setLeapTick(0);
					}
					if (!hulkcap.getUp()) {
						hulkcap.setUp(true);
					}
					if (!player.onGround) {
					if (hulkcap.isLeaping()) {
						hulkcap.setLeap(false);
					}
					}
					if (player.onGround  || hulkcap.isWallClimbing()) {
						if (!hulkcap.isLeaping()) {
							hulkcap.setLeap(true);
						}
					}
				}
				 
				}
			}
			} else {
				if (hulkcap.isTransforming()) {
					hulkcap.setTransformTick(0);
					hulkcap.setAlpha(0.0F);
					hulkcap.setSize(0.0F);
					hulkcap.setTransformation(false);
					player.eyeHeight = player.getDefaultEyeHeight();
					player.width = 0.6F;
					player.height = 1.8F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + player.width, player.getEntityBoundingBox().minY + player.height, player.getEntityBoundingBox().minZ + player.width));
				}
				if (hulkcap.isDetransforming()) {
					hulkcap.setTransformTick(0);
					hulkcap.setAlpha(0.0F);
					hulkcap.setSize(0.0F);
					hulkcap.setDetransforming(false);
					player.eyeHeight = player.getDefaultEyeHeight();
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + player.width, player.getEntityBoundingBox().minY + player.height, player.getEntityBoundingBox().minZ + player.width));
				}
				if (hulkcap.isHumanTransforming()) {
					hulkcap.setHTransformTick(0);
					hulkcap.setHAlpha(0F);
					hulkcap.setHumanTransformation(false);
					hulkcap.setAlpha(0.0F);
					hulkcap.setSize(0.0F);
				}
				if (hulkcap.isHulk()) {
					hulkcap.setHulk(false);
					
					
				}
			}
			
		}
	}
	@SubscribeEvent
	public void onHurt(LivingHurtEvent event) {
		
		if (event.getSource().getTrueSource() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
			 IHulk hulkcap = player.getCapability(HulkProvider.HULK_CAP, null);
			if (ItemHulkArmor.isWearingHulk(player) && hulkcap.isHulk()) {
			
			
					//Utils.knockbackEntity(player, event.getEntity(), 10);
					float yaw = player.rotationYaw;
					float pitch = player.rotationPitch;
					float f = 10;
					double motionX = (double)(-MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
					double motionZ = (double)(MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
					double motionY = (double)(-MathHelper.sin((pitch) / 180.0F * (float)Math.PI) * f);
					event.getEntity().motionX = motionX;
					event.getEntity().motionY = motionY *2;
					event.getEntity().motionZ = motionZ;

			}
			}
		
	}
}
