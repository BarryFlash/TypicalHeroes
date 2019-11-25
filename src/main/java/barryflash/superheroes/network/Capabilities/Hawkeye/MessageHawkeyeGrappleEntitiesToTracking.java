package barryflash.superheroes.network.Capabilities.Hawkeye;

import barryflash.superheroes.capabilities.CyborgProvider;
import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.ICyborg;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.ISpecialEffects;
import barryflash.superheroes.capabilities.ISuperman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.SpecialEffectsProvider;
import barryflash.superheroes.capabilities.SupermanProvider;
import barryflash.superheroes.entities.EntityDoctorStrangeCape;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import barryflash.superheroes.network.MessageBase;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageHawkeyeGrappleEntitiesToTracking extends MessageBase<MessageHawkeyeGrappleEntitiesToTracking> {
	private int cap;
	private int playerID;
	public MessageHawkeyeGrappleEntitiesToTracking() {
		// TODO Auto-generated constructor stub
	}
	public MessageHawkeyeGrappleEntitiesToTracking(int cap, int ID) {
		this.cap = cap;
		this.playerID = ID;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		cap = buf.readInt();
		playerID = ByteBufUtils.readVarInt(buf, 4);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(cap);
		ByteBufUtils.writeVarInt(buf, playerID, 4);
	}

	@Override
	public void handleClientSide(MessageHawkeyeGrappleEntitiesToTracking message, EntityPlayer player) {

		EntityPlayer capPlayer = (EntityPlayer) Minecraft.getMinecraft().world.getEntityByID(message.playerID);
		ISpecialEffects specialcap = capPlayer.getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
		specialcap.addGrappleEntityToList(Minecraft.getMinecraft().world.getEntityByID(message.cap));
	}

	@Override
	public void handleServerSide(MessageHawkeyeGrappleEntitiesToTracking message, EntityPlayer player, MessageContext ctx) {
		
	    
	}  
}
