package barryflash.superheroes.network;

import barryflash.superheroes.capabilities.CyborgProvider;
import barryflash.superheroes.capabilities.FlashProvider;
import barryflash.superheroes.capabilities.HulkProvider;
import barryflash.superheroes.capabilities.ICyborg;
import barryflash.superheroes.capabilities.IFlash;
import barryflash.superheroes.capabilities.IHulk;
import barryflash.superheroes.capabilities.IKeys;
import barryflash.superheroes.capabilities.IQuiver;
import barryflash.superheroes.capabilities.IShazam;
import barryflash.superheroes.capabilities.IWonderWoman;
import barryflash.superheroes.capabilities.KeysProvider;
import barryflash.superheroes.capabilities.QuiverProvider;
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

public class MessageQuiverToServer extends MessageBase<MessageQuiverToServer> {
	private boolean cap;
	private int selected;
	private String type;
	public MessageQuiverToServer() {
		// TODO Auto-generated constructor stub
	}
	public MessageQuiverToServer(int selected, boolean cooldown) {
		this.cap = cooldown;
		this.selected = selected;
		//System.out.println(this.type);
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		cap = buf.readBoolean();
		selected = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(cap);
		buf.writeInt(selected);
	}

	@Override
	public void handleClientSide(MessageQuiverToServer message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageQuiverToServer message, EntityPlayer player, MessageContext ctx) {
		IQuiver qcap = player.getCapability(QuiverProvider.QUIVER_CAP, null);
		qcap.setArrowSelected(message.selected);
		qcap.setCooldownBoolForArrow(message.selected, message.cap);
		
	}  
}
