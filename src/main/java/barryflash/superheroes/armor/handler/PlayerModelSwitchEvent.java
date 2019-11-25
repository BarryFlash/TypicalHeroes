package barryflash.superheroes.armor.handler;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.AntmanProvider;
import barryflash.superheroes.capabilities.CyborgProvider;
import barryflash.superheroes.capabilities.FlashProvider;
import barryflash.superheroes.capabilities.FusionChamberProvider;
import barryflash.superheroes.capabilities.HulkProvider;
import barryflash.superheroes.capabilities.IAntman;
import barryflash.superheroes.capabilities.ICyborg;
import barryflash.superheroes.capabilities.IFlash;
import barryflash.superheroes.capabilities.IFusionChamber;
import barryflash.superheroes.capabilities.IHulk;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.ILoki;
import barryflash.superheroes.capabilities.IQuiver;
import barryflash.superheroes.capabilities.IShazam;
import barryflash.superheroes.capabilities.ISuperman;
import barryflash.superheroes.capabilities.IThanos;
import barryflash.superheroes.capabilities.IWasp;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.LokiProvider;
import barryflash.superheroes.capabilities.QuiverProvider;
import barryflash.superheroes.capabilities.ShazamProvider;
import barryflash.superheroes.capabilities.SupermanProvider;
import barryflash.superheroes.capabilities.ThanosProvider;
import barryflash.superheroes.capabilities.WaspProvider;
import barryflash.superheroes.client.render.RenderHero;
import barryflash.superheroes.client.render.RenderHulk;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemBlackWidowArmor;
import barryflash.superheroes.items.armor.ItemCaptainAmericaArmor;
import barryflash.superheroes.items.armor.ItemCyborgArmor;
import barryflash.superheroes.items.armor.ItemFlashArmor;
import barryflash.superheroes.items.armor.ItemGeneralZodArmor;
import barryflash.superheroes.items.armor.ItemHawkeyeArmor;
import barryflash.superheroes.items.armor.ItemHulkArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50ArcReactorArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemLokiArmor;
import barryflash.superheroes.items.armor.ItemShazamArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemThanosArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.items.armor.SuperheroArmor;
import barryflash.superheroes.models.ModelCyborgSonarCannon;
import barryflash.superheroes.models.ModelCyborgSonarCannonGlow;
import barryflash.superheroes.models.ModelHero;
import barryflash.superheroes.models.ModelHulk;
import barryflash.superheroes.models.ModelIronManMark50;
import barryflash.superheroes.models.ModelIronManMark50Cannons;
import barryflash.superheroes.models.ModelIronManMark50KnockbackFists;
import barryflash.superheroes.models.ModelIronManMark50Shield;
import barryflash.superheroes.models.ModelIronManMark50Sword;
import barryflash.superheroes.models.ModelRightArm;
import barryflash.superheroes.models.ModelShazamGlow;
import barryflash.superheroes.models.ModelThanosGauntlet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerModelSwitchEvent {
	public static final RenderHero hero = new RenderHero(Minecraft.getMinecraft().getRenderManager(), new ModelHero(0), 0.1F);
	private final RenderHulk hulk = new RenderHulk(Minecraft.getMinecraft().getRenderManager(), new ModelHulk(0), 0.1F);

	@SubscribeEvent
	public void onRenderPlayer(RenderPlayerEvent.Pre event) {	
		EntityPlayer player = event.getEntityPlayer();
		IFusionChamber fccap = player.getCapability(FusionChamberProvider.FUSION_CHAMBER_CAP, null);
		IQuiver qcap = player.getCapability(QuiverProvider.QUIVER_CAP, null);
		if (qcap.isWearingQuiver() || ItemGeneralZodArmor.isWearingFullSet(player) || ItemLokiArmor.isWearingFullSet(player) || ItemHawkeyeArmor.isWearingFullSet(player) || ItemBlackWidowArmor.isWearingFullSet(player) || ItemCyborgArmor.isWearingFullSet(player) || ItemCaptainAmericaArmor.isWearingFullSet(player) || ItemFlashArmor.isWearingFlash(player) || ItemThorArmor.isWearingFullSet(player) || ItemHulkArmor.isWearingHulk(player) || ItemShazamArmor.isWearingShazam(player) || ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots) || ItemWonderWomanArmor.isWearingFullSet(player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots) || ItemBatmanArmor.isWearingFullSet(player, ModItems.BatmanCowl, ModItems.BatmanChest, ModItems.BatmanLeggings, ModItems.BatmanBoots) || ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots) || ItemIronmanMark50ArcReactorArmor.isWearingReactor(player, ModItems.IronManArcReactor)) {
			
		
	
	event.setCanceled(true);
	
	
	
	 IWasp waspcap = player.getCapability(WaspProvider.WASP_CAP, null);
	 IAntman antmancap = player.getCapability(AntmanProvider.ANTMAN_CAP, null);
	 /*
	if (ItemThanosArmor.isWearingFullSet(event.getEntityPlayer(), ModItems.ThanosHelmet, ModItems.ThanosChest, ModItems.ThanosLeggings, ModItems.ThanosBoots)) {

		GlStateManager.pushMatrix();
	GlStateManager.scale(1.5F, 1.5F, 1.5F);
	hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
	GlStateManager.popMatrix();
	
	} else if (ItemWaspArmor.isWearingFullSet(player, ModItems.WaspHelmet, ModItems.WaspChest, ModItems.WaspLegs, ModItems.WaspFeet)) {
		if (waspcap.isSmall()) {

			if (waspcap.isAnimationInProgress()) {
				wstick++;
				if (wstick > 3) {
					wsSize += 1;
					wstick = 0;
				}
				GlStateManager.pushMatrix();
				double scale = wsSize * 0.08;
				
				GlStateManager.scale(1 - scale, 1 - scale, 1 - scale);
				hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
				GlStateManager.popMatrix();
			}else {
				wsSize = 0;
				wstick = 0;
		GlStateManager.pushMatrix();
	GlStateManager.scale(0.2F, 0.2F, 0.2F);
	hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
	GlStateManager.popMatrix();
			}
		
	
	

	}
	if (!waspcap.isSmall()) {
		if (waspcap.isGrowAnimationInProgress()) {
			wgtick++;
			if (wgtick > 2) {
				wgSize += 1;
				wgtick = 0;
			}
			GlStateManager.pushMatrix();
			double scale = wgSize * 0.08;
			GlStateManager.scale(0.2 + scale, 0.2 + scale, 0.2 + scale);
			hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
			GlStateManager.popMatrix();
			}else {
				wgSize = 0;
				wgtick = 0;
				GlStateManager.pushMatrix();
				GlStateManager.scale(1.0F, 1.0F, 1.0F);
				hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
				GlStateManager.popMatrix();
						}
		}
	} /*else if (ItemAntmanArmor.isWearingFullSet(player, ModItems.AntmanHelmet, ModItems.AntmanChest, ModItems.AntmanLegs, ModItems.AntmanFeet)) {
		if (antmancap.isSmall()) {
			
			
			if (antmancap.isAnimationInProgress()) {
				stick++;
				if (stick > 3) {
					sSize += 1;
					stick = 0;
				}
				GlStateManager.pushMatrix();
				double scale = sSize * 0.08;
				
				GlStateManager.scale(1 - scale, 1 - scale, 1 - scale);
				hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
				GlStateManager.popMatrix();
			
		}else {
			stick = 0;
			sSize = 0;
				//GlStateManager.pushMatrix();
				//GlStateManager.scale(0.2F, 0.2F, 0.2F);
		hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
		//GlStateManager.popMatrix();
			}
		
		}
		if (antmancap.isNormalSize() && !antmancap.isGrowAnimationInProgress() && !antmancap.isGiantShrinkAnimationInProgress()) {
			GlStateManager.pushMatrix();
			
			GlStateManager.scale(1.0F, 1.0F, 1.0F);
			hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
			GlStateManager.popMatrix();
		}
		if (antmancap.isBig()) {
			if (antmancap.isGiantAnimationInProgress()) {
					tick++;
					if (tick > 3) {
						Size += 2;
						tick = 0;
					}
					GlStateManager.pushMatrix();
					
					double scale = 0.08 * Size;
					GlStateManager.scale(1 + scale, 1 + scale, 1 + scale);
					hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
					GlStateManager.popMatrix();
				
				} else {
					Size = 0;
					tick = 0;
					GlStateManager.pushMatrix();
					
					GlStateManager.scale(3.0F, 3.0F, 3.0F);
					hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
					GlStateManager.popMatrix();
				}
		} else {
			if (antmancap.isGiantShrinkAnimationInProgress()) {
					gstick++;
					if (gstick > 3) {
						gsSize += 2;
						gstick = 0;
					}
					GlStateManager.pushMatrix();
					double scale = 0.08 * gsSize;
					
					GlStateManager.scale(3 - scale, 3 - scale, 3 - scale);
					hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
					GlStateManager.popMatrix();
				
				} else {
					gsSize = 0;
					gstick = 0;
				}
		}
	
			
				if (antmancap.isGrowAnimationInProgress()) {
				sgtick++;
				if (sgtick > 2) {
					sgSize += 1;
					sgtick = 0;
				}
					GlStateManager.pushMatrix();
					double scale = 0.08 * sgSize;
					GlStateManager.scale(0.2 + scale, 0.2 + scale, 0.2 + scale);
					hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
					GlStateManager.popMatrix();
				
				}	else {
					sgSize = 0;
					sgtick = 0;
				}
			
		
		
		
		}else {*/
		ISuperman supercap = player.getCapability(SupermanProvider.SUPERMAN_CAP, null);
		IHulk hulkcap = player.getCapability(HulkProvider.HULK_CAP, null);
		IFlash flashcap = player.getCapability(FlashProvider.FLASH_CAP, null);
		
			if (ItemHulkArmor.isWearingHulk(player) && hulkcap.isHulk() || hulkcap.isTransforming()) {
				
				if (hulkcap.isTransforming() || hulkcap.isDetransforming()) {
				GlStateManager.pushMatrix();
					
		        	GlStateManager.enableBlend();
		        	GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		        	GlStateManager.scale(0.8F + hulkcap.getSize(), 0.8F + hulkcap.getSize(), 0.8F + hulkcap.getSize());
					GlStateManager.color(0.5F + hulkcap.getAlpha(), 0.5F + hulkcap.getAlpha(), 0.5F + hulkcap.getAlpha(), 0.5F + hulkcap.getAlpha());
			
				hulk.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
				 GlStateManager.disableBlend();
				 GlStateManager.color(1, 1, 1, 1);
			        GlStateManager.popMatrix();
				} else {
					hulk.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0625F, event.getPartialRenderTick());
				}
			} 
			if (ItemHulkArmor.isWearingHulk(player) && hulkcap.isHumanTransforming()){

					GlStateManager.pushMatrix();
		        	GlStateManager.enableBlend();
		        	GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		        	GlStateManager.color(0.1F + hulkcap.getHAlpha(), 0.1F + hulkcap.getHAlpha(), 0.1F + hulkcap.getHAlpha(), 0.1F + hulkcap.getHAlpha());
					hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0.0F, event.getPartialRenderTick());
					GlStateManager.disableBlend();
					GlStateManager.color(1, 1, 1, 1);
				    GlStateManager.popMatrix();
			} else {
				if (!hulkcap.isHumanTransforming() && !hulkcap.isDetransforming() && !hulkcap.isTransforming() && !hulkcap.isHulk()) {
					if (supercap.isAffectedByKryptonite()) {
						GlStateManager.pushMatrix();
						GlStateManager.color(0.4F, 0.6F, 0.4F);
						hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
						GlStateManager.color(1, 1, 1, 1);
					    GlStateManager.popMatrix();
					} else {
						if (flashcap.isPhasing()) {
							Random rand = player.world.rand;
							Vec3d fina = new Vec3d(0,0 + rand.nextFloat()/22,-0.1 + rand.nextFloat()/12).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2);
							GlStateManager.pushMatrix();
							GlStateManager.enableBlend();
							GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
							hero.doRender((AbstractClientPlayer) player, event.getX() + fina.x, event.getY() + fina.y, event.getZ() + fina.z, 0, event.getPartialRenderTick());
							GlStateManager.disableBlend();
							GlStateManager.popMatrix();
						} else {
							hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
							
						}
					}
				}
			}
		//}
		} else if (fccap.isInside()){
			event.setCanceled(true);
			GlStateManager.pushMatrix();
			GlStateManager.scale(0.8F, 0.8F, 0.8F);
			hero.doRender((AbstractClientPlayer) player, event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
			GlStateManager.popMatrix();
		} else {
			event.setCanceled(false);
		}
	}
	@SubscribeEvent
	public void onRenderHand(RenderHandEvent event) {
		
		
		EntityPlayerSP player = Minecraft.getMinecraft().player;
		 RenderLivingBase renderer = (RenderLivingBase) Minecraft.getMinecraft().getRenderManager().getEntityRenderObject(player);
				ModelIronManMark50 model = new ModelIronManMark50(0.0625F); 
				ModelIronManMark50Shield shieldmodel = new ModelIronManMark50Shield(0.0625F);
				ModelIronManMark50Sword swordmodel = new ModelIronManMark50Sword(0.0625F);
				ModelIronManMark50KnockbackFists knockbackmodel = new ModelIronManMark50KnockbackFists(0.0625F);
				ModelIronManMark50Cannons cannonsmodel = new ModelIronManMark50Cannons(0.0625F);
				ModelThanosGauntlet gauntletmodel = new ModelThanosGauntlet(0.0625F);
				ModelRightArm rightArmModel = new ModelRightArm(0.0625F);
				ModelBiped heromodel =  (ModelBiped) renderer.getMainModel();
				ModelHulk hulkModel = new ModelHulk(0.0625F);
				ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
				ModelShazamGlow shazamglowModel = new ModelShazamGlow(0.0625F);
				ModelCyborgSonarCannon sonarCannonModel = new ModelCyborgSonarCannon(0.0625F);
				ModelCyborgSonarCannonGlow sonarCannonGlowModel = new ModelCyborgSonarCannonGlow(0.0625F);
				IIronman ironmancap = player.getCapability(IronmanProvider.IRONMAN_CAP, null);
				//IWasp waspcap = player.getCapability(WaspProvider.WASP_CAP, null);
				ISuperman supercap = player.getCapability(SupermanProvider.SUPERMAN_CAP, null);
				IShazam shazamcap = player.getCapability(ShazamProvider.SHAZAM_CAP, null);
				IHulk hulkcap = player.getCapability(HulkProvider.HULK_CAP, null);
				ICyborg cyborgcap = player.getCapability(CyborgProvider.CYBORG_CAP, null);
				
				if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
					if (supercap.isUsingHeatVision()) {
						event.setCanceled(true);
					}
					if (!chest.isEmpty() && chest.getItem() == ModItems.HulkChest && hulkcap.isHulk()) {
						if (player.inventory.getCurrentItem().isEmpty()) {
							event.setCanceled(true);
							GlStateManager.pushMatrix();
							if (player.isSwingInProgress) {
								
								GlStateManager.translate(0.68F, -0.8F, -0.9F);
								
								GlStateManager.rotate(-90.0F, 8.0F * (player.swingProgress*3), -2.6F/ (player.swingProgress*3),-2.4F * (player.swingProgress*3));
								
							} else {
							GlStateManager.translate(0.45F, -1.0F, -1.3F);
							GlStateManager.rotate(-60.0F, 5.0F, -2.6F, 3.9F);
							GlStateManager.rotate(70.0F, 0.0F, 1.0F, 0.0F);
							}
						
						GlStateManager.enableLighting();
								Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/models/armor/hulk.png"));
							
							
							hulkModel.right_arm_base.render(0.0625F);
							GlStateManager.disableLighting();
							hulkModel.right_arm_base.showModel = true;
							GlStateManager.popMatrix();
						} 
					}else 
					if (!chest.isEmpty() && chest.getItem() == ModItems.HawkeyeChest || chest.getItem() == ModItems.LokiChest  || chest.getItem() == ModItems.GeneralZodChest || chest.getItem() == ModItems.BlackWidowChest || chest.getItem() == ModItems.CyborgChest || chest.getItem() == ModItems.FlashChest || chest.getItem() == ModItems.CaptainAmericaChest || chest.getItem() == ModItems.FlashChest && chest.getItem() == ModItems.ThorChest || chest.getItem() == ModItems.ShazamChest || chest.getItem() == ModItems.BatmanChest || chest.getItem() == ModItems.IronManMk50Chest || chest.getItem() == ModItems.SupermanChest || chest.getItem() == ModItems.WonderWomanChestplate) {
						ModelBiped armorModel = chest.getItem().getArmorModel((EntityLivingBase)player, chest, EntityEquipmentSlot.CHEST, heromodel);
						if (player.inventory.getCurrentItem().isEmpty() && !supercap.isUsingHeatVision()) {
							
						event.setCanceled(true);
						float brightnessX = OpenGlHelper.lastBrightnessX;
						float brightnessY = OpenGlHelper.lastBrightnessY;
						
						
			
			
			if (ironmancap.isShieldActivated()) {
				GlStateManager.pushMatrix();
				GlStateManager.translate(0.4F, -0.5F, -0.1F);
				GlStateManager.rotate(10.0F, 1.0F, 20.0F, 1.0F);
				GlStateManager.rotate(-120.0F, -3.0F, -1.5F, 5.0F);
				
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/models/armor/IronMan_layer_1.png"));
			
				
				shieldmodel.shield.render(0.0625F);
				shieldmodel.shield_1.render(0.0625F);
				shieldmodel.shield_2.render(0.0625F);
				shieldmodel.shield_3.render(0.0625F);
				shieldmodel.shield_4.render(0.0625F);
				shieldmodel.shield_5.render(0.0625F);
				shieldmodel.shield_6.render(0.0625F);
				shieldmodel.shield_7.render(0.0625F);
				shieldmodel.shield_8.render(0.0625F);
				shieldmodel.shield_9.render(0.0625F);
				shieldmodel.shield_10.render(0.0625F);
				shieldmodel.shield_11.render(0.0625F);
				shieldmodel.shield_12.render(0.0625F);
				shieldmodel.shield_13.render(0.0625F);
				shieldmodel.shield_14.render(0.0625F);
				shieldmodel.shield_15.render(0.0625F);
				shieldmodel.shield_16.render(0.0625F);
				shieldmodel.shield_17.render(0.0625F);
				shieldmodel.shield_18.render(0.0625F);
				shieldmodel.shield_19.render(0.0625F);
				shieldmodel.shield_20.render(0.0625F);
				shieldmodel.shield_21.render(0.0625F);
				shieldmodel.shield_22.render(0.0625F);
				shieldmodel.shield_23.render(0.0625F);
				shieldmodel.shield_24.render(0.0625F);
				shieldmodel.shield_25.render(0.0625F);
				shieldmodel.shield_26.render(0.0625F);
				shieldmodel.shield_27.render(0.0625F);
				shieldmodel.shield_28.render(0.0625F);
				shieldmodel.shield_29.render(0.0625F);
				shieldmodel.shield_30.render(0.0625F);
				shieldmodel.shield_31.render(0.0625F);
				shieldmodel.shield_32.render(0.0625F);
				shieldmodel.shield_33.render(0.0625F);
				shieldmodel.shield_34.render(0.0625F);
				shieldmodel.shield_35.render(0.0625F);
				shieldmodel.shield_36.render(0.0625F);
				shieldmodel.shield_37.render(0.0625F);
				shieldmodel.shield_38.render(0.0625F);
				shieldmodel.shield_41.render(0.0625F);
				shieldmodel.shield_42.render(0.0625F);
				shieldmodel.shield_43.render(0.0625F);
				shieldmodel.shield_44.render(0.0625F);
				shieldmodel.shield_45.render(0.0625F);
				shieldmodel.shield_46.render(0.0625F);
				shieldmodel.shield_47.render(0.0625F);
				shieldmodel.shield_48.render(0.0625F);
				shieldmodel.shield_49.render(0.0625F);
				shieldmodel.shield_50.render(0.0625F);
				shieldmodel.shield_51.render(0.0625F);
				shieldmodel.shield_52.render(0.0625F);
			
				
				
				GlStateManager.popMatrix();
			}
				
			if (ironmancap.repulsorsActivated()) {
				
				if (ironmancap.shotFromLeftArm()) {
					GlStateManager.pushMatrix();
					GlStateManager.translate(-0.48F, 0.02F, -0.2F);
					
					GlStateManager.rotate(-100.0F, 1.0F, -1.6F, 0.6F);
					armorModel.bipedLeftArm.rotateAngleX = 0.6F;
					armorModel.bipedLeftArm.rotateAngleY = -4.9F;
					armorModel.bipedLeftArm.rotateAngleZ = 0F;
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(chest.getItem().getArmorTexture(chest, player, EntityEquipmentSlot.CHEST, null)));
					
					
					armorModel.bipedLeftArm.render(0.0625F);
					armorModel.bipedLeftArm.showModel = true;
					
					GlStateManager.popMatrix();
					
					//armorModel.bipedLeftArm.offsetZ = -0.05F;
				}
				
			
			
			}
			/*if (waspcap.areBlastersActive()) {
				
				if (waspcap.shotFromLeftArm()) {
					GlStateManager.pushMatrix();
					GlStateManager.translate(-1.1F, 1.05F, 0.0);
					GlStateManager.rotate(-10, 10, -3.8F, -0.6F);
					armorModel.bipedLeftArm.rotateAngleX = 1.3F;
					armorModel.bipedLeftArm.rotateAngleZ = -1.0F;
					armorModel.bipedLeftArm.rotateAngleY = 4.3F;
					
					GlStateManager.translate(0, 0.4, 0.35);
					GlStateManager.translate(0.18F, -1.6F, -1.0F);
				
				GlStateManager.rotate(-60.0F, 15.0F, -3.6F, 7.4F);
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(chest.getItem().getArmorTexture(chest, player, EntityEquipmentSlot.CHEST, null)));
					
					
					armorModel.bipedLeftArm.render(0.0625F);
					armorModel.bipedLeftArm.showModel = true;
					GlStateManager.popMatrix();
				}
				
				
			
			}*/
			if (shazamcap.isShazam()) {
				
				if (shazamcap.isShootingLightningBeam()) {
					GlStateManager.pushMatrix();
					GlStateManager.translate(-1.1F, 1.05F, 0.0);
					GlStateManager.rotate(-10, 10, -3.8F, -0.6F);
					armorModel.bipedLeftArm.rotateAngleX = 1.2F;
					armorModel.bipedLeftArm.rotateAngleZ = -1.0F;
					armorModel.bipedLeftArm.rotateAngleY = 4.3F;
					heromodel.bipedLeftArm.rotateAngleX = 1.2F;
					heromodel.bipedLeftArm.rotateAngleZ = -1.0F;
					heromodel.bipedLeftArm.rotateAngleY = 4.3F;
					GlStateManager.translate(0, 0.4, 0.35);
					GlStateManager.translate(0.18F, -1.6F, -1.0F);
				
				GlStateManager.rotate(-60.0F, 15.0F, -3.6F, 7.4F);
				
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(chest.getItem().getArmorTexture(chest, player, EntityEquipmentSlot.CHEST, null)));
					
					
					armorModel.bipedLeftArm.render(0.0625F);
					if (chest.getItem() == ModItems.ShazamChest) {
						shazamglowModel.bipedLeftArm.rotateAngleX = 1.2F;
						shazamglowModel.bipedLeftArm.rotateAngleZ = -1.0F;
						shazamglowModel.bipedLeftArm.rotateAngleY = 4.3F;
						GlStateManager.pushMatrix();
				
						OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
						shazamglowModel.bipedLeftArm.render(0.0625F);
						OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, brightnessX, brightnessY);
						GlStateManager.popMatrix();
					}
					Minecraft.getMinecraft().renderEngine.bindTexture(((AbstractClientPlayer)Minecraft.getMinecraft().player).getLocationSkin());
					heromodel.bipedLeftArm.render(0.0625F);
					armorModel.bipedLeftArm.showModel = true;
					GlStateManager.popMatrix();
				}
				
				
			
			}
			GlStateManager.pushMatrix();
			if (cyborgcap.isSonarCannon()) {
				
				GlStateManager.translate(-0.2F, 0.2F, -0.4F);
				GlStateManager.rotate(50, -25, 2F, 25F);
			
				
			
			
			} else {
				armorModel.bipedRightArm.rotateAngleX = 0F;
				armorModel.bipedRightArm.rotateAngleZ = 0;
				armorModel.bipedRightArm.rotateAngleY = 0;
			}
			if (shazamcap.isShazam()) {
				if (shazamcap.isShootingLightningBeam()) {
					
					GlStateManager.translate(-0.2F, 0.2F, -0.4F);
					GlStateManager.rotate(50, -25, 2F, 25F);
				
					
				
				
				} else {
					armorModel.bipedRightArm.rotateAngleX = 0F;
					armorModel.bipedRightArm.rotateAngleZ = 0;
					armorModel.bipedRightArm.rotateAngleY = 0;
				}
			} else {
				armorModel.bipedRightArm.rotateAngleX = 0F;
				armorModel.bipedRightArm.rotateAngleZ = 0;
				armorModel.bipedRightArm.rotateAngleY = 0;
			}
			/*if (waspcap.areBlastersActive()) {
				if (waspcap.shotFromRightArm()) {
					
					GlStateManager.translate(0.0F, 1.15F, 0.0F);
					GlStateManager.rotate(-10, 4, 2.8F, -0.4F);
					rightArmModel.field_78112_f.rotateAngleX = 0.0F;
					rightArmModel.field_78112_f.rotateAngleZ = 0.4F;
					rightArmModel.field_78112_f.rotateAngleY = 5.2F;
					armorModel.bipedRightArm.rotateAngleX = 0.0F;
					armorModel.bipedRightArm.rotateAngleZ = 0.4F;
					armorModel.bipedRightArm.rotateAngleY = 5.2F;
					armorModel.bipedRightArm.showModel = true;

					GlStateManager.translate(0, 0.6, -0.6F);
					GlStateManager.translate(0.68F, -0.9F, 0F);
				
					GlStateManager.rotate(-60.0F, 15.0F, -18.6F, 8.4F);
					
				
				
				} else {
					armorModel.bipedRightArm.rotateAngleX = 0F;
					armorModel.bipedRightArm.rotateAngleZ = 0;
					armorModel.bipedRightArm.rotateAngleY = 0;
				}
			} else {
				armorModel.bipedRightArm.rotateAngleX = 0F;
				armorModel.bipedRightArm.rotateAngleZ = 0;
				armorModel.bipedRightArm.rotateAngleY = 0;
			}
			 */
			if (ironmancap.repulsorsActivated()) {
				
			if (ironmancap.shotFromRightArm()) {

				GlStateManager.translate(0.0F, 0.05F, 0.0);
				GlStateManager.rotate(-10, 4, -2.8F, -0.4F);
				armorModel.bipedRightArm.rotateAngleX = 0.5F;
				armorModel.bipedRightArm.showModel = true;
				
				GlStateManager.translate(0, 0.6, 0.2);
				GlStateManager.translate(0.68F, -1.0F, -0.6F);
			
			GlStateManager.rotate(-60.0F, 5.0F, -2.6F, 3.4F);
			armorModel.bipedRightArm.rotateAngleY = 3F;
				//armorModel.bipedRightArm.offsetX = 0.05F;
			}
			}
			
			if (!ironmancap.repulsorsActivated() || !shazamcap.isShootingLightningBeam()) {
				if (player.isSwingInProgress && !ironmancap.repulsorsActivated()) {
					//if (!waspcap.areBlastersActive()) {
					GlStateManager.translate(0.68F, -0.8F, -0.9F);
					
					GlStateManager.rotate(-90.0F, 8.0F * (player.swingProgress*3), -2.6F/ (player.swingProgress*3),-2.4F * (player.swingProgress*3));
					//}
				} else if (!ironmancap.shotFromRightArm()){
				GlStateManager.translate(0.4F, -1.0F, -0.8F);
				GlStateManager.rotate(-60.0F, 5.0F, -2.6F, 3.9F);
				GlStateManager.rotate(70.0F, 0.0F, 1.0F, 0.0F);
				}
			}
			GlStateManager.enableLighting();
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(chest.getItem().getArmorTexture(chest, player, EntityEquipmentSlot.CHEST, null)));
				
				
				armorModel.bipedRightArm.render(0.0625F);
				GlStateManager.disableLighting();
				armorModel.bipedRightArm.showModel = true;
				//System.out.println(armorModel.bipedRightArm.childModels);
				if (chest.getItem() == ModItems.ShazamChest && shazamcap.isShazam()) {
		
			
					OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
					shazamglowModel.bipedRightArm.render(0.0625F);
					OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, brightnessX, brightnessY);
				
				}
				if (cyborgcap.isSonarCannon()) {

					GlStateManager.enableLighting();
					sonarCannonModel.bipedRightArm.render(0.0625F);
					GlStateManager.disableLighting();
					GlStateManager.enableBlend();
					GlStateManager.color(1, 1, 1, 0.8F);
					OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
					sonarCannonGlowModel.bipedRightArm.render(0.0625F);
					OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, brightnessX, brightnessY);
					GlStateManager.color(1, 1, 1, 1F);
					GlStateManager.disableBlend();

				}
				if (ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
				if (ironmancap.areKnockbackFistsActivated()) {
					GlStateManager.enableLighting();
					knockbackmodel.bipedRightArm.render(0.0625F);
					GlStateManager.disableLighting();
				}
				if (ironmancap.isSwordActivated()) {
					GlStateManager.enableLighting();
					swordmodel.bipedRightArm.render(0.0625F);
					GlStateManager.disableLighting();
				}
				if (ironmancap.areCannonsActivated()) {
					GlStateManager.enableLighting();
					cannonsmodel.bipedRightArm.render(0.0625F);
					GlStateManager.disableLighting();
				}
				}
				
				if (!ironmancap.shotFromRightArm()) {
				Minecraft.getMinecraft().renderEngine.bindTexture(((AbstractClientPlayer)Minecraft.getMinecraft().player).getLocationSkin());
				GlStateManager.enableLighting();
				rightArmModel.field_78112_f.render(0.0625F);
				GlStateManager.disableLighting();
				}
				
				
				GlStateManager.popMatrix();
				
				
				} /*else if (player.inventory.getCurrentItem().getItem() == ModItems.thanos_gauntlet) {
					IThanos thanoscap = player.getCapability(ThanosProvider.THANOS_CAP, null);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_1);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_2);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_3);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_4);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_5);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_6);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_7);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_8);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_9);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_10);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_11);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_12);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_13);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_14);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_15);
					armorModel.bipedRightArm.addChild(gauntletmodel.rightarm_16);
				
					GlStateManager.pushMatrix();
					
				if (player.isSwingInProgress) {
					GlStateManager.translate(0.68F, -0.8F, -0.9F);
					
					GlStateManager.rotate(-90.0F, 8.0F * (player.swingProgress*3), -2.6F/ (player.swingProgress*3),-2.4F * (player.swingProgress*3));
				}
				else {
					GlStateManager.translate(0.4F, -1.0F, -0.8F);
					
					GlStateManager.rotate(-60.0F, 5.0F, -2.6F, 3.9F);
					GlStateManager.rotate(70.0F, 0.0F, 1.0F, 0.0F);
				}
			
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 40.0F, 240.0F);
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(chest.getItem().getArmorTexture(chest, player, EntityEquipmentSlot.CHEST, null)));
				GlStateManager.enableLighting();
				
				armorModel.bipedRightArm.render(0.0625F);
				
				GlStateManager.disableLighting();
				GlStateManager.popMatrix();
				}*/
				
					} else {
						event.setCanceled(false);
					}
	
	}
	}
	
}
