package barryflash.superheroes.capabilities;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.Reference;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.client.gui.GuiBatmanWeaponSelect;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangElectric;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemShazamArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.models.ModelBatarang;
import barryflash.superheroes.network.MessageBatarangSpawn;
import barryflash.superheroes.network.MessageCapToServer;
import barryflash.superheroes.network.MessageRemoveSpeedAttribute;
import barryflash.superheroes.network.MessageSpeedAttribute;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.network.Capabilities.MessageCapIntToServer;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BatmanEventHandler {
	

	public static final String uuid4 = "eb3e85b5-7b9d-4c0c-858a-936f59942902";
	public static final AttributeModifier speedAttributeModifier = new AttributeModifier(UUID.fromString(uuid4), "th:batman_speed", 0.01D, 0).setSaved(true);
	private static int[] cooldownAmounts = new int[]{20, 160, 120, 160, 80};

	
	@SubscribeEvent
	public void onAttack(LivingHurtEvent event) {
		if (event.getSource().getTrueSource() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
			ISuperheroes shcap = player.getCapability(SuperheroesProvider.SUPERHEROES_CAP, null);
			if (shcap.isBatman(player)) {
				
				
			
				float yaw = player.rotationYaw;
				float pitch = player.rotationPitch;
				float f = 1;
				double motionX = (double)(-MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
				double motionZ = (double)(MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
				double motionY = (double)(-MathHelper.sin((pitch) / 180.0F * (float)Math.PI) * f);
				event.getEntity().motionX = motionX;
				event.getEntity().motionY = motionY *2;
				event.getEntity().motionZ = motionZ;
			
				
		
			}
			}
		
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onMouseClick(MouseEvent event) {
		IBatman batcap = Minecraft.getMinecraft().player.getCapability(BatmanProvider.BATMAN_CAP, null);
		EntityPlayer player = Minecraft.getMinecraft().player;
		if (ItemBatmanArmor.isWearingFullSet(player, ModItems.BatmanCowl, ModItems.BatmanChest, ModItems.BatmanLeggings, ModItems.BatmanBoots)) {
		if (batcap.areBatarangs() && player.inventory.getCurrentItem().isEmpty()) {
			
		if (event.getButton() == 1 && event.isButtonstate()) {
			if (batcap.isBatarangActive(1)) {
				if (!batcap.getBatarangCooldownBool(0)) {
					batcap.setBatarangCooldownBool(0, true);
					player.world.playSound(player, player.getPosition(), THSoundHandler.THROW, SoundCategory.PLAYERS, 1F, 1.0F);
					Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);
					NetworkHandler.sendToServer(new MessageBatarangSpawn(batcap.getActiveBatarangType()));
					
				}
			}
			if (batcap.isBatarangActive(2)) {
				if (!batcap.getBatarangCooldownBool(1)) {
					batcap.setBatarangCooldownBool(1, true);
					player.world.playSound(player, player.getPosition(), THSoundHandler.THROW, SoundCategory.PLAYERS, 1F, 1.0F);
					Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);
					NetworkHandler.sendToServer(new MessageBatarangSpawn(batcap.getActiveBatarangType()));
				}
			}
			if (batcap.isBatarangActive(3)) {
				if (!batcap.getBatarangCooldownBool(2)) {
					batcap.setBatarangCooldownBool(2, true);
					player.world.playSound(player, player.getPosition(), THSoundHandler.THROW, SoundCategory.PLAYERS, 1F, 1.0F);
					Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);
					NetworkHandler.sendToServer(new MessageBatarangSpawn(batcap.getActiveBatarangType()));
				}
			}
			if (batcap.isBatarangActive(4)) {
				if (!batcap.getBatarangCooldownBool(3)) {
					batcap.setBatarangCooldownBool(3, true);
					player.world.playSound(player, player.getPosition(), THSoundHandler.THROW, SoundCategory.PLAYERS, 1F, 1.0F);
					Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);
					NetworkHandler.sendToServer(new MessageBatarangSpawn(batcap.getActiveBatarangType()));
				}
			}
			if (batcap.isBatarangActive(5)) {
				if (!batcap.getBatarangCooldownBool(4)) {
					batcap.setBatarangCooldownBool(4, true);
					player.world.playSound(player, player.getPosition(), THSoundHandler.THROW, SoundCategory.PLAYERS, 1F, 1.0F);
					Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);
					NetworkHandler.sendToServer(new MessageBatarangSpawn(batcap.getActiveBatarangType()));
				}
			}
			
		}
		}
		}
	}
	@SubscribeEvent
	public void onFly(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.getEntity();
		IBatman batcap = player.getCapability(BatmanProvider.BATMAN_CAP, null);
		if (ItemBatmanArmor.isWearingFullSet(player, ModItems.BatmanCowl, ModItems.BatmanChest, ModItems.BatmanLeggings, ModItems.BatmanBoots)) {
			
			if (!batcap.isArmorWorn()) {
				if (player.world.isRemote) {
				NetworkHandler.sendToServer(new MessageSpeedAttribute("batman"));
				}
				batcap.setArmorWorn(true);
			}
			for (int i = 0; i <= batcap.getMaxAmount(); i++) {
				if (batcap.getBatarangCooldownBool(i)) {
					if (batcap.getBatarangCooldown(i) < cooldownAmounts[i]) {			
						batcap.increaseBatarangCooldown(i);
					} else {
						batcap.setBatarangCooldown(i, 0);
						batcap.setBatarangCooldownBool(i, false);
					}
				}
			}
		
			
			
			/*if (player.world.isRemote) {
			
			
		if (Keyboard.isKeyDown(57) && !player.onGround && !player.isSneaking() && !player.isInWater()) {
			
			batcap.setGliding();
			NetworkHandler.sendToServer(new MessageCapToServer(batcap.isGliding(), "batmanGlide"));
			batcap.increaseTicksGliding();
			NetworkHandler.sendToServer(new MessageCapIntToServer(batcap.getGlideTicks(), "batman"));
		
			 if (player.motionY > -0.5D)
	         {
	             player.fallDistance = 1.0F;
	         }
			
	         Vec3d vec3d = player.getLookVec();
	         float f = player.rotationPitch * 0.017453292F;
	         double d6 = Math.sqrt(vec3d.x * vec3d.x + vec3d.z * vec3d.z);
	         double d8 = Math.sqrt(player.motionX * player.motionX + player.motionZ * player.motionZ);
	         double d1 = vec3d.lengthVector();
	         float f4 = MathHelper.cos(f);
	         f4 = (float)((double)f4 * (double)f4 * Math.min(1.0D, d1 / 0.4D));
	         player.motionY += -0.08D + (double)f4 * 0.06D;

	         if (player.motionY < 0.0D && d6 > 0.0D)
	         {
	        	
	             double d2 = player.motionY * -0.1D * (double)f4;
	             player.motionY += d2;
	             player.motionX += vec3d.x * d2 / d6;
	             player.motionZ += vec3d.z * d2 / d6;
	         }

	         if (f < 0.0F)
	         {
	             double d9 = d8 * (double)(-MathHelper.sin(f)) * 0.24D;
	             player.motionY += d9 * 3.2D;
	             player.motionX -= vec3d.x * d9 / d6;
	             player.motionZ -= vec3d.z * d9 / d6;
	         }

	         if (d6 > 0.0D)
	         {
	             player.motionX += (vec3d.x / d6 * d8 - player.motionX) * 0.1D;
	             player.motionZ += (vec3d.z / d6 * d8 - player.motionZ) * 0.1D;
	         }

	         player.motionX *= 0.9900000095367432D;
	         player.motionY *= 0.9800000190734863D;
	         player.motionZ *= 0.9900000095367432D;
          



		} else {
			batcap.unsetGliding();
			batcap.setTicksGliding(0);
			NetworkHandler.sendToServer(new MessageCapIntToServer(batcap.getGlideTicks(), "batman"));
			NetworkHandler.sendToServer(new MessageCapToServer(batcap.isGliding(), "batmanGlide"));
		}
		}*/
		} else {
			if (batcap.isArmorWorn()) {
				if (player.world.isRemote) {
				NetworkHandler.sendToServer(new MessageRemoveSpeedAttribute("batman"));
				}
				batcap.setArmorWorn(false);
			}
		}
		}
		
	}
	private int batarang = 0;
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onOverlay(RenderGameOverlayEvent event) {
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			if (ItemBatmanArmor.isWearingFullSet(Minecraft.getMinecraft().player, ModItems.BatmanCowl, ModItems.BatmanChest, ModItems.BatmanLeggings, ModItems.BatmanBoots)) {
				IBatman batcap = Minecraft.getMinecraft().player.getCapability(BatmanProvider.BATMAN_CAP, null);
				EntityPlayer player = Minecraft.getMinecraft().player;
				IQuiver qcap = player.getCapability(QuiverProvider.QUIVER_CAP, null);
			
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/batmanbatgadgetindicatorgui.png"));
				int lower = 0;
				if (qcap.isWearingQuiver()) {
					lower = 45;
				} else {
					lower = 0;
				}
				Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 37, 0 + lower, 0, 0, 37, 26, 256, 256);
				if (batcap.isBatarangActive(1)) {
				Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 24, 8 + lower, 0, 27, 19, 10, 256, 256);
				if (batcap.getBatarangCooldownBool(0)) {
				Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 34, 4 + lower, 38, 4 + (batcap.getBatarangCooldown(0)/(cooldownAmounts[0]/18)), 5, 18, 256, 256);
				} else {
					Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 34, 4 + lower, 38, 22, 5, 18, 256, 256);
				}
				} else if (batcap.isBatarangActive(2)) {
					Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 24, 8 + lower, 0, 37, 19, 10, 256, 256);
					if (batcap.getBatarangCooldownBool(1)) {
						Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 34, 4 + lower, 38, 4 + (batcap.getBatarangCooldown(1)/(cooldownAmounts[1]/18)), 5, 18, 256, 256);
						} else {
							Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 34, 4 + lower, 38, 22, 5, 18, 256, 256);
						}
				}else if (batcap.isBatarangActive(3)) {
					Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 24, 8 + lower, 0, 47, 19, 10, 256, 256);
					if (batcap.getBatarangCooldownBool(2)) {
						Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 34, 4 + lower, 38, 4 + (batcap.getBatarangCooldown(2)/(cooldownAmounts[2]/18)), 5, 18, 256, 256);
						} else {
							Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 34, 4 + lower, 38, 22, 5, 18, 256, 256);
						}
				}else if (batcap.isBatarangActive(4)) {
					Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 24, 8 + lower, 0, 57, 19, 10, 256, 256);
					if (batcap.getBatarangCooldownBool(3)) {
						Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 34, 4 + lower, 38, 4 + (batcap.getBatarangCooldown(3)/(cooldownAmounts[3]/18)), 5, 18, 256, 256);
						} else {
							Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 34, 4 + lower, 38, 22, 5, 18, 256, 256);
						}
				}else if (batcap.isBatarangActive(5)) {
					Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 24, 8 + lower, 0, 67, 19, 11, 256, 256);
					if (batcap.getBatarangCooldownBool(4)) {
						Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 34, 4 + lower, 38, 4 + (batcap.getBatarangCooldown(4)/(cooldownAmounts[4]/18)), 5, 18, 256, 256);
						} else {
							Gui.drawModalRectWithCustomSizedTexture(event.getResolution().getScaledWidth() - 34 + lower, 4, 38, 22, 5, 18, 256, 256);
						}
				}
				
			}
		}
	}
	
	@SubscribeEvent
	public void onFall(LivingFallEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IBatman batcap = Minecraft.getMinecraft().player.getCapability(BatmanProvider.BATMAN_CAP, null);
			if (batcap.isGliding()) {
				event.setCanceled(true); 
			}
		}
		
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void renderPlayer(RenderWorldLastEvent event) {
		for (int i = 0; i < Minecraft.getMinecraft().world.playerEntities.size(); i++) {
			EntityPlayer player = Minecraft.getMinecraft().world.playerEntities.get(i);
			IBatman batcap = player.getCapability(BatmanProvider.BATMAN_CAP, null);
			if (batcap.isGrappleShot()) {
				float distance = 60;
				float distance2 = -0.2F;
				Vec3d vec3 = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);
				
				
				double x2 = player.posX + (distance2 *vec3.x);
				double y2 = player.posY + player.getEyeHeight() + (distance2 *vec3.y);
				double z2 = player.posZ + (distance2 *vec3.z);
				
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
				Vec3d fina = new Vec3d(0,0,0.15F).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
				Vec3d fina2 = new Vec3d(0,0,0.15F).rotateYaw(player.rotationYaw * -0.017453292F + (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
				Utils.renderLaser(player, S, batcap.getGrappleEndVec(), 8, 0.01F, new float[] {0.05F,0.05F,0.05F});
				//Utils.renderLine(player, fina2, batcap.getGrappleEndVec(), 1, 20, 0, 0, 0);
			}
		}
	}
	@SubscribeEvent
	public void grappleGun(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IBatman batcap = player.getCapability(BatmanProvider.BATMAN_CAP, null);
			if (batcap.isGrappleShot()) {
				if (batcap.getGrappleType() == "entity") {
					Entity ent = batcap.getGrappleEntity();
					Vec3d evec = ent.getPositionVector();
					batcap.setGrappleEndVec(evec);
					Vec3d pvec = player.getPositionVector();
					double distX = pvec.x - evec.x;
					double distY = pvec.y+1.5D - evec.y;
		            double distZ = pvec.z - evec.z;
		            
		            double dir = Math.atan2(distZ, distX);
		            double speed = 1F / ent.getPositionVector().distanceTo(pvec) * 7;
		            
		            if (distY<0)
	                {
		            	ent.motionY += speed;
	                }
		           
		            ent.motionX += Math.cos(dir) * speed;
		            ent.motionZ += Math.sin(dir) * speed;
		            
		         int k1 = player.getPosition().getX() + 3;
		   		 int l1 = player.getPosition().getX() - 3;
		   	     int i2 = player.getPosition().getY() + 3;
		   	     int i1 = player.getPosition().getY() - 3;
		   	     int j2 = player.getPosition().getZ() + 3;
		   	     int j1 = player.getPosition().getZ() - 3;
		   		
		   		  List<Entity> list = player.world.getEntitiesWithinAABBExcludingEntity(player, new AxisAlignedBB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
		   		  for (int k2 = 0; k2 < list.size(); ++k2)
		   		  {
		   		  Entity entity = (Entity)list.get(k2);
		   		  if (entity == ent) {
		   			  batcap.retractGrapple();
		   		  }
		   		}
				} else if (batcap.getGrappleType() == "block") {
					Vec3d block = batcap.getGrappleEndVec();
					Vec3d pvec = player.getPositionVector();
					double distX = block.x - pvec.x;
					double distY = block.y - pvec.y;
		            double distZ = block.z - pvec.z;
		            double length = pvec.distanceTo(block);
		            double dir = Math.atan2(distZ, distX);
		            double dirY = Math.atan2(0, distY);
		            double speed = 1F / player.getPositionVector().distanceTo(block) * 5;
		           
		            if (distZ < -length - 5 || distZ > length + 5) {
		            	player.motionZ = Math.sin(dir) /4;
		            } 
		            if (distX < -length - 5 || distX > length + 5) {
		            	 player.motionX = Math.cos(dir) /4;
		            } 
		            if (distY < -length - 5 || distY > length + 5) {
		            	 player.motionY = (Math.cos(dirY)) /8;
		            } 
		            //player.motionX = Math.cos(dir) /2;

					//player.motionY = (Math.cos(dirY)) /2;

					//player.motionZ = Math.sin(dir) /2;
					
					//player.motionX *= 1.8D;
					
	                //player.motionZ *= 1.8D;
		           // player.motionY += (Math.cos(dirY) - Math.sin(dirY)) * speed;
	                

		          
		            
		           
		           // player.motionX += Math.cos(dir) * speed;
		            //player.motionZ += Math.sin(dir) * speed;
		            if (pvec.distanceTo(block) < 2) {
		            	batcap.retractGrapple();
		            }
				} else if (batcap.getGrappleType() == "miss") {
					
				}
			}
		}
	}
}
