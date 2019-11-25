package barryflash.superheroes.network;

import barryflash.superheroes.capabilities.HulkProvider;
import barryflash.superheroes.capabilities.IHulk;
import barryflash.superheroes.capabilities.IShazam;
import barryflash.superheroes.capabilities.ISpecialEffects;
import barryflash.superheroes.capabilities.ISuperman;
import barryflash.superheroes.capabilities.IWonderWoman;
import barryflash.superheroes.capabilities.ShazamProvider;
import barryflash.superheroes.capabilities.SpecialEffectsProvider;
import barryflash.superheroes.capabilities.SupermanProvider;
import barryflash.superheroes.capabilities.WonderWomanProvider;
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
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageCapToClient extends MessageBase<MessageCapToClient> {
	private boolean cap;
	private String type;
	private int uuid;
	public MessageCapToClient() {
		// TODO Auto-generated constructor stub
	}
	public MessageCapToClient(boolean cap, String type, int UUID) {
		this.cap = cap;
		this.type = type;
		this.uuid = UUID;
		//System.out.println(this.type);
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		type = ByteBufUtils.readUTF8String(buf);
		cap = buf.readBoolean();
		uuid = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, type);
		buf.writeBoolean(cap);
		buf.writeInt(uuid);
	}

	@Override
	public void handleClientSide(MessageCapToClient message, EntityPlayer player) {

		if (message.type.equals("hulk")) {
			IHulk hulkcap = Minecraft.getMinecraft().world.getEntityByID(message.uuid).getCapability(HulkProvider.HULK_CAP, null);
			hulkcap.setHulk(message.cap);
			
		}
		else if (message.type.equals("shazam")) {
			IShazam shazamcap = Minecraft.getMinecraft().world.getEntityByID(message.uuid).getCapability(ShazamProvider.SHAZAM_CAP, null);
			shazamcap.setShazam(message.cap);
			
		}
		else if (message.type.equals("wwTiara")) {
			IWonderWoman wwcap = Minecraft.getMinecraft().world.getEntityByID(message.uuid).getCapability(WonderWomanProvider.WONDERWOMAN_CAP, null);
			if (message.cap) {
				wwcap.setTiara();
			} else {
				wwcap.unsetTiara();
			}
			
		}
		else if (message.type.equals("shock")) {
			ISpecialEffects supercap = Minecraft.getMinecraft().world.getEntityByID(message.uuid).getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
			supercap.setShock(message.cap);
			
		}
		else if (message.type.equals("kryptonite")) {
			ISuperman supercap = Minecraft.getMinecraft().world.getEntityByID(message.uuid).getCapability(SupermanProvider.SUPERMAN_CAP, null);
			supercap.setKrpyonite(message.cap);
		}
		
	}

	@Override
	public void handleServerSide(MessageCapToClient message, EntityPlayer player, MessageContext ctx) {
		
		
	}  
}
