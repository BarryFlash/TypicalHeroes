package barryflash.superheroes.capabilities;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

import org.lwjgl.input.Mouse;

import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.network.MessageBatarangSpawn;
import barryflash.superheroes.network.MessageGiantBreakBlock;
import barryflash.superheroes.network.MessageGiantPunch;
import barryflash.superheroes.network.MessageGroundPound;
import barryflash.superheroes.network.MessageGrow;
import barryflash.superheroes.network.MessageShrink;
import barryflash.superheroes.network.MessageWaspBlast;
import barryflash.superheroes.network.MessageWaspBlastSmall;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class AntmanEventHandler {
	/*//public static Method setSize = ReflectionHelper.findMethod(Entity.class, "setSize", "func_70105_a", float.class, float.class);
	private static final UUID uuid = UUID.randomUUID();
	private static final AttributeModifier attributeModifier = new AttributeModifier(uuid, "th:strength", 2030.0D, 1).setSaved(true);
	private boolean small;
	private int tick = 0;
	private int gtick = 0;
	private int hOntick = 0;
	private int gStep = 1;
	private int animationStep;
	private int hOfftick = 0;
	private int animationOffStep;
	private int gpound;
	private boolean big;
	private boolean gpoundCooldownAccess;
	private int gpoundCooldown = 0;
	private boolean debounce;
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onMouseClick(MouseEvent event) {
		
		if (ItemAntmanArmor.isWearingFullSet(Minecraft.getMinecraft().player, ModItems.AntmanHelmet, ModItems.AntmanChest, ModItems.AntmanLegs, ModItems.AntmanFeet)) {
			IAntman antmancap = Minecraft.getMinecraft().player.getCapability(AntmanProvider.ANTMAN_CAP, null);
		if (antmancap.isBig()) {
			
		if (event.getButton() == 0 && event.isButtonstate()) {
			RayTraceResult result = Utils.getMouseOverExtended(10);
			if (result != null) {
				if (result.entityHit != null) {
					NetworkHandler.sendToServer(new MessageGiantPunch(result.entityHit.getEntityId()));
				}
				if (result.typeOfHit == result.typeOfHit.BLOCK) {
					
					NetworkHandler.sendToServer(new MessageGiantBreakBlock(result.getBlockPos()));
				}
			}
			
		}
		}
		}
	}
	@SubscribeEvent
	public void onAttack(LivingHurtEvent event) {
		if (event.getSource().getTrueSource() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
			
			ISuperheroes shcap = player.getCapability(SuperheroesProvider.SUPERHEROES_CAP, null);
			if (shcap.isAntman(player)) {
				
				if (big) {
				
			event.setAmount(event.getAmount() + 13);
				}
				if (small) {
				
			event.setAmount(event.getAmount() + 8);
				}
				if (!small && !big) {
					
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
			if (shcap.isAntman(player)) {
				IAntman antmancap = player.getCapability(AntmanProvider.ANTMAN_CAP, null);
				if (antmancap.isBig()) {
			double addY = 0.4D;
			player.motionY += addY;
			}
				if (antmancap.isSmall()) {
					double addY = 0.2D;
					player.motionY += addY;
					}
			}
		}
	}
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (player.world.isRemote) {
			if (ItemAntmanArmor.isWearingFullSet(player, ModItems.AntmanHelmet, ModItems.AntmanChest, ModItems.AntmanLegs, ModItems.AntmanFeet)) {
				
				IAntman antmancap = player.getCapability(AntmanProvider.ANTMAN_CAP, null);
				if (antmancap.isGroundPoundCooldown()) {
					gpoundCooldown++;
					if (gpoundCooldown > 180) {
						gpoundCooldown = 0;
						antmancap.unsetGroundPoundCooldown();
					}
				}
				if (antmancap.isBig()) {
					
					player.stepHeight = 1;
					big = true;
				} else {
					player.stepHeight = 0.6F;
					big = false;
				}
				if (antmancap.isSmall()) {
				
					small = true;
				} else {
					small = false;
				}
				
				
				if (antmancap.isInGroundPound()) {
					antmancap.setGroundPoundCooldown();
					gpound++;
					if (gpound < 20) {
						 player.motionY += 0.1769999991059303D;
					} else {
						 player.motionY -= 0.2269999991059303D;
					}
					if (gpound > 2 && player.onGround) {
						antmancap.unsetGroundPound();
						gpound = 0;
						NetworkHandler.sendToServer(new MessageGroundPound());
					}
				}
				}
			}
		}
	}
	
	/*@SubscribeEvent
	public static void test(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		float width = player.width;

		float height = player.height;
		width = 0.15F;
		height = 0.45F;
		try {
			
			setSize.invoke(player, width, height);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SubscribeEvent
	public void onAntmanSizeUpdate(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;

		
		IAntman antmancap = player.getCapability(AntmanProvider.ANTMAN_CAP, null);
		
		if (ItemAntmanArmor.isWearingFullSet(player, ModItems.AntmanHelmet, ModItems.AntmanChest, ModItems.AntmanLegs, ModItems.AntmanFeet)) {
			
			
			
			if (antmancap.isHelmetAnimationInProgress()) {
				
				hOntick++;
			
			 if ((hOntick % 5) == 0) {
				 animationStep += 1;
				 antmancap.helmetanimationStep(animationStep);
		        }
			 if (animationStep > 15) {
				 hOntick = 0;
				 animationStep = 0;
				 antmancap.helmetOnanimationEnd();
				 antmancap.setHelmetOn();
			 }
			}
			 if (antmancap.isHelmetOffAnimationInProgress()) {
					
					hOfftick++;
				
				 if ((hOfftick % 5) == 0) {
					 animationOffStep += 1;
					 antmancap.helmetOffanimationStep(animationOffStep);
			        }
				 if (animationOffStep > 15) {
					 hOfftick = 0;
					 animationOffStep = 0;
					 antmancap.helmetOffanimationEnd();
					 antmancap.setHelmetOff();
				 }
			 }
			 if (antmancap.isGiantAnimationInProgress()) {
					
					gtick++;
				

		
					if (gtick > 30) {
					
						antmancap.giantanimationEnd();
						
						gtick = 0;
					}
			 }
			 if (antmancap.isGiantShrinkAnimationInProgress()) {
					
					gtick++;
				
					
					if (gtick > 30) {
						
						antmancap.giantShrinkanimationEnd();
						
						gtick = 0;
					}
			 }

			if (antmancap.isAnimationInProgress()) {
				
				
				
				if (tick > 20) {
					tick = 0;
					antmancap.setAnimationEnd();
					
					
				} else {
					tick++;
				}
			}
			if (antmancap.isGrowAnimationInProgress()) {
				
				tick++;
				
				if (tick > 20) {
					tick = 0;
					antmancap.setGrowAnimationEnd();
					
				}
			}
			if (antmancap.isSmall()) {
				if (!antmancap.isAnimationInProgress()) {
			NetworkHandler.sendToServer(new MessageShrink());
			player.width = 0.2F;
			player.height = 0.4F;
			
			player.eyeHeight = player.getDefaultEyeHeight() - 1.3F;
			player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + player.width, player.getEntityBoundingBox().minY + player.height, player.getEntityBoundingBox().minZ + player.width));
			
				}
				} else 	if (antmancap.isBig()) {
					//if (!antmancap.isAnimationInProgress()) {

					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 1.8, player.getEntityBoundingBox().minY + 5.5, player.getEntityBoundingBox().minZ + 1.8));
						//}
				} else {	
					player.width = 0.6F;
					player.height = 1.8F;
					
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + player.width, player.getEntityBoundingBox().minY + player.height, player.getEntityBoundingBox().minZ + player.width));
				player.eyeHeight = player.getDefaultEyeHeight();
				
			}
			
		} else if (antmancap.isSmall() || antmancap.isBig()){
			
			player.eyeHeight = player.getDefaultEyeHeight();
			antmancap.resetSize();
		}
	}
	/*@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(MouseEvent event)
	{ 
	    if (event.getButton() == 0 && event.isButtonstate())
	    {
	        Minecraft mc = Minecraft.getMinecraft();
	        EntityPlayer thePlayer = mc.thePlayer;
	        if (thePlayer != null) {

	    		if (ItemAntmanArmor.isWearingFullSet(thePlayer, ModItems.AntmanHelmet, ModItems.AntmanChest, ModItems.AntmanLegs, ModItems.AntmanFeet)) {
	    			IAntman antmancap = thePlayer.getCapability(AntmanProvider.ANTMAN_CAP, null);
	    			if (antmancap.isBig()) {
	        	RayTraceResult mov = getMouseOverExtended(); 
                 
                 if (mov != null)
                 {
                     
                         if (mov.entityHit != null )
                         {
                             NetworkHandler.sendToServer(new MessageGiantReach(mov.entityHit.getEntityId()));
                         }
                     }
                 
                 }
	    		}
	        }
	    }
	}
	public static RayTraceResult getMouseOverExtended()
	{
	    Minecraft mc = FMLClientHandler.instance().getClient();
	    Entity theRenderViewEntity = mc.getRenderViewEntity();
	    AxisAlignedBB theViewBoundingBox = new AxisAlignedBB(
	            theRenderViewEntity.posX-0.5D,
	            theRenderViewEntity.posY-0.0D,
	            theRenderViewEntity.posZ-0.5D,
	            theRenderViewEntity.posX+0.5D,
	            theRenderViewEntity.posY+1.5D,
	            theRenderViewEntity.posZ+0.5D
	            );
	    RayTraceResult returnMOP = null;
	    if (mc.world != null)
	    {
	        double var2 = 6;
	        returnMOP = theRenderViewEntity.rayTrace(var2, 0);
	        double calcdist = var2;
	        Vec3d pos = theRenderViewEntity.getPositionEyes(0);
	        var2 = calcdist;
	        if (returnMOP != null)
	        {
	            calcdist = returnMOP.hitVec.distanceTo(pos);
	        }
	         
	        Vec3d lookvec = theRenderViewEntity.getLook(0);
	        Vec3d var8 = pos.addVector(lookvec.x * var2, 
	              lookvec.y * var2, 
	              lookvec.z * var2);
	        Entity pointedEntity = null;
	        float var9 = 3.0F;
	        @SuppressWarnings("unchecked")
	        List<Entity> list = mc.world.getEntitiesWithinAABBExcludingEntity(
	              theRenderViewEntity, 
	              theViewBoundingBox.grow(
	                    lookvec.x * var2, 
	                    lookvec.y * var2, 
	                    lookvec.z * var2).expand(var9, var9, var9));
	        double d = calcdist;
	            
	        for (Entity entity : list)
	        {
	            if (entity.canBeCollidedWith())
	            {
	                float bordersize = entity.getCollisionBorderSize();
	                AxisAlignedBB aabb = new AxisAlignedBB(
	                      entity.posX-entity.width/2, 
	                      entity.posY, 
	                      entity.posZ-entity.width/2, 
	                      entity.posX+entity.width/2, 
	                      entity.posY+entity.height, 
	                      entity.posZ+entity.width/2);
	                aabb.expand(bordersize, bordersize, bordersize);
	                RayTraceResult mop0 = aabb.calculateIntercept(pos, var8);
	                    
	                if (aabb.contains(pos))
	                {
	                    if (0.0D < d || d == 0.0D)
	                    {
	                        pointedEntity = entity;
	                        d = 0.0D;
	                    }
	                } else if (mop0 != null)
	                {
	                    double d1 = pos.distanceTo(mop0.hitVec);
	                        
	                    if (d1 < d || d == 0.0D)
	                    {
	                        pointedEntity = entity;
	                        d = d1;
	                    }
	                }
	            }
	        }
	           
	        if (pointedEntity != null && (d < calcdist || returnMOP == null))
	        {
	             returnMOP = new RayTraceResult(pointedEntity);
	        }
	    }
	    return returnMOP;
	}	
	@SubscribeEvent
	public void onFall(LivingFallEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
		
			if (big || small) {
				
				event.setCanceled(true);
			} else {
				event.setCanceled(false);
			}
		}
		
	}
	*/
}
