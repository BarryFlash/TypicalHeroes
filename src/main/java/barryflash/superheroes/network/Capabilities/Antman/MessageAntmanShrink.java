package barryflash.superheroes.network.Capabilities.Antman;

import barryflash.superheroes.capabilities.AntmanProvider;
import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IAntman;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IWonderWoman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.WonderWomanProvider;
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

public class MessageAntmanShrink extends MessageBase<MessageAntmanShrink> {
	private boolean cap;
	private int playerID;
	public MessageAntmanShrink() {
		// TODO Auto-generated constructor stub
	}
	public MessageAntmanShrink(boolean cap, int ID) {
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
	public void handleClientSide(MessageAntmanShrink message, EntityPlayer player) {

		EntityPlayer capPlayer = (EntityPlayer) Minecraft.getMinecraft().world.getEntityByID(message.playerID);
		IAntman antmancap = capPlayer.getCapability(AntmanProvider.ANTMAN_CAP, null);
		if (message.cap == true) {
			antmancap.setSmall();
		} else {
			antmancap.resetSize();
		}
	}

	@Override
	public void handleServerSide(MessageAntmanShrink message, EntityPlayer player, MessageContext ctx) {
		
	    
	}  
}
