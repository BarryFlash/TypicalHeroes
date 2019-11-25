package barryflash.superheroes.capabilities;

import java.util.List;
import java.util.Stack;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import barryflash.superheroes.entities.EntityDoctorStrangeCape;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import barryflash.superheroes.models.ModelHero;
import barryflash.superheroes.network.MessageCapeSpawn;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.tools.nsc.doc.base.comment.Link;

public class DoctorStrangeEventHandler {
	
	/*@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event)

	{

	 EntityPlayer player = event.getEntityPlayer();

	 IDoctorStrange vengefulness = player.getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);

	 IDoctorStrange oldvengefulness = event.getOriginal().getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);

	 
	

	}
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		
		if (event.getEntity() instanceof EntityPlayer) {
		if (ItemDoctorStrangeArmor.isWearingFullSet((EntityPlayer) event.getEntity(), ModArmor.DoctorStrangeRobe, ModArmor.DoctorStrangeLeggings, ModArmor.DoctorStrangeBoots)) {
			IDoctorStrange docstrangecap = event.getEntity().getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);
			if (Keyboard.isKeyDown(Keyboard.KEY_G)) {
				if(!docstrangecap.isCapeAlive()) {
					NetworkHandler.sendToServer(new MessageCapeSpawn());
					docstrangecap.setCapeAlive();
				} 
			}
			if(docstrangecap.isCapeAlive()) {
			
			}
		}
		}
	}
	@SubscribeEvent
	public void onLivingAttack(LivingAttackEvent event) {
		if (event.getSource().getEntity() instanceof EntityDoctorStrangeCape) {
		
				IDoctorStrange docstrangecap = event.getSource().getEntity().getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);
				if (!docstrangecap.isCapeCoveringEnemy()) {
				docstrangecap.setCapeCoveringEnemy();
				
			}
		}
	}
	private int tick = 0;
	@SubscribeEvent
	public void onLivingUpdateCape(LivingUpdateEvent event) {
		
		if (event.getEntity() instanceof EntityDoctorStrangeCape) {
		
			IDoctorStrange docstrangecap = event.getEntity().getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);	
				if(docstrangecap.isCapeCoveringEnemy()) {
					event.getEntity().setInvisible(true);
				if (tick < 120) {
					tick++;
				}
				else {
					tick = 0;
					docstrangecap.setCapeNotAlive();
					
				}
			}
		}
	}
	@SubscribeEvent
	public void onLivingUpdateFlight(LivingUpdateEvent event) {
		
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IDoctorStrange docstrangecap = event.getEntity().getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);	
				if(!docstrangecap.isCapeAlive()) {
					if (ItemDoctorStrangeArmor.isWearingFullSet((EntityPlayer) event.getEntity(), ModArmor.DoctorStrangeRobe, ModArmor.DoctorStrangeLeggings, ModArmor.DoctorStrangeBoots)) {
						if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
							if (player.motionY > 0D) {
								 player.motionY += 0.05499999910593033D;
			                 } else {
			                   player.motionY += 0.1069999991059303D;
			                 }
							
							
						}
						 if ((player.motionY < 0.0D) && (!player.isSneaking()))
			               {
			                 player.motionY /= 1.10D;
			                 player.motionY /= 1.10D;
			                 player.motionY /= 1.10D;
			               }
						 if ((player.moveForward >= 0.001F) && (!player.onGround)) {
			                 if ((player.motionX <= 4.0D) || (player.motionZ <= 4.0D))
			                 {
			                	 

			                	 
			                	
			                   player.motionX *= 1.052D;
			                   player.motionZ *= 1.052D;
			                 }
						 }
					}
					
				}
		}
	}
	
	
	
	
	@SubscribeEvent
	public void onLivingUpdateEye(LivingUpdateEvent event) {
		
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IDoctorStrange docstrangecap = event.getEntity().getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);	
			if (ItemDoctorStrangeArmor.isWearingFullSet((EntityPlayer) player, ModArmor.DoctorStrangeRobe, ModArmor.DoctorStrangeLeggings, ModArmor.DoctorStrangeBoots)) {
		
				LinkList theLinkedList = new LinkList();
				if(Keyboard.isKeyDown(Keyboard.KEY_N)) {
					if (!docstrangecap.isUsingEyeOfAgamotto()) {
					docstrangecap.setEyeOfAgamotto();
					
					}
				}
				if (docstrangecap.isUsingEyeOfAgamotto()) {
					
					
					
					theLinkedList.insertFirstLink(player.getPosition(), player.rotationYaw, player.rotationPitch);
					theLinkedList.display();
				}
			
					
					if(Keyboard.isKeyDown(Keyboard.KEY_M)) {
						if(!docstrangecap.EyeofAgamottoInProgress()) {
						docstrangecap.startEyeOfAgamotto();
						docstrangecap.unsetEyeOfAgamotto();
						
					}
				}
					if (docstrangecap.EyeofAgamottoInProgress()) {
						
						player.setPositionAndRotation(theLinkedList.firstLink.pos.getX(), theLinkedList.firstLink.pos.getY(), theLinkedList.firstLink.pos.getZ(), theLinkedList.firstLink.yaw, theLinkedList.firstLink.pitch);
						theLinkedList.removeFirst();
						if (theLinkedList.isEmpty()) {
							docstrangecap.endEyeOfAgamotto();
						}
					}
		}
	}
		
	}
	private float r;
	private float g;
	private float b;
	private int beamTick = 0;
	private boolean start;
	private int beamCheck = 0;
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void renderPlayer(RenderWorldLastEvent event) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		IDoctorStrange docstrangecap = player.getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);	
		if (ItemDoctorStrangeArmor.isWearingFullSet(player, ModArmor.DoctorStrangeRobe, ModArmor.DoctorStrangeLeggings, ModArmor.DoctorStrangeBoots)) {
		if (docstrangecap.isBeam()) {
			
		float distance = 20;
		double playerPitch = Math.toRadians(player.rotationPitch);
		double horzDistance = distance * Math.cos(playerPitch);
		double playerYaw2 = Math.toRadians(player.rotationYaw + 90);


		
        double particlePosX = player.posX  +(horzDistance * Math.cos(playerYaw2));

        double particlePosZ = player.posZ + (horzDistance * Math.sin(playerYaw2));
        double particlePosY = player.posY + player.getEyeHeight() + (distance * -Math.sin(playerPitch));
        
		this.r = 0.9F;
		this.g = 0.25F;
		this.b = 0.1F;
		Vec3d pvec = new Vec3d(player.posX, player.posY + 1, player.posZ);
		Vec3d vec = new Vec3d(particlePosX, particlePosY, particlePosZ);
		Utils.renderLaser(pvec, vec, 1.0F, 0.3F, new float[] {r, g, b});
		} else {
			beamCheck = 0;
		}
	}
	}*/
}
