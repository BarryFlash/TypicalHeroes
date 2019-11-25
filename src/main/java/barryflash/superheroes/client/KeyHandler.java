package barryflash.superheroes.client;

import java.util.List;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.capabilities.AntmanProvider;
import barryflash.superheroes.capabilities.BatmanProvider;
import barryflash.superheroes.capabilities.BlackWidowProvider;
import barryflash.superheroes.capabilities.CyborgProvider;
import barryflash.superheroes.capabilities.FlashProvider;
import barryflash.superheroes.capabilities.HulkProvider;
import barryflash.superheroes.capabilities.IAntman;
import barryflash.superheroes.capabilities.IBatman;
import barryflash.superheroes.capabilities.IBlackWidow;
import barryflash.superheroes.capabilities.ICyborg;
import barryflash.superheroes.capabilities.IFlash;
import barryflash.superheroes.capabilities.IHulk;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IKeys;
import barryflash.superheroes.capabilities.ILoki;
import barryflash.superheroes.capabilities.IQuiver;
import barryflash.superheroes.capabilities.IShazam;
import barryflash.superheroes.capabilities.ISpecialEffects;
import barryflash.superheroes.capabilities.ISuperman;
import barryflash.superheroes.capabilities.IThor;
import barryflash.superheroes.capabilities.IWasp;
import barryflash.superheroes.capabilities.IWonderWoman;
import barryflash.superheroes.capabilities.IZod;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.KeysProvider;
import barryflash.superheroes.capabilities.LokiProvider;
import barryflash.superheroes.capabilities.QuiverProvider;
import barryflash.superheroes.capabilities.ShazamProvider;
import barryflash.superheroes.capabilities.SpecialEffectsProvider;
import barryflash.superheroes.capabilities.SupermanProvider;
import barryflash.superheroes.capabilities.ThorProvider;
import barryflash.superheroes.capabilities.WaspProvider;
import barryflash.superheroes.capabilities.WonderWomanProvider;
import barryflash.superheroes.capabilities.ZodProvider;
import barryflash.superheroes.client.gui.GuiShapeshift;
import barryflash.superheroes.client.gui.GuiZeusAltar;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.ItemThorHammer;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemBlackWidowArmor;
import barryflash.superheroes.items.armor.ItemCyborgArmor;
import barryflash.superheroes.items.armor.ItemFlashArmor;
import barryflash.superheroes.items.armor.ItemGeneralZodArmor;
import barryflash.superheroes.items.armor.ItemHulkArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50ArcReactorArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemLokiArmor;
import barryflash.superheroes.items.armor.ItemShazamArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.network.MessageAddItemStackToInventoryServer;
import barryflash.superheroes.network.MessageCapToServer;
import barryflash.superheroes.network.MessageExplode;
import barryflash.superheroes.network.MessageExplosion;
import barryflash.superheroes.network.MessageGrow;
import barryflash.superheroes.network.MessageIronManSuitUp;
import barryflash.superheroes.network.MessageLightning;
import barryflash.superheroes.network.MessageQuiverToServer;
import barryflash.superheroes.network.MessageRemoveSpeedAttribute;
import barryflash.superheroes.network.MessageSetPosition;
import barryflash.superheroes.network.MessageSpawnBlackWidowBite;
import barryflash.superheroes.network.MessageSpeedAttribute;
import barryflash.superheroes.network.MessageThrowTiara;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.network.Capabilities.MessageCapIntToServer;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyHandler {
	

	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		EntityPlayer player = Minecraft.getMinecraft().player;
		/*if (ItemThanosArmor.isWearingFullSet(player, ModItems.ThanosHelmet,  ModItems.ThanosChest,  ModItems.ThanosLeggings,  ModItems.ThanosBoots)) {
			if (Keybinding.Ability4.isPressed()) {
				NetworkHandler.sendToServer(new MessageSpacePortal());
				
			}
		}*/
		ISpecialEffects specialcap = player.getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
		if (Keybinding.suitInfo.isKeyDown()) {
			specialcap.setSuitInfo(true);
		} else {
			specialcap.setSuitInfo(false);
		}
		IQuiver qcap = player.getCapability(QuiverProvider.QUIVER_CAP, null);
		if (qcap.isWearingQuiver()) {
			if (Keybinding.quiverForward.isPressed()) {
				qcap.addArrowSelected(1);
				NetworkHandler.sendToServer(new MessageQuiverToServer(qcap.getArrowSelected(), qcap.isArrowInCooldown(qcap.getArrowSelected())));
			}
			if (Keybinding.quiverBackward.isPressed()) {
				qcap.subtractArrowSelected(1);
				NetworkHandler.sendToServer(new MessageQuiverToServer(qcap.getArrowSelected(), qcap.isArrowInCooldown(qcap.getArrowSelected())));
			}
		}
		if (ItemCyborgArmor.isWearingFullSet(player)) {
			ICyborg cyborgcap = player.getCapability(CyborgProvider.CYBORG_CAP, null);
			if (Keybinding.Ability5.isKeyDown()) {
				if (!cyborgcap.isSonarCannon()) {
					cyborgcap.setSonarCannon(true);
					NetworkHandler.sendToServer(new MessageCapToServer(cyborgcap.isSonarCannon(), "sonarCannon"));
				}
			} else {
				if (cyborgcap.isSonarCannon()) {
					cyborgcap.setSonarCannon(false);
					NetworkHandler.sendToServer(new MessageCapToServer(cyborgcap.isSonarCannon(), "sonarCannon"));
				}
			}
			if (Keybinding.Ability4.isKeyDown()) {
				if (!cyborgcap.isLaser()) {
					cyborgcap.setLaser(true);
					NetworkHandler.sendToServer(new MessageCapToServer(cyborgcap.isLaser(), "sonarLaser"));
				}
			} else {
				if (cyborgcap.isLaser()) {
					cyborgcap.setLaser(false);
					NetworkHandler.sendToServer(new MessageCapToServer(cyborgcap.isLaser(), "sonarLaser"));
				}
			}
			if (Keybinding.flightTakeOff.isPressed()) {
				
				if (!cyborgcap.isFlying()) {
					cyborgcap.setFly(true);
					
				} else {
					cyborgcap.setFly(false);
				}
				NetworkHandler.sendToServer(new MessageCapToServer(cyborgcap.isFlying(), "cyborgFlight"));
				}
		}
		if (ItemLokiArmor.isWearingFullSet(player)) {
			ILoki lokicap = player.getCapability(LokiProvider.LOKI_CAP, null);
			if (Keybinding.Ability3.isPressed()) {
				 player.addItemStackToInventory(new ItemStack(ModItems.LOKI_SCEPTER, 1));
				 NetworkHandler.sendToServer(new MessageAddItemStackToInventoryServer(new ItemStack(ModItems.LOKI_SCEPTER, 1)));
			 }
			if (Keybinding.Ability5.isPressed()) {
				if (player.isSneaking()) {
					if (lokicap.isTeleporting()) {
						lokicap.setTeleport(false);
					} 
				} else {
				if (!lokicap.isTeleporting()) {
					lokicap.setTeleport(true);
				} else {
					RayTraceResult result = Utils.getMouseOverExtended(80);
					if (result.typeOfHit == result.typeOfHit.BLOCK) {
						BlockPos pos = result.getBlockPos().offset(player.getHorizontalFacing().getOpposite());
						NetworkHandler.sendToServer(new MessageSetPosition(pos.getX(), pos.getY(), pos.getZ()));
						lokicap.setTeleport(false);
						
					} else if (result.typeOfHit == result.typeOfHit.ENTITY) {
						BlockPos pos = result.entityHit.getPosition();
						NetworkHandler.sendToServer(new MessageSetPosition(pos.getX(), pos.getY(), pos.getZ()));
						lokicap.setTeleport(false);
					}
					
				}
				}
			}
			if (Keybinding.Ability4.isPressed()) {
				if (!lokicap.isInvisible()) {
					lokicap.setInvisible(true);
				} else {
					lokicap.setInvisible(false);
				}
			}
		}
		if (ItemBlackWidowArmor.isWearingFullSet(player)) {
			IBlackWidow widowcap = player.getCapability(BlackWidowProvider.BLACKWIDOW_CAP, null);
			if (Keybinding.Ability5.isPressed()) {
				if (!widowcap.getBlasterCooldown()) {
				NetworkHandler.sendToServer(new MessageSpawnBlackWidowBite());
				widowcap.setShootBlaster(true);
				widowcap.setBlasterCooldown(true);
				NetworkHandler.sendToServer(new MessageCapToServer(widowcap.isShootingBlaster(), "widowBite"));
				NetworkHandler.sendToServer(new MessageCapToServer(widowcap.getBlasterCooldown(), "widowBiteCooldown"));
				}
			} 
		}
		if (ItemFlashArmor.isWearingFlash(player)) {
			IFlash flashcap = player.getCapability(FlashProvider.FLASH_CAP, null);
 			if (Keybinding.Ability5.isPressed()) {
 				if (flashcap.getSpeedLevel() < 6) {
 					flashcap.increaseSpeedLevel();
 					NetworkHandler.sendToServer(new MessageCapIntToServer(flashcap.getSpeedLevel(), "flashSpeedLevel"));
 					if (flashcap.getSpeedLevel() == 1) {
 						flashcap.setSuperSpeed(true);
 						player.stepHeight = 1;
 						flashcap.clearList();
 						NetworkHandler.sendToServer(new MessageCapToServer(flashcap.isInSuperSpeed(), "flashSpeed"));
 					}
 			
 					
 					
 				}
 
 				
			}
 			if (Keybinding.Ability4.isPressed()) {
 				if (flashcap.getSpeedLevel() > 0) {
 					flashcap.decreaseSpeedLevel();
 					NetworkHandler.sendToServer(new MessageCapIntToServer(flashcap.getSpeedLevel(), "flashSpeedLevel"));
 				} 
 				if (flashcap.getSpeedLevel() == 0) {
 					flashcap.setSuperSpeed(false);
 					player.stepHeight = 0.5F;
 					NetworkHandler.sendToServer(new MessageCapToServer(flashcap.isInSuperSpeed(), "flashSpeed"));
 				}
 		
 				
 			}
 			if (Keybinding.Ability3.isPressed()) {
 				if (!flashcap.isPhasing()) {
 					flashcap.setPhasing(true);
 					
 				} else {
 					flashcap.setPhasing(false);
 				}
 				NetworkHandler.sendToServer(new MessageCapToServer(flashcap.isPhasing(), "flashPhase"));
			}
		}
		if (ItemThorArmor.isWearingFullSet(player)) {
			 IThor thorcap = player.getCapability(ThorProvider.THOR_CAP, null);
			 if (Keybinding.Ability4.isPressed()) {
				 player.addItemStackToInventory(new ItemStack(ModItems.thor_hammer, 1));
				 NetworkHandler.sendToServer(new MessageAddItemStackToInventoryServer(new ItemStack(ModItems.thor_hammer, 1)));
			 }
	
				 if (Keybinding.flightTakeOff.isPressed()) {
						
						if (!thorcap.isFlying()) {
							thorcap.setFly(true);
							
						} else {
							thorcap.setFly(false);
						}
					}
				 if (player.inventory.getCurrentItem().getItem() instanceof ItemThorHammer) {
			if (Keybinding.Ability5.isKeyDown()) {
				if (!thorcap.isShootingLightning()) {
				    thorcap.setLightningBeam(true);
				    NetworkHandler.sendToServer(new MessageCapToServer(thorcap.isShootingLightning(), "thorLightning"));
				}
			} else {
				if (thorcap.isShootingLightning()) {
				    thorcap.setLightningBeam(false);
				    NetworkHandler.sendToServer(new MessageCapToServer(thorcap.isShootingLightning(), "thorLightning"));
				}
			}
			 } else {
				 if (thorcap.isShootingLightning()) {
					    thorcap.setLightningBeam(false);
					    NetworkHandler.sendToServer(new MessageCapToServer(thorcap.isShootingLightning(), "thorLightning"));
					}
			 }
		}
		IKeys keyscap = player.getCapability(KeysProvider.KEYS_CAP, null);
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			if (!keyscap.isSpaceDown()) {
			keyscap.setSpace(true);
			NetworkHandler.sendToServer(new MessageCapToServer(keyscap.isSpaceDown(), "keySpace"));
			}
		} else {
			if (keyscap.isSpaceDown()) {
			keyscap.setSpace(false);
			NetworkHandler.sendToServer(new MessageCapToServer(keyscap.isSpaceDown(), "keySpace"));
			}
		}
		if (Keybinding.Ability4.isKeyDown()) {
			if (!keyscap.isFDown()) {
			keyscap.setF(true);
			NetworkHandler.sendToServer(new MessageCapToServer(keyscap.isFDown(), "keyF"));
			}
		} else {
			if (keyscap.isFDown()) {
			keyscap.setF(false);
			NetworkHandler.sendToServer(new MessageCapToServer(keyscap.isFDown(), "keyF"));
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_R)) {
			if (!keyscap.isRDown()) {
			keyscap.setR(true);
			NetworkHandler.sendToServer(new MessageCapToServer(keyscap.isRDown(), "keyR"));
			}
		} else {
			if (keyscap.isRDown()) {
			keyscap.setR(false);
			NetworkHandler.sendToServer(new MessageCapToServer(keyscap.isRDown(), "keyR"));
			}
		}
		
		if (ItemHulkArmor.isWearingHulk(player)) {
			IHulk hulkcap = player.getCapability(HulkProvider.HULK_CAP, null);
			if (Keybinding.Ability2.isPressed()) {
				if (!hulkcap.isDetransforming() && !hulkcap.isTransforming()) {
					if (hulkcap.isHulk()) {
						hulkcap.setDetransforming(true);
						NetworkHandler.sendToServer(new MessageCapToServer(hulkcap.isDetransforming(), "hulkDetransform"));
						
					} else {
						hulkcap.setTransformation(true);
						NetworkHandler.sendToServer(new MessageCapToServer(hulkcap.isTransforming(), "hulkTransform"));
						
					}
				}
			}
			if (hulkcap.isHulk()) {
			if (Keybinding.Ability4.isPressed()) {
				if (player.onGround) {
					if (!hulkcap.isSmashCooldown())
				NetworkHandler.sendToServer(new MessageExplosion(10F));
					hulkcap.setSmashCooldown(true);
					NetworkHandler.sendToServer(new MessageCapToServer(hulkcap.isSmashCooldown(), "hulkSmashCooldown"));
				}
			}
			}
			
		}
		if (ItemShazamArmor.isWearingShazam(player)) {
			IShazam shazamcap = player.getCapability(ShazamProvider.SHAZAM_CAP, null);
			if (Keybinding.Ability2.isPressed()) {
				NetworkHandler.sendToServer(new MessageLightning());
				 player.world.playSound(player.posX, player.posY, player.posZ, SoundEvents.ENTITY_LIGHTNING_THUNDER, SoundCategory.AMBIENT, 1F, 1F, true);
				 player.world.playSound(player.posX, player.posY, player.posZ, SoundEvents.ENTITY_LIGHTNING_IMPACT, SoundCategory.AMBIENT, 1F, 1F, true);
				if (shazamcap.isShazam()) {
					NetworkHandler.sendToServer(new MessageRemoveSpeedAttribute("shazam"));
					
					shazamcap.setShazam(false);
					NetworkHandler.sendToServer(new MessageCapToServer(shazamcap.isShazam(), "shazamTransform"));
				} else {
					shazamcap.setShazam(true);
					shazamcap.setLightning();
					NetworkHandler.sendToServer(new MessageSpeedAttribute("shazam"));
					NetworkHandler.sendToServer(new MessageCapToServer(shazamcap.isShazam(), "shazamTransform"));
					NetworkHandler.sendToServer(new MessageCapToServer(shazamcap.isLightning(), "shazamLightning"));
				}
			}
			if (shazamcap.isShazam()) {
			if (Keybinding.flightTakeOff.isPressed()) {
				
				if (!shazamcap.isFlying()) {
					shazamcap.setFlight(true);
					
				} else {
					shazamcap.setFlight(false);
				}
			}
			if (Keybinding.Ability5.isKeyDown()) {
				if (!shazamcap.isShootingLightningBeam()) {
					shazamcap.shootLightningBeam();
					NetworkHandler.sendToServer(new MessageCapToServer(shazamcap.isShootingLightningBeam(), "shazamShootBeam"));
				}
			} else {
				if (shazamcap.isShootingLightningBeam()) {
					shazamcap.stopShootingLightningBeam();
					NetworkHandler.sendToServer(new MessageCapToServer(shazamcap.isShootingLightningBeam(), "shazamShootBeam"));
				}
			}
			}
		}
		
		
			if (ItemIronmanMark50ArcReactorArmor.isWearingReactor(player, ModItems.IronManArcReactor)) {
				IIronman ironmancap = player.getCapability(IronmanProvider.IRONMAN_CAP, null);
				if (Keybinding.Ability2.isPressed()) {
					player.world.playSound(player, player.getPosition(), THSoundHandler.SUIT, SoundCategory.PLAYERS, 0.3F, 1.0F);
			ironmancap.animationStart();
			//NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isAnimationInProgress(), "ironmanSuitOn"));
			NetworkHandler.sendToServer(new MessageIronManSuitUp());
				}
			
			}
		

			if (ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
				IIronman ironmancap = player.getCapability(IronmanProvider.IRONMAN_CAP, null);
				
				if (Keybinding.Ability2.isPressed() && !ironmancap.isIronmanDisabled()) {
					player.world.playSound(player, player.getPosition(), THSoundHandler.SUIT, SoundCategory.PLAYERS, 0.3F, 1.0F);
					ironmancap.setAnimationOff(true);
					//NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isAnimationOffInProgress(), "ironmanSuitOff"));
					}
			
					
				
			}
			IZod zodcap = player.getCapability(ZodProvider.ZOD_CAP, null);
			if (ItemGeneralZodArmor.isWearingFullSet(player)) {
				
				if (!zodcap.isAffectedByKryptonite()) {
				if (Keybinding.Ability5.isKeyDown()) {
					
					zodcap.setHeatVision();
					NetworkHandler.sendToServer(new MessageCapToServer(zodcap.isUsingHeatVision(), "zodHeatVision"));
				} else {
					zodcap.unsetHeatVision();
					NetworkHandler.sendToServer(new MessageCapToServer(zodcap.isUsingHeatVision(), "zodHeatVision"));
				}
				if (Keybinding.Ability4.isKeyDown()) {
					zodcap.setXRay();
				} else {
					zodcap.unsetXRay();
				}
				if (Keybinding.flightTakeOff.isPressed()) {
					
				if (!zodcap.isFlying()) {
					zodcap.setFlying();
					
				} else {
					zodcap.unsetFlying();
				}
				NetworkHandler.sendToServer(new MessageCapToServer(zodcap.isFlying(), "supermanFlight"));
				}
				}
			} else {
				if (zodcap.isUsingHeatVision()) {
					zodcap.unsetHeatVision();
				}
			}
			ISuperman supercap = player.getCapability(SupermanProvider.SUPERMAN_CAP, null);
			if (ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots)) {
				
				if (!supercap.isAffectedByKryptonite()) {
				if (Keybinding.Ability5.isKeyDown()) {
					
					supercap.setHeatVision();
					NetworkHandler.sendToServer(new MessageCapToServer(supercap.isUsingHeatVision(), "supermanHeatVision"));
				} else {
					supercap.unsetHeatVision();
					NetworkHandler.sendToServer(new MessageCapToServer(supercap.isUsingHeatVision(), "supermanHeatVision"));
				}
				if (Keybinding.Ability4.isKeyDown()) {
					supercap.setXRay();
				} else {
					supercap.unsetXRay();
				}
				if (Keybinding.flightTakeOff.isPressed()) {
					
				if (!supercap.isFlying()) {
					supercap.setFlying();
					
				} else {
					supercap.unsetFlying();
				}
				NetworkHandler.sendToServer(new MessageCapToServer(supercap.isFlying(), "supermanFlight"));
				}
				}
			} else {
				if (supercap.isUsingHeatVision()) {
					supercap.unsetHeatVision();
				}
			}
			if (ItemWonderWomanArmor.isWearingFullSet(player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
				IWonderWoman wwcap = player.getCapability(WonderWomanProvider.WONDERWOMAN_CAP, null);
				if (Keybinding.Ability6.isPressed()) {
					if (!wwcap.isTiara()) {
						player.world.playSound(player, player.getPosition(), THSoundHandler.THROW, SoundCategory.PLAYERS, 1F, 1.0F);
					NetworkHandler.sendToServer(new MessageThrowTiara());
					wwcap.setTiara();
					NetworkHandler.sendToServer(new MessageCapToServer(wwcap.isTiara(), "wonderwomanTiara"));
					}
				}
				if (Keybinding.Ability4.isKeyDown()) {
					wwcap.setBracelets();
					NetworkHandler.sendToServer(new MessageCapToServer(wwcap.areBraceletsActive(), "wonderwomanBracelets"));
				} else {
					wwcap.unsetBracelets();
					NetworkHandler.sendToServer(new MessageCapToServer(wwcap.areBraceletsActive(), "wonderwomanBracelets"));
				}
				if (player.isSneaking()) {
					if (Keybinding.Ability4.isPressed()) {
						if (!wwcap.isBlastCooldown()) {
						  player.world.playSound(player, player.getPosition(), THSoundHandler.BRACELET_BLAST, SoundCategory.PLAYERS, 1F, 1.0F);
						wwcap.setBlast();
						wwcap.setBlastCooldown();
						NetworkHandler.sendToServer(new MessageCapToServer(wwcap.isBlast(), "wonderwomanBlast"));
						NetworkHandler.sendToServer(new MessageCapToServer(wwcap.isBlastCooldown(), "wonderwomanBlastCooldown"));
						NetworkHandler.sendToServer(new MessageExplode());
						int k1 = player.getPosition().getX() + 10;
						 int l1 = player.getPosition().getX() - 10;
					     int i2 = player.getPosition().getY() + 10;
					     int i1 = player.getPosition().getY() - 10;
					     int j2 = player.getPosition().getZ() + 10;
					     int j1 = player.getPosition().getZ() - 10;
						
						  List<Entity> list = player.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
						  for (int k2 = 0; k2 < list.size(); ++k2)
						  {
						  Entity entity = (Entity)list.get(k2);
						  if (entity instanceof EntityLiving && entity.getEntityId() != player.getEntityId()) {
						  Utils.knockbackEntity(player, entity, 5F);
						  entity.motionY += 5.0D;
						  }
						  }
						}
					}
				}
				
				
				
				
			}
			
	
		if (ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
			IIronman ironmancap = player.getCapability(IronmanProvider.IRONMAN_CAP, null);
			if (!ironmancap.isIronmanDisabled()) {
			if (Keybinding.flightTakeOff.isPressed()) {
				if (ironmancap.getFlight()) {
					ironmancap.setFlight(false);
				} else {
					ironmancap.setFlight(true);
				}
			}
			/*if (Keybinding.Ability3.isKeyDown()) {
				ironmancap.activateShield();
				//NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isShieldActivated(), "ironmanShield"));
			} else {
				ironmancap.deactivateShield();
				//NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isShieldActivated(), "ironmanShield"));
			}*/
			if (Keybinding.Ability5.isPressed()) {
				
		
			if (!ironmancap.repulsorsActivated()) {
				if (!ironmancap.areCannonsActivated() && !ironmancap.areKnockbackFistsActivated() && !ironmancap.isSwordActivated() && !ironmancap.isShieldActivated() && !ironmancap.areMissilesActivated()) {
					player.world.playSound(player, player.getPosition(), THSoundHandler.REPULSOR_CHARGE, SoundCategory.PLAYERS, 1F, 1.0F);
					ironmancap.activateRepulsors();
					NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.repulsorsActivated(), "ironmanRepulsors"));
				}
				
			} else {
				player.world.playSound(player, player.getPosition(), THSoundHandler.REPULSOR_CHARGE, SoundCategory.PLAYERS, 1F, 1.0F);
				ironmancap.deactivateRepulsors();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.repulsorsActivated(), "ironmanRepulsors"));
			}
			}
		
		if (Keybinding.Ability4.isPressed()) {
			if (ironmancap.repulsorsActivated()) {
				ironmancap.deactivateRepulsors();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.repulsorsActivated(), "ironmanRepulsors"));
			}
			ironmancap.increaseWeapon();
			if (ironmancap.getWeapon() > 4) {
				ironmancap.setWeapon(0);
			}
			switch(ironmancap.getWeapon()) {
			case 0: ironmancap.deactivateMissiles();
					NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.areMissilesActivated(), "ironmanMissile"));
					break;
			case 1: ironmancap.activateCannons(true);
					NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.areCannonsActivated(), "ironmanCannons"));
					break;
			case 2: ironmancap.activateCannons(false);
					NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.areCannonsActivated(), "ironmanCannons"));
					ironmancap.activateKnockbackFists();
					NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.areKnockbackFistsActivated(), "ironmanKnockback"));
					break;
			case 3: ironmancap.deactivateKnockbackFists();
					NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.areKnockbackFistsActivated(), "ironmanKnockback"));
					ironmancap.activateSword();
					NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isSwordActivated(), "ironmanDagger"));
					break;
			case 4: ironmancap.deactivateSword();
					NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isSwordActivated(), "ironmanDagger"));
					ironmancap.activateMissiles();
					NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.areMissilesActivated(), "ironmanMissile"));
					break;
			}
			
		}
		if (Keybinding.Ability6.isPressed()) {
			if (ironmancap.getWeapon() == 1) {
				ironmancap.activateCannons(false);
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.areCannonsActivated(), "ironmanCannons"));
			}
			if (ironmancap.getWeapon() == 2) {
				ironmancap.deactivateKnockbackFists();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.areKnockbackFistsActivated(), "ironmanKnockback"));
			}
			if (ironmancap.getWeapon() == 3) {
				ironmancap.deactivateSword();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isSwordActivated(), "ironmanDagger"));
			}
			if (ironmancap.getWeapon() == 4) {
				ironmancap.deactivateMissiles();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.areMissilesActivated(), "ironmanMissile"));
			}
			ironmancap.setWeapon(0);
		}
		if (Keybinding.Ability7.isPressed()) {
			ironmancap.increaseFlyMode();
			if (ironmancap.getFlyMode() > 2) {
				ironmancap.setFlyMode(0);
			}
			switch(ironmancap.getFlyMode()) {
			case 0: ironmancap.setFlightMode();
					NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isFlightMode(), "ironmanFlight1"));
					break;
			case 1: ironmancap.activateWings();
					NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.areWingsActivated(), "ironmanFlight2"));
					break;
			case 2: ironmancap.activateJetThruster();
					NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isJetThrusterActivated(), "ironmanFlight3"));
			break;
			}
			if (ironmancap.getFlyMode() == 0) {
				ironmancap.deactivateJetThruster();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isJetThrusterActivated(), "ironmanFlight3"));
			}
			if (ironmancap.getFlyMode() == 1) {
				ironmancap.unsetFlightMode();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.isFlightMode(), "ironmanFlight1"));
			}
			if (ironmancap.getFlyMode() == 2) {
				ironmancap.deactivateWings();
				NetworkHandler.sendToServer(new MessageCapToServer(ironmancap.areWingsActivated(), "ironmanFlight2"));
			}
		}
			
		}
		}
		if (ItemBatmanArmor.isWearingFullSet(player, ModItems.BatmanCowl, ModItems.BatmanChest, ModItems.BatmanLeggings, ModItems.BatmanBoots)) {
			IBatman batcap = player.getCapability(BatmanProvider.BATMAN_CAP, null);
			if (Keybinding.Ability5.isPressed()) {
				player.world.playSound(player, player.getPosition(), THSoundHandler.BATMAN_GADGET_SWITCH, SoundCategory.PLAYERS, 1F, 1.0F);
			if (batcap.getActiveBatarangType() > 4) {
				batcap.setBatarang(0);
			} else {
			batcap.increaseBatarangType();
			}
			
					
			}
			
		}
		
		/*if(ItemDoctorStrangeArmor.isWearingFullSet(player, ModItems.DoctorStrangeRobe, ModItems.DoctorStrangeLeggings, ModItems.DoctorStrangeBoots)) {
			IDoctorStrange docstrangecap = player.getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);	
			
			if (Keybinding.Ability4.isKeyDown()) {
				
				docstrangecap.setBeam();
				RayTraceResult res = getMouseOverExtended();
				if (res != null) {
					if (res.entityHit != null) {
						
						NetworkHandler.sendToServer(new MessageDoctorStrangeBeam(res.entityHit.getEntityId()));
						
					}
				}
			} else {
				docstrangecap.unsetBeam();
			}
		}*/
		/*if (ItemWaspArmor.isWearingFullSet(player, ModItems.WaspHelmet, ModItems.WaspChest, ModItems.WaspLegs, ModItems.WaspFeet)) {
			IWasp waspcap = player.getCapability(WaspProvider.WASP_CAP, null);
			
			if (Keybinding.Ability5.isPressed()) {
				player.world.playSound(player, player.getPosition(), THSoundHandler.REPULSOR_CHARGE, SoundCategory.PLAYERS, 1F, 1.0F);
				if (!waspcap.areBlastersActive()) {
				waspcap.activateBlasters();
				} else {
					waspcap.deactivateBlasters();
				}
			
				
			}
			if (Keybinding.Ability2.isPressed()) {
				if (!waspcap.isHelmetOn()) {
					if (!waspcap.isHelmetAnimationInProgress()) {
						waspcap.helmetOnanimationStart();
					}
				} else {
					if (!waspcap.isHelmetOffAnimationInProgress()) {
						waspcap.helmetOffanimationStart();
					}
				}
			}
			if (Keybinding.Ability4.isPressed()) {
				
			
				if (!waspcap.isSmall()) {
					player.world.playSound(player, player.getPosition(), THSoundHandler.SHRINK, SoundCategory.PLAYERS, 1.0F, 1.0F);
					waspcap.setSmall();
					waspcap.setAnimationStart();
					NetworkHandler.sendToServer(new MessageCapToServer(waspcap.isSmall(), "waspShrink"));
				} else {
					player.world.playSound(player, player.getPosition(), THSoundHandler.SHRINK, SoundCategory.PLAYERS, 1.0F, 1.0F);
					waspcap.setGrowAnimationStart();
					waspcap.resetSize();
					NetworkHandler.sendToServer(new MessageCapToServer(waspcap.isSmall(), "waspShrink"));
				}
			}
		}
		if (ItemAntmanArmor.isWearingFullSet(player, ModItems.AntmanHelmet, ModItems.AntmanChest, ModItems.AntmanLegs, ModItems.AntmanFeet)) {
			IAntman antmancap = player.getCapability(AntmanProvider.ANTMAN_CAP, null);
			if (Keybinding.Ability5.isPressed()) {
				if (!antmancap.isBig() && antmancap.isNormalSize()) {
					player.world.playSound(player, player.getPosition(), THSoundHandler.SHRINK, SoundCategory.PLAYERS, 1.0F, 1.0F);
					antmancap.setBig();
					NetworkHandler.sendToServer(new MessageCapToServer(antmancap.isBig(), "antmanGrow"));
					antmancap.giantanimationStart();
					NetworkHandler.sendToServer(new MessageGrow());
					player.eyeHeight = player.getDefaultEyeHeight() + 3.5F;
					
					
				} else if (!antmancap.isSmall()){
					player.world.playSound(player, player.getPosition(), THSoundHandler.SHRINK, SoundCategory.PLAYERS, 1.0F, 1.0F);
					antmancap.giantShrinkanimationStart();
					antmancap.resetSize();
					NetworkHandler.sendToServer(new MessageCapToServer(antmancap.isBig(), "antmanGrow"));
				}
			
			}
			if (antmancap.isBig()) {
				if (Keybinding.Ability3.isPressed()) {
					if (!antmancap.isGroundPoundCooldown()) {
					antmancap.setGroundPound();
					}
				}
			}
			if (Keybinding.Ability2.isPressed()) {
			
				if (!antmancap.isHelmetOn()) {
					if (!antmancap.isHelmetAnimationInProgress()) {
						antmancap.helmetOnanimationStart();
					}
				} else {
					if (!antmancap.isHelmetOffAnimationInProgress()) {
						antmancap.helmetOffanimationStart();
					}
				}
			}
			if (Keybinding.Ability4.isPressed()) {
				
				
				if (!antmancap.isSmall() && antmancap.isNormalSize()) {
					player.world.playSound(player, player.getPosition(), THSoundHandler.SHRINK, SoundCategory.PLAYERS, 1.0F, 1.0F);
					antmancap.setSmall();
					antmancap.setAnimationStart();
					NetworkHandler.sendToServer(new MessageCapToServer(antmancap.isSmall(), "antmanShrink"));
				} else if (!antmancap.isBig()){
					player.world.playSound(player, player.getPosition(), THSoundHandler.SHRINK, SoundCategory.PLAYERS, 1.0F, 1.0F);
					antmancap.setGrowAnimationStart();
					antmancap.resetSize();
					NetworkHandler.sendToServer(new MessageCapToServer(antmancap.isSmall(), "antmanShrink"));
				}
			}
		}*/
		
	}	
	public static RayTraceResult getMouseOverExtended()
	{
	    Minecraft mc = FMLClientHandler.instance().getClient();
	    Entity theRenderViewEntity = mc.getRenderViewEntity();
	    AxisAlignedBB theViewBoundingBox = new AxisAlignedBB(
	            theRenderViewEntity.posX-0.8D,
	            theRenderViewEntity.posY-0.0D,
	            theRenderViewEntity.posZ-0.8D,
	            theRenderViewEntity.posX+0.8D,
	            theRenderViewEntity.posY+1.8D,
	            theRenderViewEntity.posZ+0.8D
	            );
	    RayTraceResult returnMOP = null;
	    if (mc.world != null)
	    {
	        double var2 = 60;
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
	
	
}
