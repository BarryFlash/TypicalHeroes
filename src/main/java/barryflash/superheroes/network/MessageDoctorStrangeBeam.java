package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageDoctorStrangeBeam extends MessageBase<MessageDoctorStrangeBeam> {
	
	private int entityID;
	public MessageDoctorStrangeBeam() {
		// TODO Auto-generated constructor stub
	}
	public MessageDoctorStrangeBeam(int entityID) {
		this.entityID = entityID;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = ByteBufUtils.readVarInt(buf, 4);
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, entityID, 4);
		
	}

	@Override
	public void handleClientSide(MessageDoctorStrangeBeam message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageDoctorStrangeBeam message, EntityPlayer player, MessageContext ctx) {
		Entity ent = player.world.getEntityByID(message.entityID);
	
		ent.attackEntityFrom(DamageSource.causePlayerDamage(player), 3.0F);
		
		
		  
		}
}

