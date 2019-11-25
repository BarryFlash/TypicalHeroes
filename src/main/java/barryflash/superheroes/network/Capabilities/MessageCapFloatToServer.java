package barryflash.superheroes.network.Capabilities;

import barryflash.superheroes.network.MessageBase;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.network.Capabilities.Antman.MessageAntmanGrow;
import barryflash.superheroes.network.Capabilities.Antman.MessageAntmanHelmetToTracking;
import barryflash.superheroes.network.Capabilities.Antman.MessageAntmanShrink;
import barryflash.superheroes.network.Capabilities.Batman.MessageBatmanGlideTickToTracking;
import barryflash.superheroes.network.Capabilities.Batman.MessageBatmanGlideToTracking;
import barryflash.superheroes.network.Capabilities.Hulk.MessageHulkAlphaToTracking;
import barryflash.superheroes.network.Capabilities.Hulk.MessageHulkHAlphaToTracking;
import barryflash.superheroes.network.Capabilities.Hulk.MessageHulkSizeToTracking;
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

public class MessageCapFloatToServer extends MessageBase<MessageCapFloatToServer> {
	private float cap;
	private String type;
	public MessageCapFloatToServer() {
		// TODO Auto-generated constructor stub
	}
	public MessageCapFloatToServer(float cap, String type) {
		this.cap = cap;
		this.type = type;
		//System.out.println(this.type);
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		type = ByteBufUtils.readUTF8String(buf);
		cap = buf.readFloat();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, type);
		buf.writeFloat(cap);
	}

	@Override
	public void handleClientSide(MessageCapFloatToServer message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageCapFloatToServer message, EntityPlayer player, MessageContext ctx) {
		
		if (message.type.equals("hulkAlpha")) {
			NetworkHandler.sendToTracking(new MessageHulkAlphaToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("hulkSize")) {
			NetworkHandler.sendToTracking(new MessageHulkSizeToTracking(message.cap, player.getEntityId()), player);
		}
		else if (message.type.equals("hulkHAlpha")) {
			NetworkHandler.sendToTracking(new MessageHulkHAlphaToTracking(message.cap, player.getEntityId()), player);
		}
		else {
			System.out.println(message.type);
		}
	}  
}
