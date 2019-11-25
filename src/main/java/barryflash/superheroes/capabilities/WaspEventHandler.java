package barryflash.superheroes.capabilities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemThanosArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.network.MessageCapToServer;
import barryflash.superheroes.network.MessageShrink;
import barryflash.superheroes.network.MessageWaspBlast;
import barryflash.superheroes.network.MessageWaspBlastSmall;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.network.Capabilities.MessageCapIntToServer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.GuiScreenEvent.MouseInputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WaspEventHandler {
	/*
	private int flytick;
	private boolean small;

	@SubscribeEvent
	public void onAttack(LivingHurtEvent event) {
		if (event.getSource().getTrueSource() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
		
			ISuperheroes shcap = player.getCapability(SuperheroesProvider.SUPERHEROES_CAP, null);
			if (shcap.isWasp(player)) {
				
				
				
				if (small) {
				
			event.setAmount(event.getAmount() + 8);
				} else {
				
					
					event.setAmount(event.getAmount() + 5);
						}
			}
			}
		
	}
	@SubscribeEvent
	public void onJump(LivingJumpEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			ISuperheroes shcap = player.getCapability(SuperheroesProvider.SUPERHEROES_CAP, null);
			if (shcap.isWasp(player)) {
				IWasp waspcap = player.getCapability(WaspProvider.WASP_CAP, null);
				
				if (waspcap.isSmall()) {
					double addY = 0.2D;
					player.motionY += addY;
					}
			}
		}
	}
	@SubscribeEvent
	public void onFly(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.getEntity();
		if (player.world.isRemote) {
		if (ItemWaspArmor.isWearingFullSet(player, ModItems.WaspHelmet, ModItems.WaspChest, ModItems.WaspLegs, ModItems.WaspFeet)) {
		IWasp waspcap = player.getCapability(WaspProvider.WASP_CAP, null);
		if (leftArmCooldownCheck) {
			leftArmCooldown++;
			if (leftArmCooldown > 120) {
				leftArmCooldown = 0;
				leftArmCooldownCheck = false;
			}
		}
		if (rightArmCooldownCheck) {
			rightArmCooldown++;
			if (rightArmCooldown > 120) {
				rightArmCooldown = 0;
				rightArmCooldownCheck = false;
			}
		}
		if (waspcap.shotFromLeftArm()) {
			leftArmCooldownCheck = true;
		}
		if (waspcap.shotFromRightArm()) {
			rightArmCooldownCheck = true;
		}
		if (waspcap.isSmall()) {
			small = true;
		} else {
			small = false;
		}
		
		if (waspcap.isSmall()) {
		if (Keyboard.isKeyDown(57)) {
			
		if (player.motionY > 0.01D) {
            player.motionY += 0.08499999910593033D;
          } else {
            player.motionY += 0.4269999991059303D;
          }
        
        if ((player.motionY < 0.0D) && (!player.isSneaking()))
        {
          player.motionY /= 1.10D;
          player.motionY /= 1.10D;
          player.motionY /= 1.10D;
        }
        if ((player.moveForward >= 0.001F) && (!player.onGround)) {
        	flytick++;
			waspcap.ticksFlying(flytick);
			NetworkHandler.sendToServer(new MessageCapIntToServer(waspcap.getFlyTicks(), "wasp"));
			waspcap.setFly();
			if (waspcap.isFlying()) {
			NetworkHandler.sendToServer(new MessageCapToServer(waspcap.isFlying(), "waspFlight"));
			}
          if ((player.motionX <= 4.0D) || (player.motionZ <= 4.0D))
          {
         	 
         	 Vec3d vec = player.getLookVec();

					player.motionX = vec.x / 2;

					player.motionY = vec.y / 2;

					player.motionZ = vec.z / 2;
         	 
         	
            player.motionX *= 1.2D;
            player.motionZ *= 1.2D;
          }
        }
		} else {
			waspcap.unsetFly();
			flytick = 0;
			NetworkHandler.sendToServer(new MessageCapIntToServer(waspcap.getFlyTicks(), "wasp"));
			if (!waspcap.isFlying()) {
				NetworkHandler.sendToServer(new MessageCapToServer(waspcap.isFlying(), "waspFlight"));
				}
		}
		}
		}
		}
		}
	}
	

	private int tick = 0;
	private int gtick = 0;
	private int hOntick = 0;
	private int animationStep;
	private int hOfftick = 0;
	private int animationOffStep;
	private int rightarmTick = 0;
	private int leftarmTick = 0;
	private boolean rightArmCooldownCheck;
	private boolean leftArmCooldownCheck;
	private int rightArmCooldown = 0;
	private int leftArmCooldown = 0;

	@SubscribeEvent
	public void onWaspSizeUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.getEntity();
		if (player.world.isRemote) {
			IWasp waspcap = player.getCapability(WaspProvider.WASP_CAP, null);
		if (ItemWaspArmor.isWearingFullSet(player, ModItems.WaspHelmet, ModItems.WaspChest, ModItems.WaspLegs, ModItems.WaspFeet)) {
			
		if (waspcap.areBlastersActive() && player.inventory.getCurrentItem().isEmpty()) {
			
			if (!waspcap.shotFromRightArm() && !rightArmCooldownCheck) {
				if (Mouse.isButtonDown(1) && (!Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen()) && (Minecraft.getMinecraft().currentScreen == null)) {
					if (waspcap.isSmall()) {
						if (player.onGround) {
							player.world.playSound(player, player.getPosition(), THSoundHandler.REPULSOR_SHOOT, SoundCategory.PLAYERS, 1F, 1.0F);
						NetworkHandler.sendToServer(new MessageWaspBlastSmall());
						waspcap.setShotFromRightArm();
						NetworkHandler.sendToServer(new MessageCapToServer(waspcap.shotFromRightArm(), "waspBlastRight"));
						}
					} else {
						player.world.playSound(player, player.getPosition(), THSoundHandler.REPULSOR_SHOOT, SoundCategory.PLAYERS, 1F, 1.0F);
					NetworkHandler.sendToServer(new MessageWaspBlast());
					waspcap.setShotFromRightArm();
					NetworkHandler.sendToServer(new MessageCapToServer(waspcap.shotFromRightArm(), "waspBlastRight"));
					}
					
				}
			}
			if (!waspcap.shotFromLeftArm() && !leftArmCooldownCheck) {
				if (Mouse.isButtonDown(0) && (!Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen()) && (Minecraft.getMinecraft().currentScreen == null)) {
					if (waspcap.isSmall()) {
						if (player.onGround) {
							player.world.playSound(player, player.getPosition(), THSoundHandler.REPULSOR_SHOOT, SoundCategory.PLAYERS, 1F, 1.0F);
						NetworkHandler.sendToServer(new MessageWaspBlastSmall());
						waspcap.setShotFromLeftArm();
						NetworkHandler.sendToServer(new MessageCapToServer(waspcap.shotFromLeftArm(), "waspBlastLeft"));
						}
					} if (!waspcap.isSmall()) {
						player.world.playSound(player, player.getPosition(), THSoundHandler.REPULSOR_SHOOT, SoundCategory.PLAYERS, 1F, 1.0F);
					NetworkHandler.sendToServer(new MessageWaspBlast());
					waspcap.setShotFromLeftArm();
					NetworkHandler.sendToServer(new MessageCapToServer(waspcap.shotFromLeftArm(), "waspBlastLeft"));
					}
					
				}
			}
			
		}
			if (waspcap.shotFromRightArm()) {
				rightarmTick++;
				if (rightarmTick > 70) {
					waspcap.unsetShotFromRightArm();
					NetworkHandler.sendToServer(new MessageCapToServer(waspcap.shotFromRightArm(), "waspBlastRight"));
					rightarmTick = 0;
				}
			}
			if (waspcap.shotFromLeftArm()) {
				leftarmTick++;
				if (leftarmTick > 70) {
					waspcap.unsetShotFromLeftArm();
					NetworkHandler.sendToServer(new MessageCapToServer(waspcap.shotFromLeftArm(), "waspBlastLeft"));
					leftarmTick = 0;
				}
			}
			if (waspcap.isHelmetAnimationInProgress()) {
				
				hOntick++;
			
			 if ((hOntick % 5) == 0) {
				 animationStep += 1;
				 waspcap.helmetanimationStep(animationStep);
		        }
			 if (animationStep > 15) {
				 hOntick = 0;
				 animationStep = 0;
				 waspcap.helmetOnanimationEnd();
				 waspcap.setHelmetOn();
			 }
			}
			 if (waspcap.isHelmetOffAnimationInProgress()) {
					
					hOfftick++;
				
				 if ((hOfftick % 5) == 0) {
					 animationOffStep += 1;
					 waspcap.helmetOffanimationStep(animationOffStep);
			        }
				 if (animationOffStep > 15) {
					 hOfftick = 0;
					 animationOffStep = 0;
					 waspcap.helmetOffanimationEnd();
					 waspcap.setHelmetOff();
				 }
			 }

			if (waspcap.isAnimationInProgress()) {
				
				tick++;
			
				if (tick > 20) {
					
					waspcap.setAnimationEnd();
					
					tick = 0;
				}
			}
			if (waspcap.isGrowAnimationInProgress()) {
				
				tick++;
				if (tick > 20) {
					waspcap.setGrowAnimationEnd();
					tick = 0;
				}
			}
			if (waspcap.isSmall()) {
				if (!waspcap.isAnimationInProgress()) {
			NetworkHandler.sendToServer(new MessageShrink());
			player.width = 0.2F;
			player.height = 0.4F;
			player.eyeHeight = player.getDefaultEyeHeight() - 1.3F;
			player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + player.width, player.getEntityBoundingBox().minY + player.height, player.getEntityBoundingBox().minZ + player.width));
			
				}
				} else {
				
					
				player.eyeHeight = player.getDefaultEyeHeight();
				
			}
		} else if (waspcap.isSmall()){
			player.eyeHeight = player.getDefaultEyeHeight();
			waspcap.resetSize();
		}
		}
		}
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onOverlay(RenderGameOverlayEvent event) {
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			EntityPlayer player = Minecraft.getMinecraft().player;
			if (ItemWaspArmor.isWearingFullSet(player, ModItems.WaspHelmet, ModItems.WaspChest, ModItems.WaspLegs, ModItems.WaspFeet)) {
				IWasp waspcap = player.getCapability(WaspProvider.WASP_CAP, null);
				GlStateManager.pushMatrix();
				GlStateManager.translate(event.getResolution().getScaledWidth() - 60, (event.getResolution().getScaledHeight()/2) + 14, 0);
				GlStateManager.scale(0.7F, 0.7F, 0.7F);
				Minecraft.getMinecraft().fontRenderer.drawString("Right Blaster", 0, 0, 0xFFF130);
				Minecraft.getMinecraft().fontRenderer.drawString("Left Blaster", 0, 24, 0xFFF130);
				if (waspcap.areBlastersActive()) {
				Minecraft.getMinecraft().fontRenderer.drawString("Activated", 0, -12, 0x07D800, true);
				} else {
					Minecraft.getMinecraft().fontRenderer.drawString("Deactivated", 0, -12, 0xCC0300, true);
				}
				GlStateManager.popMatrix();
				GlStateManager.pushMatrix();
				GlStateManager.color(1, 1, 1);
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/wasp_gui.png"));
				Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 69, event.getResolution().getScaledHeight()/2, 0, 0, 69, 50, 256, 256);
				
				if (rightArmCooldownCheck) {
					Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 60, (event.getResolution().getScaledHeight()/2) + 21, 0, 50, 0 + (rightArmCooldown/3), 7, 256, 256);
				} else {
					Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 60, (event.getResolution().getScaledHeight()/2) + 21, 0, 50, 44, 7, 256, 256);
				}
				if (leftArmCooldownCheck) {
					Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 60, (event.getResolution().getScaledHeight()/2) + 37, 0, 50, 0 + (leftArmCooldown/3), 7, 256, 256);
				} else {
					Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 60, (event.getResolution().getScaledHeight()/2) + 37, 0, 50, 44, 7, 256, 256);
				}
				GlStateManager.popMatrix();
			}
		}
	}
	@SubscribeEvent
	public void onFall(LivingFallEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
		
			if (ItemWaspArmor.isWearingFullSet(player, ModItems.WaspHelmet, ModItems.WaspChest, ModItems.WaspLegs, ModItems.WaspFeet)) {
			
				event.setCanceled(true);
			} else {
				event.setCanceled(false);
			}
		}
		
	}
*/
}
