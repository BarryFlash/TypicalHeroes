package barryflash.superheroes.network;

import java.util.UUID;

import barryflash.superheroes.capabilities.BatmanEventHandler;
import barryflash.superheroes.capabilities.HulkEventHandler;
import barryflash.superheroes.capabilities.IronmanEventHandler;
import barryflash.superheroes.capabilities.ShazamEventHandler;
import barryflash.superheroes.capabilities.SupermanEventHandler;
import barryflash.superheroes.capabilities.WonderWomanEventHandler;
import barryflash.superheroes.items.armor.ArmorBase;
import barryflash.superheroes.network.Capabilities.Antman.MessageAntmanGrow;
import barryflash.superheroes.network.Capabilities.Antman.MessageAntmanHelmetToTracking;
import barryflash.superheroes.network.Capabilities.Antman.MessageAntmanShrink;
import barryflash.superheroes.network.Capabilities.Batman.MessageBatmanGlideToTracking;
import barryflash.superheroes.network.Capabilities.Hulk.MessageHulkDetransformToTracking;
import barryflash.superheroes.network.Capabilities.Hulk.MessageHulkHTransformToTracking;
import barryflash.superheroes.network.Capabilities.Hulk.MessageHulkToTracking;
import barryflash.superheroes.network.Capabilities.Hulk.MessageHulkTransformToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanCannonsToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanDaggerToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanFlight2ToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanFlight3ToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanFlightToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanKnockbackToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanLeftRepulsorToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanMissileToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanRepulsorsToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanRightRepulsorToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanShieldToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanSuitOffToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanSuitUpToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanUnibeamToTracking;
import barryflash.superheroes.network.Capabilities.Shazam.MessageShazamLightningToTracking;
import barryflash.superheroes.network.Capabilities.Shazam.MessageShazamShootBeamToTracking;
import barryflash.superheroes.network.Capabilities.Shazam.MessageShazamTransformToTracking;
import barryflash.superheroes.network.Capabilities.Superman.MessageSupermanFlightToTracking;
import barryflash.superheroes.network.Capabilities.Superman.MessageSupermanHeatVisionToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspFlightToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspHelmetToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspLeftBlastToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspRightBlastToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspShrink;
import barryflash.superheroes.network.Capabilities.WonderWoman.MessageWonderwomanBraceletsToTracking;
import barryflash.superheroes.network.Capabilities.WonderWoman.MessageWonderwomanTiaraToTracking;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSetAttributes extends MessageBase<MessageSetAttributes> {

	@Override
	public void fromBytes(ByteBuf buf) {

	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}

	@Override
	public void handleClientSide(MessageSetAttributes message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageSetAttributes message, EntityPlayer player, MessageContext ctx) {
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
		}
	}  
}
