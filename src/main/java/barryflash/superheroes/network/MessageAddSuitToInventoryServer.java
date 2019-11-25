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
import barryflash.superheroes.init.ModItems;
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
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageAddSuitToInventoryServer extends MessageBase<MessageAddSuitToInventoryServer> {
	private ItemStack head, chest, legs, feet;
	public MessageAddSuitToInventoryServer() {
		// TODO Auto-generated constructor stub
	}
	public MessageAddSuitToInventoryServer(ItemStack head, ItemStack chest, ItemStack legs, ItemStack feet) {
		this.head = head;
		this.chest = chest;
		this.legs = legs;
		this.feet = feet;
		//System.out.println(this.type);
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		head = ByteBufUtils.readItemStack(buf);
		chest = ByteBufUtils.readItemStack(buf);
		legs = ByteBufUtils.readItemStack(buf);
		feet = ByteBufUtils.readItemStack(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeItemStack(buf, head);
		ByteBufUtils.writeItemStack(buf, chest);
		ByteBufUtils.writeItemStack(buf, legs);
		ByteBufUtils.writeItemStack(buf, feet);
	}

	@Override
	public void handleClientSide(MessageAddSuitToInventoryServer message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageAddSuitToInventoryServer message, EntityPlayer player, MessageContext ctx) {
		if (!message.head.isEmpty()) {
			player.inventory.armorInventory.set(3, message.head);
			player.inventory.armorInventory.set(2, message.chest);
			player.inventory.armorInventory.set(1, message.legs);
			player.inventory.armorInventory.set(0, message.feet);
		} else {
			player.inventory.armorInventory.set(2, message.chest);
			player.inventory.armorInventory.set(1, message.legs);
			player.inventory.armorInventory.set(0, message.feet);
		}
		
	}  
}
