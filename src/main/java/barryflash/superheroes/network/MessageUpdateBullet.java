package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.entities.projectiles.EntityBullet;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
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

public class MessageUpdateBullet extends MessageBase<MessageUpdateBullet> {
	
	private int entityID;
	private boolean left;
	public MessageUpdateBullet() {
		// TODO Auto-generated constructor stub
	}
	public MessageUpdateBullet(int entityID, boolean left) {
		this.entityID = entityID;
		this.left = left;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = ByteBufUtils.readVarInt(buf, 4);
		left = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, entityID, 4);
		buf.writeBoolean(left);
	}

	@Override
	public void handleClientSide(MessageUpdateBullet message, EntityPlayer player) {
		
		EntityBullet ent = (EntityBullet) Minecraft.getMinecraft().world.getEntityByID(message.entityID);
		if (ent != null) {
			ent.setLeft(message.left);
			
		}
		
		
	}

	@Override
	public void handleServerSide(MessageUpdateBullet message, EntityPlayer playerd, MessageContext ctx) {
		
		}
	      
}

