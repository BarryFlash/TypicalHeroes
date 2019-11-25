package barryflash.superheroes.capabilities;

import java.util.List;
import java.util.UUID;

import javax.vecmath.Vector3f;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemHulkArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.network.MessageCapToServer;
import barryflash.superheroes.network.MessageExplosion;
import barryflash.superheroes.network.MessageReflect;
import barryflash.superheroes.network.MessageRemoveSpeedAttribute;
import barryflash.superheroes.network.MessageSpeedAttribute;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.network.Capabilities.WonderWoman.MessageWonderWomanBlastToTracking;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityArrow.PickupStatus;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WonderWomanEventHandler {
	
	
	public static final String uuid4 = "e8613a1a-e999-48ea-99a0-069075d34dcc";
	public static final AttributeModifier speedAttributeModifier = new AttributeModifier(UUID.fromString(uuid4), "th:ww_speed", 0.05D, 0).setSaved(true);
	


	@SubscribeEvent
	public void onBracelets(LivingAttackEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			IWonderWoman wwcap = event.getEntity().getCapability(WonderWomanProvider.WONDERWOMAN_CAP, null);
			
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onLivingUpdate(RenderWorldLastEvent event) {
		for (int i = 0; i < Minecraft.getMinecraft().world.playerEntities.size(); i++) {
			EntityPlayer player = Minecraft.getMinecraft().world.playerEntities.get(i);
		
			
				IWonderWoman wwcap = player.getCapability(WonderWomanProvider.WONDERWOMAN_CAP, null);
				
			
				if (wwcap.isBlast()) {
		
					for (double theta = 0; theta < Math.PI * 2; theta += Math.PI /16) {
	
						for (double phi = 0; phi < Math.PI; phi += Math.PI / 16) {
	
							
							double x = (wwcap.getScale()/2.5F) * Math.cos(theta) * Math.sin(phi);
	
							double y = (wwcap.getScale()/2.5F) * Math.cos(phi);
	
							double z = (wwcap.getScale()/2.5F) * Math.sin(theta) * Math.sin(phi);
	
	
	
						
							ParticleSpawnerDoctorStrangeShields.spawnParticle("ironman_repulsor", (double) player.posX + x, (double) player.posY + y + ((wwcap.getScale()/2.5F)/2) + player.height/2, (double) player.posZ + z, 0, 0, 0, null);
						
							
	
						}
					}
				} else {
					wwcap.setScale(0);
				}

		}
				
		
	}
	

	
	
	
	@SubscribeEvent
	public void onLeap(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IWonderWoman wwcap = player.getCapability(WonderWomanProvider.WONDERWOMAN_CAP, null);
			IKeys keyscap = player.getCapability(KeysProvider.KEYS_CAP, null);
			if (ItemWonderWomanArmor.isWearingFullSet(player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
				if (wwcap.isBlast()) {
				if (wwcap.getScale() > 10) {
					wwcap.setScale(0);
					
					wwcap.unsetBlast();
					NetworkHandler.sendToServer(new MessageCapToServer(wwcap.isBlast(), "wonderwomanBlast"));
				} else {
					
					wwcap.increaseScale();
					
				}
				}
				if (wwcap.isBlastCooldown()) {
					if (wwcap.getBlastCooldown() < 120) {
						wwcap.increaseBlastCooldown();
					} else {
						wwcap.setBlastCooldown(0);
						wwcap.unsetBlastCooldown();
					}
				}
				if (wwcap.areBraceletsActive()) {
					if (player.world.isRemote) {
					int k1 = player.getPosition().getX() + 5;
					 int l1 = player.getPosition().getX() - 5;
				     int i2 = player.getPosition().getY() + 5;
				     int i1 = player.getPosition().getY() - 5;
				     int j2 = player.getPosition().getZ() + 5;
				     int j1 = player.getPosition().getZ() - 5;
					
					  List<Entity> list = player.world.getEntitiesWithinAABBExcludingEntity(player, new AxisAlignedBB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
					  for (int k2 = 0; k2 < list.size(); ++k2)
					  {
					  Entity entity = (Entity)list.get(k2);
				
					if (entity instanceof IProjectile && (entity.motionX < -0.2 || entity.motionX > 0.2)) {
					Vec3d projectileVector = entity.getPositionVector();
					Vec3d vec3 = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw + 90);
					double x = player.posX + (vec3.x);
					double z = player.posZ + (vec3.z);
					Vec3d pVector = new Vec3d(0,0,0F).rotateYaw(-player.rotationYaw * -0.017453292F - (float)Math.PI/2).add(new Vec3d(x, player.posY, z));
					Vec3d playerVector = player.getForward().normalize();
					double multiVector = -2*(projectileVector.dotProduct(playerVector));
					Vec3d playerVectorMulti = new Vec3d(playerVector.x*multiVector, playerVector.y*multiVector, playerVector.z*multiVector);
					Vec3d reflectVector = playerVectorMulti.add(projectileVector).rotateYaw(-0.55F);
					NetworkHandler.sendToServer(new MessageReflect(entity.getEntityId(), reflectVector.x, reflectVector.y, reflectVector.z));
					}
					}
					}
				} 
	
			if (player.world.isRemote) {
				if (keyscap.isSpaceDown() && keyscap.isRDown()) {
					if (wwcap.canJump()) {
						if (!player.onGround) {
							wwcap.increaseLTick();
						
						double parabola;
						parabola = (-(1D/106D) * (Math.pow(wwcap.getLTick()/10F, 2)) + 1D);
						player.motionY = parabola;

					if (player.moveForward >= 0.001F && wwcap.canUp()) {
					Vec3d vec = player.getLookVec();

					player.motionX = vec.x / 2;

					

					player.motionZ = vec.z / 2;
      	
					player.motionX *= 4.8D;
					
					player.motionZ *= 4.8D;
					} else {
						if (wwcap.getLeapTick() < 5){
							wwcap.increaseLeapTick();
						} else {
							if (wwcap.canUp()) {
								wwcap.setUp(false);
							}
						}
					}
						} else {
							wwcap.setLTick(0);
						}
					}
						
				} else {
					if (wwcap.getLTick() != 0) {
						wwcap.setLTick(0);
					}
					if (wwcap.getLeapTick() != 0) {
					wwcap.setLeapTick(0);
					}
					if (!wwcap.canUp()) {
						wwcap.setUp(true);
					}
					if (!player.onGround) {
					if (wwcap.canJump()) {
						wwcap.setJump(false);
					}
					}
					if (player.onGround) {
						if (!wwcap.canJump()) {
							wwcap.setJump(true);
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
		
			if (ItemWonderWomanArmor.isWearingFullSet(player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
				
				event.setCanceled(true);
			} else {
				event.setCanceled(false);
			}
		}
		
	}
}
