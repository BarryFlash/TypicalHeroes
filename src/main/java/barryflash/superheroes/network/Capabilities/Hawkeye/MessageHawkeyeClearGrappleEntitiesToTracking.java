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

public class MessageHawkeyeClearGrappleEntitiesToTracking extends MessageBase<MessageHawkeyeClearGrappleEntitiesToTracking> {

	private int playerID;
	public MessageHawkeyeClearGrappleEntitiesToTracking() {
		// TODO Auto-generated constructor stub
	}
	public MessageHawkeyeClearGrappleEntitiesToTracking(int ID) {
		this.playerID = ID;
	}
	@Override
	public void fromBytes(ByteBuf buf) {

		playerID = ByteBufUtils.readVarInt(buf, 4);
	}

	@Override
	public void toBytes(ByteBuf buf) {
	
		ByteBufUtils.writeVarInt(buf, playerID, 4);
	}

	@Override
	public void handleClientSide(MessageHawkeyeClearGrappleEntitiesToTracking message, EntityPlayer player) {

		EntityPlayer capPlayer = (EntityPlayer) Minecraft.getMinecraft().world.getEntityByID(message.playerID);
		ISpecialEffects specialcap = capPlayer.getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
		if (!specialcap.getGrappleEntityList().isEmpty()) {
			specialcap.clearGrappleEntityList();
		}
	}

	@Override
	public void handleServerSide(MessageHawkeyeClearGrappleEntitiesToTracking message, EntityPlayer player, MessageContext ctx) {
		
	    
	}  
}
