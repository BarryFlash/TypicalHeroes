package barryflash.superheroes.network.Capabilities;

import barryflash.superheroes.capabilities.FlashProvider;
import barryflash.superheroes.capabilities.IFlash;
import barryflash.superheroes.network.MessageBase;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.network.Capabilities.Antman.MessageAntmanGrow;
import barryflash.superheroes.network.Capabilities.Antman.MessageAntmanHelmetToTracking;
import barryflash.superheroes.network.Capabilities.Antman.MessageAntmanShrink;
import barryflash.superheroes.network.Capabilities.Batman.MessageBatmanGlideTickToTracking;
import barryflash.superheroes.network.Capabilities.Batman.MessageBatmanGlideToTracking;
import barryflash.superheroes.network.Capabilities.Hawkeye.MessageHawkeyeClearGrappleEntitiesToTracking;
import barryflash.superheroes.network.Capabilities.Hawkeye.MessageHawkeyeGrappleEntitiesToTracking;
import barryflash.superheroes.network.Capabilities.Hawkeye.MessageHawkeyeRemoveGrappleEntitiesToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanCannonsToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanDaggerToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanFlight2ToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanFlight3ToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanFlightToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanFlyTickToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanKnockbackToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanLeftRepulsorToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanMissileToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanRightRepulsorToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanShieldToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanSuitOffToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanSuitUpToTracking;
import barryflash.superheroes.network.Capabilities.Ironman.MessageIronmanUnibeamToTracking;
import barryflash.superheroes.network.Capabilities.Superman.MessageSupermanFlightToTracking;
import barryflash.superheroes.network.Capabilities.Superman.MessageSupermanFlyTickToTracking;
import barryflash.superheroes.network.Capabilities.Superman.MessageSupermanHeatVisionToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspFlightToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspFlyTickToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspHelmetToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspLeftBlastToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspRightBlastToTracking;
import barryflash.superheroes.network.Capabilities.Wasp.MessageWaspShrink;
import barryflash.superheroes.network.Capabilities.WonderWoman.MessageWonderwomanBraceletsToTracking;
import barryflash.superheroes.network.Capabilities.WonderWoman.MessageWonderwomanTiaraToTracking;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageCapIntToServer extends MessageBase<MessageCapIntToServer> {
	private int cap;
	private String type;
	public MessageCapIntToServer() {
		// TODO Auto-generated constructor stub
	}
	public MessageCapIntToServer(int cap, String type) {
		this.cap = cap;
		this.type = type;
		//System.out.println(this.type);
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		type = ByteBufUtils.readUTF8String(buf);
		cap = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, type);
		buf.writeInt(cap);
	}

	@Override
	public void handleClientSide(MessageCapIntToServer message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageCapIntToServer message, EntityPlayer player, MessageContext ctx) {
		
		if (message.type.equals("ironman")) {
			NetworkHandler.sendToTracking(new MessageIronmanFlyTickToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("superman")) {
			NetworkHandler.sendToTracking(new MessageSupermanFlyTickToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("batman")) {
			NetworkHandler.sendToTracking(new MessageBatmanGlideTickToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("wasp")) {
			NetworkHandler.sendToTracking(new MessageWaspFlyTickToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("flashSpeedLevel")) {
			IFlash flashcap = player.getCapability(FlashProvider.FLASH_CAP, null);
			flashcap.setSpeedLevel(message.cap);
		}
		else if (message.type.equals("hawkeyeGrappleListAdd")) {
			NetworkHandler.sendToTracking(new MessageHawkeyeGrappleEntitiesToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("hawkeyeGrappleListRemove")) {
			NetworkHandler.sendToTracking(new MessageHawkeyeRemoveGrappleEntitiesToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("hawkeyeGrappleListClear")) {
			NetworkHandler.sendToTracking(new MessageHawkeyeClearGrappleEntitiesToTracking(player.getEntityId()), player);
		}
		else {
			System.out.println(message.type);
		}
	}  
}
