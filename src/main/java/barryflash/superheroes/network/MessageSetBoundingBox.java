package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSetBoundingBox extends MessageBase<MessageSetBoundingBox> {
	private float width;
	private double height;
	
	public MessageSetBoundingBox() {
		// TODO Auto-generated constructor stub
	}
	
	public MessageSetBoundingBox(float width, double height) {
		this.width = width;
		this.height = height;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		width = buf.readFloat();
		height = buf.readDouble();
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeFloat(width);
		buf.writeDouble(height);
		
	}

	@Override
	public void handleClientSide(MessageSetBoundingBox message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageSetBoundingBox message, EntityPlayer player, MessageContext ctx) {
		
		player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + message.width, player.getEntityBoundingBox().minY + message.height, player.getEntityBoundingBox().minZ + message.width));
	    player.height = (float) message.height;
	    player.width = message.width;
		
		
		}
}

