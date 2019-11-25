package barryflash.superheroes.network;

import barryflash.superheroes.capabilities.BlackWidowProvider;
import barryflash.superheroes.capabilities.CyborgProvider;
import barryflash.superheroes.capabilities.FlashProvider;
import barryflash.superheroes.capabilities.HulkProvider;
import barryflash.superheroes.capabilities.IBlackWidow;
import barryflash.superheroes.capabilities.ICyborg;
import barryflash.superheroes.capabilities.IFlash;
import barryflash.superheroes.capabilities.IHulk;
import barryflash.superheroes.capabilities.IKeys;
import barryflash.superheroes.capabilities.IShazam;
import barryflash.superheroes.capabilities.IWonderWoman;
import barryflash.superheroes.capabilities.KeysProvider;
import barryflash.superheroes.capabilities.ShazamProvider;
import barryflash.superheroes.capabilities.WonderWomanProvider;
import barryflash.superheroes.network.Capabilities.Antman.MessageAntmanGrow;
import barryflash.superheroes.network.Capabilities.Antman.MessageAntmanHelmetToTracking;
import barryflash.superheroes.network.Capabilities.Antman.MessageAntmanShrink;
import barryflash.superheroes.network.Capabilities.Batman.MessageBatmanGlideToTracking;
import barryflash.superheroes.network.Capabilities.BlackWidow.MessageWidowBiteToTracking;
import barryflash.superheroes.network.Capabilities.Cyborg.MessageCyborgFlightToTracking;
import barryflash.superheroes.network.Capabilities.Cyborg.MessageCyborgLaserToTracking;
import barryflash.superheroes.network.Capabilities.Cyborg.MessageCyborgSonicCannonToTracking;
import barryflash.superheroes.network.Capabilities.Flash.MessagePhaseToTracking;
import barryflash.superheroes.network.Capabilities.Flash.MessageSuperSpeedToTracking;
import barryflash.superheroes.network.Capabilities.Flash.MessageTrailToTracking;
import barryflash.superheroes.network.Capabilities.Hawkeye.MessageHawkeyeClearGrappleEntitiesToTracking;
import barryflash.superheroes.network.Capabilities.Hawkeye.MessageHawkeyeGrappleEntitiesToTracking;
import barryflash.superheroes.network.Capabilities.Hawkeye.MessageHawkeyeRemoveGrappleEntitiesToTracking;
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
import barryflash.superheroes.network.Capabilities.Superman.MessageZodHeatVisionToTracking;
import barryflash.superheroes.network.Capabilities.Thor.MessageThorFlightToTracking;
import barryflash.superheroes.network.Capabilities.Thor.MessageThorLightningToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspFlightToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspHelmetToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspLeftBlastToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspRightBlastToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspShrink;
import barryflash.superheroes.network.Capabilities.WonderWoman.MessageWonderWomanBlastToTracking;
import barryflash.superheroes.network.Capabilities.WonderWoman.MessageWonderwomanBraceletsToTracking;
import barryflash.superheroes.network.Capabilities.WonderWoman.MessageWonderwomanTiaraToTracking;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageCapToServer extends MessageBase<MessageCapToServer> {
	private boolean cap;
	private String type;
	public MessageCapToServer() {
		// TODO Auto-generated constructor stub
	}
	public MessageCapToServer(boolean cap, String type) {
		this.cap = cap;
		this.type = type;
		//System.out.println(this.type);
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		type = ByteBufUtils.readUTF8String(buf);
		cap = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, type);
		buf.writeBoolean(cap);
	}

	@Override
	public void handleClientSide(MessageCapToServer message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageCapToServer message, EntityPlayer player, MessageContext ctx) {
		
		if (message.type.equals("ironmanCannons")) {
			NetworkHandler.sendToTracking(new MessageIronmanCannonsToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanKnockback")) {
			NetworkHandler.sendToTracking(new MessageIronmanKnockbackToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanMissile")) {
			NetworkHandler.sendToTracking(new MessageIronmanMissileToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanDagger")) {
			NetworkHandler.sendToTracking(new MessageIronmanDaggerToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanShield")) {
			NetworkHandler.sendToTracking(new MessageIronmanShieldToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanFlight1")) {
			NetworkHandler.sendToTracking(new MessageIronmanFlightToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanFlight2")) {
			NetworkHandler.sendToTracking(new MessageIronmanFlight2ToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanFlight3")) {
			NetworkHandler.sendToTracking(new MessageIronmanFlight3ToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanSuitOn")) {
			NetworkHandler.sendToTracking(new MessageIronmanSuitUpToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanSuitOff")) {
			NetworkHandler.sendToTracking(new MessageIronmanSuitOffToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanRepulsorRight")) {
			NetworkHandler.sendToTracking(new MessageIronmanRightRepulsorToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanRepulsorLeft")) {
			NetworkHandler.sendToTracking(new MessageIronmanLeftRepulsorToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanUnibeam")) {
			NetworkHandler.sendToTracking(new MessageIronmanUnibeamToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("ironmanRepulsors")) {
			NetworkHandler.sendToTracking(new MessageIronmanRepulsorsToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("wonderwomanBracelets")) {
			IWonderWoman wwcap = player.getCapability(WonderWomanProvider.WONDERWOMAN_CAP, null);
			if (message.cap) {
				wwcap.setBracelets();
			} else {
				wwcap.unsetBracelets();
			}
			NetworkHandler.sendToTracking(new MessageWonderwomanBraceletsToTracking(message.cap, player.getEntityId()), player);
			
		}
		else if (message.type.equals("wonderwomanBlast")) {
			NetworkHandler.sendToTracking(new MessageWonderWomanBlastToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("wonderwomanBlastCooldown")) {
			IWonderWoman wwcap = player.getCapability(WonderWomanProvider.WONDERWOMAN_CAP, null);
			wwcap.setBlastCooldown();
		}
		else if (message.type.equals("wonderwomanTiara")) {
			NetworkHandler.sendToTracking(new MessageWonderwomanTiaraToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("antmanGrow")) {
			NetworkHandler.sendToTracking(new MessageAntmanGrow(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("antmanShrink")) {
			NetworkHandler.sendToTracking(new MessageAntmanShrink(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("antmanHelmet")) {
			NetworkHandler.sendToTracking(new MessageAntmanHelmetToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("waspShrink")) {
			NetworkHandler.sendToTracking(new MessageWaspShrink(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("waspBlastRight")) {
			NetworkHandler.sendToTracking(new MessageWaspRightBlastToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("waspBlastLeft")) {
			NetworkHandler.sendToTracking(new MessageWaspLeftBlastToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("waspFlight")) {
			NetworkHandler.sendToTracking(new MessageWaspFlightToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("waspHelmet")) {
			NetworkHandler.sendToTracking(new MessageWaspHelmetToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("supermanHeatVision")) {
			NetworkHandler.sendToTracking(new MessageSupermanHeatVisionToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("supermanFlight")) {
			
			NetworkHandler.sendToTracking(new MessageSupermanFlightToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("batmanGlide")) {
			NetworkHandler.sendToTracking(new MessageBatmanGlideToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("shazamTransform")) {
			IShazam shazamcap = player.getCapability(ShazamProvider.SHAZAM_CAP, null);
			shazamcap.setShazam(message.cap);
			NetworkHandler.sendToTracking(new MessageShazamTransformToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("shazamLightning")) {
			NetworkHandler.sendToTracking(new MessageShazamLightningToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("shazamShootBeam")) {
			NetworkHandler.sendToTracking(new MessageShazamShootBeamToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("hulkTransform")) {
			NetworkHandler.sendToTracking(new MessageHulkTransformToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("hulkDetransform")) {
			NetworkHandler.sendToTracking(new MessageHulkDetransformToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("hulkHTransform")) {
			NetworkHandler.sendToTracking(new MessageHulkHTransformToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("hulkSmashCooldown")) {
			IHulk hulkcap = player.getCapability(HulkProvider.HULK_CAP, null);
			hulkcap.setSmashCooldown(true);
		}
		else if (message.type.equals("hulk")) {
			IHulk hulkcap = player.getCapability(HulkProvider.HULK_CAP, null);
			hulkcap.setHulk(message.cap);
			NetworkHandler.sendToTracking(new MessageHulkToTracking(message.cap, player.getEntityId()), player);
			
		}
		else if (message.type.equals("flashPhase")) {
			IFlash flashcap = player.getCapability(FlashProvider.FLASH_CAP, null);
			flashcap.setPhasing(message.cap);
			NetworkHandler.sendToTracking(new MessagePhaseToTracking(message.cap, player.getEntityId()), player);
			
		}
		else if (message.type.equals("flashSpeed")) {
			NetworkHandler.sendToTracking(new MessageSuperSpeedToTracking(message.cap, player.getEntityId()), player);
			
		}
		else if (message.type.equals("flashTrail")) {

			NetworkHandler.sendToTracking(new MessageTrailToTracking(message.cap, player.getEntityId()), player);
			
		}
		else if (message.type.equals("widowBite")) {
			NetworkHandler.sendToTracking(new MessageWidowBiteToTracking(message.cap, player.getEntityId()), player);

			
		}
		else if (message.type.equals("widowBiteCooldown")) {
			IBlackWidow widowcap = player.getCapability(BlackWidowProvider.BLACKWIDOW_CAP, null);
			widowcap.setBlasterCooldown(true);
			
		}
		else if (message.type.equals("sonarCannon")) {
			ICyborg cyborgcap = player.getCapability(CyborgProvider.CYBORG_CAP, null);
			cyborgcap.setSonarCannon(message.cap);
			NetworkHandler.sendToTracking(new MessageCyborgSonicCannonToTracking(message.cap, player.getEntityId()), player);
			
		}
		else if (message.type.equals("sonarLaser")) {
			ICyborg cyborgcap = player.getCapability(CyborgProvider.CYBORG_CAP, null);
			cyborgcap.setLaser(message.cap);
			NetworkHandler.sendToTracking(new MessageCyborgLaserToTracking(message.cap, player.getEntityId()), player);
			
		}
		else if (message.type.equals("cyborgFlight")) {
			
			NetworkHandler.sendToTracking(new MessageCyborgFlightToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("keySpace")) {
			IKeys keyscap = player.getCapability(KeysProvider.KEYS_CAP, null);
			keyscap.setSpace(message.cap);
		
			
		}
		else if (message.type.equals("keyR")) {
			IKeys keyscap = player.getCapability(KeysProvider.KEYS_CAP, null);
			keyscap.setR(message.cap);
			
		}
		else if (message.type.equals("keyF")) {
			IKeys keyscap = player.getCapability(KeysProvider.KEYS_CAP, null);
			keyscap.setF(message.cap);
			
		}
		else if (message.type.equals("zodHeatVision")) {
			NetworkHandler.sendToTracking(new MessageZodHeatVisionToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("thorLightning")) {
			NetworkHandler.sendToTracking(new MessageThorLightningToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("thorFlight")) {
			NetworkHandler.sendToTracking(new MessageThorFlightToTracking(message.cap, player.getEntityId()), player);
		}
		
		else {
			System.out.println(message.type);
		}
	}  
}
