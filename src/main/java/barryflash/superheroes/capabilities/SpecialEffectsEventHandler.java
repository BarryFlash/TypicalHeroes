package barryflash.superheroes.capabilities;

import java.util.Random;

import org.lwjgl.input.Mouse;

import barryflash.superheroes.entities.projectiles.EntityTrickArrowGrapple;
import barryflash.superheroes.network.MessageCutGrappleArrows;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.network.Capabilities.MessageCapIntToServer;
import barryflash.superheroes.util.Utils;
import net.java.games.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.settings.KeyBindingMap;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.MouseInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SpecialEffectsEventHandler {

	public static DamageSource Shock = new DamageSource("Shock");
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void renderGrapple(RenderWorldLastEvent event) {
		for (int i = 0; i < Minecraft.getMinecraft().world.playerEntities.size(); i++) {
			EntityPlayer player = Minecraft.getMinecraft().world.playerEntities.get(i);
			ISpecialEffects specialcap = player.getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
			
			if (specialcap != null) {
				
				if (specialcap.getGrappleEntityList() != null && specialcap.getGrappleEntityList().size() > 0) {
					
					if (player != null) {
						
						float distance = 60;
						float distance2 = -0.2F;
						Vec3d vec3 = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);
								
						double x2 = player.posX + (distance2 *vec3.x);
						double y2 = player.posY + player.getEyeHeight() + (distance2 *vec3.y);
						double z2 = player.posZ + (distance2 *vec3.z);
							
						Vec3d vec = new Vec3d(-0.2F, 0.3, 0.4F);
						
						Vec3d xvec = vec.rotateYaw(-player.rotationYaw * (float) Math.PI / 180F);
						Vec3d yvec = vec.rotatePitch(player.rotationPitch * (float) Math.PI / 180F);
								
						double sx = player.posX + xvec.x;
						double sy = player.posY + (player.height - yvec.y);
						double sz = player.posZ + xvec.z;
							 
	
							 
						Vec3d S = new Vec3d(sx, sy, sz);	
						Vec3d fina = new Vec3d(0,0,0.15F).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
						Vec3d fina2 = new Vec3d(0,0,0.15F).rotateYaw(player.rotationYaw * -0.017453292F + (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
						for (int j = 0; j < specialcap.getGrappleEntityList().size(); j++) {
							if (specialcap.getGrappleEntityList().get(j) != null) {

							Utils.renderThickLine(S, specialcap.getGrappleEntityList().get(j).getPositionVector(), 1, 0.01F, new float[] {0.05F,0.05F,0.05F});
				
							}
						}
					}
				}
			}
		}
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onMouseInput(MouseInputEvent event) {
		
			EntityPlayer player = Minecraft.getMinecraft().player;
			ISpecialEffects specialcap = player.getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
			
			if (specialcap != null) {
				if (Mouse.isButtonDown(0)) {
				if (specialcap.getGrappleEntityList().size() > 0) {
					for (int i = 0; i < specialcap.getGrappleEntityList().size(); i++) {
						((EntityTrickArrowGrapple) specialcap.getGrappleEntityList().get(i)).contact = false;
					}
					specialcap.clearGrappleEntityList();
					NetworkHandler.sendToServer(new MessageCapIntToServer(player.getEntityId(), "hawkeyeGrappleListClear"));
					NetworkHandler.sendToServer(new MessageCutGrappleArrows());
				}
			}
			
		}
	}
	@SubscribeEvent
	public void onHurt(LivingHurtEvent event) {
		if (event.getEntity() instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) event.getEntity();
			if (entity != null) {
				ISpecialEffects supercap = entity.getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
				if (supercap != null) {
					if (event.getSource() == Shock) {
						if (!supercap.isShocked()) {
							Random rand = entity.world.rand;
							int randInt = rand.nextInt(100);
								if (randInt > 0 && randInt < 20) {
									supercap.setShock(true);
								}
						}
					}
				}
			}
		}
	}
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityLivingBase) {
		EntityLivingBase entity = (EntityLivingBase) event.getEntity();
		if (entity != null) {
			
		ISpecialEffects supercap = entity.getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
		if (supercap != null) {
		if (supercap.isShocked()) {
			
			if (supercap.getShockTick() < 80) {
				supercap.increaseShockTick();
				if (supercap.getShockTick() % 5 == 0) {
					entity.attackEntityFrom(Shock, 2F);
				}
			} else {
				supercap.setShockTick(0);
				supercap.setShock(false);
			}
	
		}
		}
		}
		}
	}
}
