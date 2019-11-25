package barryflash.superheroes.network.Capabilities.Ironman;

import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
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

public class MessageIronmanFlight2ToTracking extends MessageBase<MessageIronmanFlight2ToTracking> {
	private boolean cap;
	private int playerID;
	public MessageIronmanFlight2ToTracking() {
		// TODO Auto-generated constructor stub
	}
	public MessageIronmanFlight2ToTracking(boolean cap, int ID) {
		this.cap = cap;
		this.playerID = ID;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		cap = buf.readBoolean();
		playerID = ByteBufUtils.readVarInt(buf, 4);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(cap);
		ByteBufUtils.writeVarInt(buf, playerID, 4);
	}

	@Override
	public void handleClientSide(MessageIronmanFlight2ToTracking message, EntityPlayer player) {

		EntityPlayer capPlayer = (EntityPlayer) Minecraft.getMinecraft().world.getEntityByID(message.playerID);
		IIronman ironmancap = capPlayer.getCapability(IronmanProvider.IRONMAN_CAP, null);
		if (message.cap == true) {
			ironmancap.activateWings();
		} else {
			ironmancap.deactivateWings();
		}
	}

	@Override
	public void handleServerSide(MessageIronmanFlight2ToTracking message, EntityPlayer player, MessageContext ctx) {
		
	    
	}  
}
