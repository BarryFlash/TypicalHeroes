package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageGiantPunch extends MessageBase<MessageGiantPunch> {
	
	private int entityID;
	public MessageGiantPunch() {
		// TODO Auto-generated constructor stub
	}
	public MessageGiantPunch(int entityID) {
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
	public void handleClientSide(MessageGiantPunch message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageGiantPunch message, EntityPlayer playerd, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {
		Entity ent = player.world.getEntityByID(message.entityID);
	
		ent.attackEntityFrom(DamageSource.causePlayerDamage(player), 4F);
	      }
		});
		
		  
		}
}

