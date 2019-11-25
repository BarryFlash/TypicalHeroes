package barryflash.superheroes.capabilities;

import java.util.List;
import java.util.UUID;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.particles.HeatVisionParticleSpawner;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.entities.projectiles.EntityLassoWhip;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemIronmanMark50ArcReactorArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.models.ModelHero;
import barryflash.superheroes.network.MessageCapToServer;
import barryflash.superheroes.network.MessageIronmanSuitOff;
import barryflash.superheroes.network.MessageKnockBackFists;
import barryflash.superheroes.network.MessageRepulsor;
import barryflash.superheroes.network.MessageSpawnCannonBlast;
import barryflash.superheroes.network.MessageSpawnMissiles;
import barryflash.superheroes.network.MessageUnibeam;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.network.Capabilities.MessageCapIntToServer;
import barryflash.superheroes.network.Capabilities.Ironman.MessageCannonLaserToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageLeftLaserToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageRightLaserToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageUnibeamLaserToTracking;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.MouseInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IronmanEventHandler {
	


	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (player.world.isRemote) {
			if (ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
			IIronman ironmancap = player.getCapability(IronmanProvider.IRONMAN_CAP, null);
			
			
			
			if (ironmancap.isAnimationInProgress()) {
				
				ironmancap.increaseAnimationTick();
			
			 if ((ironmancap.getAnimationTick() % 5) == 0) {
				 ironmancap.increaseAnimationStep();
		        }
			 if (ironmancap.getAnimationStep() > 15) {
				 ironmancap.setAnimationStep(0);
				 ironmancap.setAnimationTick(0);
				
				 ironmancap.animationEnd();
				 //NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isAnimationInProgress(), "ironmanSuitOn"));
			 }
			 
			}
			if (ironmancap.isAnimationOff()) {
			
				ironmancap.increaseAnimationTick();
			
			 if ((ironmancap.getAnimationTick() % 5) == 0) {
				 ironmancap.increaseAnimationStep();
		        }
			 if (ironmancap.getAnimationStep() > 15) {
				 ironmancap.setAnimationStep(0);
				 ironmancap.setAnimationTick(0);
				 ironmancap.setAnimationOff(false);
				// NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isAnimationOffInProgress(), "ironmanSuitOff"));
					NetworkHandler.sendToServer(new MessageIronmanSuitOff());
			 }
			}
			}
			}
		}
	}
	
	@SubscribeEvent
	public void onFlight(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IIronman ironmancap = player.getCapability(IronmanProvider.IRONMAN_CAP, null);
			if (ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
			 

			if (ironmancap.isIronmanDisabled()) {
					player.motionX -= player.motionX/0.6;
				
					player.motionZ -= player.motionZ/0.6;
				
				
			} 
			 if (!ironmancap.isAnimationInProgress()) {
			
				 if (ironmancap.getFlight()) {

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
				 
				 
					 if (player.world.isRemote) {
					 Vec3d particlevecArmRight;
					  Vec3d particlevecArmLeft;
					  Vec3d particlevecLegRight;
					  Vec3d particlevecLegLeft;
					  particlevecArmRight = new Vec3d(-0.4F, 1.5, 1.5);
					  particlevecArmLeft = new Vec3d(0.5F, 1.5, 1.5);
					  particlevecLegRight = new Vec3d(-0.1F, 1.5, 0.4);
					  particlevecLegLeft = new Vec3d(0.1F, 1.5, 0.4);
						Vec3d xvecArmRight = particlevecArmRight.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
						Vec3d yvecArmRight = particlevecArmRight.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
						Vec3d xvecArmLeft = particlevecArmLeft.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
						Vec3d yvecArmLeft = particlevecArmLeft.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
						Vec3d xvecLegRight = particlevecLegRight.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
						Vec3d yvecLegRight = particlevecLegRight.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
						Vec3d xvecLegLeft = particlevecLegLeft.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
						Vec3d yvecLegLeft = particlevecLegLeft.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
						
					 double xArmRight = player.posX + xvecArmRight.x;
					 double yArmRight = player.posY + (player.height - yvecArmRight.y);
					 double zArmRight = player.posZ + xvecArmRight.z;
					 double xArmLeft = player.posX + xvecArmLeft.x;
					 double yArmLeft = player.posY + (player.height - yvecArmLeft.y);
					 double zArmLeft = player.posZ + xvecArmLeft.z;
					 double xLegRight = player.posX + xvecLegRight.x;
					 double yLegRight = player.posY + (player.height - yvecLegRight.y);
					 double zLegRight = player.posZ + xvecLegRight.z;
					 double xLegLeft = player.posX + xvecLegLeft.x;
					 double yLegLeft = player.posY + (player.height - yvecLegLeft.y);
					 double zLegLeft = player.posZ + xvecLegLeft.z;
					
				/*	ParticleSpawnerDoctorStrangeShields.spawnParticle("ironman_flight", xArmRight, yArmRight, zArmRight, 0, 0, 0);
					ParticleSpawnerDoctorStrangeShields.spawnParticle("ironman_flight", xArmLeft, yArmLeft, zArmLeft, 0, 0, 0);
					ParticleSpawnerDoctorStrangeShields.spawnParticle("ironman_flight", xLegRight, yLegRight, zLegRight, 0, 0, 0);
					ParticleSpawnerDoctorStrangeShields.spawnParticle("ironman_flight", xLegLeft, yLegLeft, zLegLeft, 0, 0, 0);*/
					 }
				
				
					 if (player.moveForward >= 0.001F && !player.onGround) {
				        	
				        	
							
				          if ((player.motionX <= 4.0D) || (player.motionZ <= 4.0D))
				          {
            	   ironmancap.activateFlight();
            	   if (ironmancap.getFlyTick() < 10) {
            	   ironmancap.increaseFlyTicks();
            	   }
                	 Vec3d vec = player.getLookVec();

	 					player.motionX = vec.x / 2;

	 					player.motionY = vec.y / 2;

	 					player.motionZ = vec.z / 2;
                	 
                	if (ironmancap.areWingsActivated()) {
                   player.motionX *= 4.8D;
                   player.motionY *= 2.8D;
                   player.motionZ *= 4.8D;
                	} else if (ironmancap.isJetThrusterActivated()) {
                		
                            player.motionX *= 8.4D;
                            player.motionY *= 4.2D;
                            player.motionZ *= 8.4D;
                    } else {
                    	player.motionX *= 3.4D;
                    	 player.motionY *= 1.8D;
                        player.motionZ *= 3.4D;
                    }
                 }
               }
            	  
				 
				 }  else {
					 ironmancap.deactivateFlight();
					 ironmancap.setFlyTicks(0);
					 if (player.world.isRemote) {
					 NetworkHandler.sendToServer(new MessageCapIntToServer(ironmancap.getFlyTicks(), "ironman"));
					 }
					 player.eyeHeight = player.getDefaultEyeHeight();
				 } 
				
				 }else {
					 ironmancap.deactivateFlight();
					
					 player.eyeHeight = player.getDefaultEyeHeight();
				 }
			 }
			 
			
		}
	}
	
	
	

	@SubscribeEvent
	public void onRepulsorFire(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (player.world.isRemote) {
				IIronman ironmancap = event.getEntity().getCapability(IronmanProvider.IRONMAN_CAP, null);
			if (ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
				if (ironmancap.isIronmanDisabled()) {
					if (ironmancap.getDisabledTimer() < 120) {
						ironmancap.increaseDisabledTimer();
					} else {
						ironmancap.setDisabledTimer(0);
						ironmancap.setIronmanDisabled(false);
					}
				}
			
		if (ironmancap.getCannon()) {
			ironmancap.increaseCannonTick();
			if (ironmancap.getCannonTick() > 40) {
				ironmancap.setCannonTick(0);
				ironmancap.setCannon(false);
			}
		}
		if (!ironmancap.getCooldownAccess(0)) {
			if (ironmancap.rightArmCooldown()) {
				ironmancap.unsetRightArmCooldown();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.shotFromRightArm(), "ironmanRepulsorRight"));
			}
		}
		if (!ironmancap.getCooldownAccess(1)) {
			if (ironmancap.leftArmCooldown()) {
				ironmancap.unsetLeftArmCooldown();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.shotFromLeftArm(), "ironmanRepulsorLeft"));
			}
		}
		if (!ironmancap.getCooldownAccess(2)) {
			if (ironmancap.unibeamCooldown()) {
				ironmancap.unsetUnibeamCooldown();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.shotFromArc(), "ironmanUnibeam"));
			}
		}
		if (!ironmancap.getCooldownAccess(3)) {
			
			if (ironmancap.weaponCooldown()) {
				
				ironmancap.unsetWeaponCooldown();;
			}
		}
	if (!ironmancap.getCooldownAccess(4)) {
			
			if (ironmancap.missileCooldown()) {
				
				ironmancap.unsetMissileCooldown();;
			}
		}
	if (!ironmancap.getCooldownAccess(5)) {
		
		if (ironmancap.swordCooldown()) {
			
			ironmancap.unsetSwordCooldown();;
		}
	}
	if (!ironmancap.getCooldownAccess(6)) {
		
		if (ironmancap.knockbackFistsCooldown()) {
			
			ironmancap.unsetKnockbackFistsCooldown();;
		}
	}
		if (ironmancap.getCooldownAccess(3)) {
			ironmancap.increaseCooldown(3);
			if (ironmancap.getCooldown(3) > 220) {
				ironmancap.setCooldownAccess(3, false);
				ironmancap.setCooldown(3, 0);
			}
		}
		if (ironmancap.getCooldownAccess(0)) {
			ironmancap.increaseCooldown(0);
			if (ironmancap.getCooldown(0) > 20 && ironmancap.shotFromRightArm()) {
				ironmancap.cancelRightArm();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.shotFromRightArm(), "ironmanRepulsorRight"));
			}
			if (ironmancap.getCooldown(0) > 80) {
				ironmancap.setCooldownAccess(0, false);
				
				ironmancap.setCooldown(0, 0);
				
			}
		}
		if (ironmancap.getCooldownAccess(1)) {
			ironmancap.increaseCooldown(1);
			if (ironmancap.getCooldown(1) > 20 && ironmancap.shotFromLeftArm()) {
				ironmancap.cancelLeftArm();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.shotFromLeftArm(), "ironmanRepulsorLeft"));
			}
			if (ironmancap.getCooldown(1) > 80) {
				ironmancap.setCooldownAccess(1, false);
				ironmancap.setCooldown(1, 0);
			
			}
		}
		if (ironmancap.getCooldownAccess(2)) {
			ironmancap.increaseCooldown(2);
			if (ironmancap.getCooldown(2) > 60 && ironmancap.shotFromArc()) {
				ironmancap.cancelArc();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.shotFromArc(), "ironmanUnibeam"));
			}
			if (ironmancap.getCooldown(2) > 160) {
				ironmancap.setCooldownAccess(2, false);
				ironmancap.setCooldown(2, 0);
				
			}
		}
		if (ironmancap.getCooldownAccess(6)) {
			
			ironmancap.increaseCooldown(6);
			if (ironmancap.getCooldown(6) > 160) {
				
				ironmancap.setCooldownAccess(6, false);
				ironmancap.setCooldown(6, 0);
				
				
				
			}
		}
		
		if (ironmancap.getCooldownAccess(5)) {
			ironmancap.setSwordCooldown();
			ironmancap.increaseCooldown(5);
			if (ironmancap.getCooldown(5) > 80) {
				ironmancap.setCooldownAccess(5, false);
				
				ironmancap.setCooldown(5, 0);
				
			}
		}
		if (ironmancap.getCooldownAccess(4)) {
			ironmancap.increaseCooldown(4);
			if (ironmancap.getCooldown(4) > 160) {
				ironmancap.setCooldownAccess(4, false);
				
				ironmancap.setCooldown(4, 0);
				
			}
		}
		if (ironmancap.repulsorsActivated()) {
			((EntityPlayer)event.getEntity()).swingProgressInt = -1;
		}
		
	
	
			} else {
				ironmancap.deactivateRepulsors();
			}
			}
		}
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void mouseRepulsors(MouseInputEvent event) {
		EntityPlayer player = Minecraft.getMinecraft().player;
		IIronman ironmancap = player.getCapability(IronmanProvider.IRONMAN_CAP, null);
		if (ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots) && !ironmancap.isIronmanDisabled()) {
			
			if (ironmancap.repulsorsActivated() && player.inventory.getCurrentItem().isEmpty()) {
			
				if (!ironmancap.shotFromRightArm()) {
		if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
		if (Mouse.isButtonDown(1) && (!Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen()) && (Minecraft.getMinecraft().currentScreen == null)) {
			if (!ironmancap.getCooldownAccess(0)) {
				ironmancap.setCooldownAccess(0, true);
				player.world.playSound(player, player.getPosition(), THSoundHandler.REPULSOR_SHOOT, SoundCategory.PLAYERS, 1F, 1.0F);
			ironmancap.shootRightArm();
			ironmancap.setRightArmCooldown();
			NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.shotFromRightArm(), "ironmanRepulsorRight"));
			}
		}
		
				if (!ironmancap.shotFromLeftArm()) {
		if (Mouse.isButtonDown(0)&& (!Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen()) && (Minecraft.getMinecraft().currentScreen == null)) {
			if (!ironmancap.getCooldownAccess(1)) {
				ironmancap.setCooldownAccess(1, true);
				player.world.playSound(player, player.getPosition(), THSoundHandler.REPULSOR_SHOOT, SoundCategory.PLAYERS, 1F, 1.0F);
			ironmancap.shootLeftArm();
			ironmancap.setLeftArmCooldown();
			NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.shotFromLeftArm(), "ironmanRepulsorLeft"));
			}
		}
				}
				}
				}
				
					if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
					if (Mouse.isButtonDown(0)&& Mouse.isButtonDown(1) && (!Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen()) && (Minecraft.getMinecraft().currentScreen == null)) {
						if (!ironmancap.getCooldownAccess(2)) {
							ironmancap.setCooldownAccess(2, true);
							player.world.playSound(player, player.getPosition(), THSoundHandler.REPULSOR_SHOOT, SoundCategory.PLAYERS, 1.5F, 1.0F);
							ironmancap.shootArc();
							NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.shotFromArc(), "ironmanUnibeam"));
							ironmancap.setUnibeamCooldown();
					}
				}
				}
				
			}
		}
	}
	

	@SubscribeEvent
	public void onAttackWithShield(LivingAttackEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			IIronman ironmancap = event.getEntity().getCapability(IronmanProvider.IRONMAN_CAP, null);
		
		if (ironmancap.isShieldActivated()) {
		/*if (event.getEntity().getHorizontalFacing().equals(event.getEntity().getHorizontalFacing().EAST)) {				
			if (event.getSource().getDamageLocation().xCoord > event.getEntity().posX) {
				event.setCanceled(true);
			}
		}
		if (event.getEntity().getHorizontalFacing().equals(event.getEntity().getHorizontalFacing().WEST)) {				
			if (event.getSource().getDamageLocation().xCoord < event.getEntity().posX) {
				event.setCanceled(true);
			}
		}
		if (event.getEntity().getHorizontalFacing().equals(event.getEntity().getHorizontalFacing().NORTH)) {				
			if (event.getSource().getDamageLocation().zCoord < event.getEntity().posZ) {
				event.setCanceled(true);
			}
		}
		if (event.getEntity().getHorizontalFacing().equals(event.getEntity().getHorizontalFacing().SOUTH)) {				
			if (event.getSource().getDamageLocation().zCoord > event.getEntity().posZ) {
				event.setCanceled(true);
			}
		}
		if (event.isCanceled()) {
			
		}
		
	} else {*/
			event.setCanceled(true);
		} else {
			event.setCanceled(false);
		}
	
	
	}
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onMouseInput(MouseInputEvent event) {
		if (ItemIronmanMark50Armor.isWearingFullSet(Minecraft.getMinecraft().player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
		IIronman ironmancap = Minecraft.getMinecraft().player.getCapability(IronmanProvider.IRONMAN_CAP, null);
		if (ironmancap.areCannonsActivated()  && !ironmancap.isIronmanDisabled() && Minecraft.getMinecraft().player.inventory.getCurrentItem().isEmpty() && !ironmancap.repulsorsActivated()) {
			if (Mouse.isButtonDown(0)&& (!Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen()) && (Minecraft.getMinecraft().currentScreen == null)) {
				if (!ironmancap.getCooldownAccess(3)) {
					Minecraft.getMinecraft().player.world.playSound(Minecraft.getMinecraft().player, Minecraft.getMinecraft().player.getPosition(), THSoundHandler.REPULSOR_SHOOT, SoundCategory.PLAYERS, 1.5F, 1.0F);
					ironmancap.setCooldownAccess(3, true);
				ironmancap.setCannon(true);
				ironmancap.setWeaponCooldown();
				}
			}
		}
		if (ironmancap.areMissilesActivated() && !ironmancap.isIronmanDisabled() && Minecraft.getMinecraft().player.inventory.getCurrentItem().isEmpty()  && !ironmancap.repulsorsActivated()) {
			if (Mouse.isButtonDown(0)&& (!Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen()) && (Minecraft.getMinecraft().currentScreen == null)) {
				if (!ironmancap.getCooldownAccess(4)) {
					ironmancap.setCooldownAccess(4, true);
				NetworkHandler.sendToServer(new MessageSpawnMissiles());
				ironmancap.setMissileCooldown();
				}
			}
		}
		}
	}

	@SubscribeEvent
	public void onHitWithKnockBackFists(LivingUpdateEvent event) {
		
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (player.world.isRemote) {
				IIronman ironmancap = event.getEntity().getCapability(IronmanProvider.IRONMAN_CAP, null);
			if (ItemIronmanMark50Armor.isWearingFullSet((EntityPlayer) event.getEntity(), ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots) && !ironmancap.isIronmanDisabled()) {
	
			if (ironmancap.isSwordActivated() && player.inventory.getCurrentItem().isEmpty() && !ironmancap.repulsorsActivated()) {
				ironmancap.setSwordOn(true);
			} else {
				ironmancap.setSwordOn(false);
			}
			if (ironmancap.areKnockbackFistsActivated() && player.inventory.getCurrentItem().isEmpty() && !ironmancap.repulsorsActivated()) {
				if (Mouse.isButtonDown(0)&& (!Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen()) && (Minecraft.getMinecraft().currentScreen == null)) {
					
		            
		            if (!ironmancap.getCooldownAccess(6)) {
		            	ironmancap.setCooldownAccess(6, true);
		            Utils.knockbackEntity(player, player, 3F);
					NetworkHandler.sendToServer(new MessageKnockBackFists());
					ironmancap.setKnockbackFistsCooldown();
		            }
				} 
			}

			if (ironmancap.shotFromRightArm() || ironmancap.shotFromLeftArm()) {
				RayTraceResult result = Utils.getMouseOverExtended(60);
				if (result != null) {
					if (result.typeOfHit == result.typeOfHit.ENTITY) {
						if (result.entityHit != null) {
							
							NetworkHandler.sendToServer(new MessageRepulsor(result.entityHit.getEntityId()));
						}
					}
				}
			}
			if (ironmancap.shotFromArc()) {
				RayTraceResult result = Utils.getMouseOverExtended(60);
				if (result != null) {
					if (result.typeOfHit == result.typeOfHit.ENTITY) {
						if (result.entityHit != null) {
							
							NetworkHandler.sendToServer(new MessageUnibeam(result.entityHit.getEntityId()));
						}
					}
				}
			}
			if (ironmancap.getCannon()) {
				RayTraceResult result = Utils.getMouseOverExtended(60);
				if (result != null) {
					if (result.typeOfHit == result.typeOfHit.ENTITY) {
						if (result.entityHit != null) {
							
							NetworkHandler.sendToServer(new MessageSpawnCannonBlast(result.entityHit.getEntityId()));
						}
					}
				}
			}
			}
		}
		}
			
	}
	private float r = 0.8F, g = 0.5F, b = 0.3F;
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onRepulsorRender(RenderWorldLastEvent event) {
		for (int i = 0; i < Minecraft.getMinecraft().world.playerEntities.size(); i++) {
			EntityPlayer player = Minecraft.getMinecraft().world.playerEntities.get(i);
		
	
		if (ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
			IIronman ironmancap = player.getCapability(IronmanProvider.IRONMAN_CAP, null);
			
		float distance = 60;
		float distance2 = -0.2F;
		Vec3d vec3 = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);
		
		double x = player.posX + (distance *vec3.x);
		double y = player.posY + player.getEyeHeight() + (distance *vec3.y);
		double z = player.posZ + (distance *vec3.z);
		double x2 = player.posX + (distance2 *vec3.x);
		double y2 = 0;
		double z2 = player.posZ + (distance2 *vec3.z);
		
		if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
			y2 = player.posY + player.getEyeHeight() + (distance2 *vec3.y);
		} else {
			y2 = player.posY + player.getEyeHeight() + 0.1F + (distance2 *vec3.y);
		}
	
		Vec3d fina = new Vec3d(0,0,0.06F).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
		Vec3d fina2 = new Vec3d(0,0,0.06F).rotateYaw(player.rotationYaw * -0.017453292F + (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
		
		Vec3d vector = new Vec3d(x, y, z);
		
		 if (ironmancap.shotFromRightArm()) {
			  Vec3d vec;
		  if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 1) {
		  vec = new Vec3d(-0.2F, 0.3, 2);
		  } else if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
			  vec = new Vec3d(-0.2F, 0.2, 0.2F);
		  } else {
			  vec = new Vec3d(-0.2F, 0.3, 2);
		  }
			Vec3d xvec = vec.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
			Vec3d yvec = vec.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
			
		 double sx = player.posX + xvec.x;
		 double sy = player.posY + (player.height - yvec.y);
		 double sz = player.posZ + xvec.z;
		 

		 
		 Vec3d S = new Vec3d(sx, sy, sz);	
		 Utils.renderLaser2(S, vector, 3.5F, 0.05F, new float[] {r, g, b});
		 //NetworkHandler.sendToTracking(new MessageRightLaserToTracking(), player);
			 //Utils.renderLaser(S, E, 5.5F, 0.1F, new float[] {r, g, b});
			
		 
		  }
		 if (ironmancap.shotFromArc()) {
		  Vec3d vec;
		  if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 1) {
		  vec = new Vec3d(0.0F, 0.6, 0);
		  } else if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
			  vec = new Vec3d(0.0F, 0.6, 0.2F);
		  } else {
			  vec = new Vec3d(0.0F, 0.6, 0);
		  }
			Vec3d xvec = vec.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
			Vec3d yvec = vec.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
			
		 double sx = player.posX + xvec.x;
		 double sy = player.posY + (player.height - yvec.y);
		 double sz = player.posZ + xvec.z;
		 
		

		 
		 Vec3d S = new Vec3d(sx, sy, sz);	
		
		 
			 Utils.renderLaser2(S, vector, 8.5F, 0.3F, new float[] {r, g, b});
			 //NetworkHandler.sendToTracking(new MessageUnibeamLaserToTracking(S, vector), player);
		 }
		  if (ironmancap.shotFromLeftArm()) {
			  Vec3d v1;
		  if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 1) {
		  v1 = new Vec3d(0.2F, 0.3, 2);
		  } else if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
			  v1 = new Vec3d(0.2F, 0.2, 0.2F);
		  } else {
			  v1 = new Vec3d(0.2F, 0.3, 2);
		  }
			Vec3d v2 = v1.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
			Vec3d v3 = v1.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
			
		 double sx = player.posX + v2.x ;
		 double sy = player.posY + (player.height - v3.y);
		 double sz = player.posZ + v2.z;
		
		

		 
		 Vec3d S = new Vec3d(sx, sy, sz);	
		 Utils.renderLaser2(S, vector, 3.5F, 0.05F, new float[] {r, g, b});
		 //NetworkHandler.sendToTracking(new MessageLeftLaserToTracking(S, vector), player);
			// Utils.renderLaser(S, S2, 2.5F, 0.1F, new float[] {r, g, b});
			
		 
		  }
		  if (ironmancap.getCannon()) {
			  Vec3d vec;
			  Vec3d vec2;
			  Vec3d vec33;
			  Vec3d vec4;
			  Vec3d vec5;
			  Vec3d vec6;
		  if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 1) {
		  vec = new Vec3d(-0.2F, 0.2, 2);
		  vec2 = new Vec3d(0.2F, 0.2, 2);
		  vec33 = new Vec3d(1.2F, 0.4, 2);
		  vec4 = new Vec3d(-1.2F, 0.4, 2);
		  vec5 = new Vec3d(1.8F, 0.4, 2);
		  vec6 = new Vec3d(-1.8F, 0.4, 2);
		  } else if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
			  vec = new Vec3d(-0.2F, 0.2, 0.2F);
			  vec2 = new Vec3d(0.2F, 0.2, 0.2F);
			  vec33 = new Vec3d(1.2F, 0.2, 0.2F);
			  vec4 = new Vec3d(-1.2F, 0.2, 0.2F);
			  vec5 = new Vec3d(1.8F, 0.4, 0.2F);
			  vec6 = new Vec3d(-1.8F, 0.4, 0.2F);
		  } else {
			  vec = new Vec3d(-0.2F, 0.2, 2);
			  vec2 = new Vec3d(0.2F, 0.2, 2);
			  vec33 = new Vec3d(1.2F, 0.2, 2);
			  vec4 = new Vec3d(-1.2F, 0.2, 2);
			  vec5 = new Vec3d(1.8F, 0.4, 2);
			  vec6 = new Vec3d(-1.8F, 0.4, 2);
		  }
			Vec3d xvec = vec.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
			Vec3d yvec = vec.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
			Vec3d xvec2 = vec2.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
			Vec3d yvec2 = vec2.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
			Vec3d xvec3 = vec33.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
			Vec3d yvec3 = vec33.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
			Vec3d xvec4 = vec4.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
			Vec3d yvec4 = vec4.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
			Vec3d xvec5 = vec5.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
			Vec3d yvec5 = vec5.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
			Vec3d xvec6 = vec6.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
			Vec3d yvec6 = vec6.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
			
		 double sx = player.posX + xvec.x;
		 double sy = player.posY + (player.height - yvec.y);
		 double sz = player.posZ + xvec.z;
		 double sx2 = player.posX + xvec2.x;
		 double sy2 = player.posY + (player.height - yvec2.y);
		 double sz2 = player.posZ + xvec2.z;
		 double sx3 = player.posX + xvec3.x;
		 double sy3 = player.posY + (player.height - yvec3.y);
		 double sz3 = player.posZ + xvec3.z;
		 double sx4 = player.posX + xvec4.x;
		 double sy4 = player.posY + (player.height - yvec4.y);
		 double sz4 = player.posZ + xvec4.z;
		 double sx5 = player.posX + xvec5.x;
		 double sy5 = player.posY + (player.height - yvec5.y);
		 double sz5 = player.posZ + xvec5.z;
		 double sx6 = player.posX + xvec6.x;
		 double sy6 = player.posY + (player.height - yvec6.y);
		 double sz6 = player.posZ + xvec6.z;
		
		

		 
		 Vec3d S = new Vec3d(sx, sy, sz);
		 Vec3d S2 = new Vec3d(sx2, sy2, sz2);
		 Vec3d S3 = new Vec3d(sx3, sy3, sz3);
		 Vec3d S4 = new Vec3d(sx4, sy4, sz4);
		 Vec3d S5 = new Vec3d(sx5, sy5, sz5);
		 Vec3d S6 = new Vec3d(sx6, sy6, sz6);
		 
		 
			 Utils.renderLaser2(S, vector, 2.5F, 0.1F, new float[] {r, g, b});
			 Utils.renderLaser2(S2, vector, 2.5F, 0.1F, new float[] {r, g, b});
			 Utils.renderLaser2(S3, vector, 2.5F, 0.4F, new float[] {r, g, b});
			 Utils.renderLaser2(S4, vector, 2.5F, 0.4F, new float[] {r, g, b});
			 Utils.renderLaser2(S5, vector, 2.5F, 0.3F, new float[] {r, g, b});
			 Utils.renderLaser2(S6, vector, 2.5F, 0.3F, new float[] {r, g, b});
			 //NetworkHandler.sendToTracking(new MessageCannonLaserToTracking(S, vector, 0.1F), player);
			 //NetworkHandler.sendToTracking(new MessageCannonLaserToTracking(S2, vector, 0.1F), player);
			 //NetworkHandler.sendToTracking(new MessageCannonLaserToTracking(S3, vector, 0.4F), player);
			 //NetworkHandler.sendToTracking(new MessageCannonLaserToTracking(S4, vector, 0.4F), player);
			 //NetworkHandler.sendToTracking(new MessageCannonLaserToTracking(S5, vector, 0.3F), player);
			 //NetworkHandler.sendToTracking(new MessageCannonLaserToTracking(S6, vector, 0.3F), player);
		  }
		}
	}
	}
	@SubscribeEvent
	public void onAttack(LivingHurtEvent event) {
		if (event.getSource().getTrueSource() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
			IIronman ironmancap = player.getCapability(IronmanProvider.IRONMAN_CAP, null);
			if (ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots) && !ironmancap.isIronmanDisabled()) {
				
			if (ironmancap.isSwordActivated() && !ironmancap.getCooldownAccess(5)) {
					ironmancap.setCooldownAccess(5, true);
					event.setAmount(event.getAmount() + 15);
			}
			float yaw = player.rotationYaw;
			float pitch = player.rotationPitch;
			float f = 2;
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
		
			if (ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots) ) {
				
				event.setCanceled(true);
			} else {
				event.setCanceled(false);
			}
		}
		
	}
}
