package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageReflect extends MessageBase<MessageReflect> {
	
	private int entityID;
	private double x,y,z;
	public MessageReflect() {
		// TODO Auto-generated constructor stub
	}
	public MessageReflect(int entityID, double x, double y, double z) {
		this.entityID = entityID;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = ByteBufUtils.readVarInt(buf, 4);
		x = buf.readDouble();
		y = buf.readDouble();
		z = buf.readDouble();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, entityID, 4);
		buf.writeDouble(x);
		buf.writeDouble(y);
		buf.writeDouble(z);
	}

	@Override
	public void handleClientSide(MessageReflect message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageReflect message, EntityPlayer playerd, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {
		IProjectile ent = (IProjectile) player.world.getEntityByID(message.entityID);
	
		ent.shoot(message.x, message.y, message.z, 1F, 2F);
		
	      }
		});
		  
		}
}

