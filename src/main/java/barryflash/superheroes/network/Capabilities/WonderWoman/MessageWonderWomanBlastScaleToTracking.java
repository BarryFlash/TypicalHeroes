package barryflash.superheroes.network.Capabilities.WonderWoman;

import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.ISuperman;
import barryflash.superheroes.capabilities.IWasp;
import barryflash.superheroes.capabilities.IWonderWoman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.SupermanProvider;
import barryflash.superheroes.capabilities.WaspProvider;
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

public class MessageWonderWomanBlastScaleToTracking extends MessageBase<MessageWonderWomanBlastScaleToTracking> {
	private int cap;
	private int playerID;
	public MessageWonderWomanBlastScaleToTracking() {
		// TODO Auto-generated constructor stub
	}
	public MessageWonderWomanBlastScaleToTracking(int cap, int ID) {
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
	public void handleClientSide(MessageWonderWomanBlastScaleToTracking message, EntityPlayer player) {

		EntityPlayer capPlayer = (EntityPlayer) Minecraft.getMinecraft().world.getEntityByID(message.playerID);
		IWonderWoman wonderwomancap = capPlayer.getCapability(WonderWomanProvider.WONDERWOMAN_CAP, null);
		wonderwomancap.setScale(message.cap);
	}

	@Override
	public void handleServerSide(MessageWonderWomanBlastScaleToTracking message, EntityPlayer player, MessageContext ctx) {
		
	    
	}  
}
