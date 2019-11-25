package barryflash.superheroes.network;

import java.util.UUID;

import barryflash.superheroes.capabilities.BatmanEventHandler;
import barryflash.superheroes.capabilities.FlashEventHandler;
import barryflash.superheroes.capabilities.HulkEventHandler;
import barryflash.superheroes.capabilities.IronmanEventHandler;
import barryflash.superheroes.capabilities.ShazamEventHandler;
import barryflash.superheroes.capabilities.SupermanEventHandler;
import barryflash.superheroes.capabilities.WonderWomanEventHandler;
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
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRemoveSpeedAttribute extends MessageBase<MessageRemoveSpeedAttribute> {
	private String type;
	public MessageRemoveSpeedAttribute() {
		// TODO Auto-generated constructor stub
	}
	public MessageRemoveSpeedAttribute(String type) {
		this.type = type;
		//System.out.println(this.type);
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		type = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, type);
	}

	@Override
	public void handleClientSide(MessageRemoveSpeedAttribute message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageRemoveSpeedAttribute message, EntityPlayer player, MessageContext ctx) {

		if (message.type.equals("shazam")) {
			if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(ShazamEventHandler.speedAttributeModifier)) {
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(ShazamEventHandler.speedAttributeModifier);
				
			}
		}
		if (message.type.equals("wonderwoman")) {
			if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(WonderWomanEventHandler.speedAttributeModifier)) {
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(WonderWomanEventHandler.speedAttributeModifier);
				
			}
		}
		if (message.type.equals("superman")) {
			if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(SupermanEventHandler.speedAttributeModifier)) {
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(SupermanEventHandler.speedAttributeModifier);
				
			}
		}
		if (message.type.equals("batman")) {
			if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(BatmanEventHandler.speedAttributeModifier)) {
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(BatmanEventHandler.speedAttributeModifier);
				
			}
		}
		if (message.type.equals("flash")) {
			if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(FlashEventHandler.speedAttributeModifier)) {
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(FlashEventHandler.speedAttributeModifier);
				
			}
			if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(FlashEventHandler.speedAttributeModifier1)) {
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(FlashEventHandler.speedAttributeModifier1);
				
			}
			if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(FlashEventHandler.speedAttributeModifier2)) {
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(FlashEventHandler.speedAttributeModifier2);
				
			}
			if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(FlashEventHandler.speedAttributeModifier3)) {
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(FlashEventHandler.speedAttributeModifier3);
				
			}
			if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(FlashEventHandler.speedAttributeModifier4)) {
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(FlashEventHandler.speedAttributeModifier4);
				
			}
			if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(FlashEventHandler.speedAttributeModifier5)) {
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(FlashEventHandler.speedAttributeModifier5);
				
			}
			if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(FlashEventHandler.speedAttributeModifier6)) {
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(FlashEventHandler.speedAttributeModifier6);
				
			}
		}

	}  
}
