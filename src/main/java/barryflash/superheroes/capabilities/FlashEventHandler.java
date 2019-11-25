package barryflash.superheroes.capabilities;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.lwjgl.opengl.GL11;
import org.objectweb.asm.tree.MethodInsnNode;

import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ArmorBase;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemBlackWidowArmor;
import barryflash.superheroes.items.armor.ItemCaptainAmericaArmor;
import barryflash.superheroes.items.armor.ItemCyborgArmor;
import barryflash.superheroes.items.armor.ItemFlashArmor;
import barryflash.superheroes.items.armor.ItemHawkeyeArmor;
import barryflash.superheroes.items.armor.ItemHulkArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50ArcReactorArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemShazamArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.network.MessageCapToServer;
import barryflash.superheroes.network.MessageRemoveSpeedAttribute;
import barryflash.superheroes.network.MessageSpeedAttribute;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FlashEventHandler {
	public static final String uuid = "4dc2ea00-4f99-47e1-9a89-d6a43fa6060b";
	public static final String uuid1 = "782be420-f5f2-4e81-a570-0796b9794ab9";
	public static final String uuid2 = "3cb82874-6a34-41fd-bc91-56f1ab71f948";
	public static final String uuid3 = "e5fa3a86-9749-4615-b795-5f8c0e5ccd38";
	public static final String uuid4 = "2c8d876c-695f-43f7-8a41-6343a274f5b3";
	public static final String uuid5 = "ee23e994-8383-4f5c-9e33-59101728accc";
	public static final String uuid6 = "b66c6742-abd1-4970-a6a2-f5a5ebedf3f2";
	
	public static AttributeModifier speedAttributeModifier = new AttributeModifier(UUID.fromString(uuid), "th:flash_speed", 0.05D, 0).setSaved(true);
	public static AttributeModifier speedAttributeModifier1 = new AttributeModifier(UUID.fromString(uuid1), "th:flash_speed1", 0.1D, 0).setSaved(true);
	public static AttributeModifier speedAttributeModifier2 = new AttributeModifier(UUID.fromString(uuid2), "th:flash_speed2", 0.2D, 0).setSaved(true);
	public static AttributeModifier speedAttributeModifier3 = new AttributeModifier(UUID.fromString(uuid3), "th:flash_speed3", 0.3D, 0).setSaved(true);
	public static AttributeModifier speedAttributeModifier4 = new AttributeModifier(UUID.fromString(uuid4), "th:flash_speed4", 0.4D, 0).setSaved(true);
	public static AttributeModifier speedAttributeModifier5 = new AttributeModifier(UUID.fromString(uuid5), "th:flash_speed5", 0.5D, 0).setSaved(true);
	public static AttributeModifier speedAttributeModifier6 = new AttributeModifier(UUID.fromString(uuid6), "th:flash_speed6", 0.6D, 0).setSaved(true);
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onRenderThor(RenderWorldLastEvent event) {
		for (int i = 0; i < Minecraft.getMinecraft().world.playerEntities.size(); i++) {
			EntityPlayer player = Minecraft.getMinecraft().world.playerEntities.get(i);

			IFlash flashcap = player.getCapability(FlashProvider.FLASH_CAP, null);
			if (flashcap.isInSuperSpeed()) {
				if (!flashcap.isTrailActive()) {

				Utils.renderTrail(player, flashcap.getList(), player.world.rand, new float[] {0.4F, 0.7F, 0.9F});
				}
				
			}
				
			
		}
	}

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
				if (!player.world.isRemote) {
				if (ArmorBase.isWearingTier(player, 1)) {
					if (!player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(ArmorBase.healthAttributeModifierTier1)) {
						player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(ArmorBase.healthAttributeModifierTier1);
						if (player.getHealth() == 20) {
						player.setHealth(player.getMaxHealth());
						}
					}
					if (!player.getEntityAttribute(SharedMonsterAttributes.ARMOR).hasModifier(ArmorBase.armorAttributeModifierTier1)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR).applyModifier(ArmorBase.armorAttributeModifierTier1);
					}
					if (!player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).hasModifier(ArmorBase.damageAttributeModifierTier1)) {
						player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).applyModifier(ArmorBase.damageAttributeModifierTier1);
					}
					if (!player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).hasModifier(ArmorBase.toughnessAttributeModifierTier1)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).applyModifier(ArmorBase.toughnessAttributeModifierTier1);
					}
				} else {
					if (player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(ArmorBase.healthAttributeModifierTier1)) {
						if (player.getHealth() > 20) {
							player.setHealth(20);
							}
						player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(ArmorBase.healthAttributeModifierTier1);
						
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.ARMOR).hasModifier(ArmorBase.armorAttributeModifierTier1)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR).removeModifier(ArmorBase.armorAttributeModifierTier1);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).hasModifier(ArmorBase.damageAttributeModifierTier1)) {
						player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).removeModifier(ArmorBase.damageAttributeModifierTier1);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).hasModifier(ArmorBase.toughnessAttributeModifierTier1)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).removeModifier(ArmorBase.toughnessAttributeModifierTier1);
					}
				}
				if (ArmorBase.isWearingTier(player, 2)) {
					if (!player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(ArmorBase.healthAttributeModifierTier2)) {
						player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(ArmorBase.healthAttributeModifierTier2);
						if (player.getHealth() == 20) {
							player.setHealth(player.getMaxHealth());
							}
					}
					if (!player.getEntityAttribute(SharedMonsterAttributes.ARMOR).hasModifier(ArmorBase.armorAttributeModifierTier2)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR).applyModifier(ArmorBase.armorAttributeModifierTier2);
					}
					if (!player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).hasModifier(ArmorBase.damageAttributeModifierTier2)) {
						player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).applyModifier(ArmorBase.damageAttributeModifierTier2);
					}
					if (!player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).hasModifier(ArmorBase.toughnessAttributeModifierTier2)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).applyModifier(ArmorBase.toughnessAttributeModifierTier2);
					}
				} else {
					if (player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(ArmorBase.healthAttributeModifierTier2)) {
						if (player.getHealth() > 20) {
							player.setHealth(20);
							}
						player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(ArmorBase.healthAttributeModifierTier2);
						
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.ARMOR).hasModifier(ArmorBase.armorAttributeModifierTier2)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR).removeModifier(ArmorBase.armorAttributeModifierTier2);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).hasModifier(ArmorBase.damageAttributeModifierTier2)) {
						player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).removeModifier(ArmorBase.damageAttributeModifierTier2);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).hasModifier(ArmorBase.toughnessAttributeModifierTier2)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).removeModifier(ArmorBase.toughnessAttributeModifierTier2);
					}
				}
				if (ArmorBase.isWearingTier(player, 3)) {
					if (!player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(ArmorBase.healthAttributeModifierTier3)) {
						player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(ArmorBase.healthAttributeModifierTier3);
						if (player.getHealth() == 20) {
							player.setHealth(player.getMaxHealth());
							}
					}
					if (!player.getEntityAttribute(SharedMonsterAttributes.ARMOR).hasModifier(ArmorBase.armorAttributeModifierTier3)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR).applyModifier(ArmorBase.armorAttributeModifierTier3);
					}
					if (!player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).hasModifier(ArmorBase.damageAttributeModifierTier3)) {
						player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).applyModifier(ArmorBase.damageAttributeModifierTier3);
					}
					if (!player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).hasModifier(ArmorBase.toughnessAttributeModifierTier3)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).applyModifier(ArmorBase.toughnessAttributeModifierTier3);
					}
				} else {
					if (player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(ArmorBase.healthAttributeModifierTier3)) {
						if (player.getHealth() > 20) {
							player.setHealth(20);
							}
						player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(ArmorBase.healthAttributeModifierTier3);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.ARMOR).hasModifier(ArmorBase.armorAttributeModifierTier3)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR).removeModifier(ArmorBase.armorAttributeModifierTier3);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).hasModifier(ArmorBase.damageAttributeModifierTier3)) {
						player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).removeModifier(ArmorBase.damageAttributeModifierTier3);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).hasModifier(ArmorBase.toughnessAttributeModifierTier3)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).removeModifier(ArmorBase.toughnessAttributeModifierTier3);
					}
				}
				if (ArmorBase.isWearingTier(player, 4)) {
					if (!player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(ArmorBase.healthAttributeModifierTier4)) {
						player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(ArmorBase.healthAttributeModifierTier4);
						if (player.getHealth() == 20) {
							player.setHealth(player.getMaxHealth());
							}
					}
					if (!player.getEntityAttribute(SharedMonsterAttributes.ARMOR).hasModifier(ArmorBase.armorAttributeModifierTier4)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR).applyModifier(ArmorBase.armorAttributeModifierTier4);
					}
					if (!player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).hasModifier(ArmorBase.damageAttributeModifierTier4)) {
						player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).applyModifier(ArmorBase.damageAttributeModifierTier4);
					}
					if (!player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).hasModifier(ArmorBase.toughnessAttributeModifierTier4)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).applyModifier(ArmorBase.toughnessAttributeModifierTier4);
					}
				} else {
					if (player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(ArmorBase.healthAttributeModifierTier4)) {
						if (player.getHealth() > 20) {
							player.setHealth(20);
							}
						player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(ArmorBase.healthAttributeModifierTier4);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.ARMOR).hasModifier(ArmorBase.armorAttributeModifierTier4)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR).removeModifier(ArmorBase.armorAttributeModifierTier4);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).hasModifier(ArmorBase.damageAttributeModifierTier4)) {
						player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).removeModifier(ArmorBase.damageAttributeModifierTier4);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).hasModifier(ArmorBase.toughnessAttributeModifierTier4)) {
						player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).removeModifier(ArmorBase.toughnessAttributeModifierTier4);
					}
				}
				}
			IFlash flashcap = player.getCapability(FlashProvider.FLASH_CAP, null);
			if (ItemFlashArmor.isWearingFlash(player)) {
				if (flashcap.getSpeedLevel() == 6) {
					if (!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier6)) {
						player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(this.speedAttributeModifier6);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier5)) {
						player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(this.speedAttributeModifier5);
					}
				} else if (flashcap.getSpeedLevel() == 5) {
					if (!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier5)) {
						player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(this.speedAttributeModifier5);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier4)) {
						player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(this.speedAttributeModifier4);
					}
					if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier6)) {
						player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(this.speedAttributeModifier6);
					}
				}
				 else if (flashcap.getSpeedLevel() == 4) {
						if (!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier4)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(this.speedAttributeModifier4);
						}
						if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier3)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(this.speedAttributeModifier3);
						}
						if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier5)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(this.speedAttributeModifier5);
						}
					}
				 else if (flashcap.getSpeedLevel() == 3) {
						if (!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier3)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(this.speedAttributeModifier3);
						}
						if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier2)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(this.speedAttributeModifier2);
						}
						if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier4)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(this.speedAttributeModifier4);
						}
					}
				 else if (flashcap.getSpeedLevel() == 2) {
						if (!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier2)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(this.speedAttributeModifier2);
						}
						if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier1)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(this.speedAttributeModifier1);
						}
						if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier3)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(this.speedAttributeModifier3);
						}
					} else if (flashcap.getSpeedLevel() == 1) {
						if (!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier1)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(this.speedAttributeModifier1);
						}
						if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(this.speedAttributeModifier);
						}
						if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier2)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(this.speedAttributeModifier2);
						}
					} else if (flashcap.getSpeedLevel() == 0) {
						if (!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(this.speedAttributeModifier);
						}
						if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(this.speedAttributeModifier1)) {
							player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(this.speedAttributeModifier1);
						}
					}
				
				//if (flashcap.getTicksCircle() < 60) {
				//flashcap.increaseTicksCircle();
				//} else {
				//	flashcap.setTicksCircle(0);
				//}
				//float x = (float) (player.posX + 2 * Math.cos(2 * 3.141 * (flashcap.getTicksCircle() / 20.0) * 2.2));
				//float z = (float) (player.posZ + 2 * Math.sin(2 * 3.141 * (flashcap.getTicksCircle() / 20.0) * 2.2));
			
				
				if (flashcap.getSpeedLevel() > 3) {
					if (player.motionX != 0 && player.motionZ != 0 && player.isOverWater() && player.world.getBlockState(player.getPosition().down()).getBlock() == Blocks.WATER && player.world.getBlockState(player.getPosition()).getBlock() == Blocks.AIR) {
						
						player.onGround = true;
						player.motionY = 0;
						player.world.spawnParticle(EnumParticleTypes.CLOUD, player.posX, player.posY, player.posZ, 0, 0, 0);
					}
				}
				if (flashcap.isPhasing() && player.world.getBlockState(player.getPosition().down()).getBlock() != Blocks.AIR && player.world.getBlockState(player.getPosition().down()).getBlock() != Blocks.WATER && player.posY == (int)player.posY) {
					player.noClip = true;
					player.motionY = 0;
					
					
					
				} 
				if (player.world.isRemote) {
				if (!flashcap.isArmorWorn()) {
					NetworkHandler.sendToServer(new MessageSpeedAttribute("flash"));
					flashcap.setArmorWorn(true);
				} 
				}
				
				if (flashcap.isInSuperSpeed()) {
					
					if ((player.motionX > -0.02F && player.motionX < 0.02F) && (player.motionZ > -0.02F && player.motionZ < 0.02F) && (player.motionY > -0.1F && player.motionY < 0.1F)) {
						
						if (!flashcap.isTrailActive()) {
							if (flashcap.getTicksStill() < 10) {
								flashcap.increaseTicksStill();
							} else {
								flashcap.setTicksStill(0);
								flashcap.setTrail(true);
								NetworkHandler.sendToServer(new MessageCapToServer(flashcap.isTrailActive(), "flashTrail"));
								
							}
						} 
					} else {
						if (flashcap.getTicksStill() > 0) {
							flashcap.setTicksStill(0);
						}
						if (flashcap.isTrailActive()) {
							flashcap.setTrail(false);
							NetworkHandler.sendToServer(new MessageCapToServer(flashcap.isTrailActive(), "flashTrail"));
		
						}
					}
					
					
				Random rand = player.world.rand;
				Vec3d vec3 = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);
				float distance2 = -0.2F;
				double x2 = player.posX + (distance2 *vec3.x);
				double z2 = player.posZ + (distance2 *vec3.z);
				Vec3d fina = new Vec3d(-0.1 + rand.nextFloat()/4,-0.1 + rand.nextFloat()/4,-0.1 + rand.nextFloat()/4).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2);
				flashcap.addToList(player.getPositionVector().addVector(0, player.height - player.height/3, 0).add(fina));
				
				
				}
				
			} else {
				if (flashcap.isPhasing()) {
					flashcap.setPhasing(false);
				}
				if (flashcap.isInSuperSpeed()) {
					flashcap.setSuperSpeed(false);
				}
				if (flashcap.getSpeedLevel() > 0) {
					flashcap.setSpeedLevel(0);
				}
 				if (flashcap.isArmorWorn()) {
					NetworkHandler.sendToServer(new MessageRemoveSpeedAttribute("flash"));
					player.stepHeight = 0.5F;
					flashcap.setArmorWorn(false);
				}
			}
			
		}
	}
	/*private void tick(World world, Side side)
	  {
	    float tickrate = 20.0F;
	    float slow = 4.0F;

	      tickrate = slow;
	    Utils.updateTickrate(side, tickrate);
	  }
	@SubscribeEvent
	  public void onWorldTick(TickEvent.WorldTickEvent event)
	  {
	    if (event.phase == TickEvent.Phase.END) {
	    	
	      tick(event.world, event.side);
	    }
	  }
	  
	  @SubscribeEvent
	  @SideOnly(Side.CLIENT)
	  public void onClientTick(TickEvent.ClientTickEvent event)
	  {
	    Minecraft mc = Minecraft.getMinecraft();
	    if (mc.isGamePaused()) {
	      Utils.updateClientTickrate(20.0F);
	    } else if (mc.world != null) {
	      this.tick(mc.world, Side.CLIENT);
	    }
	  }*/
}
