package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.capabilities.SpecialEffectsEventHandler;
import barryflash.superheroes.capabilities.SupermanEventHandler;
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

public class MessageRaytraceDamage extends MessageBase<MessageRaytraceDamage> {
	
	private int entityID;
	private int damage;
	private String type;
	public MessageRaytraceDamage() {
		// TODO Auto-generated constructor stub
	}
	public MessageRaytraceDamage(int entityID, int damage, String type) {
		this.entityID = entityID;
		this.damage = damage;
		this.type = type;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = ByteBufUtils.readVarInt(buf, 4);
		damage = ByteBufUtils.readVarInt(buf, 4);
		type = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, entityID, 4);
		ByteBufUtils.writeVarInt(buf, damage, 4);
		ByteBufUtils.writeUTF8String(buf, type);
	}

	@Override
	public void handleClientSide(MessageRaytraceDamage message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageRaytraceDamage message, EntityPlayer playerd, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {
		Entity ent = player.world.getEntityByID(message.entityID);
		if (ent != null) {
			if (message.type.equals("heatvision")) {
				ent.attackEntityFrom(SupermanEventHandler.HeatVision, message.damage);
				ent.setFire(2);
			} else if (message.type.equals("shock")) {
				ent.attackEntityFrom(SpecialEffectsEventHandler.Shock, message.damage);
			} else {
				System.err.println("No damage type");
			}
		}
	      }
		});
		}
	      
}

