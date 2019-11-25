package barryflash.superheroes.network.Capabilities.Shazam;

import barryflash.superheroes.capabilities.AntmanProvider;
import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.HulkProvider;
import barryflash.superheroes.capabilities.IAntman;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.capabilities.IHulk;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IShazam;
import barryflash.superheroes.capabilities.IWonderWoman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.ShazamProvider;
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

public class MessageShazamTransformToTracking extends MessageBase<MessageShazamTransformToTracking> {
	private boolean cap;
	private int playerID;
	public MessageShazamTransformToTracking() {
		// TODO Auto-generated constructor stub
	}
	public MessageShazamTransformToTracking(boolean cap, int ID) {
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
	public void handleClientSide(MessageShazamTransformToTracking message, EntityPlayer player) {

		EntityPlayer capPlayer = (EntityPlayer) Minecraft.getMinecraft().world.getEntityByID(message.playerID);
		IShazam shazamcap = capPlayer.getCapability(ShazamProvider.SHAZAM_CAP, null);
		if (message.cap == true) {
			shazamcap.setShazam(true);
		} else {
			shazamcap.setShazam(false);
		}
	}

	@Override
	public void handleServerSide(MessageShazamTransformToTracking message, EntityPlayer player, MessageContext ctx) {
		
	    
	}  
}
